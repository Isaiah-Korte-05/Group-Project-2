package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Human extends MiddleEarthCharacter{

	public Human(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	protected boolean attack(MiddleEarthCharacter target) {
		if (target.getClass().getSimpleName() == "Wizard") {
			target.setHealth(target.getHealth() - (this.power * 1.5));
			return true;
		}
		else if (target.getClass().getSimpleName() == "Orc" ||
				target.getClass().getSimpleName() == "Human") {
			return false;
		}
		else {
			target.setHealth(target.getHealth() - this.power);
			return true;
		}
	}

	@Override
	protected String getRace() {
		return this.getClass().getSimpleName();
	}

}
