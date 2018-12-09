package com.nelson.personnages;

public class Rodeur extends Personnage {

		
		/**Contructeur du personnage Rodeur 
		 * @param leJoueur valeur identifiant du joueur
		 */
		public Rodeur(int leJoueur) {
			super();
			this.leJoueur = leJoueur;
		}

		/* 
		 * Methode d�crivant le personnage selon ses sp�cificit�s.
		 */
		@Override
		public String toString() {
			return "Chut Je suis le "+super.toString();	
		}

		/**Ex�cute attaque basique du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param adversaire valeur personnage adverse
		 * 
		 */ 
		@Override
		public void attaqueBasique(Personnage adversaire) {
			int tirAlArc = this.getAgilite();
	        System.out.println("Joueur "+this.leJoueur+" utilise Tire � l'Arc et inflige "+tirAlArc+" dommages.");
	        adversaire.vie -= tirAlArc;
	        System.out.println("Le joueur"+adversaire.leJoueur+" perd "+tirAlArc+" point de vie");
	        if (adversaire.getVie()<=0)
	            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
		}

		/**Ex�cute attaque sp�ciale du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param adversaire valeur personnage adverse
		 * 
		 */ 
		@Override
		public void attaqueSpeciale(Personnage adversaire) {
			int concentration = this.getNiveau() / 2;
	        System.out.println("Joueur "+this.leJoueur+" utilise soin et gagne "+concentration+" en agilite.");
	        this.agilite += concentration;
		}
	}
