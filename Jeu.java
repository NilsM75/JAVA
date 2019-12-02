public class Jeu {
	public static void main (String [] args){
		/* Test demandé */
		Pomme p1 = new Pomme() ;
		Sac sac1 = new Sac() ;
		Sac sac2 = new Sac(5) ;
		
		sac2.ajouter(p1) ;
		sac2.ajouter(sac1) ;
		sac1.ajouter(p1) ; 
		System.out.println(sac2) ;
		/* Tests en plus */
		
		return ; 
	}
}
