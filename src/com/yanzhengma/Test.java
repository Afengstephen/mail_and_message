package com.yanzhengma;
import javax.mail.MessagingException;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        try {
        	String yanzheng = ""+(int)(Math.random() * 9999);
            MailUtil.send_mail("1660355218@qq.com", yanzheng);
            System.out.println(yanzheng);
            System.out.println("邮件发送成功!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
}