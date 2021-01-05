package com.proiectcolectiv.proiect.controllers;

import com.proiectcolectiv.proiect.config.EmailServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/sendmail")
public class MailController {

    @Autowired
    private EmailServiceImpl emailService;
    @RequestMapping(value = "/verifyAccount", method = RequestMethod.POST)
    public ResponseEntity<?> SupervisorEmailResponseEntity(@RequestBody String string){
        emailService.emailSupervisor(string);
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication());
    }
}
