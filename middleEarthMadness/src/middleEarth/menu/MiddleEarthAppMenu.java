package middleEarth.menu;

import java.util.Scanner;

import middleEarth.council.MiddleEarthCouncil;

import middleEarth.character.subtypes.*;

public class MiddleEarthAppMenu {

	private static void printOptions() {
		System.out.println("Please select which option you would like to take:");
		System.out.println("[1] Add a new character.");
		System.out.println("[2] View all characters.");
		System.out.println("[3] Update a character.");
		System.out.println("[4] Delete a character.");
		System.out.println("[5] Execute all characters' attack actions.");
		System.out.println("[6] Exit.");
		
	}
	
	private static void addNewChar(MiddleEarthCouncil council) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			String name;
			String race;
			double health;
			double power;
			
			System.out.println("Please enter new character name:");
			name = scanner.nextLine();
			
			System.out.println("Please enter new character health:");
			health = scanner.nextDouble();
			scanner.nextLine();
			
			System.out.println("Please enter new character power:");
			power = scanner.nextDouble();
			scanner.nextLine();
			
			System.out.println("Please enter new character race:");
			race = scanner.nextLine();
			System.out.println();
			
			System.out.println("Creating and adding new character...");
			boolean addSuccess = false;
			
			switch(race.toLowerCase()) {
			
			case "dwarf":
				addSuccess = council.getCharacterManager().addCharacter(new Dwarf(name, health, power));
				break;
				
			case "elf":
				addSuccess = council.getCharacterManager().addCharacter(new Elf(name, health, power));
				break;
				
			case "human":
				addSuccess = council.getCharacterManager().addCharacter(new Human(name, health, power));
				break;
				
			case "orc":
				addSuccess = council.getCharacterManager().addCharacter(new Orc(name, health, power));
				break;
				
			case "wizard":
				addSuccess = council.getCharacterManager().addCharacter(new Wizard(name, health, power));
				break;
			
			}
			
			if(addSuccess) {
				System.out.println("Character addition successful!\n");
			}
			else {
				System.out.println("Error adding new character.\n");
			}
			
		}
		
	}
	
	private static void viewCharacters(MiddleEarthCouncil council) {
		council.getCharacterManager().displayAllCharacters();
	}
	
	private static void updateChar(MiddleEarthCouncil council) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			String character;
			String name;
			double health;
			double power;
			
			boolean update;
			
			System.out.println("Select which character to delete:");
			council.getCharacterManager().displayAllCharacters();
			System.out.println();
			
			character = scanner.nextLine();
			
			System.out.println("Please enter updated name:");
			name = scanner.nextLine();
			
			System.out.println("Please enter updated health:");
			health = scanner.nextFloat();
			scanner.nextLine();
			
			System.out.println("Please enter updated power:");
			power = scanner.nextFloat();
			scanner.nextLine();
			System.out.println();
			
			System.out.println("Updating character...");
			
			update = council.getCharacterManager().updateCharacter(council.getCharacterManager().getCharacter(character), name, health, power);
			
			if(update) {
				System.out.println("Update successful!\n");
			}
			else {
				System.out.println("Error: no updates made or character not found.\n");
			}
			
		}

	}
	
	private static void deleteChar(MiddleEarthCouncil council) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			String name;
			
			System.out.println("Select which character to delete:");
			council.getCharacterManager().displayAllCharacters();
			System.out.println();
			
			name = scanner.nextLine();
			System.out.println("Deleting...");
			
			if(council.getCharacterManager().deleteCharacter(council.getCharacterManager().getCharacter(name))) {
				System.out.println("Deletion successful!\n");
			}
			else {
				System.out.println("Error deleting character.\n");
			}
		}
		
	}
	
	private static void attackChar(MiddleEarthCouncil council) {
		//TODO write attack func
	}
	
	public static void menu() {
		
		System.out.println("Starting Middle Earth Simulation...");
		
		boolean exit = false;
		int option;
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		
		try (Scanner scanner = new Scanner(System.in)) {
			while(!exit) {
				
				printOptions();
				option = scanner.nextInt();
				scanner.nextLine();
				
				switch(option) {
				
				case 1:
					addNewChar(council);
					break;
					
				case 2:
					viewCharacters(council);
					break;
					
				case 3:
					updateChar(council);
					break;
					
				case 4:
					deleteChar(council);
					break;
					
				case 5:
					attackChar(council);
					break;
					
				case 6:
					exit = true;
					break;
				
				}
				
			}
			
			System.out.println("Exiting menu...");
			
		}
		
	}
	
}