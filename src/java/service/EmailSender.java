/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import config.EmailConfig;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ahmad
 */
public class EmailSender {
    
     public static void sendEmail(String recipientEmail, String subject, String body) {
        try {
            // Dapatkan sesi dari EmailConfig
            Session session = EmailConfig.getSession();
            
            // Buat pesan email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailConfig.getSenderEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            // Kirim email
            Transport.send(message);
            System.out.println("Email berhasil dikirim!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Gagal mengirim email!");
        }
    }
}
