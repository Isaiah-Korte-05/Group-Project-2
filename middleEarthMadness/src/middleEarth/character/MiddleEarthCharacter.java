package middleEarth.character;

public abstract class MiddleEarthCharacter {
	
	// Class fields for Character information
	protected String name;
	protected double health;
	protected double power;
	
	/**
	 * This is a parameterized constructor.
	 * @param name This parameter takes a string for new Character name.
	 * @param health This parameter takes a double for new Character health.
	 * @param power This parameter takes a double for new Character power.
	 */
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	// Abstract method stubs
	public abstract boolean attack(MiddleEarthCharacter target);
	public abstract String getRace();
	
	/**
	 * This formats Character information and prints to console.
	 */
	public void displayInfo() {
		System.out.println(name + "\t\t" + health + "\t\t" + power);
	}

	/**
	 * This is a getter.
	 * @return Character name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This is a setter.
	 * @param name This parameter takes a string for Character name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is a getter.
	 * @return Character health.
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * This is a setter.
	 * @param health This parameter takes a double for Character health to set.
	 */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 * This is a getter.
	 * @return Character power.
	 */
	public double getPower() {
		return power;
	}

	/**
	 * This is a setter.
	 * @param power This parameter takes a double for Character power to set.
	 */
	public void setPower(double power) {
		this.power = power;
	}

}
