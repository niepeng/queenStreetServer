package com.baibutao.hui.common;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class MailUtil {

	/**
	 * 发送邮件
	 * 
	 * @param email
	 * @param title
	 * @param content
	 */
	public static void sendMail(String emailAddress, String title, String content) {
		SimpleEmail email = new SimpleEmail();           
        email.setTLS(true);  
//        email.setSSL(true);
        // 在做发送邮件的java，一定要记得把邮箱的pop3.smtp服务开启,  发送邮箱->选择对应的邮件服务器
        email.setHostName("smtp.126.com");     
        email.setAuthentication("kuailezhoumo_app@126.com", "hello1234");   //用户名和密码        
                
        try         
        {        
            email.addTo(emailAddress); //接收方        
            email.setFrom("kuailezhoumo_app@126.com");       //发送方
            email.setCharset("GBK");
            email.setSubject(title);         //标题           
            email.setMsg(content);   //内容           
            email.send();         
                    
        } catch (EmailException e) {        
            e.printStackTrace();        
        }    
	
	}
}
