package com.yanzhengma;
import javax.mail.MessagingException;

/**
 * ������
 */
public class Test {
    public static void main(String[] args) {
        try {
        	String yanzheng = ""+(int)(Math.random() * 9999);
            MailUtil.send_mail("1660355218@qq.com", yanzheng);
            System.out.println(yanzheng);
            System.out.println("�ʼ����ͳɹ�!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
}