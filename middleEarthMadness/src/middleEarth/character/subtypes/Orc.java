package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Orc extends MiddleEarthCharacter{

	public Orc(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target.getRace() == "Human") {
			target.setHealth(target.getHealth() - (this.power * 1.5));
			return true;
		}
		else if (target.getRace() == "Elf" || target.getRace() == "Orc") {
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
