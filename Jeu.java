public class Jeu{
  public static void main (String [] args){
    Sac sac = new Sac(5);
    sac.ajouter(new Pomme());
    sac.ajouter(new Pomme());
    System.out.println(sac);
    /*for(Acc val: tab){
      System.out.println(val);
    } */
  }
}
