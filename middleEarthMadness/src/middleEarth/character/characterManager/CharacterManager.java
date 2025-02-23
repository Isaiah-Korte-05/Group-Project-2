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
		return false;
		
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		return false;
		
	}
	
	public void displayAllCharacters() {
		
	}
}
