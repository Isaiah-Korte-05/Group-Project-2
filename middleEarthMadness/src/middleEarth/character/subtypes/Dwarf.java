package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Dwarf extends MiddleEarthCharacter{

	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}

	@Override
	protected boolean attack(MiddleEarthCharacter target) {
		if (target.getClass().getSimpleName() == "Elf") {
			target.setHealth(target.getHealth() - (this.power * 1.5));
			return true;
		}
		else if (target.getClass().getSimpleName() == "Wizard" ||
				target.getClass().getSimpleName() == "Dwarf") {
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
