import java.util.LinkedList;
import java.util.List;

public class Jeu {

	private List<String> arme;
	private List<String> lieu;
	private List<String> suspect;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueur3;
	private Joueur joueur4;
	private List<String> solution;
	private Deck deck;
	
	public Jeu(Deck deck, Joueur Joueur1, Joueur Joueur2, Joueur Joueur3, Joueur Joueur4, List<String> Solution ){
		this.arme=deck.getArme();
		this.lieu=deck.getLieu();
		this.suspect=deck.getSuspect();
		this.joueur1=Joueur1;
		this.joueur2=Joueur2;
		this.joueur3=Joueur3;
		this.joueur4=Joueur4;
		this.solution=Solution;
		this.deck=deck;
		
	}
	
	public void Jouer() {
		int j1=joueur1.getType();
		int j2=joueur2.getType();
		int j3=joueur3.getType();
		int j4=joueur4.getType();
		Affichage affichage = new Affichage();
		
		String positionJoueur1 = joueur1.PositionDepart();
    	String positionJoueur2 = joueur2.PositionDepart();
    	String positionJoueur3 = joueur3.PositionDepart();
    	String positionJoueur4 = joueur4.PositionDepart();
    	
    	int gagneJoueur1=0;
    	int gagneJoueur2=0;
    	int gagneJoueur3=0;
    	int gagneJoueur4=0;
    	
    	List<String> Hypothese = new LinkedList<String>();
    	String CarteMontree;
    	int accuser;
    	
    	//int compteur = 0;
    	
    	while (gagneJoueur1==0 && gagneJoueur2==0 && gagneJoueur3==0 && gagneJoueur4==0){
    		
    		//TourJoueur1
    		if (joueur1.getNumeroJoueur()!=4) { //si le joueur n'est pas un Fantome
	    		affichage.Debut(joueur1.getPersonnage());
	    		if (j1==0){	
	    			affichage.MainJoueur(joueur1.getMain());
	    			affichage.Position(positionJoueur1);
	    		}
	    		
	    		positionJoueur1 = joueur1.Deplacement(positionJoueur1);
	    		Hypothese = joueur1.FormulerHypothese(positionJoueur1);
    		
    			positionJoueur2 = joueur2.DeplacementparHypothese(positionJoueur2, Hypothese);
    			positionJoueur3 = joueur3.DeplacementparHypothese(positionJoueur3, Hypothese);
    			positionJoueur4 = joueur4.DeplacementparHypothese(positionJoueur4, Hypothese);
    		
    			
    			if (j1==0) {
    				affichage.transition1(joueur1.getPersonnage());
    			}
    			if (j2==0) {
    				affichage.transition2(joueur1.getPersonnage(), joueur2.getPersonnage());
    			}
    		
    			CarteMontree = joueur2.MontrerCarte(Hypothese, joueur1.getPersonnage(), joueur1.getNumeroJoueur());
    			if (CarteMontree=="") {
    				if (j2==0) {
    					affichage.transition3(joueur2.getPersonnage());
    				}
    				if (j3==0) {
    					affichage.transition2(joueur1.getPersonnage(),joueur3.getPersonnage());
    				}
    				CarteMontree = joueur3.MontrerCarte(Hypothese, joueur1.getPersonnage(), joueur1.getNumeroJoueur());
    			}
    			if (CarteMontree=="") {
    				if (j3==0) {
    					affichage.transition3(joueur3.getPersonnage());
    				}
    				if (j4==0) {
    					affichage.transition2(joueur1.getPersonnage(),joueur4.getPersonnage());
    				}
    				CarteMontree = joueur4.MontrerCarte(Hypothese, joueur1.getPersonnage(), joueur1.getNumeroJoueur());
    			}
    			if (j1==1) {
    				joueur1.InterpreterCarte(CarteMontree, Hypothese);
    				gagneJoueur1 = joueur1.Gagner(solution);
    			}
    			else {
    				affichage.Reprise(joueur1.getPersonnage());
    				System.out.println("La carte montrée est : "+CarteMontree);
    				accuser = joueur1.FaireAccusation();
    				if (accuser==0) {
    					joueur1.Accusation();
    					gagneJoueur1 = joueur1.Gagner(solution);
    					break;
    				}
    			}
    		}
    		
    		//TourJoueur2
    		if (joueur2.getNumeroJoueur()!=4) {
	    		affichage.Debut(joueur2.getPersonnage());
	    		if (j2==0){	
	    			affichage.MainJoueur(joueur2.getMain());
	    			affichage.Position(positionJoueur2);
	    		}
	    		
	    		positionJoueur2 = joueur2.Deplacement(positionJoueur2);
	    		Hypothese = joueur2.FormulerHypothese(positionJoueur2);
    		
	    		positionJoueur1 = joueur1.DeplacementparHypothese(positionJoueur1, Hypothese);
	    		positionJoueur3 = joueur3.DeplacementparHypothese(positionJoueur3, Hypothese);
	    		positionJoueur4 = joueur4.DeplacementparHypothese(positionJoueur4, Hypothese);
	    		
	    		if (j2==0) {
	    			affichage.transition1(joueur2.getPersonnage());
	    		}
	    		if (j3==0) {
	    			affichage.transition2(joueur2.getPersonnage(),joueur3.getPersonnage());
	    		}
	    		CarteMontree = joueur3.MontrerCarte(Hypothese, joueur2.getPersonnage(), joueur2.getNumeroJoueur());
	    		
	    		if (CarteMontree=="") {
	    			if (j3==0) {
	        			affichage.transition3(joueur3.getPersonnage());
	        		}
	    			if (j4==0) {
	        			affichage.transition2(joueur2.getPersonnage(),joueur4.getPersonnage());
	        		}
	    			CarteMontree = joueur4.MontrerCarte(Hypothese, joueur2.getPersonnage(), joueur2.getNumeroJoueur());
	    		}
	    		if (CarteMontree=="") {
	    			if (j4==0) {
	        			affichage.transition3(joueur4.getPersonnage());
	        		}
	    			if (j1==0) {
	        			affichage.transition2(joueur2.getPersonnage(),joueur1.getPersonnage());
	        		}
	    			CarteMontree = joueur1.MontrerCarte(Hypothese, joueur2.getPersonnage(), joueur2.getNumeroJoueur());
	    		}
	    		if (j2==1) {
	    			joueur2.InterpreterCarte(CarteMontree, Hypothese);
	    			gagneJoueur2 = joueur2.Gagner(solution);
	    		}
	    		else {
	    			affichage.Reprise(joueur2.getPersonnage());
	    			System.out.println("La carte montrée est : "+CarteMontree);
	    			accuser = joueur2.FaireAccusation();
	    			if (accuser==0) {
	    				joueur2.Accusation();
	    				gagneJoueur2 = joueur2.Gagner(solution);
	    				break;
	    			}
	    		}
    		}


    		//TourJoueur3
    		if (joueur3.getNumeroJoueur()!=4) {
	    		affichage.Debut(joueur3.getPersonnage());
	    		if (j3==0){	
	    			affichage.MainJoueur(joueur3.getMain());
	    			affichage.Position(positionJoueur3);
	    		}
	    		
	    		positionJoueur3 = joueur3.Deplacement(positionJoueur3);
	    		Hypothese = joueur3.FormulerHypothese(positionJoueur3);
    		
	    		positionJoueur1 = joueur1.DeplacementparHypothese(positionJoueur1, Hypothese);
	    		positionJoueur2 = joueur2.DeplacementparHypothese(positionJoueur2, Hypothese);
	    		positionJoueur4 = joueur4.DeplacementparHypothese(positionJoueur4, Hypothese);
	    		
	    		if (j3==0) {
	    			affichage.transition1(joueur3.getPersonnage());
	    		}
	    		if (j4==0) {
	    			affichage.transition2(joueur3.getPersonnage(),joueur4.getPersonnage());
	    		}
	    		CarteMontree = joueur4.MontrerCarte(Hypothese, joueur3.getPersonnage(), joueur3.getNumeroJoueur());
	    		if (CarteMontree=="") {
	    			if (j4==0) {
	        			affichage.transition3(joueur4.getPersonnage());
	        		}
	    			if (j1==0) {
	        			affichage.transition2(joueur3.getPersonnage(),joueur1.getPersonnage());
	        		}
	    			CarteMontree = joueur1.MontrerCarte(Hypothese, joueur3.getPersonnage(), joueur3.getNumeroJoueur());
	    		}
	    		if (CarteMontree=="") {
	    			if (j1==0) {
	        			affichage.transition3(joueur1.getPersonnage());
	        		}
	    			if (j2==0) {
	        			affichage.transition2(joueur3.getPersonnage(),joueur2.getPersonnage());
	        		}
	    			CarteMontree = joueur2.MontrerCarte(Hypothese, joueur3.getPersonnage(), joueur3.getNumeroJoueur());
	    		}
	    		if (j3==1) {
	    			joueur3.InterpreterCarte(CarteMontree, Hypothese);
	    			gagneJoueur3 = joueur3.Gagner(solution);
	    		}
	    		else {
	    			affichage.Reprise(joueur3.getPersonnage());
	    			System.out.println("La carte montrée est : "+CarteMontree);
	    			accuser = joueur3.FaireAccusation();
	    			if (accuser==0) {
	    				joueur3.Accusation();
	    				gagneJoueur3 = joueur3.Gagner(solution);
	    				break;
	    			}
	    		}
    		}

    		
    		//TourJoueur4
    		if (joueur4.getNumeroJoueur()!=4) {
	    		affichage.Debut(joueur4.getPersonnage());
	    		if (j4==0){	
	    			affichage.MainJoueur(joueur4.getMain());
	    			affichage.Position(positionJoueur4);
	    		}
	    		
	    		positionJoueur4 = joueur4.Deplacement(positionJoueur4);
	    		Hypothese = joueur4.FormulerHypothese(positionJoueur4);
    		
	    		positionJoueur1 = joueur1.DeplacementparHypothese(positionJoueur1, Hypothese);
	    		positionJoueur2 = joueur2.DeplacementparHypothese(positionJoueur2, Hypothese);
	    		positionJoueur3 = joueur3.DeplacementparHypothese(positionJoueur3, Hypothese);
	    		
	    		if (j4==0) {
	    			affichage.transition1(joueur4.getPersonnage());
	    		}
	    		if (j1==0) {
	    			affichage.transition2(joueur4.getPersonnage(),joueur1.getPersonnage());
	    		}
	    		CarteMontree = joueur1.MontrerCarte(Hypothese, joueur4.getPersonnage(), joueur4.getNumeroJoueur());
	    		if (CarteMontree=="") {
	    			if (j1==0) {
	        			affichage.transition3(joueur1.getPersonnage());
	        		}
	    			if (j2==0) {
	        			affichage.transition2(joueur4.getPersonnage(),joueur2.getPersonnage());
	        		}
	    			CarteMontree = joueur2.MontrerCarte(Hypothese, joueur4.getPersonnage(), joueur4.getNumeroJoueur());
	    		}
	    		if (CarteMontree=="") {
	    			if (j2==0) {
	        			affichage.transition3(joueur2.getPersonnage());
	        		}
	    			if (j3==0) {
	        			affichage.transition2(joueur4.getPersonnage(),joueur3.getPersonnage());
	        		}
	    			CarteMontree = joueur3.MontrerCarte(Hypothese, joueur4.getPersonnage(), joueur4.getNumeroJoueur());
	    		}
	    		if (j4==1) {
	    			joueur4.InterpreterCarte(CarteMontree, Hypothese);
	    			gagneJoueur4 = joueur4.Gagner(solution);
	    		}
	    		else {
	    			affichage.Reprise(joueur4.getPersonnage());
	    			System.out.println("La carte montrée est : "+CarteMontree);
	    			accuser = joueur4.FaireAccusation();
	    			if (accuser==0) {
	    				joueur4.Accusation();
	    				gagneJoueur4 = joueur4.Gagner(solution);
	    				break;
	    			}
	    		}
    		}
    		//compteur=compteur+1;
    		
    	}
    	

		affichage.suite();
		
		//System.out.println(compteur);
		
    	Fin fin = new Fin(gagneJoueur1, gagneJoueur2, gagneJoueur3, gagneJoueur4, deck, joueur1, joueur2, joueur3, joueur4);
    	fin.Conclusion(solution);
	}
}
