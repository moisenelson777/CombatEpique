package com.nelson.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nelson.personnages.Guerrier;

public class GuerrierTest {

	@Test
    public void Given_GuerrierLevel20_When_UseBasicAttack_Then_InflictGoodDamagesValue() {
        Guerrier guerrier = new Guerrier("Test", 20, 20, 0, 0);
        Guerrier ennemie = new Guerrier("ennemie", 20, 10, 0, 0);
        guerrier.attaqueBasique(ennemie);
        assertEquals(100 - 20, ennemie.getVitalite());
    }

    @Test
    public void Given_WarriorLevel20_When_UseSpecialAttack_Then_InflictGoodDamagesValue() {
    	Guerrier guerrier = new Guerrier("Test", 20, 20, 0, 0);
    	Guerrier ennemie = new Guerrier("ennemie", 20, 20, 0, 0);
    	guerrier.attaqueSpeciale(ennemie);
        assertEquals(100 - 40, ennemie.getVitalite());
    }

    @Test
    public void Given_WarriorLevel20_When_UseSpecialAttack_Then_InflictGoodDamagesValueOnHimself() {
    	Guerrier guerrier = new Guerrier("Test", 20, 20, 0, 0);
    	Guerrier ennemie = new Guerrier("ennemie", 20, 20, 0, 0);
    	guerrier.attaqueSpeciale(ennemie);
        assertEquals(100 - 10, guerrier.getVitalite());
    }
}
