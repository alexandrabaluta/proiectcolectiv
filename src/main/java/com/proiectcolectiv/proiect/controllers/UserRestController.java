package com.proiectcolectiv.proiect.controllers;

import com.proiectcolectiv.proiect.entities.UserEntity;
import com.proiectcolectiv.proiect.repositories.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/employee/upload", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("imageFile") MultipartFile file)
            throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        UserEntity img = new UserEntity(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
        userRepository.save(img);
        return "ok";
    }
    @RequestMapping(value = "employee/get/", method = RequestMethod.POST)
    public UserEntity getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<UserEntity> retrievedImage = userRepository.findUserEntityByProfilePicName(imageName);
        UserEntity img = new UserEntity(retrievedImage.get().getProfilePicName(), retrievedImage.get().getProfilePicType(), decompressBytes(retrievedImage.get().getProfilePic()));
        return img;
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException ioe) {
        }
        return outputStream.toByteArray();
    }
}

