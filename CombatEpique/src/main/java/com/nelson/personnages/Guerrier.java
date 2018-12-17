package com.nelson.personnages;

public class Guerrier extends Personnage {
	
	
	public Guerrier(String nom, int niveau, int force, int agilite, int intelligence) throws BadCharacteristicsException {
        super(nom, niveau, force, agilite, intelligence);
    }

	@Override
    public void attaqueBasique(Personnage ennemie) {
        int dommage = force;
        System.out.println(nom +  " utilise Coup d'épée et inflige " + dommage + " dommages.");
        ennemie.infligeDommages(dommage);
    }

    @Override
    public void attaqueSpeciale(Personnage ennemie) {
        int dommage = force * 2;
        System.out.println(nom +  " utilise Coup de Rage et inflige " + dommage + " dommages.");
        ennemie.infligeDommages(dommage);
        int autoDommage = force / 2;
        this.infligeDommages(autoDommage);
    }
	
	/* 
	 * Methode décrivant le personnage selon ses spécificités.
	 */
	@Override
	public String toString() {
		return "Woarg Je suis le "+super.toString();	
	}
}