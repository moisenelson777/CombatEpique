package com.nelson.personnages;

public class Rodeur extends Personnage {

		
		/**Contructeur du personnage Rodeur 
		 * @param nom
		 * @param niveau
		 * @param force
		 * @param agilite
		 * @param intelligence
		 * @throws BadCharacteristicsException
		 */
		public Rodeur(String nom, int niveau, int force, int agilite, int intelligence) throws BadCharacteristicsException {
	        super(nom, niveau, force, agilite, intelligence);
	    }

		/* 
		 * @see com.nelson.personnages.Personnage#attaqueBasique(com.nelson.personnages.Personnage)
		 */
		@Override
	    public void attaqueBasique(Personnage ennemie) {
			int dommage = agilite;
	        System.out.println(nom +  " utilise Tir à  l'arc et inflige " + dommage + " dommages.");
	        ennemie.infligeDommages(dommage);
	    }

	    /* 
	     * @see com.nelson.personnages.Personnage#attaqueSpeciale(com.nelson.personnages.Personnage)
	     */
	    @Override
	    public void attaqueSpeciale(Personnage ennemie) {
	    	 int agiliteGeneree = agilite/2;
	         System.out.println(nom +  " utilise Concentration et gagne " + agiliteGeneree + " en agilité.");
	         agilite += agiliteGeneree;
	    }
		
		
		/* 
		 * @see com.nelson.personnages.Personnage#toString()
		 */
		@Override
		public String toString() {
			return "Chut je suis le "+super.toString();	
		}
	}