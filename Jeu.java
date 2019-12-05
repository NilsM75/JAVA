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
		Creature c1 = new Creature() ;  // création d'une créature c1
		System.out.println("La créature est crée :\n" + c1 + "\n") ; // affichage de la créature c1
		System.out.println("La créature court \n" + c1.courir() + "\n") ; // La créature c1 court 
		// On crée 3 pommes p11, p22 et p33 pour les ajouter dans le sac principal de la créature
		Pomme p11 = new Pomme() ; 
		Pomme p22 = new Pomme() ;
		Pomme p33 = new Pomme() ; 
		c1.ajouterAcc(p11) ; 
		c1.ajouterAcc(p22) ; 
		c1.ajouterAcc(p33) ; 
		// Et la créature court, de nouveau, mais avec 3 pommes dans son sac :
		System.out.println("La créature court encore une fois mais avec 3 pommes dans son sac \n" + c1.courir() + "\n") ; 
		// Maintenant, la créature va manger ses pommes 
		c1.manger() ; 
		System.out.println("La créature court après avoir manger toutes ses pommes \n" + c1.courir()) ; 
		
		return ; 
	}
}
