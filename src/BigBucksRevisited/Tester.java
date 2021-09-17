package BigBucksRevisited;

import java.text.NumberFormat;
import java.util.*;

public class Tester {
	public static void main(String[] args) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		String name;
		ArrayList<BankAccount> aryList = new ArrayList<BankAccount>();
		ListIterator<BankAccount> iterator = aryList.listIterator();
		do {
			Scanner kbReader = new Scanner(System.in);
			System.out.print("Please enter the name to whom the account belongs. (\"Exit\" to abort)");
			name = kbReader.nextLine();
			if (!name.equalsIgnoreCase("EXIT")) {
				System.out.print("Please enter the amount of the deposit. ");
				double amount = kbReader.nextDouble();
				System.out.println(" ");
				BankAccount inputtedUser = new BankAccount(name, amount);
				iterator.add(inputtedUser);
			}
		} while (!name.equalsIgnoreCase("EXIT"));
		System.out.println(iterator.hasPrevious());
		BankAccount ba = iterator.previous();
		double maxBalance = ba.balance;
		String maxName = ba.name;
		while (iterator.hasPrevious()) {
			BankAccount tempAcc = iterator.previous();
			if (tempAcc.balance > maxBalance) {
				maxBalance = tempAcc.balance;
				maxName = tempAcc.name;
			}
		}
		System.out.println("The account with the largest balance belongs to " + maxName);
		System.out.println("This amount is $" + formatter.format(maxBalance));
	}
}
