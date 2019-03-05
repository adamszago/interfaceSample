package sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Programa {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter contract data");
		System.out.println("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Date (dd/mm/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.println("Contract Value: ");
		double totalValue = sc.nextDouble();
		Contract contract = new Contract(number, date, totalValue);
		System.out.println("Enter number of installments: ");
		int installments = sc.nextInt();
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, installments);
		System.out.println("Installments: ");
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
	}

}
