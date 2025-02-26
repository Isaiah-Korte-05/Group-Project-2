package middleEarth.character.characterManager;

import middleEarth.character.MiddleEarthCharacter;

public class CharacterManager {

	public MiddleEarthCharacter[] characters;
	public int size = 0;
	
	//TODO how to do tests for returns?
	public boolean addCharacter(MiddleEarthCharacter c) {
		
		if(size == characters.length - 1) {
	        int[] newArray = new int[characters.length * 2];
	        System.arraycopy(characters, 0, newArray, 0, characters.length);
		}
		
		characters[++size] = c;
		
		return true;
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		for (int i = 0; i < size; i++) {
			if (characters[i].getName() == name) {
				return characters[i];
			}
		}
		return null;
	}
	
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		boolean change = false;
		// TODO this could be wrong, idk if we check if the character is in the array or not
		// I think this is right, since it has to check for a matching character b4 every getting to edit 'change'
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
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		
		for (int i = 0; i < size; i++) {
			if (characters[i] == character) {
				for(int j = i; characters[j] == null; j++) {
					characters[j] = characters[j + 1];
				}
				return true;
			}
		}
		
		return false;
		
	}
	
	public void displayAllCharacters() {
		for (int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
}
