public class Jeu {
	public static void main (String [] args){ // Notre main de Jeu
		System.out.println("Début du main de Jeu") ; 
		
		/* Test demandé numéro 1 */
		System.out.println("\nTest demandé numéro 1") ; 
		Pomme p1 = new Pomme() ;
		System.out.println("Pomme p1 crée :\t" + p1) ; 
		Sac sac1 = new Sac() ;
		System.out.println("Sac sac1 crée :\t" + sac1) ; 
		Sac sac2 = new Sac(5) ;
		System.out.println("Sac sac2 crée :\t" + sac2) ;
		Pomme p2 = new Pomme() ; 
		System.out.println("Pomme p2 crée :\t" + p2) ; 
		System.out.println("Ajout de p1 dans sac2") ; 
		sac2.ajouter(p1) ;
		System.out.println("Ajout de sac1 dans sac2") ; 
		sac2.ajouter(sac1) ;
		System.out.println("Ajout de p2 dans sac1") ; 
		sac1.ajouter(p2) ; 
		System.out.println("Voici notre sac2 :\n" + sac2) ;
		
		/* Test demandé 2 */
		System.out.println("\nTest demandé numéro 2") ;
		
		Creature c1 = new Creature() ;  // création d'une créature c1
		System.out.println("La créature est crée :\n" + c1 + "\n") ; // affichage de la créature c1
		// La créature c1 court 
		System.out.println("La créature court \n") ; 
		c1.courir() ;
		System.out.println() ; 
		
		// On crée 3 pommes p11, p22 et p33 pour les ajouter dans le sac principal de la créature
		Pomme p11 = new Pomme() ; 
		Pomme p22 = new Pomme() ;
		Pomme p33 = new Pomme() ; 
		c1.ajouterAcc(p11) ; 
		c1.ajouterAcc(p22) ; 
		c1.ajouterAcc(p33) ; 
		
		// Et la créature court, de nouveau, mais avec 3 pommes dans son sac :
		System.out.println("La créature court encore une fois mais avec 3 pommes dans son sac \n") ; 
		c1.courir() ;
		System.out.println() ;
		
		// Maintenant, la créature va manger toutes les pommes dans son sac 
		c1.manger() ;

		// Maintenant, la créature va courir encore une fois après avoir mangé ses pommes 
		System.out.println("La créature court après avoir manger toutes ses pommes \n") ; 
		c1.courir() ; 
		
		/* Test demandé 3 */
		System.out.println("\nTest demandé numéro 3") ; 
		Monde m = new Monde(5) ; // création d'un Monde de taille 5 
		Creature cm1 = new Creature() ; 
		System.out.println(cm1) ; 
		Creature cm2 = new Creature() ; 
		System.out.println(cm2) ; 
		Creature cm3 = new Creature() ; 
		System.out.println(cm3) ; 
		m.ajouterItem(cm1) ;
		m.ajouterItem(cm2) ; 
		m.ajouterItem(cm3) ; 
		m.ajouterItem(new Pomme()) ; 
		m.ajouterItem(new Pomme()) ; 
		m.ajouterItem(new Pomme()) ; 
		m.ajouterItem(new Avatar()) ; 
		m.ajouterItem(new Avatar()) ; 
		m.ajouterItem(new Avatar()) ;
		m.afficher() ; 
		
		System.out.println("\nFin du main de Jeu") ; 
		return ; 
	}
}
