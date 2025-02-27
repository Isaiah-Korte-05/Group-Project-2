package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Dwarf extends MiddleEarthCharacter{

	/**
	 * This is a parameterized constructor that initializes the name, health,
	 * and power of a Dwarf
	 * @param name This parameter is a String for the name of the Dwarf
	 * @param health This parameter is a double for the health of the Dwarf
	 * @param power This parameter is a double for the power of the Dwarf
	 */
	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	 * This attacks a MiddleEarthCharacter.
	 * Dwarf has 1.5x damage against Elf,
	 * 		     1.0x damage against Human and Orc,
	 * 		     0.0x damage against Wizard and Dwarf
	 * @param target This parameter is the MiddleEarthCharacter object to be attacked
	 * @return Returns true if the attack is successful and the target's health is reduced,
	 * 		   or false if the attack was ineffective or against a target of own kin
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target.getRace().equals("Elf")) {
			target.setHealth(target.getHealth() - (this.power * 1.5));
			return true;
		}
		else if (target.getRace().equals("Wizard") || target.getRace().equals("Dwarf")) {
			return false;
		}
		else {
			target.setHealth(target.getHealth() - this.power);
			return true;
		}
	}

	/**
	 * This gets the race of the character
	 * @return Returns a String of the race of the MiddleEarthCharacter
	 */
	@Override
	public String getRace() {
		return this.getClass().getSimpleName();
	}

}
