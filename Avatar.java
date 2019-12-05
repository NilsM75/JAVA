import java.util.ArrayList ;

public class Avatar extends Personnage { // Avatar est un personnage qui a une liste d'amis et une liste d'accessoires
	
	/* Attributs */
	
	private ArrayList<Creature> listeAmis ; // liste d'amis (qui sont des créatues)
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
		
		// ami (s) / accessoire (s) 
		
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
		/* Exemple : 
			Jake 79.5 kg 1 ami 3 accessoires 
		*/
	}
	
	public boolean estAmi (Creature c){ // retourne True si c est une amie, False sinon
		for(int i = 0 ; i < listeAmis.size() ; i ++){
			if((listeAmis.get(i)).equals(c)){
				return true ;
			}
		}
		return false ;
	}
	
	public void devenirAmi (Creature c){ // fait devenir ami l'avatar avec la créature c (s'ils ne sont pas amis)
		if (estAmi(c)){
			return ; 
		}
		
		listeAmis.add(c) ;
		System.out.println(this.toString() + "devient ami avec " + c.toString()) ; 
		
		return ; 
	}
	
	public void perdreAmi (Creature c){ // fait perdre l'avatar son ami c (s'ils sont amis)
		if (!estAmi(c)){
			return ; 
		}
		
		listeAmis.remove(listeAmis.indexOf(c)) ; 
		System.out.println(this.toString() + "a rompu son lien d'amitié avec " + c.toString()) ; 
		
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
		Acc a ; 
		// On cherche le premier accessoire dans la liste 
		do{
			if (i == listeAcc.size()){ // pas d'acccessoire à offrir
				if (estAmi(c)){ 
					perdreAmi(c) ;
				}
				return ; 
			}
			
			a = listeAcc.get(i) ; 
			i ++ ; 
		}while (a == null) ; 
		
		// Si  on est là c'est qu'on a le premier accesseoire a et ils ne sont pas amis 
		if (a.getPoids() > 0.5) {
			devenirAmi(c) ;
			c.ajouterAcc(a) ; 
			listeAcc.remove(listeAcc.indexOf(a)) ; 
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
	
	public Creature getCreaturePlusRapide(){ // retourne la créature qui court le plus vite 
		Creature tmpRapide = listeAmis.get(0) ;
		
		for(int i = 1 ; i < listeAmis.size() ; i ++){
			if(tmpRapide.getVitesse() < (listeAmis.get(i)).getVitesse()) {
				tmpRapide = listeAmis.get(i); 
			}
		}
		
		return tmpRapide;
	}
	
	public int compterAccMangeable(){ // retourne le nombre d'accessoires mangeables 
		int cpt = 0 ; // compteur 
		for (int i = 0 ; i < listeAcc.size() ; i ++){
			if (listeAcc.get(0) instanceof Mangeable){
				cpt ++ ;
			}
		}
		return cpt ;
	}

}
