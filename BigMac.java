import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO ; 
import java.io.* ;

public class BigMac extends Acc implements Mangeable {

  /* Attributs */
  private static final String[] TAB = new String[] {"Bien gras", "Delicieux", "Fat de ouf"} ;
  private static int pointeur = (-1) ; 
  private double poids ; // poids de la pomme en kg
  

  /* Constructeurs */
  public BigMac() {
    super("BigMac") ; // Appel au cosntructeur Acc(categorie)
	poids = Math.random() ; // Considère de base qu'il est Délicieux
	
	if (pointeur == 0){ // Bien gras
		poids += 1.0 ; 
	}
	
	if (pointeur == 2){ // Fat de ouf 
		poids += 2.0 ; 
	}
  }

  /* Méthodes */
  @Override
  public String toString(){
	if (pointeur == 2){
		pointeur = 0 ; 
	} else {
		pointeur ++ ; 
	}
    return ("BigMac : " + super.toString() + " " + TAB[pointeur]) ; // toString d'Acc

  }

  public double getPoids(){ // retourne le poids du bigMac
    return poids ;
  }
  
  public void dessiner(Graphics g, Monde m) {

	int tc = m.getTailleCase();
	int tc2 = tc/2;

	File bm;
	Image image;

	try {
		bm = new File("./images/bm.png");
		image = ImageIO.read(bm);
		g.drawImage(image, getX()*tc, getY()*tc+tc2, tc, tc-tc2, m); 
	    } catch (IOException e){
		System.out.println(e.getMessage());
	      }
  }

}
