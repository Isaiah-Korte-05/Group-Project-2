package middleEarth.character.characterManager;

import middleEarth.character.MiddleEarthCharacter;

public class CharacterManager {

	private MiddleEarthCharacter[] characters;
	private int size;
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		return false;
		
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
		int change = 0;
		// TODO this could be wrong, idk if we check if the character is in the array or not
		for(int i = 0; i < size; i++) {
			if (characters[i] == character) {
				if (characters[i].getName() != name) {
					characters[i].setName(name);
					change = 1;
				}
				if (characters[i].getHealth() != health) {
					characters[i].setHealth(health);
					change = 1;
				}
				if (characters[i].getPower() != power) {
					characters[i].setPower(power);
					change = 1;
				}
			}
		}
		if (change == 1) {
			return true;
		}
		return false;
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		return false;
		
	}
	
	public void displayAllCharacters() {
		
	}
}
