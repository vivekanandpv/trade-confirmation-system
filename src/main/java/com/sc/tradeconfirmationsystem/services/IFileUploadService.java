package com.sc.tradeconfirmationsystem.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileUploadService {
    void uploadFile(MultipartFile file, String directoryName) throws IOException;
}
