package com.example.backend.controller;

import com.example.backend.dtos.EmailDetail;
import com.example.backend.entities.Account;
import com.example.backend.services.account.AccountService;
import com.example.backend.services.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1") // router
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.POST, path = "/sendEmail")
    public int sendMail(@RequestBody EmailDetail detail) {
        {
            Random rand = new Random();
            var passRefresh = "mkrandom" + rand.nextInt(1000);
            var lstAccount = accountService.findAll();
            int status = 0;
            for (Account acc: lstAccount) {
                System.out.println(acc.getEmail() == detail.getRecipient());
                if (acc.getEmail().equals(detail.getRecipient())) {
                    Account accUpdate = accountService.findById(acc.getAccount_id());
                    accUpdate.setUpdate_at(new Date());
                    accUpdate.setPassword(passRefresh);
                    accountService.save(accUpdate);
                    status = emailService.sendSimpleMail(detail.getRecipient(), passRefresh);
                }
            }

            return status;
        }
    }

        // Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(
//            @RequestBody EmailDetail details)
//    {
//        String status
//                = emailService.sendMailWithAttachment(details);
//
//        return status;
//    }
}
