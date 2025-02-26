package middleEarth.council;

import middleEarth.character.characterManager.CharacterManager;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	
	private CharacterManager manager;
	
	private MiddleEarthCouncil() {
		this.manager = new CharacterManager();
	}

	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	public CharacterManager getCharacterManager() {
		return manager;
	}
}
