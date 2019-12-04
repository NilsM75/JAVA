public class Creature extends Personnage{
  /*Attributs*/
  private Sac sacCreature ;

  /*Constructeurs*/
  public Creature (){
    super(Noms.getNom());
    sacCreature = new Sac(); //Le sac peut de la creature peut contenir entre 1 et 10 accessoires
    //this.nom = getNom();
  }

  /*Methodes*/
  public void ajouterAcc (Acc a){
    if((sacCreature.getPoids()+a.getPoids())<(0.5*super.poids)) {
      sacCreature.ajouter(a);
    } else { System.out.println("Trop lourd!"); }
  }

  public double getVitesse(){
    double v = (0.25*super.poids)-(sacCreature.getPoids());
    if (v < 0){
      return 0;
    }
    return v;
  }

  public void manger (){
    Acc tab [] = this.sacCreature.getSac();
    for(int i=0; i<tab.length; i++){
      if(tab[i] instanceof Mangeable){
        Acc temp = tab[i];
        manger((Mangeable) temp);
        tab[i] = null;
        System.out.println(super.nom+" a mangé "+temp.toString());
      }
    }
  }

  public void manger (Mangeable m){
    super.poids += m.getPoids();
  }

  public String courir (){
    String s = String.format("%.2f", this.getVitesse());
    return (super.toString()+" court à la vitesse "+s+"km/h avec le "+sacCreature);
  }
  /* affiche par exemple :
Bob1 51,0 kg court à vitesse 11,29 km/h avec sac No 4 1,46kg contient 2
accessoires sur 10 places
pomme No 5 0,38kg 4,5cm
pomme No 6 1,08kg 6,4cm */
}