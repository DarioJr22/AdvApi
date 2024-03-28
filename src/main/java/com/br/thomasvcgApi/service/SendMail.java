package com.br.thomasvcgApi.service;

import com.br.thomasvcgApi.domain.entity.Contact;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class SendMail {
    public static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    public static final String UTF_8_ENCODING = "UTF-8";
    public static final String EMAIL_TEMPLATE = "emailtemplate";

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String fromEmail;

    private MimeMessage getMimeMessage() {
        return emailSender.createMimeMessage();
    }

    @Async
    public void sendHtmlEmail(Contact contact, String to) {
        try {
            Context context = new Context();
            context.setVariable("costumerName", contact.getCostumer().getCostumerName());
            context.setVariable("contactContent", decodeBase64(contact.getContactContent()));
            context.setVariable("relationship", contact.getCostumer().getRelationship());
            context.setVariable("email", contact.getCostumer().getEmail());
            context.setVariable("contact", contact.getCostumer().getContact());
            context.setVariable("cep", contact.getCostumer().getAddress().getCep());
            context.setVariable("district", contact.getCostumer().getAddress().getDistrict());
            context.setVariable("uf", contact.getCostumer().getAddress().getUf());
            String text = templateEngine.process(EMAIL_TEMPLATE, context);
            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
            helper.setPriority(1);
            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText(text, true);
            emailSender.send(message);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
    public static String decodeBase64(String encodedContent) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedContent);
            return new String(decodedBytes, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao decodificar conteúdo Base64: " + ex.getMessage(), ex);
        }
    }
}
