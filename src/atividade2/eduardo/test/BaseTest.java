package atividade2.eduardo.test;

import atividade2.eduardo.cls.Calculadora;
import atividade2.eduardo.cls.Funcionario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseTest {

	// Criando vari�veis locais dos funcionarios
	Funcionario funcionario_dev1, funcionario_dev2, funcionario_dev3, funcionario_dev4;
	Funcionario funcionario_dba1, funcionario_dba2, funcionario_dba3, funcionario_dba4;
	Funcionario funcionario_test1, funcionario_test2, funcionario_test3, funcionario_test4;
	Funcionario funcionario_man1, funcionario_man2, funcionario_man3, funcionario_man4;
	Calculadora c;

	@Before
	public void initialize() {

		// Inicializando Devs com sal�rios 3000, 3001, 2999 e 1500
		funcionario_dev1 = new Funcionario("Dev1", "dev1@email.com", 3000, "DESENVOLVEDOR");
		funcionario_dev2 = new Funcionario("Dev2", "dev2@email.com", 3001, "DESENVOLVEDOR");
		funcionario_dev3 = new Funcionario("Dev3", "dev3@email.com", 2999, "DESENVOLVEDOR");
		funcionario_dev4 = new Funcionario("Dev4", "dev4@email.com", 1500, "DESENVOLVEDOR");

		// Inicializando Dbas com sal�rios 2000, 2001, 1999 e 1000
		funcionario_dba1 = new Funcionario("Dba1", "dba1@email.com", 2000, "DBA");
		funcionario_dba2 = new Funcionario("Dba2", "dba2@email.com", 2001, "DBA");
		funcionario_dba3 = new Funcionario("Dba3", "dba3@email.com", 1999, "DBA");
		funcionario_dba4 = new Funcionario("Dba4", "dba4@email.com", 1000, "DBA");

		// Inicializando Testadores com sal�rios 2000, 2001, 1999 e 1000
		funcionario_test1 = new Funcionario("Testador1", "testador1@email.com", 2000, "TESTADOR");
		funcionario_test2 = new Funcionario("Testador2", "testador2@email.com", 2001, "TESTADOR");
		funcionario_test3 = new Funcionario("Testador3", "testador3@email.com", 1999, "TESTADOR");
		funcionario_test4 = new Funcionario("Testador4", "testador4@email.com", 1000, "TESTADOR");

		// Inicializando Gerentes com sal�rios 5000, 5001, 4999 e 3500
		funcionario_man1 = new Funcionario("Gerente1", "gerente1@email.com", 5000, "GERENTE");
		funcionario_man2 = new Funcionario("Gerente2", "gerente2@email.com", 5001, "GERENTE");
		funcionario_man3 = new Funcionario("Gerente3", "gerente3@email.com", 4999, "GERENTE");
		funcionario_man4 = new Funcionario("Gerente4", "gerente4@email.com", 3500, "GERENTE");
		
		//Inicializando Calculadora
		c = new Calculadora();
	}

	// Testando nome do funcionario
	@Test
	public void testNome() {
		assertEquals("Dev1", funcionario_dev1.getNome());
	}

	// Testando email do funcionario
	@Test
	public void testEmail() {
		assertEquals("dev1@email.com", funcionario_dev1.getEmail());
	}

	// Testando cargo do funcionario
	@Test
	public void testCargo() {
		assertEquals("DESENVOLVEDOR", funcionario_dev1.getCargo());
		assertEquals("DBA", funcionario_dba1.getCargo());
		assertEquals("TESTADOR", funcionario_test1.getCargo());
		assertEquals("GERENTE", funcionario_man1.getCargo());
	}

	// Testando salario bruto do funcionario
	@Test
	public void testSalario() {
		assertEquals(3000, funcionario_dev1.getSalario(), 0.0d);
	}

	// Testando salario liquido do funcionario
	@Test
	public void testDescontoSalario() {

		// Desenvolvedores (Desconto de 20% para salarios >= a 3000 e 10% caso
		// contr�rio)
		assertEquals(2400, c.calculaSalario(funcionario_dev1), 0.0d);
		assertEquals(2400.8, c.calculaSalario(funcionario_dev2), 0.0d);
		assertEquals(2699.1, c.calculaSalario(funcionario_dev3), 0.0d);
		assertEquals(1350, c.calculaSalario(funcionario_dev4), 0.0d);

		// DBAs (Desconto de 25% para salarios >= a 2000 e 15% caso contr�rio)
		assertEquals(1500, c.calculaSalario(funcionario_dba1), 0.0d);
		assertEquals(1500.75, c.calculaSalario(funcionario_dba2), 0.0d);
		assertEquals(1699.15, c.calculaSalario(funcionario_dba3), 0.0d);
		assertEquals(850, c.calculaSalario(funcionario_dba4), 0.0d);

		// Testadores (Desconto de 25% para salarios >= a 2000 e 15% caso
		// contr�rio)
		assertEquals(1500, c.calculaSalario(funcionario_test1), 0.0d);
		assertEquals(1500.75, c.calculaSalario(funcionario_test2), 0.0d);
		assertEquals(1699.15, c.calculaSalario(funcionario_test3), 0.0d);
		assertEquals(850, c.calculaSalario(funcionario_test4), 0.0d);

		// Gerentes (Desconto de 30% para salarios >= a 5000 e 20% caso
		// contr�rio
		assertEquals(3500, c.calculaSalario(funcionario_man1), 0.0d);
		assertEquals(3500.7, c.calculaSalario(funcionario_man2), 0.0d);
		assertEquals(3999.2, c.calculaSalario(funcionario_man3), 0.0d);
		assertEquals(2800, c.calculaSalario(funcionario_man4), 0.0d);
	}
}
