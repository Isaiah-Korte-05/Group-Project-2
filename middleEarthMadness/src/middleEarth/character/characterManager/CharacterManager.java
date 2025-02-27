package middleEarth.character.characterManager;

import middleEarth.character.MiddleEarthCharacter;

public class CharacterManager {

	// Class fields for CharacterManager
	public MiddleEarthCharacter[] characters; // stores MiddleEarthCharacter objects
	public int size = 0; // tracks stored characters
	
	/**
	 * This is a constructor that initializes a MiddleEarthCharater array
	 * of size 4
	 */
	public CharacterManager() {
		this.characters = new MiddleEarthCharacter[4];
	}
	
	//TODO how to test success
	/**
	 * This adds a MiddleEarthCharacter. If the array is full, doubles array.
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		
		if(size == (characters.length - 1)) {
	        MiddleEarthCharacter[] newArray = new MiddleEarthCharacter[characters.length * 2];
	        System.arraycopy(characters, 0, newArray, 0, characters.length);
	        characters = newArray;
		}
		
		characters[size] = c;
		size++;
		
		return true;
	}
	
	/**
	 * This retrieves a MiddleEarthCharacter by name
	 * @param name This parameter is a String of the name of the desired MiddleEarthCharacter
	 * @return Returns MiddleEarthCharacter object if found,
	 * 		   or null if not found
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for (int i = 0; i < size; i++) {
			if (characters[i].getName() == name) {
				return characters[i];
			}
		}
		return null;
	}
	
	/**
	 * This updates a MiddleEarthCharacter
	 * @param character This parameter is the MiddleEarthCharacter object to be updated
	 * @param name This parameter is a String of the desired updated MiddleEarthCharacter name
	 * @param health This parameter is a double of the desired updated MiddleEarthCharacter health
	 * @param power This parameter is a double of the desired updated MiddleEarthCharacter power
	 * @return Returns true if a change is made to the MiddleEarthCharacter,
	 * 		   or false if there is no change or the MiddleEarthCharacter does not exist
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		
		boolean change = false;
		for(int i = 0; i < size; i++) {
			if (characters[i] == character) {
				if (characters[i].getName() != name) {
					characters[i].setName(name);
					change = true;
				}
				if (characters[i].getHealth() != health) {
					characters[i].setHealth(health);
					change = true;
				}
				if (characters[i].getPower() != power) {
					characters[i].setPower(power);
					change = true;
				}
			}
		}
		if (change) {
			return true;
		}
		return false;
	}
	
	// TODO how to test success
	/**
	 * This deletes a MiddleEarthCharacter and shifts later elements in the array.
	 * @param character This parameter is the MiddleEarthCharacter object to be deleted
	 * @return Returns true if MiddleEarthCharacter is successfully deleted,
	 * 		   or false if character not found
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		
		for (int i = 0; i < size; i++) {
			if (characters[i] == character) {
				for(int j = i; characters[j] != null; j++) {
					characters[j] = characters[j + 1];
				}
				size--;
				return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * This displays all characters.
	 */
	public void displayAllCharacters() {
		
		System.out.println("--------------------------------------");
		System.out.println("Name\t\tHealth\t\tPower");
		System.out.println("--------------------------------------");
		for (int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
		System.out.println("--------------------------------------");
	}
}
