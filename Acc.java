public abstract class Acc { // Acc pour accessoire 
	
	/* Attributs */
	
	protected static int cpt = 0 ; // compteur qui compte le nombre d'accessoires
	private int numero ; // numéro de l'accessoire (1 pour le 1er, 2 pour le 2ème...)
	private String categorie ; // catégorie de l'accessoire (sac, pomme...)

	/* Constructeurs */
	
	private Acc () { }
	
	public Acc (String categorie) {
		this.categorie = categorie ;
		cpt ++ ; 
		numero = cpt ; 
	}

	/* Méthodes */
	
	public abstract double getPoids() ; // retourne le poids de l'accessoire 
	/* 	On ne peut pas définir le corps de cette méthode dans cette classe (abstraite)
		le crops sera défini dans les classes filles, utilisable ici */
	
	@Override
	public String toString () {
		return String.format("%s No %d %.2fkg", categorie, numero, getPoids()) ; // affichage du poids avec uniquement deux chiffres derrière la virgule 
		// exemple 1 : pomme No 1 0.26kg | exemple 2 : sac No 2 1.80kg
	}
	
	public int getNumero(){ // retourne le numéro de l'accessoire
		return numero ; 
	}
	
	private void setNumero(int numero){ // modifie le numéro de l'accessoire
		this.numero = numero ; 
		return ; 
	}
	
	public String getCategorie(){ // retourne la catégorie de l'accessoire
		return categorie ; 
	}
	
	private void setCategorie(String categorie){ // modifie la catégorie de l'accessoire 
		this.categorie = categorie ; 
		return ; 
	}
}
