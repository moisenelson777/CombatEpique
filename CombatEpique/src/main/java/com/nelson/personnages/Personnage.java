package com.nelson.personnages;

		/*
		* La classe abstraite avec les methodes  à implémenter selon la specialité.
	 	* Elle héritera de classes enfants selon la spécialité nominale.
	 	*/
		public abstract class Personnage {
		
			protected String nom ;
			protected int niveau, force, agilite, intelligence, vitalite;

		/**Constructeur par défaut du personnage;
		 * @param nom valeur nomination du personnage;
		 * @param niveau valeur niveau du personnage;
		 * @param force valeur force du personnage;
		 * @param agilite valeur agilité du personnage;
		 * @param intelligence valeur intelligence du personnage;
		 * @throws BadCharacteristicsException levée si somme des capacités supérieure au niveau;
		 */
		public Personnage(String nom, int niveau, int force, int agilite,int intelligence) throws BadCharacteristicsException{
			
			this.nom = nom;
			this.niveau = niveau;
			this.force = force;
			this.agilite = agilite;
			this.intelligence = intelligence;
			this.vitalite = this.niveau * 5;
			
			if(force+agilite+intelligence > niveau) throw new BadCharacteristicsException();
		}
		
		public String getNom() {
			return nom;
		}
		
		public String getNomEtVitalite() {
			return nom + " (" + vitalite + " Vitalité)";
		}
		
		public int getNiveau() {
			return niveau;
		}
		
		public int getVitalite() {
			return vitalite;
		}

		public int getForce() {
			return force;
		}
		
		public int getAgilite() {
			return agilite;
		}

		public int getIntelligence() {
			return intelligence;
		}
		
		/**Méthode décrivant la portée des dégats infligés suite à une attaque.
		 * @param dommage valeur dégat infligé à l'adversaire.
		 */
		public void infligeDommages(int dommage) {
			this.vitalite -= dommage;
	        System.out.println(this.getNom() + " perd " + dommage + " points de vie") ;
	        if (this.vitalite <= 0)
	            System.out.println(this.getNom() + " est mort");
		}
		
		/**Exécute attaque basique du joueur et affiche le dégat infligé à l'adversaire.
		 * @param ennemie valeur personnage adverse
		 */
		public abstract void attaqueBasique(Personnage ennemie);
		
		/**Exécute attaque spéciale du joueur et affiche le dégat infligé à l'adversaire.
		 * @param ennemie valeur personnage adverse
		 */
		public abstract void attaqueSpeciale(Personnage ennemie);
		
		/* 
		 * Présente le personnage ainsi que ses attributs.
		 */
		@Override
		public String toString() {
			return   this.getClass().getSimpleName()+" {" + this.nom +", niveau "+this.niveau+" je possède "+this.vitalite+" de vitalité, "+this.force+" de force, "+this.agilite+" d'agilité et "+this.intelligence+" d'intelligence }";
		    }
		}	