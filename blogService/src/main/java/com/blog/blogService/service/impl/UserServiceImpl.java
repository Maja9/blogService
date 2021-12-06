package com.blog.blogService.service.impl;

import com.blog.blogService.dto.UserDto;
import com.blog.blogService.entity.User;
import com.blog.blogService.mapper.UserMapper;
import com.blog.blogService.repository.UserRepository;

import com.blog.blogService.service.spi.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Optional;
import java.util.Properties;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${mail.smtp.starttls.enable}")
    private String mailSmtpStarttlsEnable;

    @Value("${mail.smtp.host}")
    private String mailSmtpHost;

    @Value("${mail.smtp.port}")
    private String mailSmtpPort;

    @Value("${mail.smtp.ssl.trust}")
    private String mailSmtpSslTrust;

    @Value("${mail.address}")
    private String mailAddress;

    @Value("${mail.password}")
    private String mailPassword;


    public UserServiceImpl(final UserRepository userRepository,
                           final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    @Override
    public Long createUser(final UserDto userDto) {
        User userToSave = userMapper.map(userDto, User.class);
        if (userDto.getPassword() != null) {
            userToSave.setPassHash(userDto.getPassword().hashCode());
        }
        return userRepository.save(userToSave)
                .getId();

    }

    @Override
    public UserDto getUser(final Long userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            UserDto user = userMapper.map(optional.get(), UserDto.class);
            return user;
        }
        return null;
    }

    @Override
    public String deleteUser(final Long userId, final String password) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent() && password.hashCode() == userOptional.get().getPassHash()) {
            userRepository.deleteById(userId);
            return "The user has been deleted.";
        }
        return "The user has not been deleted.";
    }

    @Override
    public String resetPassword(final String email) {
        final User user = userRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
        final String temporaryPassword = RandomStringUtils.randomAlphanumeric(6);
        user.setPassHash(temporaryPassword.hashCode());
        userRepository.save(user);

        return sendMessage(temporaryPassword, email);
    }

    private String sendMessage(final String newPass, final String email) {

        final Message message = new MimeMessage(setSession());
        try {
            message.setFrom(new InternetAddress(mailAddress));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Twoje nowe hasło do konta");
            String msg = "Twoje haslo do konta zostalo zresetowane. Nowe haslo to: " + newPass;
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            final Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            Transport.send(message);
            return "Wiadomość e-mail została wysłana";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "Nie udało się wysłać wiadomości e-mail.";
        }

    }

    private Properties setProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", mailSmtpAuth);
        prop.put("mail.smtp.starttls.enable", mailSmtpStarttlsEnable);
        prop.put("mail.smtp.host", mailSmtpHost);
        prop.put("mail.smtp.port", mailSmtpPort);
        prop.put("mail.smtp.ssl.trust", mailSmtpSslTrust);
        return prop;
    }

    private Session setSession() {
        return Session.getInstance(setProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailAddress, mailPassword);
            }
        });
    }


}
