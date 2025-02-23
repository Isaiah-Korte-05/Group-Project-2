package middleEarth.character;

public abstract class MiddleEarthCharacter {
	
	protected String name;
	protected double health;
	protected double power;
	
	public MiddleEarthCharacter(String name, double health, double power) {
		this.health = health;
		this.power = power;
	}
	
	protected abstract boolean attack(MiddleEarthCharacter target);
	
	protected abstract String getRace();
	
	public void displayInfo() {
		System.out.println("Name: " + name);
		System.out.println("Health: " + health);
		System.out.println("Power: " + power);
	}

}
