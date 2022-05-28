package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private BonusService service;
	
	@BeforeEach
	public void inicializar() {
		this.service = new BonusService();
	}

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		try {
			service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a exception!");
		} catch (Exception e) {
			assertEquals(("Salário do funcionário não tem os requerimentos necessários para receber o bônus."), e.getMessage());
		}
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
