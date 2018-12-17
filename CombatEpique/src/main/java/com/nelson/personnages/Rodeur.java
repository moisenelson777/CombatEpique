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
	        System.out.println(nom +  " utilise Tir � l'arc et inflige " + dommage + " dommages.");
	        ennemie.infligeDommages(dommage);
	    }

	    @Override
	    public void attaqueSpeciale(Personnage ennemie) {
	    	 int agiliteGeneree = agilite/2;
	         System.out.println(nom +  " utilise Concentration et gagne " + agiliteGeneree + " en agilit�.");
	         agilite += agiliteGeneree;
	    }
		
		/* 
		 * Methode d�crivant le personnage selon ses sp�cificit�s.
		 */
		@Override
		public String toString() {
			return "Chut je suis le "+super.toString();	
		}
	}