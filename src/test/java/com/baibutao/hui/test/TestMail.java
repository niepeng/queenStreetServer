package com.baibutao.hui.test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class TestMail {
	
	public static void main(String[] args) {
		send();
	}
	
	private static void send() {
		SimpleEmail email = new SimpleEmail();           
        email.setTLS(true);  
//        email.setSSL(true);
        // 在做发送邮件的java，一定要记得把邮箱的pop3.smtp服务开启,  发送邮箱->选择对应的邮件服务器
        email.setHostName("smtp.126.com");     
        email.setAuthentication("kuailezhoumo_app@126.com", "hello1234");   //用户名和密码        
                
        try         
        {        
            email.addTo("lsb20352891@126.com"); //接收方        
            email.setFrom("kuailezhoumo_app@126.com");       //发送方
            email.setCharset("GBK");
            email.setSubject("快乐周末订单来了：");         //标题           
            email.setMsg("您好：邮件报警了，温湿度偏高");   //内容           
            email.send();         
                    
        } catch (EmailException e) {        
            e.printStackTrace();        
        }    
	}
}


	