package entities;

public class PhysicalPerson extends Person {

	private Double spendingHealth;
	
	public PhysicalPerson() {
		super();
	}

	public PhysicalPerson(String name, Double income, Double spendingHealth) {
		super(name, income);
		this.spendingHealth = spendingHealth;
	}

	public Double getSpendingHealth() {
		return spendingHealth;
	}

	public void setSpendingHealth(Double spendingHealth) {
		this.spendingHealth = spendingHealth;
	}

	@Override
	public Double getTax() {
		double tax;
		if(super.getIncome() < 20000.00) {
			tax = 0.15;
		}else {
			tax = 0.25;
		}
		return super.getIncome() * tax - spendingHealth * 0.5;		
	}

}
