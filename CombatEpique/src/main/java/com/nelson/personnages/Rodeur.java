package com.nelson.personnages;

public class Rodeur extends Personnage {

		
		/**Contructeur du personnage Rodeur 
		 * @param leJoueur valeur identifiant du joueur
		 */
		public Rodeur(String nom, int niveau, int force, int agilite, int intelligence) throws BadCharacteristicsException {
	        super(nom, niveau, force, agilite, intelligence);
	    }

		@Override
	    public void attaqueBasique(Personnage ennemie) {
			int dommage = agilite;
	        System.out.println(nom +  " utilise Tir à  l'arc et inflige " + dommage + " dommages.");
	        ennemie.infligeDommages(dommage);
	    }

	    @Override
	    public void attaqueSpeciale(Personnage ennemie) {
	    	 int agiliteGeneree = agilite/2;
	         System.out.println(nom +  " utilise Concentration et gagne " + agiliteGeneree + " en agilité.");
	         agilite += agiliteGeneree;
	    }
		
		/* 
		 * Methode décrivant le personnage selon ses spécificités.
		 */
		@Override
		public String toString() {
			return "Chut je suis le "+super.toString();	
		}
	}