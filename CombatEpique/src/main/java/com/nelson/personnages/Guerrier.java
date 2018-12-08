package com.nelson.personnages;

public class Guerrier extends Personnage {
	
	public Guerrier(int leJoueur) {
		super();
		this.leJoueur = leJoueur;
	}
	
	@Override
	public String toString() {
		return "Woarg Je suis le "+this.getClasse()+" joueur "+this.leJoueur+" niveau "+this.niveau+" je possède "+this.vie+" de vitalité, "+this.force+" de force, "+this.agilite+" d'agilité et "+this.intelligence+" d'intelligence !";	
	}

	@Override
	void attaqueBasique(Personnage adversaire) {
		int coupdEpee = this.getForce();
        System.out.println("Joueur "+this.leJoueur+" utilise Coup d'Epée et inflige "+coupdEpee+" dommages.");
        adversaire.vie -= coupdEpee;
        if (adversaire.vie <=0)
            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
	}

	@Override
	void attaqueSpeciale(Personnage adversaire) {
		int coupDeRage = this.getForce() * 2;
        System.out.println("Joueur "+this.leJoueur+" Coup de Rage et inflige "+coupDeRage+" dommages.");
        adversaire.vie -= coupDeRage;
        this.vie -= this.getForce()/2;
        System.out.println("Le joueur"+adversaire.leJoueur+" perd "+coupDeRage+" point de vie");
        if (adversaire.vie <= 0)
            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
        System.out.println("Le joueur"+this.leJoueur+" perd "+coupDeRage/4+" point de vie");
	}		
}
