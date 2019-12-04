public abstract class Acc {
	
	/* Attributs */
	
	protected static int cpt = 0 ; // compte le nombre d'accessoires
	private int numero ; // numero de l'accessoire (1 pour le 1er, 2 pour le 2ème...)
	private String categorie ; // catégorie de l'accessoire (sac, pomme...)

	/* Constructeurs */
	
	private Acc () { }
	
	public Acc (String categorie) {
		this.categorie = categorie ;
		cpt ++ ; 
		numero = cpt ; 
	}

	/* Méthodes */
	
	public abstract double getPoids() ; // On ne peut pas définir le corps de cette méthode dans cette classe (abstraite)
	// le crops sera défini dans les classes filles, utilisable ici 
	
	@Override
	public String toString () {
		return String.format("%s No %d %.2fkg", categorie, numero, getPoids()) ;
		// exemple : pomme No 1 0.26kg // exemple : sac No 2 1.80kg
	}
	
	public int getNumero(){
		return numero ; 
	}
	
	private void setNumero(int numero){
		this.numero = numero ; 
		return ; 
	}
	
	public String getCategorie(){
		return categorie ; 
	}
	
	private void setCategorie(String categorie){
		this.categorie = categorie ; 
		return ; 
	}
}
