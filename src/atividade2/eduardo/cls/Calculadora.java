package com.es.cls;

public class Calculadora {
	
	private final static double DEV_LIMITE_IMPOSTO = 3000;
	private final static double DBA_TESTER_LIMITE_IMPOSTO = 2000;
	private final static double MAN_LIMITE_IMPOSTO = 5000;
	
	private final static String DEV = "DESENVOLVEDOR";
	private final static String DBA = "DBA";
	private final static String TESTER = "TESTADOR";
	private final static String GERENTE = "GERENTE";

	public static double calculaSalario(Funcionario f) {
		double salarioLiquido = 0;
		if (DEV.equals(f.getCargo())) {
			if (f.getSalario() >= DEV_LIMITE_IMPOSTO) {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.2d;
			} else {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.1d;
			}
		} else if (DBA.equals(f.getCargo()) || TESTER.equals(f.getCargo())) {
			if (f.getSalario() >= DBA_TESTER_LIMITE_IMPOSTO) {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.25d;
			} else {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.15d;
			}
		} else if (GERENTE.equals(f.getCargo())){
			if (f.getSalario() >= MAN_LIMITE_IMPOSTO) {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.3d;
			} else {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.2d;
			}
		} else {
			System.out.println("Funcionário não possui um cargo válido");
		}
		return salarioLiquido;
	}

}
