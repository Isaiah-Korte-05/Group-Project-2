package middleEarth.council;

import middleEarth.character.characterManager.CharacterManager;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	
	private CharacterManager manager;
	
	private MiddleEarthCouncil() {}

	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	// TODO idk if this is right (?)
	public CharacterManager getCharacterManager() {
		return manager;
	}
}
