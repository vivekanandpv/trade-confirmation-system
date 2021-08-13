package com.sc.tradeconfirmationsystem.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface IFileUploadService {
    Path uploadFile(MultipartFile file, String directoryName) throws IOException;
}
