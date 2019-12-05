public class Sac extends Acc { // Un sac est un accessoire, Sac est une classe fille d'Acc

	/* Attribut, obligatoirement un seul attribut */
	
	private Acc[] tab ; // tableau d'accessoires 

	/* Constructeurs */
	
	public Sac (int n) {
		super("Sac") ; // Appel au constructeur Acc("Sac") 
		tab = new Acc[n] ; // Le sac peut contenir au maximum n accessoires (n est la taille du tableau)
	}
	
	public Sac () {
		super("Sac") ; // Appel au constructeur Acc("Sac") 
		tab = new Acc[(1 + (int)(Math.random() * 10.0d))] ; //Sac peut contenir un nombre dans [1;10] d'accessoires
	}

	/* Méthodes */

	public double getPoids () { // retourne le poids du sac 
		double poids = 0.0 ;
		for(int i = 0 ; i < tab.length ; i ++){
			if(tab[i] != null){
				poids += tab[i].getPoids() ;
			}
		}
		return poids ;
	}
	
	public int size () { // retourne le nombre maximal de places dans le sac 
		return (tab.length) ;
	}
	
	public void ajouter (Acc a) { // Ajoute l'accessoire a à la première place libre, ou affiche "Pas de place" si aucune place n'est libre dans le sac.
		for (int i = 0 ; i < tab.length ; i ++){
			if (tab[i] == null){
				tab[i] = a ;
				return ;
			}
		}
		System.out.println("Pas de place") ; 
		return ; 
	}
		
	public Acc obtenir(int i){ // retourne l'accessoire à la position i dans le sac s'il existe, null sinon. L'accessoire retourné n'est plus dans le sac.
		if (tab[i] != null){
			Acc temp = tab[i] ; 
			tab[i] = null ;
			return temp ; 
		}
		return null ; 
	}

	public int getNbElementsSac(){ // retourne le nombre d'éléments/accessoires dans le sac
		int cpt = 0 ;
		for (int i = 0 ; i < tab.length ; i ++){
			if (tab[i] != null){
				cpt ++ ; 
			}
		}
		return cpt ; 
	}
	
	@Override
	public String toString(){
		String temp = new String() ; 
		for (Acc acc : tab){
			if (acc != null){ 
				temp += "\t" + acc.toString() + "\n" ; 
			}
		}

		// accessoire (s) / place (s)
		
		String temp1, temp2 ; 
		if(getNbElementsSac() > 1){
			temp1 = new String(" accessoires sur ") ;
		}
		else{
			temp1 = new String(" accessoire sur ") ; 
		}
		if(size() > 1){
			temp2 = new String(" places\n") ; 
		}
		else{
			temp2 = new String(" place\n") ; 
		}
		
		return (super.toString() + " contient " + getNbElementsSac() + temp1 + size() + temp2 + temp) ;
		/* Exemple : 
			sac No 3 0.80kg contient 2 accessoires sur 7 places 
				pomme No 1 0,26kg 3.9cm
				pomme No 2 0.54kg 5.0cm
		*/
	}
	
	public Acc[] getTab(){ // retourne le tableau d'accessoires 
		return tab ; 
	}
	
}
