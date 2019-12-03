public  class Noms { // classe outil 
	/* Attributs */
	private String tabNoms[] ; // tableau qui contiendra les noms choisis
	private static int cpt = 0 ; // compteur du nombre de fois que le tableau est parcouru
	private static int position = (0) ; // donne la position courante dans le tableau

	/* Constructeurs */
	
	public Noms() {
		String tabNoms[] = {"Jean", "Petit", "QuiDanse"} ;
	}
	
	/* Methodes */
	
  public String getNom(){ // marche pas
    if(cpt > 0){
      return (""+tabNoms[position++]+cpt);
    }
    if(position == tabNoms.length){
      cpt++;
      return (""+tabNoms[position++]);
    }
    return (""+tabNoms[position++]);
  }

	public static void main(String[] args) {
		Noms test = new Noms() ;
		System.out.print(test.getNom() + "  " + test.getNom() + "  " + test.getNom()) ;  
		
	}

}
