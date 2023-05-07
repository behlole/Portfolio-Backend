package com.behlole.portfolio.Portfolio.services.implementations;

import com.behlole.portfolio.Portfolio.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImplementation implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        String randomUID = UUID.randomUUID().toString();
        assert name != null;
        String filename1 = randomUID.concat(
                name.substring(name.lastIndexOf("."))
        );
        String filepath = path + File.separator + filename1;
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filepath));
        return filename1;
    }

    @Override
    public InputStream getResource(String path, String filename) throws IOException {
        String fullPath = path + File.separator + filename;
        return new FileInputStream(fullPath);
    }
}
