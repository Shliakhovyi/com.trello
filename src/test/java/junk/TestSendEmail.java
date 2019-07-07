package junk;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

/**
 * Created by lolik on 04.07.2019
 */
public class TestSendEmail {


    @Test
    public void asdasd() throws EmailException {
        Email email = new SimpleEmail(); // Create Object
        email.setHostName("smtp.googlemail.com"); // Set SMTP hostname
        email.setSmtpPort(465); // Set port
        email.setAuthenticator(new DefaultAuthenticator("dashatest22@gmail.com", "1qaz2WSX3edc")); // Set email/password
        email.setSSLOnConnect(true); // SSL true
        email.setFrom("user@gmail.com"); // set FROM
        email.setSubject("TestMail"); // set Subject
        email.setMsg("This is a test mail ... :-)"); // Set message
        email.addTo("dashatest22@gmail.com"); // Set recipients
        email.send(); // Send Email
    }
}