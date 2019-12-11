public class BigMac extends Acc implements Mangeable {

  /* Attributs */
  private String[] tab = new String[] {"Bien gras", "Delicieux", "Fat de ouf"} ;
  private double poids ; // poids de la pomme en kg
  private String adjectif ;


  /* Constructeurs */
  public BigMac() {
    super("BigMac") ; // Appel au cosntructeur Acc(categorie)
    adjectif = tab [((int)Math.random()*3+0)] ;
    poids = Math.random() ;
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
}
