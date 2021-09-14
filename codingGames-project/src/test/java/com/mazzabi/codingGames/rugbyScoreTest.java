package com.mazzabi.codingGames;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class rugbyScoreTest {
	
	@Test
   	public void getCombinaisonOfZeroTest()
    {
        int score = 0;
        List<String> combinaisons = Arrays.asList("0 0 0") ;
		assertTrue( rugbyScore.getCombinaison(score).containsAll(combinaisons) );
    }
	
	@Test
	public void getCombinaisonOfOnlyTry()
	{
		int score = 5;
        List<String> combinaisons = Arrays.asList("1 0 0") ;
		assertTrue( rugbyScore.getCombinaison(score).containsAll(combinaisons) );
	}
	
	@Test
	public void getCombinaisonOfOnlyTryWithTransformation()
	{
		int score = 7;
        List<String> combinaisons = Arrays.asList("1 1 0") ;
		assertTrue( rugbyScore.getCombinaison(score).containsAll(combinaisons) );
	}

	@Test
	public void getCombinaisonOfOnlyTwoTryWithTransformation()
	{
		int score = 12;
        List<String> combinaisons = Arrays.asList("2 1 0", "0 0 4") ;
		assertTrue( rugbyScore.getCombinaison(score).containsAll(combinaisons) );
	}
	
	@Test
	public void getCombinaisonOfOnlyTwoTryWithTwoTransformation()
	{
		int score = 14;
        List<String> combinaisons = Arrays.asList("2 2 0", "1 0 3") ;
		assertTrue( rugbyScore.getCombinaison(score).containsAll(combinaisons));
	}

	@Test
	public void getCombinaisonOfOnlyTryWithNoTransformationWithPenalty()
	{
		int score = 8;
        List<String> combinaisons = Arrays.asList("1 0 1") ;
		assertTrue( rugbyScore.getCombinaison(score).containsAll(combinaisons) );
	}

	@Test
	public void getCombinaisonOfOnlyTryWithNoTransformationWithTwoPenalty()
	{
		int score = 11;
        List<String> combinaisons = Arrays.asList("1 0 2") ;
		assertTrue( rugbyScore.getCombinaison(score).containsAll(combinaisons) );
	}
}
