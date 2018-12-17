package com.nelson.personnages;

public class Mage extends Personnage {

		/**Contructeur du personnage Mage 
		 * @param leJoueur valeur identifiant du joueur
		 */
		public Mage(String nom, int niveau, int force, int agilite, int intelligence) throws BadCharacteristicsException {
	        super(nom, niveau, force, agilite, intelligence);
	    }
		
		/**Ex�cute attaque basique du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param i valeur personnage adverse
		 * 
		 */
		@Override
	    public void attaqueBasique(Personnage adversaire) {
	        int dommage = intelligence;
	        System.out.println(nom +  " utilise  Boule de Feu et inflige " + dommage + " dommages.");
	        adversaire.infligeDommages(dommage);
	    }

		/**Ex�cute attaque sp�ciale du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param ennemie valeur personnage adverse
		 * 
		 */ 
	    @Override
	    public void attaqueSpeciale(Personnage ennemie) {
	    	int vitaliteGeneree = intelligence * 2;
	        int nouvelleVitalite = vitalite + vitaliteGeneree;
	        if (nouvelleVitalite > niveau * 5)
	        	nouvelleVitalite = niveau * 5;
	        System.out.println(nom +  " utilise Soin et gagne " + (nouvelleVitalite - vitalite) + " en vitalit�.");
	        vitalite = nouvelleVitalite;
	    }
		
		/* 
		 * Methode d�crivant le personnage selon ses sp�cificit�s.
		 */
		@Override
		public String toString() {
			return "Abracadabra Je suis le "+super.toString();
		}
}	