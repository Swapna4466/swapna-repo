package com.zensar;

import java.util.List;
import java.util.Scanner;

import com.zensar.dao.EmployeeDAO;
import com.zensar.entity.Employee;

public class JDBCCRUD {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int choice = 0;
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee emp = new Employee();
		int status = 0;
		int id = 0;
		while (choice >= 0) {
			System.out.println("Welcome to Employee CRUD Operation");
			System.out.println("\t\t\t\t 1. View Employees");
			System.out.println("\t\t\t\t 2. Add Employee");
			System.out.println("\t\t\t\t 3. Update Employee");
			System.out.println("\t\t\t\t 4. Delete Employee");
			System.out.println("\t\t\t\t 5. Search Employee");
			System.out.println("\t\t\t\t 6. Exit");
			System.out.print("Enter your Choice [1-6] :");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				List<Employee> employees = employeeDAO.findAll();
				for (Employee employee : employees) {
					System.out.println(employee);
				}
				break;
			case 2:
				System.out.print("Enter Employee name :");
				emp.setName(input.next());
				System.out.print("Enter Employee Age :");
				emp.setAge(input.nextInt());
				System.out.print("Enter Salary of Employee:");
				emp.setSalary(input.nextInt());
				status = employeeDAO.addEmployee(emp);
				if (status > 0)
					System.out.println("One Record Inserted!!!");
				break;
			case 3:
				System.out.print("Enter Id of the Employee to Update :");
				id = 0;
				id = input.nextInt();
				emp = employeeDAO.findById(id);
				System.out.print("Enter Employee name to Update:");
				emp.setName(input.next());
				System.out.print("Enter Employee Age to Update:");
				emp.setAge(input.nextInt());
				System.out.print("Enter Salary of Employee to Update:");
				emp.setSalary(input.nextInt());
				status = employeeDAO.update(id, emp);
				if (status > 0)
					System.out.println("One Record Updated!!!");
				break;
			case 4:
				System.out.print("Enter Id of the Employee to Delete :");
				id = 0;
				id = input.nextInt();
				status = employeeDAO.delete(id);
				if (status > 0)
					System.out.println("One Record Deleted!!!");
				break;
			case 5:
				System.out.print("Enter Id of the Employee to Search :");
				id = 0;
				id = input.nextInt();
				emp = employeeDAO.findById(id);
				System.out.println("Searched Employee details :" + emp);
				break;
			case 6:
				System.out.println("Thank You. Have a Nice Day!!!");
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter a value between 1 and Six");
				break;
			}
		}
		input.close();

	}

}