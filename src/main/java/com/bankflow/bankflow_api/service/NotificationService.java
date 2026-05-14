package com.bankflow.bankflow_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(message);
        mailSender.send(mail);
    }

    public void sendTransactionSuccess(String to, String transactionId) {
        sendEmail(
                to,
                "Transaction Successful",
                "Transaction ID: " + transactionId + " has been completed successfully."
        );
    }

    public void sendTransactionFailed(String to, String transactionId, String reason) {
        sendEmail(
                to,
                "Transaction Failed",
                "Transaction ID: " + transactionId + " failed.\nReason: " + reason
        );
    }
}