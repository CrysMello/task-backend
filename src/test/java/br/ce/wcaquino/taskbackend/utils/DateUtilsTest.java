package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;


public class DateUtilsTest {
	
	@Test
	public void deveRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		DateUtils.isEqualOrFutureDate(date);
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		
	}
	
	@Test
	public void deveRetornaraFalseParaDataspassadas() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		DateUtils.isEqualOrFutureDate(date);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
		
	}
	
	@Test
	public void deveRetornarTrueParaDataAtual() {
		//data atual
		LocalDate date = LocalDate.now(); 
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
	}
}
