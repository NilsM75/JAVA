public class Creature extends Personnage { // Creature est un personnage qui a un sac 
	private Sac leSac ; // sac du personnage pouvant contenir entre 1 et 10 accessoires
	private String nom ; // nom du personnage 
	
	public Creature(){
		leSac = new Sac(10) ;
		nom = getNom() ; 
	}
	
	
	public double getVitesse(){
		return (1.0 / 4.0) * vitesse - getPoids ;
	}
	
}