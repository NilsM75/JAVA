public class Sac extends Acc{ // Un sac est un accessoire
	private Acc[] tab ; // seul attribut de cette classe

	/* Constructeurs */
	public Sac (int n){
		super("Sac") ; // Appel au constructeur Acc("Sac") 
		tab = new Acc[n] ; // Le sac peut contenir au maximum n accessoires (n taille du tableau)
	}
	
	public Sac (){
		super("Sac") ; // Appel au constructeur Acc("Sac") 
		tab = new Acc[(1 + (int)(Math.random() * 10.0))] ; //Sac peut contenir entre [1;10] accessoires
	}

	/* Méthodes */
	public int nbElementSac(){
    int cpt=0;
    for(Acc val :tab){
      if(val != null){
        cpt++;
      }
    }
    return cpt;
  }
  public double getPoids(){
    double poids = 0;
    for(int i=0;i<nbElementSac();i++){
      poids += tab[i].getPoids();
    }
    return poids;
  }

	public int size(){
		return (tab.length) ;
	}
	
	public void ajouter(Acc a){
		for (Acc val : tab){
			if (val == null){
				val = a ;
				return ;
			}
		}
		System.out.println("Pas de place") ; 
		return ; 
	}
		
	public Acc obtenir(int i){
		if (tab[i] != null){
			Acc temp = tab[i] ; 
			tab[i] = null ;
			return temp ; 
		}
		return null ; 
	}

	@Override
	public String toString(){
		//return ("Sac No %d %2.fkg contient %d accessoires sur %d places", numero, getPoids(), super.cpt);
		return ("Sac No "+numero+" "+getPoids()+"kg contient "+super.cpt+" places");
	}
}
