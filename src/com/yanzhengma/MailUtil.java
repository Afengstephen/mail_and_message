package com.yanzhengma;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * �ʼ�������
 */
public class MailUtil {
    /**
     * �����ʼ�
     * @param to ��˭��
     * @param text ��������
     */
    public static void send_mail(String to,String text) throws MessagingException {
        //�������Ӷ��� ���ӵ��ʼ�������
        Properties properties = new Properties();
        //���÷����ʼ��Ļ�������
        //�����ʼ�������
        properties.put("mail.smtp.host", "smtp.163.com");
        //���Ͷ˿�
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        
        MailSSLSocketFactory sf = null;    //qq����   ����ssl
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        
        //���÷����ʼ����˺ź�����
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //���������ֱ��Ƿ����ʼ����˻�������
                return new PasswordAuthentication("lgdafeng@163.com","zrh131415");
            }
        });

        //�����ʼ�����
        Message message = new MimeMessage(session);
        //���÷�����
        message.setFrom(new InternetAddress("lgdafeng@163.com"));
        //�����ռ���
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        //��������
        message.setSubject("�����֤�����£�");
        //�����ʼ�����  �ڶ����������ʼ����͵�����
        message.setContent(text,"text/html;charset=UTF-8");
        //����һ���ʼ�
        Transport.send(message);
    }
}
