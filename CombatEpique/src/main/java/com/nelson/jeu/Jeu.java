package com.nelson.jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.nelson.personnages.*;

public class Jeu {

	Personnage joueur1;
	Personnage joueur2;
	
	Scanner sc = new Scanner(System.in);
	
	public void jouer() {
        System.out.println("Création du personnage du Joueur 1");
        joueur1 = creerPersonnage("Joueur 1");
        System.out.println(joueur1);
        System.out.println("Création du personnage du Joueur 2");
        joueur2 = creerPersonnage("Joueur 2");
        System.out.println(joueur2);
        while (joueur1.getVitalite() > 0 && joueur2.getVitalite() > 0) {
        	tourDuJoueur(joueur1, joueur2);
            if (joueur2.getVitalite() > 0)
            	tourDuJoueur(joueur2, joueur1);
        }
        if (joueur1.getVitalite() <= 0)
            System.out.println(joueur1.getNom() + " a perdu !");
        if (joueur2.getVitalite() <= 0)
            System.out.println(joueur2.getNom() + " a perdu !");
    }

   public void tourDuJoueur(Personnage playerOffense, Personnage playerDefense) {
        int typeAttaque = demandeValeur(playerOffense.getNomEtVitalite()+ " veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)", 1, 2);
        if (typeAttaque == 1)
        	playerOffense.attaqueBasique(playerDefense);
        else
        	playerOffense.attaqueSpeciale(playerDefense);
    }

   public Personnage creerPersonnage(String nom) {
    	Personnage personnage = null;
        do {
            int classePersonnage = demandeValeur("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rodeur, 3 : Mage)", 1, 3);
            int niveau = demandeValeur("Niveau du personnage ?", 1, 100);
            int force = demandeValeur("Force du personnage ?", 0, 100);
            int agilite = demandeValeur("Agilité du personnage ?", 0, 100);
            int intelligence = demandeValeur("Intelligence du personnage ?", 0, 100);
            try {
                switch (classePersonnage) {
                    case 1 :
                    	personnage = new Guerrier(nom, niveau, force, agilite, intelligence);
                        break;
                    case 2 :
                    	personnage = new Rodeur(nom, niveau, force, agilite, intelligence);
                        break;
                    case 3 :
                    	personnage = new Mage(nom, niveau, force, agilite, intelligence);
                        break;
                }
            } catch (BadCharacteristicsException e) {
                System.err.println("Merci de saisir un total de points de caractéristiques égal au niveau de votre personnage.");
                personnage = null;
            }
        } while (personnage == null);
        return personnage;
    }

    public int demandeValeur(String question, int valeurMin, int valeurMax) {
        System.out.println(question);
        int value = -1;
        boolean valeurValide;
        do {
            try {
                value = sc.nextInt();
                valeurValide = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.err.println("Merci de saisir une valeur valide");
                valeurValide = false;
            }
            if (value < valeurMin) {
                System.err.println("Merci de saisir une valeur supérieure ou égale à  " + valeurMin);
                valeurValide = false;
            }
            if (value > valeurMax) {
                System.err.println("Merci de saisir une valeur inférieure ou égale à  " + valeurMax);
                valeurValide = false;
            }
        } while (!valeurValide);
        return value;
    }
    
	public Personnage getJoueur1() {
		return joueur1;
	}

	public Personnage getJoueur2() {
		return joueur2;
	}
}
