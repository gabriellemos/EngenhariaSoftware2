package com.es.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.es.cls.Calculadora;
import com.es.cls.Funcionario;

public class BaseTest {

	// Criando variáveis locais dos funcionarios
	Funcionario funcionario_dev1, funcionario_dev2, funcionario_dev3, funcionario_dev4;
	Funcionario funcionario_dba1, funcionario_dba2, funcionario_dba3, funcionario_dba4;
	Funcionario funcionario_test1, funcionario_test2, funcionario_test3, funcionario_test4;
	Funcionario funcionario_man1, funcionario_man2, funcionario_man3, funcionario_man4;
	Funcionario funcionario_null;

	private final double PRECISAO = 0.0d;

	// Inicializando funcionarios utilizados no teste
	@Before
	public void initialize() {

		// Inicializando Devs com salários 3000, 3001, 2999 e 1500
		funcionario_dev1 = new Funcionario("Dev1", "dev1@email.com", 3000, "DESENVOLVEDOR");
		funcionario_dev2 = new Funcionario("Dev2", "dev2@email.com", 3001, "DESENVOLVEDOR");
		funcionario_dev3 = new Funcionario("Dev3", "dev3@email.com", 2999, "DESENVOLVEDOR");
		funcionario_dev4 = new Funcionario("Dev4", "dev4@email.com", 1500, "DESENVOLVEDOR");

		// Inicializando Dbas com salários 2000, 2001, 1999 e 1000
		funcionario_dba1 = new Funcionario("Dba1", "dba1@email.com", 2000, "DBA");
		funcionario_dba2 = new Funcionario("Dba2", "dba2@email.com", 2001, "DBA");
		funcionario_dba3 = new Funcionario("Dba3", "dba3@email.com", 1999, "DBA");
		funcionario_dba4 = new Funcionario("Dba4", "dba4@email.com", 1000, "DBA");

		// Inicializando Testadores com salários 2000, 2001, 1999 e 1000
		funcionario_test1 = new Funcionario("Testador1", "testador1@email.com", 2000, "TESTADOR");
		funcionario_test2 = new Funcionario("Testador2", "testador2@email.com", 2001, "TESTADOR");
		funcionario_test3 = new Funcionario("Testador3", "testador3@email.com", 1999, "TESTADOR");
		funcionario_test4 = new Funcionario("Testador4", "testador4@email.com", 1000, "TESTADOR");

		// Inicializando Gerentes com salários 5000, 5001, 4999 e 3500
		funcionario_man1 = new Funcionario("Gerente1", "gerente1@email.com", 5000, "GERENTE");
		funcionario_man2 = new Funcionario("Gerente2", "gerente2@email.com", 5001, "GERENTE");
		funcionario_man3 = new Funcionario("Gerente3", "gerente3@email.com", 4999, "GERENTE");
		funcionario_man4 = new Funcionario("Gerente4", "gerente4@email.com", 3500, "GERENTE");

		// Inicializando Funcionario nulo
		funcionario_null = new Funcionario();
	}

	// Testando nome do funcionario
	@Test
	public void testNome() {
		assertEquals("Dev1", funcionario_dev1.getNome());

		// Caso o funcionário não tenha nome especificado
		assertNull(funcionario_null.getNome());

	}

	// Testando email do funcionario
	@Test
	public void testEmail() {
		assertEquals("dev1@email.com", funcionario_dev1.getEmail());

		// Caso o funcionário não tenha email especificado
		assertNull(funcionario_null.getEmail());
	}

	// Testando cargo do funcionario
	@Test
	public void testCargo() {
		assertEquals("DESENVOLVEDOR", funcionario_dev1.getCargo());
		assertEquals("DBA", funcionario_dba1.getCargo());
		assertEquals("TESTADOR", funcionario_test1.getCargo());
		assertEquals("GERENTE", funcionario_man1.getCargo());

		// Caso o funcionário não tenha cargo especificado
		assertNull(funcionario_null.getCargo());
	}

	// Testando salario bruto do funcionario
	@Test
	public void testSalario() {
		assertEquals(3000, funcionario_dev1.getSalario(), 0.0d);

		// Caso o funcionário não tenha cargo especificado
		assertTrue(0.0d == funcionario_null.getSalario());
	}

	// Testando salario liquido dos funcionarios

	@Test
	public void testDescontoSalarioDEV() {
		// Desenvolvedores (Desconto de 20% para salarios >= a 3000 e 10% caso
		// contrário)
		assertEquals(2400, Calculadora.calculaSalario(funcionario_dev1), PRECISAO);
		assertEquals(2400.8, Calculadora.calculaSalario(funcionario_dev2), PRECISAO);
		assertEquals(2699.1, Calculadora.calculaSalario(funcionario_dev3), PRECISAO);
		assertEquals(1350, Calculadora.calculaSalario(funcionario_dev4), PRECISAO);
	}

	@Test
	public void testDescontoSalarioDBA() {
		// DBAs (Desconto de 25% para salarios >= a 2000 e 15% caso contrário)
		assertEquals(1500, Calculadora.calculaSalario(funcionario_dba1), PRECISAO);
		assertEquals(1500.75, Calculadora.calculaSalario(funcionario_dba2), PRECISAO);
		assertEquals(1699.15, Calculadora.calculaSalario(funcionario_dba3), PRECISAO);
		assertEquals(850, Calculadora.calculaSalario(funcionario_dba4), PRECISAO);
	}

	@Test
	public void testDescontoSalarioTESTER() {
		// Testadores (Desconto de 25% para salarios >= a 2000 e 15% caso
		// contrário)
		assertEquals(1500, Calculadora.calculaSalario(funcionario_test1), PRECISAO);
		assertEquals(1500.75, Calculadora.calculaSalario(funcionario_test2), PRECISAO);
		assertEquals(1699.15, Calculadora.calculaSalario(funcionario_test3), PRECISAO);
		assertEquals(850, Calculadora.calculaSalario(funcionario_test4), PRECISAO);
	}

	@Test
	public void testDescontoSalarioMAN() {
		// Gerentes (Desconto de 30% para salarios >= a 5000 e 20% caso
		// contrário
		assertEquals(3500, Calculadora.calculaSalario(funcionario_man1), PRECISAO);
		assertEquals(3500.7, Calculadora.calculaSalario(funcionario_man2), PRECISAO);
		assertEquals(3999.2, Calculadora.calculaSalario(funcionario_man3), PRECISAO);
		assertEquals(2800, Calculadora.calculaSalario(funcionario_man4), PRECISAO);
	}
}
