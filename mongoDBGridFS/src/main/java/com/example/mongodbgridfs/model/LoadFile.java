package com.example.mongodbgridfs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoadFile {
    private String filename;
    private String fileType;
    private byte[] file;
}
