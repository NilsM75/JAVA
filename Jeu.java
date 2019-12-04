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
		System.out.println("\nTest demandé 2") ;
		/* 
			Ne marche pas 
		*/
		Creature c1 = new Creature() ; 
		System.out.println(c1) ; 
		Pomme p11 = new Pomme() ; 
		Pomme p22 = new Pomme() ;
		Pomme p33 = new Pomme() ; 
		
		System.out.println("\n" + c1.courir()) ;

		c1.ajouterAcc(p11) ; 
		c1.ajouterAcc(p22) ; 
		c1.ajouterAcc(p33) ; 
		
		System.out.println("\n" + c1.courir()) ; 
		
		c1.manger() ; 
		System.out.println("\n" + c1.courir()) ; 
		
		return ; 
	}
}
