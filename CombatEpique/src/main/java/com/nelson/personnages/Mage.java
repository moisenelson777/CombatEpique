package com.nelson.personnages;

public class Mage extends Personnage {

		/**Contructeur du personnage Mage 
		 * @param leJoueur valeur identifiant du joueur
		 */
		public Mage(int leJoueur) {
			super();
			this.leJoueur = leJoueur;
		}
		
		/* 
		 * Methode d�crivant le personnage selon ses sp�cificit�s.
		 */
		@Override
		public String toString() {
			return "Abracadabra Je suis le "+super.toString();
		}
		
		/**Ex�cute attaque basique du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param adversaire valeur personnage adverse
		 * 
		 */ 
		@Override
		public void attaqueBasique(Personnage adversaire) {
			int bouleDeFeu = this.intelligence;
	        System.out.println("Joueur "+this.leJoueur+" utilise Boule de feu et inflige "+bouleDeFeu+" dommages.");
	        adversaire.vie -= bouleDeFeu;
	        System.out.println("Le joueur"+adversaire.leJoueur+" perd "+bouleDeFeu+" point de vie");
	        if (adversaire.getVie()<=0)
	            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
		}

		/**Ex�cute attaque sp�ciale du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param adversaire valeur personnage adverse
		 * 
		 */ 
		@Override
		public void attaqueSpeciale(Personnage adversaire) {
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


