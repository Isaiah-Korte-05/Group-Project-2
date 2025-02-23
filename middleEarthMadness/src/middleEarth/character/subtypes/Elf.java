package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Elf extends MiddleEarthCharacter{

	public Elf(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	protected boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getRace() {
		return this.getClass().getSimpleName();
	}

}
