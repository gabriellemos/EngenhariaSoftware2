package com.es.cls;

public class Funcionario {

	private String nome;
	private String email;
	private double salario;
	private String cargo;

	public Funcionario(String nome, String email, double salario, String cargo) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
		this.cargo = cargo;
	}

	public Funcionario() {
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCargo() {
		return cargo;
	}

	public double getSalario() {
		return salario;
	}

}
