package modal.entities;

public class Fisica extends Contribuinte{
	private Double gastoSaude;
	
	public Fisica() {}

	public Fisica(String name, Double rendaAnual, Double gastoSaude) {
		super(name, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public Double taxa() {
		double taxa = super.getRendaAnual() < 20000.00 ? .15 : .25;
		return (super.getRendaAnual() * taxa) - (getGastoSaude() * .5);
	}

	@Override
	public String toString() {
		return super.getName()+": $"+String.format("%.2f", taxa());
	}
}