package com.pradeep.java.practise.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Employee.class);
	private int empId;
	private String name;
	private String department;

	public Employee() {
		log.info("-----Employee()----");
	}
	
	public Employee(int empId, String name, String department) {
		super();
		log.info("-----Employee(-,-,-)----");
		this.empId = empId;
		this.name = name;
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", department=" + department + "]";
	}
	

}

public class SerializationTest {
	private static final String FILE_PATH = "C:/My_Data/employee.txt";
	private static final Logger log = LoggerFactory.getLogger(SerializationTest.class);
	
	public static void main(String[] args) {
		
			Employee employee = new Employee(101, "Pradeep", "IT");
			boolean result = serialize(employee);
			
			if(result){
				log.info("----Employee got serialized successfully---");
			}else{
				log.info("----Problem occured while serialization of Employee---");
			}
	
			Employee employee2 = deSerialize();
			log.info("----Employee got deSerialized with result : employee : {}---", employee);
	}

	private static boolean serialize(Employee employee){
		boolean result = false;
		try{
		FileOutputStream outputStream = new FileOutputStream(FILE_PATH);
		ObjectOutputStream oos = new ObjectOutputStream(outputStream);
		oos.writeObject(employee);
		result = true;
		
	}  
	catch (IOException e) {
		log.error("----serialization failed with exception : {}, and stack trace : {} -----", e.getMessage(), e.getStackTrace());
	}

		return result;
	}
	
	private static Employee deSerialize(){
		Employee employee = null;
		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);
			employee = (Employee) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			log.error("----deSerialization failed with exception : {}, and stack trace : {} -----", e.getMessage(), e.getStackTrace());
		}
		return employee;
	}
}
