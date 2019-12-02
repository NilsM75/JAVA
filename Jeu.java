public class Jeu {
	public static void main (String [] args){
		
		/* Test complet */
		
		Pomme p1 = new Pomme() ;
		System.out.println(p1) ; 
		Sac sac1 = new Sac() ;
		System.out.println(sac1) ; 
		Sac sac2 = new Sac(5) ;
		System.out.println(sac2) ; 
		sac2.ajouter(p1) ; 
		sac2.ajouter(sac1) ; 
		System.out.println(sac2) ; 
		Sac sac3 = sac2.obtenir(1) ; 
		System.out.println(sac3) ; 
		
		return ; 
	}
}
