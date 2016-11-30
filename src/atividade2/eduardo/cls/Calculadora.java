package atividade2.eduardo.cls;

public class Calculadora {

	public double calculaSalario(Funcionario f) {
		double salarioLiquido = 0;
		if (f.getCargo().equals("DESENVOLVEDOR")) {
			if (f.getSalario() >= 3000) {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.2d;
			} else {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.1d;
			}
		} else if (f.getCargo().equals("DBA") || f.getCargo().equals("TESTADOR")) {
			if (f.getSalario() >= 2000) {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.25d;
			} else {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.15d;
			}
		} else {
			if (f.getSalario() >= 5000) {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.3d;
			} else {
				salarioLiquido = f.getSalario() - f.getSalario() * 0.2d;
			}
		}
		return salarioLiquido;
	}

}
