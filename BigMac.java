import java.awt.*;
import javax.swing.*;
public class BigMac extends Acc implements Mangeable, Macdo {

  /* Attributs */
  private String[] tab = new String[] {"Bien gras", "Delicieux", "Fat de ouf"} ;
  private double poids ; // poids de la pomme en kg
  private String adjectif ;
  private static int i = 0;


  /* Constructeurs */
  public BigMac() {
    super("BigMac") ; // Appel au cosntructeur Acc(categorie)
    adjectif = tab [i] ;
    poids = 0.6 ; //le poids du BigMac est toujours identique pcq chez Macdo c'est pro :)
    i++;
    if(i == (tab.length + 1)){
      i = 0;
    }
  }

  /* Méthodes */
  @Override
  public String toString(){
    return (""+super.toString()+" "+adjectif) ; // toString d'Acc
    // exemple : pomme No 1 0.26kg 3.9cm
  }

  public double getPoids(){ // retourne le poids de la pomme
    return poids ;
  }
  public void dessiner (Graphics g, Monde m){
    return ;
  }
}
