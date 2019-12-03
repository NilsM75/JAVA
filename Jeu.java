public class Jeu {
	public static void main (String [] args){
		/* Test demandé */
		Pomme p1 = new Pomme() ;
		Sac sac1 = new Sac() ;
		Sac sac2 = new Sac(5) ;
		Pomme p2 = new Pomme() ; 
		sac2.ajouter(p1) ;
		sac2.ajouter(sac1) ;
		sac1.ajouter(p2) ; 
		System.out.println(sac2) ;
		/* // Test à décommenter
			//Test d'ajouter pour voir si cela enlève 
		return ; 
	}
}
