package org.asdtiang.grails.service
import java.lang.Thread.UncaughtExceptionHandler

import javax.mail.internet.MimeMessage

import org.springframework.mail.javamail.MimeMessageHelper
class AsyncMailService {
	static scope = "singleton"
	def javaMailSender
	def taskExecutor
	public boolean sendSimpleEmail(String subject,String text,String toEmail){
		return sendSimpleEmail(null, subject, text, toEmail);
	}
	public boolean sendSimpleEmail(String sendName,String subject,String text,String toEmail){
		return sendSimpleEmail(null, sendName, subject, text, toEmail);
	}
	public boolean sendSimpleEmail(String sendFrom,String sendName,String subject,String text,String toEmail){
		try{
			EmailBean emailBean=new EmailBean( sendFrom,  sendName,  subject,
					text,toEmail);
			sendMailByAsynchronousMode(emailBean);
			return true;
		}
		catch(Exception e){
			e.printStackTrace()
			return false;
		}
	}
	public void sendMailByAsynchronousMode(EmailBean emailBean){
		taskExecutor.execute(new Runnable(){
					public void run(){
						try{
							MimeMessage mimeMessage = javaMailSender.createMimeMessage();
							MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");;
							messageHelper.setTo(emailBean.getToEmail());
							if(null==emailBean.getSendFrom()){
								emailBean.setSendFrom(emailBean.sendFrom);
							}
							if(null!=emailBean.getSendName()&&!"".equals(emailBean.getSendName().trim())){
								messageHelper.setFrom(emailBean.getSendFrom(), emailBean.getSendName());
							}
							else{
								messageHelper.setFrom(emailBean.getSendFrom());
							}
							messageHelper.setSubject(emailBean.getSubject());
							messageHelper.setText(emailBean.getText(),true);
							javaMailSender.send(mimeMessage); 
						}
						catch(Exception e){
							e.printStackTrace()
						}
					}
				})
	}
	
	
	
	class ExceptionHandler implements UncaughtExceptionHandler {
		public void uncaughtException(Thread t, Throwable e) {
			System.out.printf("An exception has been captured\n");
			System.out.printf("Thread: %s\n", t.getId());
			System.out.printf("Exception: %s: %s\n",
					e.getClass().getName(), e.getMessage());
			System.out.printf("Stack Trace: \n");
			e.printStackTrace(System.out);
			System.out.printf("Thread status: %s\n", t.getState());
		}
	}
	
	class EmailBean {
		private String sendFrom;
		private String sendName;
		private String subject;
		private String text;
		private boolean  isHtml;

		public boolean isHtml() {
			return isHtml;
		}

		public void setHtml(boolean html) {
			isHtml = html;
		}

		private String toEmail;


		public EmailBean(String sendFrom, String sendName, String subject,
		String text, String toEmail) {
			super();
			this.sendFrom = sendFrom;
			this.sendName = sendName;
			this.subject = subject;
			this.text = text;
			this.toEmail = toEmail;
		}
		public String getSendFrom() {
			return sendFrom;
		}
		public void setSendFrom(String sendFrom) {
			this.sendFrom = sendFrom;
		}
		public String getSendName() {
			return sendName;
		}
		public void setSendName(String sendName) {
			this.sendName = sendName;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getToEmail() {
			return toEmail;
		}
		public void setToEmail(String toEmail) {
			this.toEmail = toEmail;
		}
	}
}
