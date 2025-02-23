package middleEarth.council;

//import middleEarth.character.characterManager.CharacterManager;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	
	private MiddleEarthCouncil() {}

	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
//	private CharacterManager getCharacterManager() {
//		
//	}
}
