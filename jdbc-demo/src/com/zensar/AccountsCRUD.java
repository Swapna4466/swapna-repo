package com.zensar;

import java.util.List;
import java.util.Scanner;

import com.zensar.dao.AccountsDAO;
import com.zensar.entity.Accounts;

public class AccountsCRUD {

	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		int choice = 0;

		AccountsDAO accountsDAO = new AccountsDAO();
		Accounts acc = new Accounts();

		int status = 0;
		int id = 0;

		while (choice >= 0) {
			System.out.println("Welcome to Account CRUD Operation");
			System.out.println("\t\t\t\t 1. View Accounts");
			System.out.println("\t\t\t\t 2. Add Account");
			System.out.println("\t\t\t\t 3. Update Account");
			System.out.println("\t\t\t\t 4. Delete Account");
			System.out.println("\t\t\t\t 5. Search Account");
			System.out.println("\t\t\t\t 6. Exit");
			System.out.print("Enter your Choice [1-6] :");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				List<Accounts> accounts = accountsDAO.findAll();
				for (Accounts employee : accounts) {
					System.out.println(employee);
				}
				break;
			case 2:
				System.out.print("Enter Account name :");
				acc.setAccountType(input.next());
				System.out.print("Enter Account Interest Rate :");
				acc.setInterestRate(input.nextFloat());
				System.out.print("Enter Subcategory of Account:");
				acc.setSubcategory(input.next());
				System.out.print("Enter Account Minimum balance :");
				acc.setMinimum_bal(input.nextDouble());
				status = accountsDAO.addAccount(acc);
				if (status > 0)
					System.out.println("One Record Inserted!!!");
				break;
			case 3:
				System.out.print("Enter Account_Id of the Account to Update :");
				id = 0;
				id = input.nextInt();
				acc = accountsDAO.findById(id);
				System.out.print("Enter Account type to Update:");
				acc.setAccountType(input.next());
				System.out.print("Enter Interest rate to Update:");
				acc.setInterestRate(input.nextFloat());
				System.out.print("Enter sub category to Update:");
				acc.setSubcategory(input.next());
				System.out.print("Enter minimum balance to Update:");
				acc.setMinimum_bal(input.nextDouble());
				status = accountsDAO.update(id, acc);
				if (status > 0)
					System.out.println("One Record Updated!!!");
				break;
			case 4:
				System.out.print("Enter Id of the Account to Delete :");
				id = 0;
				id = input.nextInt();
				status = accountsDAO.delete(id);
				if (status > 0)
					System.out.println("One Record Deleted!!!");
				break;
			case 5:
				System.out.print("Enter Id of the Account to Search :");
				id = 0;
				id = input.nextInt();
				acc = accountsDAO.findById(id);
				System.out.println("Searched Account details :" + acc);
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
