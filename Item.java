public abstract class Item { 

	/* Acc et Personnage héritent de cette classe (Item soit Acc soit Personnage en fait) */
	
	/* Attributs */
	private final String nom ; // nom de l'item, qui est en fait, sa catégorie
	// les coordonnées de l'item ^
	private int x ; // abscisse entière 
	private int y ; // ordonnée entière 

	/* Constructeurs */ 

	public Item(String nom, int x, int y){
		this.nom = nom ; 
		this.x = x ; 
		this.y = y ; 
	}
	
	public Item(String nom){
		this(nom, -1, -1) ; 
	}
	
	/* Méthodes */
	
	public int getX(){ // retourne x 
		return x ; 
	}
	
	public int getY(){ // retourne y 
		return y ; 
	}
	
	protected void setX(int x){ // modifie x 
		this.x = x ; 
		return ; 
	}
	
	protected void setY(int y){ // modifie y 
		this.y = y ; 
		return ; 
	}
	
	public String getnom() { // retourne nom 
		return nom ; 
	}
	
	@Override
	public String toString(){ // retourne chaine de caractères donnant des informations sur l'item  
		return (nom + "(" + x + ", " + y + ")") ;
	}
	
	public int distance (Item item) { // retorune distance distance de Manhattan
		return (Math.abs(x - item.x) + Math.abs(y - item.y)) ; 
	}
}
