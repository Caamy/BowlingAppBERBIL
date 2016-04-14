package dcll.projet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de tests de Bowling.java
 */
public class BowlingTest {

    @Test
    public void testCalculScore() throws Exception {
        int resultat = Bowling.calculScore(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertEquals(0,resultat);
        int err = Bowling.calculScore(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
        assertEquals(-1, err);
        int strikes = Bowling.calculScore(new int[]{10,10,10,10,10,10,10,10,10,10,10,10});
        assertEquals(300, strikes);
        int spares = Bowling.calculScore(new int[]{9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9});
        assertEquals(190, spares);
        int partie = Bowling.calculScore(new int[]{1,6,10,6,2,0,8,5,5,2,6,0,4,6,4,8,1,3,7,10});
        assertEquals(112, partie);
    }

    @Test
    public void testEstValide() throws Exception {
        assertTrue(Bowling.estValide(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        assertTrue(Bowling.estValide(new int[]{10,10,10,10,10,10,10,10,10,10,10,10}));
        assertTrue(Bowling.estValide(new int[]{9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9}));
        assertTrue(Bowling.estValide(new int[]{1,6,10,6,2,0,8,5,5,2,6,0,4,6,4,8,1,3,7,10}));

        // Coups en trop
        assertFalse(Bowling.estValide(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}));
        // Pas assez de coup
        assertFalse(Bowling.estValide(new int[]{0,0,0,0,0,0,0,0,0,0,0}));
        // Coup impossible
        assertFalse(Bowling.estValide(new int[]{9,4,9,1,9,7,9,1,9,3,9,1,7,1,9,1,4,3,2,8,4}));
        // Scores négatifs
        assertFalse(Bowling.estValide(new int[]{-1,6,10,-6,2,0,8,5,5,2,6,0,-4,6,4,8,1,3,-7,10}));
        // Scores supérieurs à 10
        assertFalse(Bowling.estValide(new int[]{1,6,20,6,2,0,18,5,5,2,16,0,4,6,4,8,1,13,7,10}));
        //Spare sans prochain score
        assertFalse(Bowling.estValide(new int[]{10,10,10,10,10,10,10,10,10,10,10}));
        //Strike sans prochain score
        assertFalse(Bowling.estValide(new int[]{9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1}));
    }
}