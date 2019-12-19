import java.awt.* ;
import javax.swing.* ;
import java.util.Scanner ; 
import javax.imageio.ImageIO;
import java.io.*;

public class Question15 {
	public static void main (String [] args){ // Notre main de Jeu
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
	/*
		// Ajout de BigMac dans le Monde **************************************
		BigMac b1 = new BigMac();
		monde.ajouterItem(b1);
		BigMac b2 = new BigMac();
		monde.ajouterItem(b2);
		BigMac b3 = new BigMac();
		monde.ajouterItem(b3);
	*/
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
		
	}
}
