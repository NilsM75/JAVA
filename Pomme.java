public class Pomme extends Acc implements Mangeable {
  private double poids; //poids de la pomme en kg
  private double rayon; //rayon de la pomme en cm

  public Pomme (){
    super("Pomme");
    this.rayon = (Math.random()*4) + 3; //rayon = [3;7[ cm
    this.poids = (((4/3000)*Math.PI)*rayon*rayon*rayon);
  }

  public String toString(){
    String s = String.format("%.2f",poids);
    return ("Pomme No "+super.cpt+" "+s+"kg "+rayon+"cm");
  }

  public double getPoids(){
    return poids;
  }

  /*
  private double rayon;


  public Pomme(){
    super("Pomme");
    rayon=Math.random()* 4 + 3;
  }

  public double getPoids(){
    return (4* Math.PI * (rayon*rayon*rayon))/3000;
  }


  public String toString(){
    return super.toString()+String.format("   %.2f",rayon)+"cm\n";
  } */
}
