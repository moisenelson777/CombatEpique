package com.nelson.personnages;

public class Guerrier extends Personnage {
	
	
	/**Contructeur du personnage
	 * @param nom
	 * @param niveau
	 * @param force
	 * @param agilite
	 * @param intelligence
	 * @throws BadCharacteristicsException
	 */
	public Guerrier(String nom, int niveau, int force, int agilite, int intelligence) throws BadCharacteristicsException {
        super(nom, niveau, force, agilite, intelligence);
    }

	/* Exécute attaque basique du joueur et affiche le dégat infligé à l'adversaire.
	 * @see com.nelson.personnages.Personnage#attaqueBasique(com.nelson.personnages.Personnage)
	 */
	@Override
    public void attaqueBasique(Personnage ennemie) {
        int dommage = force;
        System.out.println(nom +  " utilise Coup d'épée et inflige " + dommage + " dommages.");
        ennemie.infligeDommages(dommage);
    }

    /* Exécute attaque basique du joueur et affiche le dégat infligé à l'adversaire.
     * @see com.nelson.personnages.Personnage#attaqueSpeciale(com.nelson.personnages.Personnage)
     */
    @Override
    public void attaqueSpeciale(Personnage ennemie) {
        int dommage = force * 2;
        System.out.println(nom +  " utilise Coup de Rage et inflige " + dommage + " dommages.");
        ennemie.infligeDommages(dommage);
        int autoDommage = force / 2;
        this.infligeDommages(autoDommage);
    }
	
	
	/* 
	 * @see com.nelson.personnages.Personnage#toString()
	 */
	@Override
	public String toString() {
		return "Woarg Je suis le "+super.toString();	
	}
}