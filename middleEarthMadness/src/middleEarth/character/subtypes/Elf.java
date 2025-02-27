package middleEarth.character.subtypes;

import middleEarth.character.MiddleEarthCharacter;

public class Elf extends MiddleEarthCharacter{

	/**
	 * This is a parameterized constructor that initializes the name, health,
	 * and power of an Elf
	 * @param name This parameter is a String for the name of the Elf
	 * @param health This parameter is a double for the health of the Elf
	 * @param power This parameter is a double for the power of the Elf
	 */
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	 * This attacks a MiddleEarthCharacter.
	 * Elf has 1.5x damage against Orc,
	 * 		   1.0x damage against Human and Wizard,
	 * 		   0.0x damage against Dwarf and Elf
	 * @param target This parameter is the MiddleEarthCharacter object to be attacked
	 * @return Returns true if the attack is successful and the target's health is reduced,
	 * 		   or false if the attack was ineffective or against a target of own kin
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target.getRace().equals("Orc")) {
			target.setHealth(target.getHealth() - (this.power * 1.5));
			return true;
		}
		else if (target.getRace().equals("Dwarf") || target.getRace().equals("Elf")) {
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
