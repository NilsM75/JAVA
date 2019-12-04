import java.util.ArrayList;

public class Avatar extends Personnage { // Avatar est un personnage 
	/* Attributs */
	private ArrayList<Creature> listeAmis ; // liste d'amis
	private ArrayList<Acc> listeAcc ; // liste d'accessoires

	/* Constructeurs */
	public Avatar (String nom, double poids){
		super(nom, poids) ; // Appel au constructeur Personnage(nom, poids) 
		listeAmis = new ArrayList<Creature>() ;
		listeAcc = new ArrayList<Acc>() ;
	}

	/* Méthodes */
	@Override
	public String toString(){
		// String s = String.format("%.2f", poids); (?)
		
		String temp1, temp2 ; 
		
		if(listeAmis.size() > 1){
			temp1 = new String (" amis ") ;
		}else{
			temp1 = new String (" ami ") ; 
		}
		
		if(listeAcc.size() > 1){
			temp2 = new String (" accessoires") ; 
		}else{
			temp2 = new String (" accessoire") ; 
		}
		
		return (super.toString() + " " + listeAmis.size() + temp1 + listeAcc.size() + temp2) ;
	}
	
	public boolean estAmi (Creature c){
		for(int i = 0 ; i < listeAmis.size() ; i ++){
			if(listeAmis.get(i) == c){
				return true ;
			}
		}
		return false ;
	}
	
	public void devenirAmi (Creature c){
		if (estAmi(c)){
			return ; 
		}
		
		listeAmis.add(c) ;
		System.out.println(this.toString() + "devient ami avec " + c.toString()) ; 
		
		return ; 
	}
	
	public void perdreAmi (Creature c){
		if (!estAmi(c)){
			return ; 
		}
		
		listeAmis.remove(c) ; 
		System.out.println(this.toString() + "a perdu " + c.toString()) ; 
		
		return ; 
	}
	
	public void rencontrer (Creature c){
		/*  Lorsque l'avatar rencontre une créature, il lui offre le premier accessoire
			qu'il a dans la liste d'accessoires et la créature ajoute cet accessoire dans son
			sac. 
			Si la créature n'est pas amie avec lui et si l'accessoire offert a un poids supérieur
			à 0.5 kg alors la créature devient amie avec lui. Si, par contre, il n'a pas d'accessoires à offrir
			à la créature alors si cette créature était une amie, il perd son amitié. */
		
		int i = 0 ; // compteur
		Acc a = listeAcc.get(0) ; // accessoire temporaire
		// On cherche le premier accessoire dans la liste 
		while (a == null){
			if (i == listeAcc.size()){ // pas d'acccessoire à offrir
				if (estAmi(c)){ 
					perdreAmi(c) ;
				}
				return ; 
			}
			
			a = listeAcc.get(i) ; 
			i ++ ; 
		}
		// Si  on est là c'est qu'on a le premier accesseoire a et ne sont pas amis 
		if (a.getPoids() > 0.5) {
			devenirAmi(c) ;
			c.ajouterAcc(a) ; 
		}
		return ; 
	}
	
	
	public double course (){ // fait manger puis courir pendant 1 heure chaque créature l'une après l'autre et retourne la distance totale parcourue
		Creature c ;
		double distance = 0.0 ; //distance en km
		for(int i = 0 ; i < listeAmis.size() ; i ++){
			c = listeAmis.get(i) ;
			c.manger() ; // mange 
			c.courir() ; // court pendant 1 heure
			distance += c.getVitesse() ; 
		}
		
		return distance ;
	}
	
	public Creature getCreaturePlusRapide(){ // créature qui court le plus vite 
		Creature tmpRapide = listeAmis.get(0) ;
		
		for(int i = 1 ; i < listeAmis.size() ; i ++){
			if(tmpRapide.getVitesse() < listeAmis.get(i).getVitesse()) {
				tmpRapide = listeAmis.get(i);
			}
		}
		
		return tmpRapide;
	}
	
	public int compterAccMangeable(){ // retourne le nombre d'accessoires mangeables 
		int cpt = 0 ;
		for (Acc a : listeAcc){
			if (a instanceof Mangeable){
				cpt ++ ;
			}
		}
		return cpt ;
	}

}
