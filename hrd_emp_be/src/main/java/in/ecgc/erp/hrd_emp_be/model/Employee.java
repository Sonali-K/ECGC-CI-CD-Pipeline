package in.ecgc.erp.hrd_emp_be.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;


/**
 *Employee Model class
 *
 *@version 1.0 31-March-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
@Data
public class Employee {
	int empId;
	
	String firstName;
	
	String midName;
	
	String lastName;
	
	String dob;
	
	String doj;
	
	String empType;
	
	String designation;
}
