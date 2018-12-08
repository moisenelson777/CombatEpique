package com.nelson.personnages;

public class Mage extends Personnage {

		public Mage(int leJoueur) {
			super();
			this.leJoueur = leJoueur;
		}
		
		@Override
		public String toString() {
			return "Woarg Je suis le "+this.getClasse()+" joueur "+this.leJoueur+" niveau "+this.niveau+" je possède "+this.vie+" de vitalité, "+this.force+" de force, "+this.agilite+" d'agilité et "+this.intelligence+" d'intelligence !";
		}
		
		@Override
		void attaqueBasique(Personnage adversaire) {
			int bouleDeFeu = this.intelligence;
	        System.out.println("Joueur "+this.leJoueur+" utilise Boule de feu et inflige "+bouleDeFeu+" dommages.");
	        adversaire.vie -= bouleDeFeu;
	        System.out.println("Le joueur"+adversaire.leJoueur+" perd "+bouleDeFeu+" point de vie");
	        if (adversaire.getVie()<=0)
	            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
		}

		@Override
		void attaqueSpeciale(Personnage personne) {
			int poinDeVieMax = this.niveau * 5;
	        int soin = this.intelligence * 2;
	        if (this.vie < poinDeVieMax){
	            this.vie += soin;
	        System.out.println("Joueur "+this.leJoueur+" utilise soin et gagne "+soin+" en vitalite.");
	        }else if(this.vie + soin > poinDeVieMax){
	            soin = poinDeVieMax - this.vie;
	                    this.vie = poinDeVieMax;
	        System.out.println("Joueur "+this.leJoueur+" utilise soin et gagne "+soin+" en vitalite.");
	        }
		}
	}


