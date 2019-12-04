public class Jeu {
	public static void main (String [] args){
		/* Test demandé 1 */
		System.out.println("\nTest demandé 1") ; 
		Pomme p1 = new Pomme() ;
		Sac sac1 = new Sac() ;
		Sac sac2 = new Sac(5) ;
		Pomme p2 = new Pomme() ; 
		sac2.ajouter(p1) ;
		sac2.ajouter(sac1) ;
		sac1.ajouter(p2) ; 
		System.out.println(sac2) ;
		/* Test demandé 2 */
		Ststem.out.println("\nTest demandé 2") ; 
		Creature c1 = new Creature() ; 
		Pomme p11 = new Pomme() ; 
		Pomme p22 = new Pomme() ;
		Pomme p33 = new Pomme() ; 
		
		System.out.println("\n" + c1.courir()) ;

		c1.ajouterAcc(p1) ; 
		c1.ajouterAcc(p2) ; 
		c1.ajouterAcc(p3) ; 
		
		System.out.println("\n" + c1.courir()) ; 
		
		c1.manger() ; 
		System.out.println("\n" + c1.courir()) ; 
		
		return ; 
	}
}
