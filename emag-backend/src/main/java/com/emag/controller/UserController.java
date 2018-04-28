package com.emag.controller;

import com.emag.config.Constants;
import com.emag.exceptions.UserException;
import com.emag.model.ResponseEntity;
import com.emag.model.User;
import com.emag.service.LoggedUserService;
import com.emag.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoggedUserService loggedUserService;

    @GetMapping("/getUserPersonalData")
    public ResponseEntity getUserInfo(@RequestParam("id") Long id) {

        Gson gson = new Gson();
        String json = null;

        try {
            User user = userService.findUserById(id);
            if(user.getPictureUrl()!=null){
                int newLocationProfilePictureIndex = user.getPictureUrl().lastIndexOf("\\");
                String newlocation = "http://127.0.0.1:8887/" + user.getPictureUrl().substring(newLocationProfilePictureIndex+1);
                user.setPictureUrl(newlocation);
            }
            json = gson.toJson(user);
        } catch (UserException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (SQLException e) {
            return new ResponseEntity(Constants.ACC_PROBLEM, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(json, HttpStatus.OK);
    }

    @PutMapping("/updateUserPersonalData")
    public ResponseEntity updateUserPersonalData
            (@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("email") String email,
             @RequestParam("gender") String gender,@RequestParam("phone") String phone){

        User user = null;
        try {
            user = new User(id,name,email,gender,phone);
            loggedUserService.updateUserPersonalInfo(user);
        } catch (UserException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("OK", HttpStatus.OK);
    }

    @RequestMapping(value = {"/updateUserProfilePicture"}, method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity updateUserProfilePicture(@RequestParam("id") Long id,@RequestParam("picture") MultipartFile picture){

        Gson gson = new Gson();
        String json = null;

        try {
            File newFile = convert(picture);
            loggedUserService.updateUserProfilePicture(id,newFile.getPath());
            int newLocationProfilePictureIndex = newFile.getPath().lastIndexOf("\\");
            String newlocation = "http://127.0.0.1:8887/" + newFile.getPath().substring(newLocationProfilePictureIndex+1);
            json = gson.toJson(newlocation);
        } catch (IOException|UserException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }

        return new ResponseEntity(json, HttpStatus.OK);
    }

    private File convert(MultipartFile file) throws IOException {
        File convFile = new File("D:\\userPictures\\" + file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


}
