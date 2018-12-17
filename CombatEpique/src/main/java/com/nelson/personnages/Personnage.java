package com.nelson.personnages;

		/*
		* La classe abstraite avec les methodes  à implémenter selon la specialité voulue.
	 	* Elle héritera de classes enfants selon la spécialité nominale.
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
		
		public void infligeDommages(int dommage) {
			this.vitalite -= dommage;
	        System.out.println(this.getNom() + " perd " + dommage + " points de vie") ;
	        if (this.vitalite <= 0)
	            System.out.println(this.getNom() + " est mort");
		}
		
		/**Exécute attaque basique du joueur et affiche le dégat infligé à l'adversaire.
		 * @param adversaire valeur personnage adverse
		 */
		public abstract void attaqueBasique(Personnage ennemie);
		
		/**Exécute attaque spéciale du joueur et affiche le dégat infligé à l'adversaire.
		 * @param adversaire valeur personnage adverse
		 */
		public abstract void attaqueSpeciale(Personnage ennemie);
		
		@Override
		public String toString() {
			return  "Personnage {" + this.nom +", niveau "+this.niveau+" je possède "+this.vitalite+" de vitalité, "+this.force+" de force, "+this.agilite+" d'agilité et "+this.intelligence+" d'intelligence }";
		    }
		}	
		
		/*
		
		/**
		 * Methode qui implémente les attributs du personnage niveau,
		 * force, agilité, intelligence avec une gestion de cas d'exception possible. 
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
				
				this.agilite = askForIntValue("Agilité du personnage ?", 0, this.niveau);
				this.niveauMax -= this.agilite; 
				
				this.intelligence = askForIntValue("Intelligence du personnage ?", 0, this.niveau);
				this.niveauMax -= this.intelligence;
				
				if(this.force+this.agilite+this.intelligence <= this.niveau) {
					valeurIsGood = true;
				}else {
					System.out.println("Merci de saisir un total de points de caractères égal au niveau de votre personnage.");
					valeurIsGood = false;
				}
			}while(!valeurIsGood);
					
		}
			
		/* 
		 * Methode décrivant le personnage selon ses spécificités.
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
	                System.err.println("Merci de saisir une valeur supérieure ou égale à  " + minValue);
	                valueIsGood = false;
	            }
	            if (value > maxValue) {
	            			System.err.println("Merci de saisir une valeur inférieure ou égale à  " + maxValue);
		            		valueIsGood = false;
	            }
	        } while (!valueIsGood);
	        return value;
	    }
}
*/