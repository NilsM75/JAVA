import java.awt.*;
import javax.swing.*;
import java.util.ArrayList ;

public class Monde extends JPanel{
	/* les personnages et les acccessoires se trouvent dans un monde de forme carrée */

	/* Attributs */
	private ArrayList<Item> listeItems ; // liste d'items
	private int taille ; // taille du monde
	private int tailleCase ;

	/* Constructeurs */
	public Monde() {
		taille = 5 ;
		listeItems = new ArrayList<Item>() ;
	}
	public Monde(int taille, int tailleCase){
		setPreferredSize(new Dimension ( taille*tailleCase , taille*tailleCase ) ) ;
		this.tailleCase = tailleCase ;
		this.taille = taille ;
		listeItems = new ArrayList<Item>() ;
	}

	/* Méthodes */
	// permet de dessiner chaque item dans le panneau
	public void paintComponent (Graphics g) {
		super.paintComponent (g) ; // redessine le panneau
		for ( Item itemVoisin : listeItems ) {
			if ( itemVoisin != null ) {
				itemVoisin.dessiner(g, this) ;
			}
		}
	}

	public int getPositionAlea(){
	/*  retourne une position enitère aléatoire dans le monde,
		méthode utilisée pour donner des valeurs aussi bien pour les abscisses que pour les ordonnées */
		return ((int)(Math.random() * (taille - 1))) ; // entier entre 0 et la (taille - 1)
	}

	public void ajouterItem(Item item){ // initialise aléatoirement l'abscisse et l'ordonnée de l'item et l'ajoute dans le monde
		item.setX(getPositionAlea()) ;
		item.setY(getPositionAlea()) ;
		listeItems.add(item) ;
		return ;
	}

	public void ajouterItem(Item item, int x, int y){
		item.setX(x) ;
		item.setY(y) ;
		listeItems.add(item) ;
		return ;
	}
	public void supprimerItem(Item item){ // supprimer l'item du monde et met ses coordonnées à (-1, -1)
		item.setX((-1)) ;
		item.setY((-1)) ;
		listeItems.remove(listeItems.indexOf(item)) ;
		return ;
	}

	public Item chercher(int x, int y){ // retorune le premier item trouvé aux coordonnées (x, y) ou null sinon
		for(int i = 0 ; i < listeItems.size() ; i ++){
			if (((listeItems.get(i)).getX() == x) && ((listeItems.get(i)).getY() == y)){
				return (listeItems.get(i)) ;
			}
		}
		return null ;
	}

	public ArrayList<Item> getVoisins(Item item){
	/* retourne la liste des items qui sont à une distance <= 2 de l'item en paramètre
	   (la liste de voisins ne doit pas contenir l'item en paramètre) */
		ArrayList<Item> temp = new ArrayList<Item>() ;
		for(int i = 0 ; i < listeItems.size() ; i ++){
			if ((((listeItems.get(i)) != item)) && (Math.sqrt(Math.pow(((listeItems.get(i)).getX() - item.getX()), 2) + Math.pow(((listeItems.get(i)).getY() - item.getY()), 2)) <= 2.0d)){
				temp.add(listeItems.get(i)) ;
			}
		}
		return temp ;
	}

	private static String getNomCourt(String nom){
		/* 	retourne une chaine d'exactement 4 caractères suivant un certain pattern :
			x -> __x_
			xx -> _xx_
			sac -> sac_
			pomme -> pomm
			...
			(_ veut dire espace)
		*/
		// On aurait pu faire plus simple, mais comme on exige un certain "pattern" de placement d'espaces à suivre

		if(nom.length() > 4){
			return getNomCourt(nom.substring(0, nom.length()-1)) ;
		}

		if(nom.length() < 4){
			if((nom.length() % 2) == 0){ // 0 ou 2
				return getNomCourt(" " + nom + " ") ;  // un espace puis nom puis un espace
			}
			// 1
			return ("  " + nom + " ") ; // deux espaces puis nom puis un espace
		}

		// 4
		return nom ;
	}

	/*
	// Décommenter pour tester la fonction getNomCourt ici
	public static void main(String[] args){
		System.out.println("pour \"x\" : " + getNomCourt("x") + "f") ; // __x_
		System.out.println("pour \"xx\" : " + getNomCourt("xx") + "f") ; // _xx_
		System.out.println("pour \"sac\" : " + getNomCourt("sac") + "f") ; // sac_
		System.out.println("pour \"pomme\" : " + getNomCourt("pomme") + "f") ; // pomm
		return ;
	}
	*/

	public void afficher(){
		/*  Affiche un monde aves ses items.
			Exemple :
			Pour un monde de taille 5.
			Principe : Pour chaque case de coordonnées (x, y), rechercher un item à ces coordonnées.
			Si plusieurs items sont aux mêmes coordonnées, afficher seuelement le premier item trouvé.
		*/

		// affichage première ligne (sans retour à la ligne)
		// Décommenter la ligne d'en dessous si on souhaite avoir un affichage correspondant à l'exemple donné, l'affichage proposé montre x et y (meilleur)
		//System.out.print(getNomCourt("") + "|") ;
		System.out.print(" x/y|") ;
		for(int i = 0 ; i < taille ; i ++){
			System.out.print(getNomCourt(i+"") + "|") ;
		}

		// affichage du reste des lignes
		for(int i = 0 ; i < taille ; i ++){
			System.out.print("\n" + getNomCourt((i+"")) + "|") ;
			for(int j = 0 ; j < taille ; j ++){
				if(chercher(i, j) == null){
					System.out.print(getNomCourt("") + "|") ;
				}else{
					System.out.print(getNomCourt((chercher(i, j)) + "") + "|") ;
				}
			}
		}
		System.out.println() ;
		return ;
	}

	public int getTaille(){
		return taille ;
	}

	public int getTailleCase(){
		return tailleCase;
	}
	@Override
	public String toString(){ // retourne une chaine de caractère décrivant le monde
		String temp ;
		if (listeItems.size() == 0){
			temp = new String(" ne contenant aucun items (vide).") ;
		} else {
			temp = new String(" et d'items : \n") ;
		}
		for(int i = 0 ; i < listeItems.size() ; i ++){
			temp += ("item[" + i + "] : " + listeItems.get(i) + "\n") ;
		}

		return ("Monde de taille égale à " + taille + temp) ;
	}
}
