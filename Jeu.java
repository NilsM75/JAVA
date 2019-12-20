import java.awt.* ;
import javax.swing.* ;
import java.util.Scanner ; 
import javax.imageio.ImageIO;
import java.io.*;

public class Jeu {
	
	/* Constantes pour qu'on puisse les modifier à notre guise ici, pour plus de tests */
	private static final int TAILLE_CASE = 80 ;
	private static final int NB_CASES = 10 ;
	private static final int NB_CREATURES = 8 ;
	
	public static void main (String [] args){ // Notre main de Jeu
	
		//Création fenêtre graphique et ses caractéristiques
		JFrame f = new JFrame();

		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Création du monde en mode panneau 
		Monde m = new Monde(NB_CASES, TAILLE_CASE);

		f.setContentPane(m); // le monde est ajouté à la fenêtre
		f.pack(); // la dite fenêtre est adaptée au panneau 
		f.setVisible(true); // visible OK 
		
		System.out.println("@\t|Créatures et Avatars|\t@");

		m.repaint(); 

		/* Tours de jeu. */
		//m.repaint() à chaque tour


		System.exit(0);
		
		return ; 
	} // en dessous, il y a les anciens tests demandés, à mettre dans le main 
	
		/*
		
		
		//Décommenter pour test 
		
		// Partie 4 - Le jeu et ses améliorations

		// Q 15

		System.out.println("\n*************************** Début du main du Jeu ***************************\n") ;

		// Création du monde
		Monde monde = new Monde() ;
		//System.out.println("Voici notre monde :\n" + monde.toString()) ;

		// Populons ce monde
		// Ajout de 6 créatures dans le monde **************************************
		Creature creature1 = new Creature() ;
		monde.ajouterItem(creature1) ;
		//System.out.println("Créature1 ajoutée :\n" + creature1.toString()) ;
		Creature creature2 = new Creature() ;
		monde.ajouterItem(creature2) ;
		//System.out.println("Créature2 ajoutée :\n" + creature2.toString()) ;
		Creature creature3 = new Creature() ;
		monde.ajouterItem(creature3) ;
		//System.out.println("Créature3 ajoutée :\n" + creature3.toString()) ;
		Creature creature4 = new Creature() ;
		monde.ajouterItem(creature4) ;
		//System.out.println("Créature4 ajoutée :\n" + creature4.toString()) ;
		Creature creature5 = new Creature() ;
		monde.ajouterItem(creature5) ;
		//System.out.println("Créature5 ajoutée :\n" + creature5.toString()) ;
		Creature creature6 = new Creature() ;
		monde.ajouterItem(creature6) ;
		//System.out.println("Créature6 ajoutée :\n" + creature6.toString()) ;
		RonaldMcDonald ronald1 = new RonaldMcDonald();
		monde.ajouterItem(ronald1) ;

		// Ajout de 3 pommes dans le monde **************************************
		Pomme p1 = new Pomme() ;
		monde.ajouterItem(p1) ;
		//System.out.println("Pomme1 ajoutée :\n" + p1.toString()) ;
		Pomme p2 = new Pomme() ;
		monde.ajouterItem(p2) ;
		//System.out.println("Pomme2 ajoutée :\n" + p2.toString()) ;
		Pomme p3 = new Pomme() ;
		monde.ajouterItem(p3) ;
		//System.out.println("Pomme3 ajoutée :\n" + p3.toString()) ;

		// Ajout de BigMac dans le Monde **************************************
		BigMac b1 = new BigMac();
		monde.ajouterItem(b1);
		BigMac b2 = new BigMac();
		monde.ajouterItem(b2);
		BigMac b3 = new BigMac();
		monde.ajouterItem(b3);

		// Ajout de 3 sacs dans le monde **************************************
		Sac sac1 = new Sac() ;
		monde.ajouterItem(sac1) ;
		//System.out.println("sac1 ajouté :\n" + sac1.toString()) ;
		Sac sac2 = new Sac() ;
		monde.ajouterItem(sac2) ;
		//System.out.println("sac2 ajouté :\n" + sac2.toString()) ;
		Sac sac3 = new Sac() ;
		monde.ajouterItem(sac3) ;
		//System.out.println("sac3 ajouté :\n" + sac3.toString()) ;

		// Monde généré avec succès, affichage du monde
		//System.out.println("Voici le monde peuplé : " + monde.toString()) ;
		//System.out.println("Affichons ce monde : ") ;
		//monde.afficher() ;

		// Il est temps d'ajouter deux avatars représentant chacun un joueur humain
		Avatar joueur1 = new Avatar(monde) ;
		monde.ajouterItem(joueur1) ;
		//System.out.println("Ajout du premier avatar/joueur :\n" + joueur1.toString()) ;
		Avatar joueur2 = new Avatar(monde) ;
		monde.ajouterItem(joueur2) ;
		//System.out.println("Ajout du deuxième avatar/joueur :\n" + joueur2.toString()) ;

		// réaffichage du monde
		//System.out.println("Voici le monde peuplé : " + monde.toString()) ;
		//System.out.println("Affichons ce monde : ") ;
		//monde.afficher() ;

		// réalisation de 5 tours de jeu
		System.out.println("Monde : ") ; monde.afficher() ;
		System.out.println("joueur1 : " + joueur1) ;
		System.out.println("joueur2 : " + joueur2) ;
		System.out.println("\n\n\n") ;
		for(int tour = 1 ; tour < 3 ; tour ++){
			// Annonce du round
			System.out.println("*** Tour " + tour + " ***") ;
			// tour du joueur 1
			System.out.println("Action de " + joueur1.getNomPersonnage()) ;
			joueur1.seDeplacer() ;
			System.out.println("Maj j1 :" + joueur1) ;
			monde.afficher() ;
			// tour  du joueur 2
			System.out.println("Action de " + joueur2.getNomPersonnage()) ;
			joueur2.seDeplacer() ;
			System.out.println("Maj j2 :" + joueur2) ;
			monde.afficher() ;
		}
		System.out.println("Fin") ;
		// réaffichage du monde
		//System.out.println("Voici le monde peuplé : " + monde.toString()) ;
		//System.out.println("Affichons ce monde : ") ;
		//monde.afficher() ;


		// réaffichage des joueurs
		//System.out.println("premier avatar/joueur :\n" + joueur1.toString()) ;
		//System.out.println("deuxième avatar/joueur :\n" + joueur1.toString()) ;

		// Fin 5 tours, donc, il faut que chaque avatar réalise une course avec ses créatures
		System.out.println("\n\n\n*************************** Score Final ***************************\n") ;
		double j1 = joueur1.course() ; System.out.println("j1 = " + j1 + " kilometres") ;
		double j2 = joueur2.course() ;  System.out.println("j2 = " + j2 + " kilometres") ;
		if (j1 == j2) {
			System.out.println("Match nul") ;
		}
		if (j1 > j2) {
			System.out.println("Joueur1 gagne !") ;
		}
		if (j1 < j2) {
			System.out.println("Joueur2 gagne !") ;
		}

		System.out.println("\nFin du main du jeu") ;

		*/
		/* // décommenter pour voir les tests des demandés avant la Partie 4
		System.out.println("Début du main de Jeu") ;
		// Test demandé 1
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

		// Test deamndé 2
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

		// Test demandé 3
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
		*/
		
		
}
