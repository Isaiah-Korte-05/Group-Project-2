package middleEarth.character.characterManager;

import middleEarth.character.MiddleEarthCharacter;

public class CharacterManager {

	public MiddleEarthCharacter[] characters;
	public int size = 0;
	
	public CharacterManager() {
		this.characters = new MiddleEarthCharacter[4];
	}
	
	//TODO how to do tests for returns?
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
	
	// TODO fix deleteCharacter
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		
		for (int i = 0; i < size; i++) {
			if (characters[i] == character) {
				for(int j = i-1; characters[j] != null; j++) {
					characters[j] = characters[j + 1];
				}
				size--;
				return true;
			}
		}
		
		return false;
		
	}
	
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
