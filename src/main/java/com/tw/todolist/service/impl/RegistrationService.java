package com.tw.todolist.service.impl;

import com.tw.todolist.domain.Order;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

public class RegistrationService {

    @Value("${email.switch:false}")
    private Boolean isAllowRegister;

    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;


    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void register(Order order) {
        if(!isAllowRegister) {
            throw new RuntimeException("forbidden register");
        }

        sendConfirmationEmail(order);
    }

    private void sendConfirmationEmail(final Order order) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(order.getCustomer().getEmailAddress());
                message.setFrom("webmaster@csonth.gov.uk");
                Map model = new HashMap();
                model.put("order", order);
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                        "template/registration-confirmation.vm", "utf-8", model);
                message.setText(text, true);
            }
        };
        this.mailSender.send(preparator);
    }
}
