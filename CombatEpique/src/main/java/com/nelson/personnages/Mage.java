package com.nelson.personnages;

public class Mage extends Personnage {

		
		/**Contructeur du personnage
		 * @param nom
		 * @param niveau
		 * @param force
		 * @param agilite
		 * @param intelligence
		 * @throws BadCharacteristicsException
		 */
		public Mage(String nom, int niveau, int force, int agilite, int intelligence) throws BadCharacteristicsException {
	        super(nom, niveau, force, agilite, intelligence);
	    }
		
		
		/* Exécute attaque basique du joueur et affiche le dégat infligé à l'adversaire.
		 * @see com.nelson.personnages.Personnage#attaqueBasique(com.nelson.personnages.Personnage)
		 */
		@Override
	    public void attaqueBasique(Personnage adversaire) {
	        int dommage = intelligence;
	        System.out.println(nom +  " utilise  Boule de Feu et inflige " + dommage + " dommages.");
	        adversaire.infligeDommages(dommage);
	    }

		 
	    /* Exécute attaque basique du joueur et affiche le dégat infligé à l'adversaire.
	     * @see com.nelson.personnages.Personnage#attaqueSpeciale(com.nelson.personnages.Personnage)
	     */
	    @Override
	    public void attaqueSpeciale(Personnage ennemie) {
	    	int vitaliteGeneree = intelligence * 2;
	        int nouvelleVitalite = vitalite + vitaliteGeneree;
	        if (nouvelleVitalite > niveau * 5)
	        	nouvelleVitalite = niveau * 5;
	        System.out.println(nom +  " utilise Soin et gagne " + (nouvelleVitalite - vitalite) + " en vitalité.");
	        vitalite = nouvelleVitalite;
	    }
		
		/* 
		 * @see com.nelson.personnages.Personnage#toString()
		 */
		@Override
		public String toString() {
			return "Abracadabra Je suis le "+super.toString();
		}
}	