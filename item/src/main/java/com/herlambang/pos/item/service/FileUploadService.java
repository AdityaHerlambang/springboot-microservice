package com.herlambang.pos.item.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadService {

    @Value("${file.upload.directory}")
    private String fileUploadDirectory;

    public String saveUploadedFile(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            File uploadDirectory = new File(fileUploadDirectory);
            if (!uploadDirectory.exists()) {
                uploadDirectory.mkdirs();
            }

            Path filePath = Path.of(fileUploadDirectory, fileName);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save uploaded file: " + e.getMessage(), e);
        }
    }
}
