package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modal.entities.Contribuinte;
import modal.entities.Fisica;
import modal.entities.Juridica;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> contribuintes = new ArrayList<>();
		
		System.out.printf("Digite o número de contribuintes: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=n; i++) {
			System.out.println("CONTRIBUINTE #"+i);
			System.out.printf("Pessoa FÍSICA ou JURÍDICA (F/J): ");
			char opc = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.printf("Nome: ");
			String nome = sc.nextLine();
			System.out.printf("Gasto anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (opc == 'F') {
				System.out.printf("Gastos com saúde: ");
				double gastoSaude = sc.nextDouble();
				contribuintes.add(new Fisica(nome, rendaAnual, gastoSaude));
			}else if(opc == 'J') {
				System.out.printf("Quantidade de funcionários: ");
				int quantidadeFuncionários = sc.nextInt();
				contribuintes.add(new Juridica(nome, rendaAnual, quantidadeFuncionários));
			}
		}
		
		System.out.println("\nTAXAS PAGAS");
		double somatorioTaxas = 0.0;
		for (Contribuinte contribuinte : contribuintes) {
			System.out.println(contribuinte);
			somatorioTaxas += contribuinte.taxa();
		}
		System.out.println("\nTOTAL DE TAXAS: $"+String.format("%.2f", somatorioTaxas));
		
		sc.close();

	}

}
