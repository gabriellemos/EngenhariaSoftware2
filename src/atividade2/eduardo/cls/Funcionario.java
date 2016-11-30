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
		return this.nome;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return this.cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return this.salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

}
