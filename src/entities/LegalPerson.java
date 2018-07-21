package entities;

public class LegalPerson extends Person {

	private int numberEmployees;
	
	public LegalPerson() {
		super();
	}	
	
	public LegalPerson(String name, Double income, int numberEmployees) {
		super(name, income);
		this.numberEmployees = numberEmployees;
	}

	public int getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double getTax() {
		if(numberEmployees > 10) {
			return super.getIncome() * 0.14;
		}else {
			return super.getIncome() * 0.16;
		}
	}

}
