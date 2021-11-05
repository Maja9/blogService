package blogService.service;

import blogService.dto.UserDto;
import blogService.entity.User;
import blogService.mapper.UserMapper;
import blogService.repository.UserRepository;

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
public class UserService {
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


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;

    }

    public Long createUser(UserDto userDto) {
        User userToSave = userMapper.map(userDto, User.class);
        if (userDto.getPassword() != null) {
            userToSave.setPassHash(userDto.getPassword().hashCode());
        }
        return userRepository.save(userToSave)
                .getId();

    }

    public UserDto getUser(Long userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            UserDto user = userMapper.map(optional.get(), UserDto.class);
            return user;
        }
        return null;
    }

    public String deleteUser(Long userId, String password) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent() && password.hashCode() == userRepository.findById(userId).get().getPassHash()) {
            userRepository.deleteById(userId);
            return "The user has been deleted.";
        }
        return "The user has not been deleted.";
    }

    public void resetPassword(final String email) {
        final User user = userRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
        final String temporaryPassword = RandomStringUtils.randomAlphanumeric(6);
        user.setPassHash(temporaryPassword.hashCode());
        userRepository.save(user);

        sendMessage(temporaryPassword, email);
    }

    private void sendMessage(final String newPass, final String email) {

        final Message message = new MimeMessage(setSession());
        try {
            message.setFrom(new InternetAddress("majadomin@gmail.com")); // adres nadawcy - na początek możesz podać go tutaj, w celu testów ale zależy mi abyć użyła @Value i pobrała wartość z pliku konfiguracyjnego
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Twoje nowe hasło do konta");
            String msg = "Twoje haslo do konta zosalo zresetowane. Nowe haslo to: " + newPass;
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            final Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private Properties setProperties() {
        Properties prop = new Properties();
        return prop;
    }

    private Session setSession() {
        return Session.getInstance(setProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("maja-domin@wp.pl", "adminadmin"); // te dane rwniez mają zostać wsktrzyknięte za pomocą @Value, najprawdopodobniej podasz tutaj dane swojego email - będziesz nadawcą i odbiorcą :)
            }
        });
    }


}
