public abstract class Acc{
  protected static int cpt = 0; //compte le nb d'accessoires
  public final int numero; //numero de l'accessoire
  private String categorie; //categorie de l'accessoire ex: sac, pomme

  /* Constructeurs */
  public Acc (String categorie){
    this.categorie = categorie;
    numero = cpt++;
  }

  /* Methodes */
  public abstract double getPoids();

  public String toString (){
    String s = String.format("%s No %d %.2fkg", categorie, numero, getPoids());
    return s;
    //return (""+categorie+" No"+numero+" "+getPoids()+"kg");
  }
}
