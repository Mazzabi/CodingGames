package com.mazzabi.codingGames;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class rugbyScore {

	public static final int TRY_POINT = 5;
	public static final int TRANSFORMATION_POINT = 2;
	public static final int PENALTY_DROPS_POINT = 3;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int score = in.nextInt();
		List<String> combinaisons = getPossibleCombinaisons(score);
		for (String combinaison : combinaisons) {
			System.out.println(combinaison);
		}
	}

	public static List<String> getPossibleCombinaisons(int score) {
		if (score == 0) {
			return Arrays.asList(String.format("%s %s %s", 0, 0, 0));
		}
		return Stream.concat(getPenaltiesCombinaisons(score).stream(),
				getCombinaisonsWithTryTranformationPenalties(score).stream()).sorted().collect(Collectors.toList());
	}

	private static List<String> getCombinaisonsWithTryTranformationPenalties(int score) {
		List<String> combinaisons = new ArrayList<>();
		for (int nbrTry = 0; nbrTry <= score / TRY_POINT; nbrTry++) {
			if (nbrTry * TRY_POINT == score) {
				combinaisons.add(String.format("%s %s %s", nbrTry, 0, 0));
				break;
			}
			fetchForAdditionalTransformationsWithPenalties(score, combinaisons, nbrTry);
		}
		return combinaisons;
	}

	private static void fetchForAdditionalTransformationsWithPenalties(int score, List<String> combinaisons,
			int nbrTry) {
		for (int nbrTransformations = 0; nbrTransformations <= nbrTry; nbrTransformations++) {
			if (nbrTry * TRY_POINT + nbrTransformations * TRANSFORMATION_POINT == score) {
				combinaisons.add(String.format("%s %s %s", nbrTry, nbrTransformations, 0));
				break;
			}
			if (nbrTry > 0) {
				fetchForAdditionalPenalties(score, combinaisons, nbrTry, nbrTransformations);
			}
		}
	}

	private static void fetchForAdditionalPenalties(int score, List<String> combinaisons, int nbrTry,
			int nbrTransformations) {
		for (int nbrPenalty = 0; nbrPenalty <= score / PENALTY_DROPS_POINT; nbrPenalty++) {
			if (nbrTry * TRY_POINT + nbrTransformations * TRANSFORMATION_POINT
					+ nbrPenalty * PENALTY_DROPS_POINT == score) {
				combinaisons.add(String.format("%s %s %s", nbrTry, nbrTransformations, nbrPenalty));
			}
		}
	}

	private static List<String> getPenaltiesCombinaisons(int score) {
		List<String> combinaisons = new ArrayList<>();
		for (int nbrPenalty = 0; nbrPenalty <= score / PENALTY_DROPS_POINT; nbrPenalty++) {
			if (nbrPenalty * PENALTY_DROPS_POINT == score) {
				combinaisons.add(String.format("%s %s %s", 0, 0, nbrPenalty));
			}
		}
		return combinaisons;
	}
}
