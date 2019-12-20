import java.awt.*;
import javax.swing.*;
public class RonaldMcDonald extends Creature{
	/* Creation de la classe RonaldMcDonald qui est une créature qui court plus vite si celle-ci possède dans son sac un (ou plusieurs) bigMac
		 Si celle-ci possède un élément mangeable de type légumes, elle court moins vite */
	/* Attributs */
	private static double tempV = 0;

	/* Constructeurs */
	public RonaldMcDonald (){
		super("RonaldMcDonald");
	}

	/* Methodes */
	@Override // je souhaite réécrire la methode getVitesse() de Creature
	public double getVitesse(){
	// retourne la vitesse à laquelle peut courir la créature

		System.out.println("la vitesse non modifiee de la creature est: "+super.getVitesse());
		System.out.println("nombre de bigmac mangés: "+super.getCptBigMac());
		double v = super.getVitesse() + super.getCptBigMac()*2 ;	//plus il mange de BigMac PLUS la vitesse est gde
		System.out.println("la vitesse MODIFIEE de la creature est: "+v);

		if (v < 0.0d){
			v = 0.0d ;
		}
		return v ;
	}
}
