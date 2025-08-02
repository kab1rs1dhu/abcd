package com.abcd.abcd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Value("${spring.resources.static-locations:classpath:/}")
    private String uploadDir;

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();
        
        if (file.isEmpty()) {
            response.put("error", "Please select a file to upload");
            return response;
        }

        try {
            // Get the file extension
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
            
            // Generate a unique filename
            String filename = "img_" + UUID.randomUUID().toString() + extension;
            
            // Save the file
            String uploadPath = System.getProperty("user.dir") + "/src/main/resources";
            Path path = Paths.get(uploadPath + "/" + filename);
            Files.write(path, file.getBytes());
            
            response.put("success", "true");
            response.put("filename", "/" + filename);
            return response;
        } catch (IOException e) {
            response.put("error", "Failed to upload file: " + e.getMessage());
            return response;
        }
    }
} 