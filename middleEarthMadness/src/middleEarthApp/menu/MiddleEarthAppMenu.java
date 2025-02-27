package middleEarthApp.menu;

import middleEarth.council.MiddleEarthCouncil;
import middleEarth.character.subtypes.*;

public class MiddleEarthAppMenu {

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
	
	public static void addNewChar(String race, String name, long health, long power) {
		
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
			
		System.out.println("Adding new character...");
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
			System.out.println("Error adding new character\n");
		}
			
	}
	
	public static void viewCharacters() {
		
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		council.getCharacterManager().displayAllCharacters();
		System.out.println();
	
	}
	
	public static void updateChar(String name, double health, double power) {
			
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
					
		System.out.println("Updating character...");
			
		if(council.getCharacterManager().updateCharacter(council.getCharacterManager().getCharacter(name), name, health, power)) {
			System.out.println("Update successful!\n");
		}
		else {
			System.out.println("Error: no updates or character not found\n");
		}

	}
	
	public static void deleteChar(String name) {
		
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		
		System.out.println("Deleting character...");
			
		if(council.getCharacterManager().deleteCharacter(council.getCharacterManager().getCharacter(name))) {
			System.out.println("Deletion successful!\n");
		}
		else {
			System.out.println("Error deleting character\n");
		}
		
	}
	
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
	
	public static void exit() {
		System.out.println("\nExiting simulation...");
	}
}