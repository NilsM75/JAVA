import java.util.ArrayList ;

public abstract class Monde { 
	/* les personnages et les acccessoires se trouvent dans un monde de forme carrée,
		abstract donc pas de création d'instance */

	/* Attributs */
	private ArrayList<Item> listeItems ; // liste d'items
	private int taille ; // taille du monde 
	
	/* Constructeurs */ 

	/* Méthodes */
	
	public int getPositionAlea(){ 
	/*  retourne une position enitère aléatoire dans le monde,
		méthode utilisée pour donner des valeurs aussi bien pour les abscisses que pour les ordonnées */
		return ((int)(Math.random() * taille)) ; 
	}
	
	public void ajouterItem(Item item){ // initialise aléatoirement l'abscisse et l'ordonnée de l'item et l'ajoute dans le monde
		item.setX(getPositionAlea()) ; 
		item.setY(getPositionAlea()) ; 
		listeItems.add(item) ;
		return ; 
	}
	
	public void supprimerItem(Item item){ // supprimer l'item du monde et met ses coordonnées à (-1, -1) 
		item.setX((-1)) ;
		item.setY((-1)) ;
		listeItems.remove(listeItems.indexOf(item)) ;
		return ;
	}
	
	public Item chercher(int x, int y){ // retorune le premier item trouvé aux coordonnées (x, y) ou null sinon 
		for(int i = 0 ; i < listeItems.size() ; i ++){
			if (((listeItems.get(i)).getX() == x) && ((listeItems.get(i)).getY() == y)){
				return (listeItems.get(i)) ; 
			}				
		}
		return null ;
	}
	
	public ArrayList<Item> getVoisins(Item item){
	
		return null ; // pour que cela compile
	}
	
	private static String getNomCourt(String nom){
		
		return new String() ; // pour que cela compile 
	}
	
	public void afficher(){
		
		return ;  // pour que cela compile
	}
}