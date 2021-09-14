package com.mazzabi.codingGames;

import java.util.*;
import java.io.*;
import java.math.*;

public class temperature {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // the number of temperatures to analyse
		List<Integer> temperaturesList = new ArrayList();
		for (int i = 0; i < n; i++) {
			int temperature = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
			temperaturesList.add(temperature);
		}
		System.out.println(getTemperatureCloseToZero(temperaturesList));
		// Write an answer using System.out.println()
		// To debug: System.err.println("Debug messages...");
	}

	public static int getTemperatureCloseToZero(List<Integer> temperaturesList) {
		if (temperaturesList.isEmpty()) {
			return 0;
		}
		int minimalTemperature = temperaturesList.stream().min((x, y) -> Integer.compare(Math.abs(x), Math.abs(y)))
				.get();
		return temperaturesList.contains(Math.abs(minimalTemperature)) ? Math.abs(minimalTemperature) : minimalTemperature;
	}

}
