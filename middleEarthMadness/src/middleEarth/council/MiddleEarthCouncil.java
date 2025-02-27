package middleEarth.council;

import middleEarth.character.characterManager.CharacterManager;

public class MiddleEarthCouncil {
	
	// Static field used to maintain Singleton pattern
	private static MiddleEarthCouncil instance;
	// Character Manager accessed through council
	private CharacterManager manager;
	
	/**
	 * This is a constructor.
	 */
	private MiddleEarthCouncil() {
		this.manager = new CharacterManager();
	}

	/**
	 * This gets only instance of MiddleEarthCouncil.
	 * @return Instance of MiddleEarthCouncil.
	 */
	public static MiddleEarthCouncil getInstance() {
		// Tests if instance exists, creates new one if not
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	/**
	 * This is a getter.
	 * @return Character manager.
	 */
	public CharacterManager getCharacterManager() {
		return manager;
	}
}
