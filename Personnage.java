public class Personnage extends Item { // abstract permet d'empecher la creation directe d'instance de cette classe
	
	/* Attributs */
	
	private String nom ; // nom du personnage
	private double poids ; // poids du personnage

	/* Constructeurs */
	
	private Personnage() { }
	private Personnage(double poids) { }
	
	public Personnage(String nom, double poids){
		this.nom = nom ;
		this.poids = poids ;
	}
	
	public Personnage(String nom){
		this.nom = nom ;
		poids = (30.0 + (Math.random() * 100.0)) ; // poids dans [30;130[
	}

	/* Méthodes */
	
	protected void addPoids(double p){ // ajoute du poids au personnage si p > 0
		if (p > 0.0) {
			poids += p ; 
		}
		return ; 
	}
	
	public String toString(){
		return String.format("%s %.1f kg", nom, poids) ;
		// exemple : Tulip 77.3 kg 
	}
	
	public String getNomPersonnage(){
		return nom ; 
	}
	
	protected double getPoids(){
		return poids ; 
	}
	
	private void setNom(String nom){
		this.nom = nom ;
		return ;
	}
	
	private void setPoids(double poids){
		this.poids = poids ; 
		return ; 
	}
	
}
