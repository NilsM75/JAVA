public class Creature extends Personnage{
	/* Attributs */
	private Sac sacCreature ; // sac de la créature

	/* Constructeurs */
	public Creature (){
		super(Noms.getNom()) ;
		sacCreature = new Sac() ; // Le sac de la creature peut contenir entre 1 et 10 accessoires (aléatoirement)
	}

	/* Méthodes */
	public void ajouterAcc (Acc a){ 
	// ajoute un accessoire dans le sac de la créature si le poids du sac plus le poids de l'accessoire est inférieur à la moitié du poids de la créature, affiche "Trop Lourd" sinon.
		if( (sacCreature.getPoids() + a.getPoids()) < (0.5 * super.poids) ) {
			sacCreature.ajouter(a) ;
		}else{
			System.out.println("Trop lourd") ;
		}
	}

	public double getVitesse(){
	// retourne la vitesse à laquelle peut courir la créature 
		double v = (0.25 * super.poids) - (sacCreature.getPoids()) ;
		if (v < 0.0){
			v = 0.0 ;
		}
		return v ;
	}

	public void manger (){ // à vérifier ? 
	/*  La créature mange les accessoires mangeables du sac ce qui augmente son poids.
		Pour cela, on sort un par un les accessoires mangeables du sac. Si l'accessoire
		est mangeable, alors on ajoute le poids de l'accessoire au poids de la créature,
		sinon on remet l'accessoire dans le sac.
		Si l'accessoire est un sac, la créature ne mange pas le contenu de ce sac.*/	
		Acc tab [] = this.sacCreature.getSac() ;
		for(int i = 0 ; i < tab.length ; i ++){
			if(tab[i] instanceof Mangeable){
				Acc temp = tab[i] ;
				manger((Mangeable) temp) ;
				tab[i] = null ;
				System.out.println(super.nom + " a mangé " + temp.toString()) ;
			}
		}
	}

	public void manger (Mangeable m){ // ajoute le poids du mangeable au poids de la créature
		super.poids += m.getPoids() ;
		return ; 
	}

	public String courir (){
		return (super.toString() + " court à la vitesse " + String.format("%.2f", this.getVitesse()) + "km/h avec le " + sacCreature) ;
	}
	
	/* Exemple :
		Bob1 51,0 kg court à vitesse 11,29 km/h avec sac No 4 1,46kg contient 2
		accessoires sur 10 places
			pomme No 5 0,38kg 4,5cm
			pomme No 6 1,08kg 6,4cm 
	*/
}