package lesson21;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendEmailTest {
@Test
 public void azaza() throws EmailException {
     Email email = new SimpleEmail(); // Create Object
     email.setHostName("smtp.googlemail.com"); // Set SMTP hostname
     email.setSmtpPort(465); // Set port
     email.setAuthenticator(new DefaultAuthenticator("svitlana.mykolaienko@gen.tech", "")); // Set email/password
     email.setSSLOnConnect(true); // SSL true
     email.setFrom("svitlana.mykolaienko@gen.tech"); // set FROM
     email.setSubject("TestMail"); // set Subject
     email.setMsg("This is a test mail ... :-)"); // Set message
     email.addTo("svitlana.mykolaienko@gen.tech"); // Set recipients
     email.send(); // Send Email
 }
}
