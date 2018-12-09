package com.nelson.personnages;

public class Guerrier extends Personnage {
	
	/**Contructeur du personnage Guerrier 
	 * @param leJoueur valeur identifiant du joueur
	 */
	public Guerrier(int leJoueur) {
		super();
		this.leJoueur = leJoueur;
	}
	
	
	/* 
	 * Methode d�crivant le personnage selon ses sp�cificit�s.
	 */
	@Override
	public String toString() {
		return "Woarg Je suis le "+super.toString();	
	}

	/**Ex�cute attaque basique du joueur et affiche le d�gat inflig� � l'adversaire.
	 * @param adversaire valeur personnage adverse
	 * 
	 */ 
	@Override
	public void attaqueBasique(Personnage adversaire) {
		int coupdEpee = this.getForce();
        System.out.println("Joueur "+this.leJoueur+" utilise Coup d'Ep�e et inflige "+coupdEpee+" dommages.");
        adversaire.vie -= coupdEpee;
        if (adversaire.vie <=0)
            System.out.println("Joueur " + adversaire.leJoueur + " est mort");
	}

	
	/**Ex�cute attaque sp�ciale du joueur et affiche le d�gat inflig� � l'adversaire.
	 * @param adversaire valeur personnage adverse
	 * 
	 */ 
	@Override
	public void attaqueSpeciale(Personnage adversaire) {
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
