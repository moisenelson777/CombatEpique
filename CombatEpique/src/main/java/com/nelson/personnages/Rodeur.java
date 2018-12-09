package com.nelson.personnages;

public class Rodeur extends Personnage {

		public Rodeur(int leJoueur) {
			super();
			this.leJoueur = leJoueur;
		}

		@Override
		public String toString() {
			return "Chut Je suis le "+super.toString();	
		}

		@Override
		public void attaqueBasique(Personnage adversaire) {
			int tirAlArc = this.getAgilite();
	        System.out.println("Joueur "+this.leJoueur+" utilise Tire ра l'Arc et inflige "+tirAlArc+" dommages.");
	        adversaire.vie -= tirAlArc;
	        System.out.println("Le joueur"+adversaire.leJoueur+" perd "+tirAlArc+" point de vie");
	        if (adversaire.getVie()<=0)
	            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
		}

		@Override
		public void attaqueSpeciale(Personnage personne) {
			int concentration = this.getNiveau() / 2;
	        System.out.println("Joueur "+this.leJoueur+" utilise soin et gagne "+concentration+" en agilite.");
	        this.agilite += concentration;
		}
	}
