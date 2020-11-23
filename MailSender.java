package mail_demo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

class BabyAuthenticator extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication pa=new PasswordAuthentication("nvivek735", "v9837567310");
		return pa;
	}
}

public class MailSender {

	public static void main(String[] args) {

		try{
			
			Properties p=new Properties();
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", 587);
			//validate email password to sender
			
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.debug", "true");
			BabyAuthenticator ba=new BabyAuthenticator();
			//get session object jiske context m hame mail bhejna h
			
			Session s=Session.getDefaultInstance(p,ba);
			//create objrct of message to be send in context of this session.
			
			MimeMessage mm=new MimeMessage(s);
			
			//provide subject 
			mm.setSubject("Dont panic just a test mail");
			//specify type of recipient
			mm.setRecipients(RecipientType.TO,"viveksingh2121@gmail.com");
			
			//create body part
			
			MimeBodyPart bp=new MimeBodyPart();
			MimeBodyPart bp2=new MimeBodyPart();
			//associate text with body part
		//	int car=30;
			bp.setContent("<p>This is a message sent by java application</p>", "text/html");
			//create multipart to hold body part
		//	bp2.attachFile("C:\\Users\\VivekNeGi\\Desktop\\ab.jpg");
			
			MimeMultipart mp=new MimeMultipart();
			
			mp.addBodyPart(bp);
		//	mp.addBodyPart(bp2);
			//store multipart inside message
			
			mm.setContent(mp);
			//send this message to mail server
			
			Transport.send(mm);
			
			System.out.println("Message has been sent");
			
			
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
