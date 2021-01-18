import java.util.Scanner;

public class Final {

	public static int floors = 2; // global constant for how many floors there are

	public static void main(String[] args) {
		boolean doorsPosition = false; // false is open
		boolean motor = false; // false is off
		boolean grooves = false; // false is off
		int position = 0; // elevator current floor
		String looper = "Y";

		while (looper.equals("Y")) { // .equals is for string shannagains

			// initial setup for elevator
			System.out.println("door open greeting user" + "\n" + "the elevator current position is: " + position + "\n"
					+ "motor usage: " + motor + "\n" + "grooves usage: " + grooves + "\n" + "doors placements: "
					+ doorsPosition + "\n\n");

			// what happens when the user pushes a button on the elevator
			doorsPosition = activate(doorsPosition); // door closes
			position = elevator(position); // user determined elevator location
			motor = activate(motor); // motor on

			System.out.println("elevator in use" + "\n" + "the elevator is currently heading to:  " + position + "\n"
					+ "motor usage: " + motor + "\n" + "grooves usage: " + grooves + "\n" + "doors placements: "
					+ doorsPosition + "\n\n");

			// elevator stops
			grooves = activate(grooves); // grooves on
			motor = activate(motor); // motor off
			doorsPosition = activate(doorsPosition); // doors open

			// elevator reaches its destination
			System.out.println("elevator at its destination" + "\n" + "the elevator current position is:  " + position
					+ "\n" + "motor usage: " + motor + "\n" + "grooves usage: " + grooves + "\n" + "doors placements: "
					+ doorsPosition + "\n\n");

			grooves = activate(grooves); // groves off

			// Entering Y or N will loop or end the program
			System.out.println(" Continue Y/N ");
			Scanner paycheck = new Scanner(System.in);
			looper = paycheck.next();
			System.out.println(looper);
		}
	}

	public static boolean activate(boolean component) { // this simplify switches the boolean value
		if (component == false)
			component = true;
		else
			component = false;
		return component;
	}

	public static int elevator(int position) {
		int startingPoint = position;
		int start;

		// scans user input
		Scanner KB = new Scanner(System.in);
		System.out.print(" Basement = 0 \n First floor = 1 \n Second floor = 2 \n input: ");
		position = KB.nextInt();
		System.out.print("\n\n");

		// checks if input is valid
		while (!(position <= floors) || position < 0 || position == startingPoint) {
			System.out.println("Error input invalid please try again");
			position = KB.nextInt();
			System.out.print("\n\n");
		}

		// sees how many far the elevator moved
		start = startingPoint - position;
		if (start < 0)
			start *= -1;
		System.out.println("moving " + start + " floors\n\n");

		return position;
	}

}
