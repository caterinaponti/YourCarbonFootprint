// https://www.wikihow.com/Calculate-Your-Carbon-Footprint

import java.util.Scanner;

public class YourCarbonFootprint {
	public static void main(String[] args) {
		System.out.println("Welcome to the Environmental Impact Calculator");
		System.out.println("This application calculates your carbon footprint points.");
		System.out.println("Enter ENTER to keep going");
		System.out.println("Enter QUIT to exit the program");

		Scanner scanner = new Scanner(System.in);

        int total_points = 0;

        while(true){
        	System.out.println("Enter your choice: ");
        	String choice = scanner.nextLine();

        	if (choice.equalsIgnoreCase("QUIT")){
        		System.out.println("Exiting program.");
        		break;
			}

			try{
        	int house_footprint = 0;
        	System.out.println("Insert the number of members of your household: ");
			String members = scanner.nextLine();
			if (members.equalsIgnoreCase("QUIT")) {
                    break;
                }
	        house_footprint = membersHousehold(members);
	        total_points += house_footprint;

	        int size_footprint = 0;
	        System.out.println("Consider the size of your home.");
			System.out.println("Enter 1 - Large");
			System.out.println("Enter 2 - Medium");
			System.out.println("Enter 3 - Small");
			System.out.println("Enter 4 - Apartment");
			String size = scanner.nextLine();
			if (size.equalsIgnoreCase("QUIT")) {
                    break;
                }
            size_footprint = sizeHome(size);
            total_points += size_footprint;

            int diet_footprint =0;
	        System.out.println("Evaluate your food choices.");
			System.out.println("Enter 1 - if you eat domestic meat on a daily basis.");
			System.out.println("Enter 2 - if you eat domestic meat a few times per week.");
			System.out.println("Enter 3 - if you are a vegetarian.");
			System.out.println("Enter 4 - If you are a vegan.");
			String diet = scanner.nextLine();
			if (diet.equalsIgnoreCase("QUIT")) {
                break;
            }
	        diet_footprint = diet(diet);
	        total_points += diet_footprint;
	  
	    	int water_footprint = 0;
	        System.out.println("Consider how many times per week you run your washing machine and/or dish washer.");
			System.out.println("Enter 0 - if you do not have a washing machine/dish washer.");
			System.out.println("Enter 1 - if you run your washing machine/dish washer 1 to 3 times per week.");
			System.out.println("Enter 2 - if you run your washing machine/dish washer 4 to 9 times per week.");
			System.out.println("Enter 3 - if you run your washing machine/dish washer more than 9 times per week.");
			String water = scanner.nextLine();
			if (water.equalsIgnoreCase("QUIT")) {
                break;
            }
	        water_footprint = waterConsumption(water);
	        total_points += water_footprint;
	    
            int waste_footprint = 0;
	        System.out.println("Consider how much waste you produce.");
			System.out.println("Enter 0 - if you fill half of a garbage can or less per week.");
			System.out.println("Enter 1 - if you fill 1 garbage cans each week.");
			System.out.println("Enter 2 - if you fill 2 garbage can per week.");
			System.out.println("Enter 3 - if you fill 3 garbage can per week.");
			System.out.println("Enter 4 - if you fill 4 garbage cans each week.");

			String waste = scanner.nextLine();
			if (waste.equalsIgnoreCase("QUIT")) {
                break;
            }
			waste_footprint = waste(waste);
	        total_points += waste_footprint;

	    	int transportation_footprint = 0;
	        System.out.println("Consider how far you travel with your car.");
			System.out.println("Enter 1 - if you travel more than 15,000 miles per year.");
			System.out.println("Enter 2 - if you travel 10,000 to 15,000 miles per year.");
			System.out.println("Enter 3 - if you travel 1,000 to 10,000 miles per year.");
			System.out.println("Enter 4 - if you travel less than 1,000 miles per year.");
			System.out.println("Enter 5 - if you don't have a car.");

			String transportation = scanner.nextLine();
			if (transportation.equalsIgnoreCase("QUIT")) {
                break;
            }
	        transportation_footprint = transportation(transportation);
	        total_points += transportation_footprint;

    }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1-4, or 'quit' to exit.");
                }
        break;
    }

