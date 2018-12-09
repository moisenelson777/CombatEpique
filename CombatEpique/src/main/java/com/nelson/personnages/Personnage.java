package com.nelson.personnages;

import java.util.InputMismatchException;
import java.util.Scanner;

		/*
		* La classe abstraite avec les methodes  à implémenter selon la specialité voulue.
	 	* Elle héritera de classes enfants selon la spécialité nominale.
	 	*/
		public abstract class Personnage {
	
		protected int niveau, vie, force, agilite, intelligence, niveauMax;
		protected String classe ;
		protected int leJoueur;

		Scanner sc = new Scanner(System.in);
		
		
		/**
		 * Methode qui implémente les attributs du personnage niveau,
		 * force, agilité, intelligence avec une gestion de cas d'exception possible. 
		 */
		public void caracteresPersonnage(){
			boolean valueIsGood;
			do {
				System.out.println("Niveau du personnage ?");
				try {
					this.niveau = sc.nextInt();
					valueIsGood = true;
				}catch (InputMismatchException e) {
	                System.err.println("Merci de saisir une valeur valide");
	                valueIsGood = false;
				}
				if (this.niveau <= 0 || this.niveau > 100) {
					System.out.println("Votre niveau doit etre compris entre 1 et 100.");
					valueIsGood = false;
				}
				sc.nextLine();
			}while(!valueIsGood);
			
			this.vie = this.niveau * 5;
			this.niveauMax = this.niveau;
			
			do {
				System.out.println("Force du personnage ?");
				try {
					this.force = sc.nextInt();
					valueIsGood = true;
				}catch(InputMismatchException e) {
					System.err.println("Merci de saisir une valeur valide");
	                valueIsGood = false;
				}
				
				if(this.force > this.niveauMax) {
					System.out.println("le total force + agilité + intelligence doit être égal au niveau du joueur");
					valueIsGood = false;
				}
				sc.nextLine();
			}while(!valueIsGood);
			
			this.niveauMax -= this.force; 
		
			do {
				System.out.println("Agilité du personnage ?");
				try {
					this.agilite = sc.nextInt();
					valueIsGood = true;
				}catch(InputMismatchException e) {
					System.err.println("Merci de saisir une valeur valide");
	                valueIsGood = false;
				}
				if(this.agilite > this.niveauMax) {
					System.out.println("le total force + agilité + intelligence doit être égal au niveau du joueur");
					valueIsGood = false;
				}
				sc.nextLine();
			}while(!valueIsGood);
			
			this.niveauMax -= this.agilite; 
			
			do {
				System.out.println("Intelligence du personnage ?");
				try{
					this.intelligence = sc.nextInt();
					valueIsGood = true;
				}catch(InputMismatchException e) {
					System.err.println("Merci de saisir une valeur valide");
					valueIsGood = false;
				}
				if(this.intelligence > this.niveauMax) {
					System.out.println("le total force + agilité + intelligence doit être égal au niveau du joueur");
					valueIsGood = false;
				}
				sc.nextLine();
			}while(!valueIsGood);
			
			this.niveauMax -= this.intelligence; 
		};
		
		
		/* 
		 * Methode décrivant le personnage selon ses spécificités.
		 */
		public String toString() {
			return this.getClasse()+" joueur "+this.leJoueur+" niveau "+this.niveau+" je possède "+this.vie+" de vitalité, "+this.force+" de force, "+this.agilite+" d'agilité et "+this.intelligence+" d'intelligence !";
		};
		
		
		/**Exécute attaque basique du joueur et affiche le dégat infligé à l'adversaire.
		 * @param adversaire valeur personnage adverse
		 */
		public abstract void attaqueBasique(Personnage adversaire);
		
		
		/**Exécute attaque spéciale du joueur et affiche le dégat infligé à l'adversaire.
		 * @param adversaire valeur personnage adverse
		 */
		public abstract void attaqueSpeciale(Personnage adversaire);
		
		
		public int getVie() {
			return vie;
		}

		public void setVie(int vie) {
			this.vie = vie;
		}

		public int getForce() {
			return force;
		}

		public void setForce(int force) {
			this.force = force;
		}

		public int getAgilite() {
			return agilite;
		}

		public void setAgilite(int agilite) {
			this.agilite = agilite;
		}

		public int getIntelligence() {
			return intelligence;
		}

		public void setIntelligence(int intelligence) {
			this.intelligence = intelligence;
		}

		public void setClasse(String classe) {
			this.classe = classe;
		}
		public String getClasse() {
			return classe;
		}

		public int getNiveauMax() {
			return niveauMax;
		}

		public void setNiveauMax(int niveauMax) {
			this.niveauMax = niveauMax;
		}
		public int getNiveau() {
			return niveau;
		}
	}
