package com.nelson.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.nelson.personnages.Mage;


public class MageTest {

	@Test
    public void Given_MageLevel20_When_UseBasicAttack_Then_InflictGoodDamagesValue() {
        Mage mage = new Mage("Test", 20, 0, 0, 20);
        Mage ennemie = new Mage("ennemie", 20, 0, 0, 20);
        mage.attaqueBasique(ennemie);
        assertEquals(100 - 20, ennemie.getVitalite());
    }

    @Test
    public void Given_MageLevel20With20Vitality_When_UseSpecialAttack_Then_EarnGoodVitalityValue() {
    	Mage mage = new Mage("Test", 20, 0, 0, 20);
    	Mage ennemie = new Mage("ennemie", 20, 0, 0, 20);
    	mage.infligeDommages(60);
    	mage.attaqueSpeciale(ennemie);
        assertEquals(100 - 60 + 40, mage.getVitalite());
    }

    @Test
    public void Given_MageLevel20With40Vitality_When_UseSpecialAttack_Then_VitalityGoToMax() {
    	Mage mage = new Mage("Test", 20, 0, 0, 10);
    	Mage ennemie = new Mage("ennemie", 20, 0, 0, 20);
    	mage.infligeDommages(20);
    	mage.attaqueSpeciale(ennemie);
        assertEquals(100, mage.getVitalite());
    }
}