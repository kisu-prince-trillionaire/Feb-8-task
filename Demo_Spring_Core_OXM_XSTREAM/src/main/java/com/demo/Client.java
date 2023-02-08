package com.demo;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.stream.StreamResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;

import com.demo.bean.Employee;

public class Client {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Marshaller marshaller = (Marshaller) context.getBean("xstreamMarshallerBean");

		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("Sonoo Jaiswal");
		employee.setSalary(100000);

		marshaller.marshal(employee, new StreamResult(new FileWriter("employee.xml")));

		System.out.println("XML Created Sucessfully");
	}
}
