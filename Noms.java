import java.awt.*;
import javax.swing.*;
public abstract class Noms { // classe outil, aucune instance de cette classe ne peut être crée (abstraite)

	/* Attributs */
	
	private final static String[] TAB_NOMS = new String[] {"Bob", "Fil", "Jaz"} ; // tableau qui contient les noms choisis
	private static int cpt = 0 ; // compteur du nombre de fois que le tableau est parcouru
	private static int position = (-1) ; // donne la position courante dans le tableau

	/* Constructeurs */
	
	private Noms() { }
	
	/* Méthodes */
	
	public static String getNom(){ // retourne un truc du genre Bob1 puis Fil1 puis Jaz1 puis Bob2, etc.
		position ++ ; 
		
		if (position < TAB_NOMS.length){
			/* // à décommenter si on souhaite obtenir les noms sans les chiffres rajoutès à la fin de ces derniers les 3 premiers appels successifs
			if(cpt == 0){ 
				return ("" + TAB_NOMS[position]) ; 
			} */
			return ("" + TAB_NOMS[position] + (cpt + 1)) ; 
		}
		
		cpt ++ ; 
		position = (-1) ; 
		
		return getNom() ; 
	}
	
	/*
	
	 // Décommenter cette partie pour tester la méthode getNom() 
	 
	public static void main(String[] args){
		System.out.println(Noms.getNom() + "  " + Noms.getNom() + "  " + Noms.getNom() + "  " +
		Noms.getNom() + "  " + Noms.getNom() + "   " + Noms.getNom() + "  " 
		+ Noms.getNom() + "  " + Noms.getNom() + "   " + Noms.getNom()+ "  " +
		Noms.getNom() + "  " + Noms.getNom() + "  " + Noms.getNom()) ; 
		return ; 
	}
	
	*/
}
