package com.emag.controller;

import com.emag.config.Constants;
import com.emag.service.SendEmailService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
public class SendEmailController {

    @Autowired
    private SendEmailService sendingEmailService;

    @PutMapping("/subscribeUser")
    public ResponseEntity subscribe(@RequestParam("email") String email) {
        Gson gson = new Gson();
        try {
            sendingEmailService.sendEmail(email);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson(e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(Constants.SUCCESS));
    }
}