package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUpload {
    private String RootPath = "static/uploads";
    private Path convertRelativeToAbsolutePath(String relativePath) throws Exception{
        return Paths.get(RootPath + relativePath);
    }
    public void saveAs(MultipartFile file, String relativePath){
        try {
            File directory = new File(convertRelativeToAbsolutePath(relativePath).getParent().toString());
            if(!directory.exists()){
                directory.mkdirs();
            }
            Files.copy(file.getInputStream(), convertRelativeToAbsolutePath(relativePath));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error:" + e.getMessage());
        }
    }
}
