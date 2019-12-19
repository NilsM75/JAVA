import java.awt.*;
import javax.swing.*;
public class RonaldMcDonald extends Creature{
	/* Creation de la classe RonaldMcDonald qui est une créature qui court plus vite si celle-ci possède dans son sac un (ou plusieurs) bigMac
		 Si celle-ci possède un élément mangeable de type légumes, elle court moins vite */
	/* Attributs */
	private static int cptBigMac = 0;
	//private static cptCarotte = 0;
	private static double tempV = 0;

	/* Constructeurs */
	public RonaldMcDonald (){
		super("RonaldMcDonald");
	}

	/* Methodes */
	@Override // je souhaite réécrire la methode getVitesse() de Creature
	public double getVitesse(){
	// retourne la vitesse à laquelle peut courir la créature
		Sac sacRonald = super.getLeSac(); // j'ai écris un accesseur getLeSac() dans Creature car leSac est private
		System.out.println("je commence") ; 
		for(int i=0; i < sacRonald.size(); i++){ //size() est dans la classe Sac
			System.out.println("je suis dans le sac") ;
			if(sacRonald.obtenir(i) != null){ System.out.println("j ai un truc dans le sac") ;
				if((sacRonald.obtenir(i)) instanceof BigMac){ //si le nom de l'accessoire est BigMac, j'incrémente mon compteur
					cptBigMac++;
					System.out.println("Youhou je vais pouvoir courir plus vite!");
				}
			}
		}
		System.out.println("je finis") ;
		double v = (0.250d * super.getPoids()) - (sacRonald.getPoids()) + cptBigMac*2 ; // 1.0/4.0 = 0.250	//plus il mange de BigMac PLUS la vitesse est gde
		if(tempV != 0){
			tempV = v;
			System.out.println("vitesse changee");
		}
		if(v == tempV){
			System.out.println("Erreur la vitesse de ronald n'a pas été augmentéé");
		}
		if (v < 0.0d){
			v = 0.0d ;
		}
		return v ;
	}
}
