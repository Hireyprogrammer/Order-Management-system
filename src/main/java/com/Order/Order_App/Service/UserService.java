package com.Order.Order_App.Service;

import com.Order.Order_App.Models.User;
import com.Order.Order_App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public void saveUser(User user, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
            user.setProfileImage(filePath.toString());  // Save the string representation of the path
        }
        userRepository.save(user);
    }
}
