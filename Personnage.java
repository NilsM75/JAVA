public abstract class Personnage { // abstract permet d'empecher la creation directe d'instance de cette classe
	
	/* Attributs */
	
	private String nom ; // nom du personnage
	private double poids ; // poids du personnage

	/* Constructeurs */
	
	private Personnage() { }
	
	public Personnage(String nom, double poids){
		this.nom = nom ;
		this.poids = poids ;
	}
	
	public Personnage(String nom){
		this.nom = nom ;
		poids = (30.0d + (Math.random() * 100.0d)) ; // poids dans [30;130[
	}

	/* Méthodes */
	
	protected void addPoids(double p){ // ajoute du poids au personnage si p > 0
		if (p > 0.0d) {
			poids += p ; 
		}
		return ; 
	}
	
	public String toString(){
		return String.format("%s %.1f kg", nom, poids) ;
		// exemple : Tulipo 77.3 kg 
	}
	
	public String getNomPersonnage(){ // retourne le nom du personnage 
		return nom ; 
	}
	
	protected double getPoids(){ // retourne le poids du personnage, que pour les classes filles 
		return poids ; 
	}
	
	private void setNom(String nom){ // modifie le nom du personnage
		this.nom = nom ;
		return ;
	}
	
	private void setPoids(double poids){ // modifie le poids du personnage
		this.poids = poids ; 
		return ; 
	}
	
}
