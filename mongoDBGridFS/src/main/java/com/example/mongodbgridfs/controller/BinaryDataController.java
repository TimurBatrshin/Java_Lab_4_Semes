package com.example.mongodbgridfs.controller;

import com.example.mongodbgridfs.model.LoadFile;
import com.example.mongodbgridfs.security.details.UserDetailsImpl;
import com.example.mongodbgridfs.service.FileOperationService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class BinaryDataController {

    @Autowired
    private FileOperationService fileOperation;

    @GetMapping("/saveFile")
    public String getSaveFilePage() {
        System.out.println("gbg");
        return "downloadPhoto";
    }

    @PostMapping("/saveFile")
    public String saveFile(MultipartFile file, @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("userId", userDetails.getUser().getId());

        fileOperation.save(metaData, file);

        return "redirect:/saveFile";
    }

    @GetMapping("/download")
    public String download(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) throws IOException {

        List<LoadFile> loadFile = fileOperation.downloadFile(userDetails.getUser().getId());
        model.addAttribute("loadFiles", loadFile);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < loadFile.size(); i++) {
             strings.add(Base64.getEncoder().encodeToString(loadFile.get(i).getFile()));
        }
        model.addAttribute("strings", strings);
        return "dow";
    }

}