    if(total_points < 45) {
                    System.out.println("Thank you!!");
                    System.out.println("Your carbon footprint is " + total_points + " points.");
                    System.out.println("You are making a small impact on the planet.");
                }
    else{
        System.out.println("Thank you!!");
        System.out.println("Your carbon footprint is " + total_points + " points.");
        System.out.println("Your footprint is higher than 50, you might want to look for some ways that you can reduce your impact.");
        System.out.println("For instance, you can replace old appliances with energy-efficient ones, purchase items with less packaging,\n use public transportation or carpool, compost, and recycle.");	
        }
}

	public static int membersHousehold(String members){
		int footprint = 0;
		Scanner scanner = new Scanner(System.in);
		while(true){
		try{
			Integer int_members = Integer.valueOf(members);

			if(int_members == 1){
				footprint = footprint + 14;
				break;
			}
			else if(int_members == 2){
				footprint = footprint + 12;
				break;
			}
			else if(int_members == 3){
				footprint = footprint + 10;
				break;
			}
			else if(int_members == 4){
				footprint = footprint + 8;
				break;
			}
			else if(int_members == 5){
				footprint = footprint + 6;
				break;
			}
			else if(int_members == 6){
				footprint = footprint + 4;
				break;
			}
			else if(int_members > 0 && int_members < 25){
				footprint = footprint + 2;
				break;
			}
			else{
				System.out.println("Invalid input. Enter a number of members between 1-25.");
	        	members = scanner.nextLine();
			}
		}
		catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number of members between 1-25, or 'quit' to exit.");
                members = scanner.nextLine();
            }
        }
        return footprint;
	}

	public static int sizeHome(String size){
		int footprint = 0;
		Scanner scanner = new Scanner(System.in);
		while(true){
	        if(size.equals("1")){
	        	footprint = footprint + 10;
	        	break;
	        }
	        else if(size.equals("2")){
	        	footprint = footprint + 7;
	        	break;
	        }
	        else if(size.equals("3")){
	        	footprint = footprint + 4;
	        	break;
	        }
	        else if(size.equals("4")){
	        	footprint = footprint + 2;
	        	break;
	        }
	        else{
	        	System.out.println("Invalid input. Enter a number between 1-4.");
	        	size = scanner.nextLine();
	        }
	    }
        return footprint;
	}

	public static int diet(String diet){
		int footprint = 0;
		Scanner scanner = new Scanner(System.in);

		while(true){
	        if(diet.equals("1")){
	        	footprint = footprint + 10;
	        	break;
	        }
	        else if(diet.equals("2")){
	        	footprint = footprint + 8;
	        	break;
	        }
	        else if(diet.equals("3")){
	        	footprint = footprint + 4;
	        }
	        else if(diet.equals("4")){
	        	footprint = footprint + 2;
	        	break;
	        }
	        else{
	        	System.out.println("Invalid input. Enter a number between 1-4.");
	        	diet = scanner.nextLine();
	        }
	    }
        return footprint;
	}

	public static int waterConsumption(String water){
		int footprint = 0;
		Scanner scanner = new Scanner(System.in);
		while(true){
	        if(water.equals("3")){
	        	footprint =+ 3;
	        	break;
	        }
	        else if(water.equals("2")){
	        	footprint =+ 2;
	        	break;
	        }
	        else if(water.equals("1")){
	        	footprint =+ 1;
	        	break;
	        }
	        else if(water.equals("0")){
	        	footprint =+ 0;
	        	break;
	        }
	        else{
	        	System.out.println("Invalid input. Enter a number between 0-3.");
	        	water = scanner.nextLine();
	        }
	    }
        return footprint;
	}

	public static int waste(String waste){
		int footprint = 0;
		Scanner scanner = new Scanner(System.in);
		while(true){
	        if(waste.equals("4")){
	        	footprint = footprint + 50;
	        	break;
	        }
	        else if(waste.equals("3")){
	        	footprint = footprint + 40;
	        	break;
	        }
	        else if(waste.equals("2")){
	        	footprint = footprint + 30;
	        	break;
	        }
	        else if(waste.equals("1")){
	        	footprint = footprint + 20;
	        	break;
	        }
	        else if(waste.equals("0")){
	        	footprint = footprint + 5;
	        	break;
	        }
	        else{
	        	System.out.println("Invalid input. Enter a number between 0-4.");
	        	waste = scanner.nextLine();
	        }
	    }
        return footprint;
	}

	public static int transportation(String transportation){
		int footprint = 0;
		Scanner scanner = new Scanner(System.in);
		while(true){
	        if(transportation.equals("1")){
	        	footprint = footprint + 12;
	        	break;
	        }
	        else if(transportation.equals("2")){
	        	footprint = footprint + 10;
	        	break;
	        }
	        else if(transportation.equals("3")){
	        	footprint = footprint + 6;
	        	break;
	        }
	        else if(transportation.equals("4")){
	        	footprint = footprint + 4;
	        	break;
	        }
	        else if(transportation.equals("5")){
	        	footprint = footprint + 0;
	        	break;
	        }
	        else{
	        	System.out.println("Invalid input. Enter a number between 1-5.");
	        	transportation = scanner.nextLine();
	        }
	    }
        return footprint;
	}
}