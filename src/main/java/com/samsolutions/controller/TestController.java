package com.samsolutions.controller;

import com.samsolutions.repository.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/adminpanel/user")
public class TestController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/download", method = RequestMethod.POST, consumes = "multipart/form-data")
    public String add(@RequestParam MultipartFile file) throws IOException {

        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String resultFileName = UUID.randomUUID().toString();
            String fileName = file.getName();
            file.transferTo(new File(uploadPath + "/" + fileName));
        }
        return "/adminpanel/user/crud";
    }
}
