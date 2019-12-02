public class Jeu {
	public static void main (String [] args){
		/* Test demandé */
		Sac sac = new Sac(5) ;
		System.out.println(sac) ;
		
		sac.ajouter(new Pomme()) ;
		sac.ajouter(new Pomme()) ;
		sac.ajouter(new Pomme()) ;sac.ajouter(new Pomme()) ;sac.ajouter(new Pomme()) ;sac.ajouter(new Pomme()) ;sac.ajouter(new Pomme()) ;
		System.out.println(sac) ;
		/* Tests en plus */
		
		return ; 
	}
}
