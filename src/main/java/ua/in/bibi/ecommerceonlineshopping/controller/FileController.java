package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.in.bibi.ecommerceonlineshopping.dto.request.FileRequest;
import ua.in.bibi.ecommerceonlineshopping.service.FileService;

import java.io.IOException;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String upload(@RequestBody FileRequest fileRequest) throws IOException {
        String filePath = fileService.saveFile(fileRequest);
        return filePath;
    }
}
