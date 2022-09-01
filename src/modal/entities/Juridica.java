package modal.entities;

public class Juridica extends Contribuinte{

	private Integer numeroEmpregados;
	
	public Juridica() {}

	public Juridica(String name, Double rendaAnual, Integer numeroEmpregados) {
		super(name, rendaAnual);
		this.numeroEmpregados = numeroEmpregados;
	}

	public Integer getNumeroEmpregados() {
		return numeroEmpregados;
	}

	public void setNumeroEmpregados(Integer numeroEmpregados) {
		this.numeroEmpregados = numeroEmpregados;
	}
	
	@Override
	public Double taxa() {
		double taxa = getNumeroEmpregados()>10 ? .14 : .16;
		return super.getRendaAnual() * taxa;
	}
	
	
	@Override
	public String toString() {
		return super.getName()+": $"+String.format("%.2f", taxa());
	}
}
