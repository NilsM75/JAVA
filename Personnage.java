public abstract class Personnage { //abstract permet d'empecher la creation d'instance de cette classe
	/*Attributs*/
	private String nom;
	protected double poids;

	/*Constructeurs*/
	public Personnage(String nom, double poids){
		this.nom = nom;
		this.poids = poids;
	}
	public Personnage(String nom){
		this.nom = nom;
		this.poids = ((Math.random()*100)+30);
	}

	/*Methodes*/
	protected void addPoids(double p){
		if (p>0) {
			poids+=p;
		}
	}
	public String toString(){
		return (""+nom+" "+poids+" kg");
	}
}
