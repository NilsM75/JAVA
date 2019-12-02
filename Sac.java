public class Sac extends Acc{
  private Acc[] tab;

  /* Constructeurs */
  public Sac (int n){
    super("Sac");
    tab = new Acc[n]; //On crée un sac pouvant contenir au max n accessoires
  }
  public Sac (){
    super("Sac");
    tab = new Acc[(int)(Math.random()*10)+1]; //Sac peut contenir entre [1;10] accessoires
  }

  /* Methodes */
  public int nbElementSac(){
    int cpt=0;
    for(Acc val :tab){
      if(val != null){
        cpt++;
      }
    }
    return cpt;
  }
  public double getPoids(){
    double poids = 0;
    for(int i=0;i<nbElementSac();i++){
      poids += tab[i].getPoids();
    }
    return poids;
  }

  public int size(){
    return (tab.length);
  }
  public void ajouter(Acc a){
    for (Acc val : tab){
      if (val==null){
        val = a;
        break;
      }
      else{ System.out.println("Pas de place dans le sac"); }
    }
  }
  public Acc obtenir(int i){
    if (tab[i] != null){
      return tab[i];
    } else{
      return null;
    }
  }
  public String toString(){
    //return ("Sac No %d %2.fkg contient %d accessoires sur %d places", numero, getPoids(), super.cpt);
    return ("Sac No "+numero+" "+getPoids()+"kg contient "+super.cpt+" places");
  }
}
