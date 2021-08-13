package com.sc.tradeconfirmationsystem.services;

import com.sc.tradeconfirmationsystem.exceptions.EmptyFileException;
import com.sc.tradeconfirmationsystem.utils.StaticProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadService implements IFileUploadService {
    @Override
    public Path uploadFile(MultipartFile file, String directoryName) throws IOException {
        if (file.isEmpty()) {
            throw new EmptyFileException("The uploaded file is empty");
        }

        byte[] fileBytes = file.getBytes();

        Path filePath = Paths.get(
                directoryName,
                UUID.randomUUID() + ".xml"
        );

        return Files.write(filePath, fileBytes);
    }
}
