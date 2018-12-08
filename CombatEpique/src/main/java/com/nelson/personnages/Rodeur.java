package com.nelson.personnages;

public class Rodeur extends Personnage {

		public Rodeur(int leJoueur) {
			super();
			this.leJoueur = leJoueur;
		}

		@Override
		public String toString() {
			return "Woarg Je suis le "+this.getClasse()+" joueur "+this.leJoueur+" niveau "+this.niveau+" je possède "+this.vie+" de vitalité, "+this.force+" de force, "+this.agilite+" d'agilité et "+this.intelligence+" d'intelligence !";	
		}

		@Override
		void attaqueBasique(Personnage adversaire) {
			int tirAlArc = this.getAgilite();
	        System.out.println("Joueur "+this.leJoueur+" utilise Tire à  l'Arc et inflige "+tirAlArc+" dommages.");
	        adversaire.vie -= tirAlArc;
	        System.out.println("Le joueur"+adversaire.leJoueur+" perd "+tirAlArc+" point de vie");
	        if (adversaire.getVie()<=0)
	            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
		}

		@Override
		void attaqueSpeciale(Personnage personne) {
			int concentration = this.getNiveau() / 2;
	        System.out.println("Joueur "+this.leJoueur+" utilise soin et gagne "+concentration+" en agilite.");
	        this.agilite += concentration;
		}
	}
