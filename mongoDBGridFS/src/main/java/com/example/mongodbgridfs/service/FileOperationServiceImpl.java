package com.example.mongodbgridfs.service;

import com.example.mongodbgridfs.model.LoadFile;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileOperationServiceImpl implements FileOperationService {

    @Autowired
    private GridFsOperations gridFsOperations;

    @Override
    public void save(DBObject metaData, MultipartFile file) throws IOException {
        InputStream inputStream = new BufferedInputStream(file.getInputStream());
        gridFsOperations.store(inputStream, file.getOriginalFilename(), file.getContentType(), metaData);
    }

    @Override
    public List<LoadFile> downloadFile(Long userId) throws IOException {
        GridFSFindIterable gridFSFile = gridFsOperations.find(new Query(Criteria.where("metadata.userId").is(userId)));
        List<GridFSFile> fsFiles = new ArrayList<>();
        gridFSFile.forEach(file -> {
            fsFiles.add(new GridFSFile(
                    file.getId(),
                    file.getFilename(),
                    file.getChunkSize(),
                    (int) file.getLength(),
                    file.getUploadDate(),
                    file.getMetadata()
            ));
        });

        List<LoadFile> loadFileList = new ArrayList<>();
        for (int i = 0; i < fsFiles.size(); i++) {
            if (fsFiles.get(i).getMetadata() != null) {
                LoadFile loadFile = LoadFile.builder()
                        .filename(fsFiles.get(i).getFilename())
                        .fileType(fsFiles.get(i).getMetadata().get("_contentType").toString())
                        .file(IOUtils.toByteArray(gridFsOperations.getResource(fsFiles.get(i)).getInputStream()))
                        .build();
                loadFileList.add(loadFile);
            }
        }
        return loadFileList;
    }
}
