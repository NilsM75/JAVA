public abstract class Noms{
  /*Attributs*/
  private String tabNoms [];
  private static int cpt = 0; //compte le nombre de fois que le tableau est parcouru
  private static int position = 0; //donne la position courante dans notre tableau

  /*Constructeurs*/
  public Noms(){
    String tabNoms [] = {"Jean","Petit","QuiDanse"};
  }
  /*Methodes*/
  public String getNom(){
    if(cpt > 0){
      return (""+tabNoms[position++]+cpt);
    }
    if(position == tabNoms.length){
      cpt++;
      return (""+tabNoms[position++]);
    }
    return (""+tabNoms[position++]);
  }


}
