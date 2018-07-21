package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.Person;
import entities.PhysicalPerson;

public  class Program {
	
	public static void main(String args[]) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Person> persons = new ArrayList<>();
		
		
		System.out.print("Enter the number of tax payers: ");
		int nb = sc.nextInt();
		for(int i=1; i<=nb; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double income = sc.nextDouble();
			if(ch == 'c') {
				System.out.print("Number of employees: ");
				int nbEmployees = sc.nextInt();
				persons.add(new LegalPerson(name, income, nbEmployees));
			}else {
				System.out.print("Health expenditures: ");
				double spending = sc.nextDouble();
				persons.add(new PhysicalPerson(name, income, spending));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for(Person p : persons) {
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.getTax()));
		}
		
		double sum = 0;
		for(Person p : persons) {
			sum += p.getTax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ "  + String.format("%.2f", sum));
		
		
		sc.close();
	}

}
