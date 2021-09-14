package com.mazzabi.codingGames;

import java.util.*;

public class rugbyScore {

	public static final int TRY_POINT = 5;
	public static final int TRANSFORMATION_POINT = 2;
	public static final int PENALTY_DROPS_POINT = 3;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int score = in.nextInt();

		List<String> combinaisons = getCombinaison(score);
	}

	public static List<String> getCombinaison(int score) {
		List<String> combinaisons = new ArrayList<String>() ;
		if (score == 0 ) {
			return Arrays.asList(String.format("%s %s %s" ,0 , 0, 0));
		}
		for (int nbrPenalty = 0 ; nbrPenalty <= score/ PENALTY_DROPS_POINT ; nbrPenalty++) {
			if (nbrPenalty*PENALTY_DROPS_POINT == score) {
				combinaisons.add(String.format("%s %s %s" , 0, 0, nbrPenalty));
			}
		}
		for (int nbrTry = 0; nbrTry <= score/TRY_POINT; nbrTry++) {
			if (nbrTry*TRY_POINT == score) {
				combinaisons.add(String.format("%s %s %s" , nbrTry, 0, 0));
				break;
			}
			if (nbrTry != 0) {
				for (int nbrTransformations = 0 ; nbrTransformations <= nbrTry ; nbrTransformations++  ) {
					if (nbrTry*TRY_POINT + nbrTransformations*TRANSFORMATION_POINT == score) {
						combinaisons.add(String.format("%s %s %s" , nbrTry, nbrTransformations, 0));
						break;
					}
					for (int nbrPenalty = 0 ; nbrPenalty <= score/ PENALTY_DROPS_POINT ; nbrPenalty++) {
						if (nbrTry*TRY_POINT + nbrTransformations*TRANSFORMATION_POINT + nbrPenalty*PENALTY_DROPS_POINT == score) {
							combinaisons.add(String.format("%s %s %s" , nbrTry, nbrTransformations, nbrPenalty));
						}
					}
				}
			}
		}
		
		return combinaisons;
	}
}
