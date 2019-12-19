import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO ; 
import java.io.* ;

public class Creature extends Personnage{ // créature est un personnage qui a un sac

	/* Attributs */
	private Sac leSac ; // sac de la créature

	/* Constructeurs */
	public Creature (){
		super(Noms.getNom()) ; // appel au constructeur Personnage(Noms.getNom())
		leSac = new Sac() ; // Le sac de la creature peut contenir entre 1 et 10 accessoires (aléatoirement)
	}

	public Creature(String nom){
		super(nom) ;
		leSac = new Sac() ;
	}

	/* Méthodes */
	public void ajouterAcc (Acc a){
	/* 	Ajoute un accessoire dans le sac de la créature si le poids du sac plus le poids de l'accessoire est inférieur à la moitié du poids de la créature
		affiche "Trop Lourd" sinon. */
		if( (leSac.getPoids() + a.getPoids()) < (0.50d * super.getPoids()) ){ // 1.0/2.0 = 0.50
			leSac.ajouter(a) ;
		}else{
			System.out.println("Trop lourd") ;
		}
	}

	public double getVitesse(){
	// retourne la vitesse à laquelle peut courir la créature
		double v = (0.250d * super.getPoids()) - (leSac.getPoids()) ; // 1.0/4.0 = 0.250
		if (v < 0.0d){
			v = 0.0d ;
		}
		return v ;
	}

	public void manger (){
	/*  Voici ce que l'on nous propose de faire :
			La créature mange les accessoires mangeables du sac ce qui augmente son poids.
			Pour cela, on sort un par un les accessoires mangeables du sac. Si l'accessoire
			est mangeable, alors on ajoute le poids de l'accessoire au poids de la créature,
			sinon on remet l'accessoire dans le sac.
			Si l'accessoire est un sac, la créature ne mange pas le contenu de ce sac.
		Nous avons proposé une solution moins complexe pour faire exactement la même chose.*/
		Acc tab [] = leSac.getTab() ;
		for(int i = 0 ; i < tab.length ; i ++){
			if(tab[i] instanceof Mangeable){
				Acc temp = tab[i] ;
				manger((Mangeable) temp) ;
				tab[i] = null ;
				System.out.println(super.getNomPersonnage() + " a mangé " + temp.toString()) ;
			}
		}
	}

	public void manger (Mangeable m){ // ajoute le poids du mangeable au poids de la créature
		super.addPoids(m.getPoids()) ;
		return ;
	}

	public void courir (){ // affiche une chaine de caractère du même style que l'exemple plus bas
		System.out.println(this.toString() + " court à vitesse " + String.format("%.2f", this.getVitesse()) + "km/h avec " + leSac.toString()) ;
		return ;
	}

	/* Exemple :
		Bob1 51,0 kg court à vitesse 11,29 km/h avec sac No 4 1,46kg contient 2
		accessoires sur 10 places
			pomme No 5 0,38kg 4,5cm
			pomme No 6 1,08kg 6,4cm
	*/

	@Override
	public String toString(){ // retourne chaine de caractères donnant des informations sur la créature
		return (super.toString()) ;
	}

	public Sac getLeSac(){
		return leSac;
	}
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		File creature;
		Image image;
		if (cptC == 0) {
			try {
				creature = new File("./images/creature.png");
				image = ImageIO.read(creature);
				g.drawImage(image, getX()*tc, getY()*tc, tc/2, tc/2, m); 
			} catch (IOException e){
				System.out.println(e.getMessage());
			}
		} else {
			try {
				creature = new File("./images/creature1.png");
				image = ImageIO.read(creature);
				g.drawImage(image, getX()*tc, getY()*tc, tc/2, tc/2, m); 
			} catch (IOException e){
				System.out.println(e.getMessage());
			}
		}
		cptC ++ ;
		return ; 
	}
}
