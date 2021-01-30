package tutorials.days30;

import java.util.Scanner;

/**
 *
 *
 * @author gwon
 * @history
 *          2021. 1. 31. initial creation
 */
public class Day12Inheritance {

	public static class Person {
		protected String firstName;
		protected String lastName;
		protected int idNumber;

		// Constructor
		Person(String firstName, String lastName, int identification) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.idNumber = identification;
		}

		// Print person data
		public void printPerson() {
			System.out.println(
			        "Name: " + lastName + ", " + firstName
			                + "\nID: " + idNumber);
		}

	}

	public static class Student extends Person {
		/**
		 * @param firstName
		 * @param lastName
		 * @param identification
		 */
		Student(String firstName, String lastName, int identification, int[] testScores) {
			super(firstName, lastName, identification);
			this.testScores = testScores;
		}

		private int[] testScores;

		public String calculate() {
			int tot = 0;
			for (int i = 0; i < testScores.length; i++) {
				tot += testScores[i];
			}

			tot /= testScores.length;

			if (tot >= 90 && tot <= 100) {
				return "O";
			} else if (tot >= 80 && tot < 90) {
				return "E";
			} else if (tot >= 70 && tot < 80) {
				return "A";
			} else if (tot >= 55 && tot < 70) {
				return "P";
			} else if (tot >= 40 && tot < 55) {
				return "D";
			} else {
				return "T";
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for (int i = 0; i < numScores; i++) {
			testScores[i] = scan.nextInt();
		}
		scan.close();

		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}
