package cn.edu.njupt.bigdata.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import cn.edu.njupt.bigdata.bean.AdminBean;
import cn.edu.njupt.bigdata.bean.EmailBean;
import cn.edu.njupt.bigdata.dao.AdminDao;
import cn.edu.njupt.bigdata.utils.ConstCodeUtils;

public class SendMailService {
	
	private String filePath = null;
	
	private Properties prop = null;
	
	private String content = null;
	
	private String subject = null;
	
	public SendMailService(String subject, String content, String filePath) {
		this.subject = subject;
		this.content = content;
		this.filePath = filePath;
		this.prop = new Properties();
		prop.setProperty("mail.stmp.host", ConstCodeUtils.MAIL_HOST);
		prop.put("mail.smtp.port", ConstCodeUtils.SMTP_PORT);
		prop.setProperty("mail.stmp.auth", "true");
	}
	
	public boolean execute() throws SQLException {
		Session sendMailSession = Session.getInstance(this.prop);
		sendMailSession.setDebug(true);
		try {
			Transport transport = sendMailSession.getTransport("smtp");
			Message message = new MimeMessage(sendMailSession);
			
			transport.connect(ConstCodeUtils.MAIL_HOST, ConstCodeUtils.SENDER_NAME, ConstCodeUtils.SENDER_PASSWORD);
			message.setFrom(new InternetAddress(ConstCodeUtils.SENDER));
			AdminDao adminDao = new AdminDao();
			AdminBean adminBean = adminDao.query("admin");
			System.out.println(adminBean.getAdminEmail());
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(adminBean.getAdminEmail()));
			//System.out.println(emailBean.getAdminEmail());
			message.setSubject(this.subject);
			message.setSentDate(new Date());
			
			BodyPart content = new MimeBodyPart();
			content.setContent(this.content, "text/html;charset=utf-8");
			
			BodyPart attach = new MimeBodyPart();
			DataHandler dh = new DataHandler(new FileDataSource(this.filePath));
			attach.setDataHandler(dh);
			attach.setFileName(MimeUtility.encodeText(dh.getName()));
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(content);
			multipart.addBodyPart(attach);
			
			message.setContent(multipart);
			message.saveChanges();
			
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
