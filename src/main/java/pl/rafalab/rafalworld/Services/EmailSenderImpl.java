package pl.rafalab.rafalworld.Services;

import java.util.Properties;

import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service("emailSender")
public class EmailSenderImpl implements EmailSender {


	private static final Logger LOG = LoggerFactory.getLogger(EmailSenderImpl.class);	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    return mailSender;
	}
	
	
	
	@Override
	public void sendEmail(String to, String subject, String text) {
		String from="noreply@rafalworld.pl";
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
		try{
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true);
			messageHelper.setTo(to);
			messageHelper.setFrom(from);
			messageHelper.setSubject(subject);
			messageHelper.setText(text,true);		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		javaMailSender.send(mailMessage);
		LOG.info("***Wysłano email z potiwerdzeniem linkiem aktywacyjnym na adres: "+to);
	}

}
