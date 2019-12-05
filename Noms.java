public abstract class Noms { // classe outil, aucune instance de cette classe ne peut être crée (abstraite)

	/* Attributs */
	
	private final static String[] TAB_NOMS = new String[] {"Altair", "Ezio", "Desmond"} ; // tableau qui contient les noms choisis
	private static int cpt = 0 ; // compteur du nombre de fois que le tableau est parcouru
	private static int position = (-1) ; // donne la position courante dans le tableau

	/* Constructeurs */
	
	private Noms() { }
	
	/* Méthodes */
	
	public static String getNom(){ 
		position ++ ; 
		
		if (position < TAB_NOMS.length){
			/* // à décommenter si on souhaite obtenir les noms sans les chiffres les 3 premiers appels successifs
			if(cpt == 0){ 
				return ("" + TAB_NOMS[position]) ; 
			} */
			return ("" + TAB_NOMS[position] + (cpt + 1)) ; 
		}
		
		cpt ++ ; 
		position = (-1) ; 
		
		return getNom() ; 
	}
	
	/*
	 // Décommenter cette partie pour tester (sauvegarder, compiler puis Java Noms) 
	 
	public static void main(String[] args){
		System.out.println(Noms.getNom() + "  " + Noms.getNom() + "  " + Noms.getNom() + "  " +
		Noms.getNom() + "  " + Noms.getNom() + "   " + Noms.getNom() + "  " 
		+ Noms.getNom() + "  " + Noms.getNom() + "   " + Noms.getNom()+ "  " +
		Noms.getNom() + "  " + Noms.getNom() + "  " + Noms.getNom()) ; 
		return ; 
	}
	*/
}
