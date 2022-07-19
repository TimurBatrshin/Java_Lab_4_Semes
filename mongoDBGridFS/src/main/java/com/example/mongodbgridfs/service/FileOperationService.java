package com.example.mongodbgridfs.service;

import com.example.mongodbgridfs.model.LoadFile;
import com.mongodb.DBObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileOperationService {
    void save(DBObject metaData, MultipartFile file) throws IOException;
    List<LoadFile> downloadFile(Long userId) throws IOException;
}
