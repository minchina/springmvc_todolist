package com.tw.todolist.domain;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class SimpleOrderManager implements OrderManager {

    private JavaMailSender mailSender;
    private SimpleMailMessage templateMessage;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public void send(Order order) {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(order.getCustomer().getEmailAddress());
        msg.setText(
                "Dear" + order.getCustomer().getFirstName()
                        + order.getCustomer().getLastName()
                        + ", thank you for placing order. Your order number is "
                        + order.getOrderNumber());
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void sendTo(Order order) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(templateMessage.getFrom());
            helper.setTo(templateMessage.getTo());
            helper.setSubject(templateMessage.getSubject());
            helper.setText("Dear" + order.getCustomer().getFirstName()
                    + order.getCustomer().getLastName()
                    + ", thank you for placing order. Your order number is "
                    + order.getOrderNumber());

            FileSystemResource file = new FileSystemResource("C:\\log.txt");
            helper.addAttachment(file.getFilename(), file);

        }catch (MessagingException e) {
            throw new MailParseException(e);
        }
        mailSender.send(mimeMessage);
    }

}
