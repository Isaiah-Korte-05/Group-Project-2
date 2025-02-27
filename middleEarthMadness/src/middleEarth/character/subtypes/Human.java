package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Human extends MiddleEarthCharacter{

	public Human(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target.getRace().equals("Wizard")) {
			target.setHealth(target.getHealth() - (this.power * 1.5));
			return true;
		}
		else if (target.getRace().equals("Orc") || target.getRace().equals("Human")) {
			return false;
		}
		else {
			target.setHealth(target.getHealth() - this.power);
			return true;
		}
	}

	@Override
	public String getRace() {
		return this.getClass().getSimpleName();
	}

}
