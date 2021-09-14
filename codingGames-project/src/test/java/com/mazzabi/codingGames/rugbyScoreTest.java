package com.mazzabi.codingGames;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class rugbyScoreTest {

	@Test
	public void getCombinaisonOfZeroTest() {
		int score = 0;
		List<String> combinaisons = Arrays.asList("0 0 0");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfOnlyTry() {
		int score = 5;
		List<String> combinaisons = Arrays.asList("1 0 0");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfOnlyTryWithTransformation() {
		int score = 7;
		List<String> combinaisons = Arrays.asList("1 1 0");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfOnlyTwoTryWithTransformation() {
		int score = 12;
		List<String> combinaisons = Arrays.asList("2 1 0", "0 0 4");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfOnlyTwoTryWithTwoTransformation() {
		int score = 14;
		List<String> combinaisons = Arrays.asList("2 2 0", "1 0 3");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfOnlyTryWithNoTransformationWithPenalty() {
		int score = 8;
		List<String> combinaisons = Arrays.asList("1 0 1");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfOnlyTryWithNoTransformationWithTwoPenalty() {
		int score = 11;
		List<String> combinaisons = Arrays.asList("1 0 2");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfBigSocre() {
		int score = 88;
		List<String> combinaisons = Arrays.asList("1 1 27", "2 0 26", "3 2 23", "4 1 22", "4 4 20", "5 0 21", "5 3 19",
				"6 2 18", "6 5 16", "7 1 17", "7 4 15", "7 7 13", "8 0 16", "8 3 14", "8 6 12", "9 2 13", "9 5 11",
				"9 8 9", "10 1 12", "10 4 10", "10 7 8", "10 10 6", "11 0 11", "11 3 9", "11 6 7", "11 9 5", "12 2 8",
				"12 5 6", "12 8 4", "12 11 2", "13 1 7", "13 4 5", "13 7 3", "13 10 1", "14 0 6", "14 3 4", "14 6 2",
				"14 9 0", "15 2 3", "15 5 1", "16 1 2", "16 4 0", "17 0 1");
		assertTrue(rugbyScore.getPossibleCombinaisons(score).containsAll(combinaisons));
	}
}
