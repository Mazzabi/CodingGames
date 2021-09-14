package com.mazzabi.codingGames;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class temperatureTest {

	@Test
	public void getTemperatureCloseToZeroTestWithZero() {
		List<Integer> temperatureInput = Arrays.asList(-20, 0 , 1 , -1);
		assertEquals(temperature.getTemperatureCloseToZero(temperatureInput) , 0);
	}

	@Test
	public void getTemperatureCloseToZeroTestWithNegatifInputs() {
		List<Integer> temperatureInput = Arrays.asList(-20 , -11 , -5);
		assertEquals(temperature.getTemperatureCloseToZero(temperatureInput) , -5);
	}

	@Test
	public void getTemperatureCloseToZeroTestWithPositifInputs() {
		List<Integer> temperatureInput = Arrays.asList(10 , 11 , 4);
		assertEquals(temperature.getTemperatureCloseToZero(temperatureInput) , 4);
	}
	
	@Test
	public void getTemperatureCloseToZeroTestWithNegatifAndPositifInputs() {
		List<Integer> temperatureInput = Arrays.asList(-20 , 11 , -5 , 5);
		assertEquals(temperature.getTemperatureCloseToZero(temperatureInput) , 5);
	}
	
}
