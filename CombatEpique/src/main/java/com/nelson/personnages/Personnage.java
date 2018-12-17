package com.nelson.personnages;

		/*
		* La classe abstraite avec les methodes  � impl�menter selon la specialit�.
	 	* Elle h�ritera de classes enfants selon la sp�cialit� nominale.
	 	*/
		public abstract class Personnage {
		
			protected String nom ;
			protected int niveau, force, agilite, intelligence, vitalite;

		/**Constructeur par d�faut du personnage;
		 * @param nom valeur nomination du personnage;
		 * @param niveau valeur niveau du personnage;
		 * @param force valeur force du personnage;
		 * @param agilite valeur agilit� du personnage;
		 * @param intelligence valeur intelligence du personnage;
		 * @throws BadCharacteristicsException lev�e si somme des capacit�s sup�rieure au niveau;
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
			return nom + " (" + vitalite + " Vitalit�)";
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
		
		/**M�thode d�crivant la port�e des d�gats inflig�s suite � une attaque.
		 * @param dommage valeur d�gat inflig� � l'adversaire.
		 */
		public void infligeDommages(int dommage) {
			this.vitalite -= dommage;
	        System.out.println(this.getNom() + " perd " + dommage + " points de vie") ;
	        if (this.vitalite <= 0)
	            System.out.println(this.getNom() + " est mort");
		}
		
		/**Ex�cute attaque basique du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param ennemie valeur personnage adverse
		 */
		public abstract void attaqueBasique(Personnage ennemie);
		
		/**Ex�cute attaque sp�ciale du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param ennemie valeur personnage adverse
		 */
		public abstract void attaqueSpeciale(Personnage ennemie);
		
		/* 
		 * Pr�sente le personnage ainsi que ses attributs.
		 */
		@Override
		public String toString() {
			return   this.getClass().getSimpleName()+" {" + this.nom +", niveau "+this.niveau+" je poss�de "+this.vitalite+" de vitalit�, "+this.force+" de force, "+this.agilite+" d'agilit� et "+this.intelligence+" d'intelligence }";
		    }
		}	