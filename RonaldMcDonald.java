import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class RonaldMcDonald extends Creature{
	/* Creation de la classe RonaldMcDonald qui est une créature qui court plus vite si celle-ci possède dans son sac un (ou plusieurs) bigMac */
	/* Attributs */
	private static int cptBigMac = 0;

	/* Constructeurs */
	public RonaldMcDonald (){
		super("RonaldMcDonald");
	}

	/* Methodes */
	@Override // je souhaite réécrire la methode getVitesse() de Creature
	public double getVitesse(){
	// retourne la vitesse à laquelle peut courir la créature
		Sac sacRonald = getLeSac(); // j'ai écris un accesseur getLeSac() dans Creature car leSac est private
		Acc temp;
		for(int i=0; i < sacRonald.size(); i++){ //size() est dans la classe Sac
			temp = sacRonald.obtenir(i); //obtenir() est dans la classe Sac
			if(temp.getCategorie() == "BigMac"){ //si le nom de l'accessoire est BigMac, j'incrémente mon compteur
				cptBigMac++;
			}
		}
		double v = (0.250d * super.getPoids()) - (sacRonald.getPoids()) + cptBigMac*2 ; // 1.0/4.0 = 0.250	//plus il mange de BigMac PLUS la vitesse est gde
		if (v < 0.0d){
			v = 0.0d ;
		}
		return v ;
	}

	public void dessiner(Graphics g, Monde m){

		int tc = m.getTailleCase();

		File Ronald;
		Image image;

		try {
			Ronald = new File("./images/Ronald.png");
			image = ImageIO.read(Ronald);
			g.drawImage(image, getX()*tc, getY()*tc, tc, tc, m); 
		} catch (IOException e){
		System.out.println(e.getMessage());
		}

	}
}
