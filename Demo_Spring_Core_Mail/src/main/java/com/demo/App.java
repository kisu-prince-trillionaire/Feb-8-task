package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.demo.bean.MailMail;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory b = new XmlBeanFactory(r);
		MailMail m = (MailMail) b.getBean("mailMail");
		String sender = "sendergmailid@gmail.com";// write here sender gmail id
		String receiver = "receiveremailid@gmail.com";// write here receiver id
		m.sendMail(sender, receiver, "hi", "welcome");

		System.out.println("success");
	}
}
