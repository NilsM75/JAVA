public abstract class Acc{
	protected static int cpt = 0 ; // compte le nombre d'accessoires
	private int numero ; // numero de l'accessoire (1 pour le 1er, 2 pour le 2ème...)
	private String categorie ; // catégorie de l'accessoire (sac, pomme...)

	/* Constructeurs */
	public Acc (String categorie){
		this.categorie = categorie ;
		numero = cpt++ ;
	}

	/* Méthodes */
	public abstract double getPoids(); // On ne peut pas définir le corps de cette méthode dans cette classe (abstraite)
	// le crops sera défini dans les classes filles, utilisable ici 
	
	@Override
	public String toString (){
		return String.format("%s No %d %.2fkg", categorie, numero, getPoids());
	}
}
