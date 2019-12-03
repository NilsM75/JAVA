public abstract class Noms { // classe outil 
	/* Attributs */
	private String[] tabNoms ; // tableau qui contiendra les noms choisis
	private static int cpt = 0 ; // compteur du nombre de fois que le tableau est parcouru
	private static int position = (-1) ; // donne la position courante dans le tableau

	/* Constructeurs */
	
	public Noms() {
		tabNoms = new String[] {"Jean", "Petit", "QuiDanse"} ;
	}
	
	/* Methodes */
	
	public String getNom(){ 
		position ++ ; 
		if (position < tabNoms.length){
			if(cpt == 0){
				return ("" + tabNoms[position]) ; 
			}
			return ("" + tabNoms[position] + cpt) ; 
		}
		
		cpt ++ ; 
		position = (-1) ; 
		
		return getNom() ; 
	}
	
	/* //Pour tester la fonction getNom(), il suffit de décommenter cette partie et de rendre la classe non abstraite 
	public static void main(String[] args) {
		Noms test = new Noms() ;
		System.out.println(test.getNom() + "  " + test.getNom() + "   " + test.getNom()+
		test.getNom() + "  " + test.getNom() + "   " + test.getNom()
		+test.getNom() + "  " + test.getNom() + "   " + test.getNom()+
		test.getNom() + "  " + test.getNom() + "   " + test.getNom()) ; 
	}
	*/
}
