package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Human extends MiddleEarthCharacter{

	public Human(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	protected boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getRace() {
		// TODO Auto-generated method stub
		return null;
	}

}
