package middleEarthApp.menu;

import middleEarth.council.MiddleEarthCouncil;
import middleEarth.character.subtypes.*;

public class MiddleEarthAppMenu {

	/**
	 * This prints all the menu options to console.
	 */
	public static void printOptions() {
		System.out.println("Please select which option you would like to take:\n");
		System.out.println("[1] Add a new character.");
		System.out.println("[2] View all characters.");
		System.out.println("[3] Update a character.");
		System.out.println("[4] Delete a character.");
		System.out.println("[5] Execute all characters' attack actions.");
		System.out.println("[6] Exit.");
		System.out.println();
	}
	
	/**
	 * This creates a new Middle Earth Character using parameters and adds it to Character Manager.
	 * 
	 * @param race This parameter takes a string for the Character race.
	 * @param name This parameter takes a string for the Character name.
	 * @param health This parameter takes a double for the Character health.
	 * @param power This parameter takes a double for the Character power.
	 */
	public static void addNewChar(String race, String name, double health, double power) {
		
		// Gets sole instance of Council
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
			
		System.out.println("Adding new character...");
		boolean addSuccess = false;
		
		// Determines which constructor to use based on race parameter
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
		
		// Prints success/failure message to console
		if(addSuccess) {
			System.out.println("Character addition successful!\n");
		}
		else {
			System.out.println("Error adding new character\n");
		}
			
	}
	
	/**
	 * This prints all Characters to console.
	 */
	public static void viewCharacters() {
		
		// Gets sole instance of Council
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		// Calls display method from Character Manager
		council.getCharacterManager().displayAllCharacters();
		System.out.println();
	
	}
	
	/**
	 * This takes Character parameters and attempts to update Character.
	 * This responds accordingly based on update success/failure.
	 * 
	 * @param name This parameter takes a string for the name of Character to update.
	 * @param health This parameter takes a double for Character health to update.
	 * @param power This parameter takes a double for Character power to update.
	 */
	public static void updateChar(String name, double health, double power) {
		
		// Gets sole instance of Council
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
					
		System.out.println("Updating character...");
			
		// Calls update method from Character Manager with parameter and tests success/failure
		if(council.getCharacterManager().updateCharacter(council.getCharacterManager().getCharacter(name), name, health, power)) {
			System.out.println("Update successful!\n");
		}
		else {
			System.out.println("Error: no updates or character not found\n");
		}

	}
	
	/**
	 * This takes string and deletes Character from Character Manager.
	 * 
	 * @param name This parameter takes a string for the name of Character to delete.
	 */
	public static void deleteChar(String name) {
		
		// Gets sole instance of Council
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		
		System.out.println("Deleting character...");
			
		// Calls deletion method from Character Manager using parameter and tests success/failure
		if(council.getCharacterManager().deleteCharacter(council.getCharacterManager().getCharacter(name))) {
			System.out.println("Deletion successful!\n");
		}
		else {
			System.out.println("Error deleting character\n");
		}
		
	}
	
	// TODO javadoc after deciding how to do this...
	public static void attackChar() {
		
		// If function wants to every character to attack every other character, use this
		
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		
		System.out.println("Starting attack sequence...\n");
		
		for(int i = 0; i < council.getCharacterManager().size; i++) {
			for(int j = 0; j < council.getCharacterManager().size; j++) {
				
				council.getCharacterManager().characters[i].attack(council.getCharacterManager().characters[j]);
				if(council.getCharacterManager().characters[j].getHealth() <= 0) {
					
					System.out.println(council.getCharacterManager().characters[j].getName() + " was killed by " + 
										council.getCharacterManager().characters[i].getName() + ".");
					council.getCharacterManager().deleteCharacter(council.getCharacterManager().characters[j]);	
					
				}
				
			}
		}
		
		System.out.println("\nAttack sequence completed. Remaining characters:\n");
		council.getCharacterManager().displayAllCharacters();
		
		
		// If the function instead takes an attacker and target parameters, use this
		
		/*
		
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		
		council.getCharacterManager().getCharacter(attacker).attack(council.getCharacterManager().getCharacter(target));
		
		if(council.getCharacterManager().getCharacter(target).getHealth() <= 0) {
			System.out.println(target + " was killed by " + attacker);
			council.getCharacterManager().deleteCharacter(council.getCharacterManager().getCharacter(target));
		}
		*/
		
	}
	
	/**
	 * This prints exit message to console.
	 */
	public static void exit() {
		System.out.println("\nExiting simulation...");
	}
}