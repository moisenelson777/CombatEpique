package com.nelson.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.nelson.jeu.Jeu;
import com.nelson.personnages.Guerrier;
import com.nelson.personnages.Personnage;

public class JeuTest {

	 @Test
	    public void Given_InformationsToCreateWarrior_When_CreateCharacter_Then_WarriorIsCorrectlyCreated() {
	        System.setIn(new ByteArrayInputStream(String.format("1%n10%n5%n3%n2%n").getBytes()));
	        Jeu jeu = new Jeu();
	        Personnage personnage = jeu.creerPersonnage("Test");
	        assertEquals("Test", personnage.getNom());
	        assertEquals(10, personnage.getNiveau());
	        assertEquals(5, personnage.getForce());
	        assertEquals(3, personnage.getAgilite());
	        assertEquals(2, personnage.getIntelligence());
	        assertTrue(personnage instanceof Guerrier);
	    }

	    @Test
	    public void Given_GoodIntValue_When_AskForIntValue_Then_GetSameIntValue() {
	        System.setIn(new ByteArrayInputStream(String.format("42%n").getBytes()));
	        Jeu jeu = new Jeu();
	        int valeur = jeu.demandeValeur("Test ?", 35, 50);
	        assertEquals(42, valeur);
	    }

	    @Test
	    public void Given_BadIntValuesAndGoodIntValue_When_AskForIntValue_Then_GetGoodIntValue() {
	        System.setIn(new ByteArrayInputStream(String.format("84%n21%n42%n").getBytes()));
	        Jeu jeu = new Jeu();
	        int valeur = jeu.demandeValeur("Test ?", 35, 50);
	        assertEquals(42, valeur);
	    }

	    @Test
	    public void Given_TwoCharacterFighting_When_IsPlayerTurn_Then_PlayerTargetedLosesVitality() {
	        System.setIn(new ByteArrayInputStream(String.format("1%n").getBytes()));
	        Jeu jeu = new Jeu();
	        Personnage personnage = new Guerrier("Test", 10, 10, 0, 0);
	        Personnage adversaire = new Guerrier("Target", 10, 10, 0, 0);
	        jeu.tourDuJoueur(personnage, adversaire);
	        assertEquals(50 - 10, adversaire.getVitalite());
	    }

	    @Test
	    public void Given_FullGamePlayed_When_GameIsRun_Then_Player2IsDead() {
	        // Joueur 1 : Guerrier niveau 10 avec 10 force, 0 agilite and 0 intelligence
	        // Joueur 2 : Rodeur niveau 3 avec 0 force, 3 agilite and 0 intelligence
	        // Joueur 1 attaque basique
	        // Joueur 2 attaque basique
	        // Joueur 1 attaque basique et mort joueur 2
	        System.setIn(new ByteArrayInputStream(String.format("1%n10%n10%n0%n0%n2%n3%n0%n3%n0%n1%n1%n1%n").getBytes()));
	        Jeu jeu = new Jeu();
	        jeu.jouer();
	        assertEquals(50 - 3, jeu.getJoueur1().getVitalite());
	        assertEquals(15 - 10 - 10, jeu.getJoueur2().getVitalite());
	    }
	}