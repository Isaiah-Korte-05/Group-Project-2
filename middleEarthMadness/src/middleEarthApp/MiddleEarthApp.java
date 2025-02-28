package middleEarthApp;

import middleEarthApp.menu.MiddleEarthAppMenu;

public class MiddleEarthApp {

	public static void main(String[] args) {

		System.out.println("Starting simulation...");
		
		// Prints menu options
		MiddleEarthAppMenu.printOptions();
		
		// Adds characters One through Three
		MiddleEarthAppMenu.addNewChar("human", "Boromir", 14, 2);
		MiddleEarthAppMenu.addNewChar("elf", "Legolas", 31, 10);
		MiddleEarthAppMenu.addNewChar("human", "Aragorn", 38, 5);
		
		// Prints all characters
		MiddleEarthAppMenu.viewCharacters();
		
		// Updates character with changes
		MiddleEarthAppMenu.updateChar("Aragorn", 50, 10);
		
		// Adds characterFour
		MiddleEarthAppMenu.addNewChar("dwarf", "Gimli", 27, 3);
		
		// Tries to update character with no changes
		MiddleEarthAppMenu.updateChar("Legolas", 31, 10);
		
		// Deletes character
		MiddleEarthAppMenu.deleteChar("Gimli");
				
		// Adds characters Five through Eight
		MiddleEarthAppMenu.addNewChar("orc", "Azog", 12, 8);
		MiddleEarthAppMenu.addNewChar("wizard", "Gandalf", 26, 7);
		MiddleEarthAppMenu.addNewChar("dwarf", "Gloin", 17, 4);
		MiddleEarthAppMenu.addNewChar("elf", "Elrond", 11, 8);
		
		// Prints all characters
		MiddleEarthAppMenu.viewCharacters();
		
		// Initiates attack sequence
		MiddleEarthAppMenu.attackAllChar();
		
		// Exits simulation
		MiddleEarthAppMenu.exit();

	}

}
