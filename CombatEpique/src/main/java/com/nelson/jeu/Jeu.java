package com.nelson.jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.nelson.personnages.Guerrier;
import com.nelson.personnages.Mage;
import com.nelson.personnages.Personnage;
import com.nelson.personnages.Rodeur;

public class Jeu {
	
		private Personnage [] joueurs = new Personnage[2];
		Scanner sc = new Scanner(System.in);
		
		public void jouer(){
				creationDesPersonnages();
				battaille();
			}
		
		private void creationDesPersonnages() {
			for(int i = 0; i < joueurs.length;i++) {
				System.out.println("Création du personnage du joueur "+(i+1));
				boolean valueIsGood;
				int classeNum = ' ';
				do {
					System.out.println("Veuillez entrer la classe de votre joueur (1 : Guerrier, 2 : Rodeur, 3 : Mage)");
					try{
						classeNum = sc.nextInt();
						valueIsGood = true;
					}catch(InputMismatchException e) {
						System.err.println("Merci de saisir une valeur valide ");
						valueIsGood = false;
					}
					if(classeNum == 1) {
						joueurs[i] = new Guerrier(i+1);
						joueurs[i].setClasse("Guerrier");
						valueIsGood = true;
					}else if(classeNum == 2) {
						joueurs[i] = new Rodeur(i+1);
						joueurs[i].setClasse("Rodeur");
						valueIsGood = true;
					}else if(classeNum == 3) {
						joueurs[i] = new Mage(i+1);
						joueurs[i].setClasse("Mage");
						valueIsGood = true;
					}
					else System.out.println("Votre choix est hors proposition !");
					valueIsGood = false;
						sc.nextLine();
				}while(classeNum != 1 && classeNum != 2 && classeNum != 3 && !valueIsGood);
				
				joueurs[i].caracteresPersonnage();
				System.out.println(joueurs[i].toString());
			}
		}
		
		private void battaille(){
	        int x=0,y=1;
	        while (joueurs[x].getVie() > 0 && joueurs[y].getVie() > 0) {
	            for (int tour = 0; tour < 2; tour++) {
	                if (tour == 1) {
	                    x = 1;
	                    y = 0;
	                } else if (tour == 0) {
	                    x = 0;
	                    y = 1;
	                }
	                int leJoueur = x+1, ladversaire = y+1;
	                System.out.println("Joueur" +leJoueur+ " (" + joueurs[x].getVie() + " Vitalite " + "veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spécial)");
	                int attaque = sc.nextInt();
	                if (attaque < 1 || attaque > 2) {
	                    System.out.println("Cette attaque est inexistante");
	                    tour--;
	                }else {
	                    if (attaque == 1)
	                        joueurs[x].attaqueBasique(joueurs[y]);
	                    else
	                        joueurs[x].attaqueSpeciale(joueurs[y]);
	                    if (joueurs[x].getVie() <= 0 || joueurs[y].getVie() <= 0) {
	                        System.out.println("Joueur " + ladversaire + " a perdu !");
	                        tour = 2;
	                    }
	                }
	            }
	       }
		}		
	}

