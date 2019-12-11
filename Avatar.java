import java.util.Scanner ; 
import java.util.ArrayList ;

public class Avatar extends Personnage { // Avatar est un personnage qui a une liste d'amis et une liste d'accessoires
	
	/* Attributs */
	
	private ArrayList<Creature> listeAmis ; // liste d'amis (qui sont des créatues)
	private ArrayList<Acc> listeAcc ; // liste d'accessoires 
	private Monde monde ; // le monde dans lequel "évolue" l'Avatar 
	
	/* Constructeurs */
	
	public Avatar (){
		super(Noms.getNom()) ; // Appel au constructeur Personnage(nom)
		listeAmis = new ArrayList<Creature>() ; 
		listeAcc = new ArrayList<Acc>() ; 
		monde = new Monde() ; 
	}
	
	public Avatar (String nom, double poids){
		super(nom, poids) ; // Appel au constructeur Personnage(nom, poids) 
		listeAmis = new ArrayList<Creature>() ;
		listeAcc = new ArrayList<Acc>() ;
		monde = new Monde() ; 
	}
	
	public Avatar (String nom){
		super(nom) ; // Appel au constructeur Personnage(nom)
		listeAmis = new ArrayList<Creature>() ; 
		listeAcc = new ArrayList<Acc>() ; 
		monde = new Monde() ; 
	}

	public Avatar(Monde monde) {
		this() ;
		this.monde = monde ; 
	}
	
	public Avatar (String nom, double poids, Monde monde){
		this(nom, poids) ; 
		this.monde = monde ; 
	}
	
	public Avatar(String nom, Monde monde){
		this(nom) ; 
		this.monde = monde ; 
	}
	
	/* Méthodes */
	
	@Override
	public String toString(){ // retourne chaine de caractères donnant des informations sur l'avatar
		
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
			// court pendant 1 heure 
			System.out.println("Pendant 1 heure : ") ; 
			c.courir() ; 
			distance += c.getVitesse() ; 
		}
		
		return distance ;
	}
	
	public Creature getCreaturePlusRapide(){ // retourne la créature qui court le plus vite 
		Creature tempRapide = listeAmis.get(0) ;
		
		for(int i = 1 ; i < listeAmis.size() ; i ++){
			if(tempRapide.getVitesse() < (listeAmis.get(i)).getVitesse()) {
				tempRapide = listeAmis.get(i); 
			}
		}
		
		return tempRapide;
	}
	
	public int compterAccMangeable(){ // retourne le nombre d'accessoires mangeables 
		int cpt = 0 ; // compteur 
		for (int i = 0 ; i < listeAcc.size() ; i ++){
			if (listeAcc.get(i) instanceof Mangeable){
				cpt ++ ;
			}
		}
		return cpt ;
	}
	
	public void ramasser(Acc a){ 
	/*  L'Avatar ramasse l'acessoire a :
		L'accessoire a est supprmié du monde, a est mis dans la liste d'accessoires de l'avatar
		Un message du style "X ramasse A" est affiché
	*/
		listeAcc.add(a) ; 
		monde.supprimerItem(a) ;
		System.out.println(this.toString() + " ramasse " + a.toString()) ; 
		return ; 
	}
	
	public void rencontrerVoisins(){
	/*	Pour chaque voisin de l'avatar
		si le voisin est un accessoire, alors l'avatar ramasse l'accessoire;
		si le voisin est une créature, alors l'avatar rencontre la créature;
		si le voisin est un avatar, alors l'avatar salue (affiche une salutation) l'autre avatar 
		Attention : l'avatar ne doit pas se saluer lui même
	*/
		ArrayList<Item> tempVoisins = monde.getVoisins((Item) this) ; 
		Item tempVoisin ;
		for (int i = 0 ; i < tempVoisins.size() ; i++){
			tempVoisin = tempVoisins.get(i) ; 
			if (tempVoisin instanceof Acc){
				ramasser((Acc) tempVoisin) ; 
			}
			
			if (tempVoisin instanceof Creature){
				rencontrer((Creature) tempVoisin) ; 
			}
			
			if (tempVoisin instanceof Avatar) {
				if (tempVoisin == this){
					System.out.println(this.toString() + " salue " + tempVoisin.toString()) ;
				}
			}
		}
		
		return ; 
	}
	
	public void seDeplacer(){
	/*	Le programme demande à l'utilisateur de saisir dans le terminal une abscisse.
		Si l'abscisse n'est pas dans le monde, alors le programme demande à nouveau de saisir une abscisse
		jusqu'à ce que le nombre saisi soit correcte.
		Si l'abscisse est dans le monde, alors on fait de même avec l'ordonnée.
		L'utilisateur saisit toujours un nombre entier. 	
	*/
		
		System.out.println("### Déplacement de " + this.getNomPersonnage() + "###") ; 
	
		int valeurMax = (monde.getTaille() - 1) ; 
		int x, y ;
		Scanner scanner = new Scanner("") ; 
		
		do{
			System.out.println("Entrer une abscisse entre [0, " + valeurMax + "] : ") ; 
			x = scanner.nextInt() ;
		} while ((x < 0) && (x > valeurMax)) ;
		
		do{
			System.out.println("Entrer une ordonnée entre [0, " + valeurMax + "] : ") ; 
			y = scanner.nextInt() ; 
		} while ((y <0) && (y > valeurMax)) ; 
		
		System.out.print("Déplacement de " + this.getNomPersonnage() + " de (" + this.getX() + ", " + this.getY() + ") vers (") ; 
		this.setX(x) ; 
		this.setY(y) ;
		System.out.println(this.getX() + ", " + this.getY() + ")") ; 
		
		return ; 
		
	/* Exemple : 
		### Déplacement de Jake ###
		Entrer une abscisse entre [0, 4] : 
		20
		Entrer une abscisse entre [0, 4] : 
		3
		Entrer une ordonnée entre [0, 4] : 
		2
		Déplacement de Jake de (1, 1) vers (3, 2)
	*/
	}
}
