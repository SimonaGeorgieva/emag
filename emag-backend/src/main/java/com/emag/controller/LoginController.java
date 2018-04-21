package com.emag.controller;

import com.emag.config.Constants;
import com.emag.exceptions.AccountException;
import com.emag.model.Account;
import com.emag.model.ResponseEntity;
import com.emag.service.AccountService;
import com.google.gson.Gson;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBElement;
import java.sql.SQLException;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AccountService accountService;

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity login(@RequestParam("email") String email, @RequestParam("password") String password) {

        Gson gson = new Gson();
        String json = null;

        try {
            accountService.checkDoesGivenUserExists(email, password);
            Account user = accountService.findByAccountEmail(email);
            json = gson.toJson(user);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (SQLException e) {
            return new ResponseEntity(Constants.ACC_PROBLEM, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(json, HttpStatus.OK);
    }

    @GetMapping("/getUserPageByEmail")
    @ResponseBody
    public ResponseEntity getUserPageByEmail(@RequestParam("email") String email) {

        JSONObject obj = new JSONObject();
        try {
            Account user = accountService.findByAccountEmail(email);
            obj.put("user", user);
        } catch (AccountException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (SQLException e) {
            return new ResponseEntity(Constants.ERROR, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(obj, HttpStatus.OK);
    }


    @GetMapping("/getUserPageById")
    @ResponseBody
    public ResponseEntity getUserPageById(@RequestParam("id") Long id) {

        JSONObject obj = new JSONObject();
        try {
            Account user = accountService.findAccountById(id);
            obj.put("user", user);
        } catch (AccountException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (SQLException e) {

            return new ResponseEntity(Constants.ERROR, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(obj, HttpStatus.OK);
    }
}
