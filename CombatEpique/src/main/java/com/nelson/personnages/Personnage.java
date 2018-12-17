package com.nelson.personnages;

		/*
		* La classe abstraite avec les methodes  � impl�menter selon la specialit� voulue.
	 	* Elle h�ritera de classes enfants selon la sp�cialit� nominale.
	 	*/
		public abstract class Personnage {
		
			protected String nom ;
			protected int niveau, force, agilite, intelligence, vitalite;

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
		
		public void infligeDommages(int dommage) {
			this.vitalite -= dommage;
	        System.out.println(this.getNom() + " perd " + dommage + " points de vie") ;
	        if (this.vitalite <= 0)
	            System.out.println(this.getNom() + " est mort");
		}
		
		/**Ex�cute attaque basique du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param adversaire valeur personnage adverse
		 */
		public abstract void attaqueBasique(Personnage ennemie);
		
		/**Ex�cute attaque sp�ciale du joueur et affiche le d�gat inflig� � l'adversaire.
		 * @param adversaire valeur personnage adverse
		 */
		public abstract void attaqueSpeciale(Personnage ennemie);
		
		@Override
		public String toString() {
			return  "Personnage {" + this.nom +", niveau "+this.niveau+" je poss�de "+this.vitalite+" de vitalit�, "+this.force+" de force, "+this.agilite+" d'agilit� et "+this.intelligence+" d'intelligence }";
		    }
		}	
		
		/*
		
		/**
		 * Methode qui impl�mente les attributs du personnage niveau,
		 * force, agilit�, intelligence avec une gestion de cas d'exception possible. 
		 */
/*
		public void caracteresPersonnage(){
			boolean valeurIsGood;
			do {
				this.niveau = askForIntValue("Niveau du personnage ?", 0, 100);
				this.vie = this.niveau * 5;
				this.niveauMax = this.niveau;
				
				this.force = askForIntValue("Force du personnage ?", 0, this.niveau);
				this.niveauMax -= this.force; 
				
				this.agilite = askForIntValue("Agilit� du personnage ?", 0, this.niveau);
				this.niveauMax -= this.agilite; 
				
				this.intelligence = askForIntValue("Intelligence du personnage ?", 0, this.niveau);
				this.niveauMax -= this.intelligence;
				
				if(this.force+this.agilite+this.intelligence <= this.niveau) {
					valeurIsGood = true;
				}else {
					System.out.println("Merci de saisir un total de points de caract�res �gal au niveau de votre personnage.");
					valeurIsGood = false;
				}
			}while(!valeurIsGood);
					
		}
			
		/* 
		 * Methode d�crivant le personnage selon ses sp�cificit�s.
		 */
		
		
	
/*		
		public int askForIntValue(String question, int minValue, int maxValue) {
	        System.out.println(question);
	        int value = -1;
	        boolean valueIsGood;
	        do {
	            try {
	                value = sc.nextInt();
	                valueIsGood = true;
	            } catch (InputMismatchException e) {
	                sc.next();
	                System.err.println("Merci de saisir une valeur valide");
	                valueIsGood = false;
	            }
	            if (value < minValue) {
	                System.err.println("Merci de saisir une valeur sup�rieure ou �gale � " + minValue);
	                valueIsGood = false;
	            }
	            if (value > maxValue) {
	            			System.err.println("Merci de saisir une valeur inf�rieure ou �gale � " + maxValue);
		            		valueIsGood = false;
	            }
	        } while (!valueIsGood);
	        return value;
	    }
}
*/