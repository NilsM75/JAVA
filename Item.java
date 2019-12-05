public abstract class Item { 

	/*  Le nom de l'accessoire est sa catégorie.
		Acc et Personnage héritent de cette classe */
	
	/* Attributs */
	private final String NOM ;
	private int x, y ;

	/* Constructeurs */ 

	public Item(String nom, int x, int y){
		this.NOM = nom ; 
		this.x = x ; 
		this.y = y ; 
	}
	
	public Item(String nom){
		this(nom, -1, -1) ; 
	}
	
	/* Méthodes */
	
	public int getX(){
		return x ; 
	}
	
	public int getY(){
		return y ; 
	}
	
	protected void setX(int x){
		this.x = x ; 
		return ; 
	}
	
	protected void setY(int y){
		this.y = y ; 
		return ; 
	}
	
	public String getNom() {
		return NOM ; 
	}
	
	public String toString(){
		return (NOM + "(" + x + ", " + y + ")") ;
	}
	
	public int distance (Item item) { // distance de Manhattan
		return (Math.abs(x - item.x) + Math.abs(y - item.y)) ; 
	}
}
