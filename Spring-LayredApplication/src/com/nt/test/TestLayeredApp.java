package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

public class TestLayeredApp {
    
	 public static void main(String[] args) {
		 
		 Scanner sc =null;
		 String  sno=null;
		 String sname =null;
		 String saddr =null;
		 String m1,m2,m3;		 
		 StudentVO vo =new StudentVO();
		 Resource res =null;
		 BeanFactory factory =null;
		 MainController maincon =null;
		String result =null;
		
		 
		 //specify the class path resource 
		 res =new ClassPathResource("com/nt/config/ApplicationContext.xml");
		 //create IOC  controller
		 factory =new XmlBeanFactory(res);	 
		 //create controller object
		 maincon =factory.getBean("controller",MainController.class);		 
		 
		 
		 //create scanner object
		 sc =new Scanner(System.in);
		 System.out.println("Enter sno ::");
		 sno = sc.nextLine();
		 System.out.println("Enter sname ::");
		 sname = sc.nextLine();
		 System.out.println("Enter saddr ::");
		 saddr =sc.nextLine();
		 System.out.println("Enter m1 ::");
		 m1 =sc.nextLine();
		 System.out.println("Enter m2 ::");
		 m2 =sc.nextLine();
		 System.out.println("Enter m3  ::");
		 m3 =sc.nextLine();
		 
		 vo.setSno(sno);
		 vo.setSname(sname);
		 vo.setSaddr(saddr);
		 vo.setM1(m1);
		 vo.setM2(m2);
		 vo.setM3(m3);
		 
		try {
			result =maincon.process(vo);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
				 
		 
   }//main
}//class
