package com.nelson.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.nelson.personnages.Rodeur;


public class RodeurTest {

	@Test
    public void Given_RogueLevel20_When_UseBasicAttack_Then_InflictGoodDamagesValue() {
        Rodeur rodeur = new Rodeur("Test", 20, 0, 20, 0);
        Rodeur ennemie = new Rodeur("ennemie", 20, 0, 20, 0);
        rodeur.attaqueBasique(ennemie);
        assertEquals(100 - 20, ennemie.getVitalite());
    }

    @Test
    public void Given_RogueLevel20_When_UseSpecialAttack_Then_EarnGoodAgilityValue() {
    	Rodeur rodeur = new Rodeur("Test", 20, 0, 20, 0);
    	Rodeur ennemie = new Rodeur("ennemie", 20, 0, 10, 0);
    	rodeur.attaqueSpeciale(ennemie);
        assertEquals(20 + 10, rodeur.getAgilite());
    }
}