import java.util.LinkedList;
import java.util.List;
//import java.util.ListIterator;
import java.util.Arrays;
import java.util.Scanner;

public class Lancement {
	
	private List<String> arme;
	private List<String> lieu;
	private List<String> suspect;
	private int j1;
	private int j2;
	private int j3;
	private int j4;
	
	public Lancement(Deck deck) {
		this.arme=deck.getArme();
		this.lieu=deck.getLieu();
		this.suspect=deck.getSuspect();
		
	}
	
	public void commencer() { 
		
    	//Choix du type des joueurs enregistré en binaire avec j1, j2, j3, j4
    	Deck deck = new Deck();
		Lancement lancement = new Lancement(deck); 
    	
		Initialisation initialisation = new Initialisation(deck);
    	
    	List<Integer> Joueur = new LinkedList<Integer>();
    	Joueur = initialisation.ChoixType(Joueur);
    	
    	
		lancement.j1=Joueur.get(0);
    	lancement.j2=Joueur.get(1);
    	lancement.j3=Joueur.get(2);
    	lancement.j4=Joueur.get(3);
    	
    	// Attribution du nom des personnage
		
    	List<String> Personnage = new LinkedList<String>();
		Personnage.addAll(lancement.suspect);
		String NomJoueur1;
		String NomJoueur2;
		String NomJoueur3;
		String NomJoueur4;	
		if (lancement.j1==0) {
			NomJoueur1 = initialisation.ChoixPersonnage(Personnage);
		}
		else
			NomJoueur1 = initialisation.AttributionPersonnage(Personnage);
		if (lancement.j2==0) {
			NomJoueur2 = initialisation.ChoixPersonnage(Personnage);
		}
		else
			NomJoueur2 = initialisation.AttributionPersonnage(Personnage);
		if (lancement.j3==0) {
			NomJoueur3 = initialisation.ChoixPersonnage(Personnage);
		}
		else
			NomJoueur3 = initialisation.AttributionPersonnage(Personnage);
		if (lancement.j4==0) {
			NomJoueur4 = initialisation.ChoixPersonnage(Personnage);
		}
		else
			NomJoueur4 = initialisation.AttributionPersonnage(Personnage);
	
		System.out.println("Joueur1 : "+NomJoueur1);
		System.out.println("Joueur2 : "+NomJoueur2);
		System.out.println("Joueur3 : "+NomJoueur3);
		System.out.println("Joueur4 : "+NomJoueur4);
		
		//Creation de la solution
		
		List<String> solution = initialisation.Solution();
		
		//Distribution des cartes
		
    	List<String> Jeu = initialisation.Jeu(solution);
    	List<String> mainJoueur1 = initialisation.Distribution(Jeu);
    	List<String> mainJoueur2 = initialisation.Distribution(Jeu);
    	List<String> mainJoueur3 = initialisation.Distribution(Jeu);
    	List<String> mainJoueur4 = initialisation.Distribution(Jeu);
    	
    	//Création des différents joueurs
    	
    	Joueur joueur1;
    	Joueur joueur2;
    	Joueur joueur3;
    	Joueur joueur4;
    	
    	if (lancement.j1==0) {
    		joueur1 = new Joueur(deck, mainJoueur1, NomJoueur1,0,0);
		}
		else {
			joueur1 = new IA(deck, mainJoueur1, NomJoueur1, 0,1);
		}
    	
    	if (lancement.j2==0) {
    		joueur2 = new Joueur(deck, mainJoueur2, NomJoueur2,1,0);
		}
		else {
			joueur2 = new IA(deck, mainJoueur2, NomJoueur2, 1,1);
		}
    	if (lancement.j3==0) {
    		joueur3 = new Joueur(deck, mainJoueur3, NomJoueur3,2,0);
		}
		else {
			joueur3 = new IA(deck, mainJoueur3, NomJoueur3, 2,1);
		}
    	if (lancement.j4==0) {
    		joueur4 = new Joueur(deck, mainJoueur4, NomJoueur4,3,0);
		}
		else {
			joueur4 = new IA(deck, mainJoueur4, NomJoueur4, 3,1);
		}
    	
    	//lancement du jeu
    	Jeu jeu = new Jeu(deck, joueur1, joueur2, joueur3, joueur4, solution);
    	jeu.Jouer();
    	//List<Integer> entier = new LinkedList();
    	//for (int i=0;i<5;i++) {
			//entier.add(i+2);
		//}
    	
    	//Initialisation initialisation = new Initialisation(principal.arme, principal.lieu, principal.suspect);
    	
    	
    	//List<String> Personnage = new LinkedList<String>();
		//Personnage.addAll(principal.suspect);
		//String NomJoueur = initialisation.ChoixPersonnage(Personnage);
		//String NomIA1 = initialisation.AttributionPersonnage(Personnage);
		//String NomIA2 = initialisation.AttributionPersonnage(Personnage);
		//String NomIA3 = initialisation.AttributionPersonnage(Personnage);
		
		
		//System.out.println(NomJoueur);
    	//System.out.println(NomIA1);
    	//System.out.println(NomIA2);
    	//System.out.println(NomIA3);
		
		
    	//List<String> solution = initialisation.Solution();
    	//System.out.println(solution);
    	
    	//List<String> Jeu = initialisation.Jeu(solution);
    	//List<String> mainJoueur = initialisation.Distribution(Jeu);
    	//List<String> mainIA1 = initialisation.Distribution(Jeu);
    	//List<String> mainIA2 = initialisation.Distribution(Jeu);
    	//List<String> mainIA3 = initialisation.Distribution(Jeu);
    	
    	
    	//System.out.println(mainJoueur);
    	//System.out.println(mainIA1);
    	//System.out.println(mainIA2);
    	//System.out.println(mainIA3);
    	
    	//TourJoueur tourjoueur = new TourJoueur(principal.arme, principal.lieu, principal.suspect, mainJoueur, NomJoueur);
    	//TourIA tourIA1 = new TourIA(principal.arme, principal.lieu, principal.suspect, mainIA1, NomIA1, 1);
    	//TourIA tourIA2 = new TourIA(principal.arme, principal.lieu, principal.suspect, mainIA2, NomIA2, 2);
    	//TourIA tourIA3 = new TourIA(principal.arme, principal.lieu, principal.suspect, mainIA3, NomIA3, 3);
    	
    	
    	//String positionJoueur = tourjoueur.PositionDepart();
    	//String positionIA1 = tourIA1.PositionDepart();
    	//String positionIA2 = tourIA2.PositionDepart();
    	//String positionIA3 = tourIA3.PositionDepart();
    	
    	
    	//System.out.println(positionJoueur);
    	//System.out.println(positionIA1);
    	//System.out.println(positionIA2);
    	//System.out.println(positionIA3);
    	//System.out.println("Vous êtes dans la pièce : " + positionJoueur);
    	//positionJoueur = tourjoueur.Deplacement(positionJoueur);
    	//positionIA1 = tourIA1.Deplacement(positionIA1);
    	//positionIA2 = tourIA2.Deplacement(positionIA2);
    	//positionIA3 = tourIA3.Deplacement(positionIA3);
    	//System.out.println(positionJoueur);
    	//System.out.println(positionIA1);
    	//System.out.println(positionIA2);
    	//System.out.println(positionIA3);
    	
    	//List<String> HypotheseJoueur = tourjoueur.FormulerHypothese(positionJoueur);
    	//positionIA1 = tourjoueur.DeplacementparHypothese(NomIA1, positionIA1, HypotheseJoueur);
    	//positionIA2 = tourjoueur.DeplacementparHypothese(NomIA2, positionIA2, HypotheseJoueur);
    	//positionIA3 = tourjoueur.DeplacementparHypothese(NomIA3, positionIA3, HypotheseJoueur);
    	//System.out.println(HypotheseJoueur);
    	
    	//List<String> HypotheseIA1 = tourIA1.FormulerHypothese(positionIA1);
    	//List<String> HypotheseIA2 = tourIA2.FormulerHypothese(positionIA2);
    	//List<String> HypotheseIA3 = tourIA3.FormulerHypothese(positionIA3);
    	//System.out.println(HypotheseIA1);
    	//System.out.println(HypotheseIA2);
    	//System.out.println(HypotheseIA3);
    	
    	//System.out.println(tourjoueur.main);
    	//String carteMontreeJoueur = tourjoueur.MontrerCarte(HypotheseIA1, NomIA1);
    	
    	//System.out.println(mainIA2);
    	//String carteMontreeIA2 = tourIA2.MontrerCarte(HypotheseIA1, NomIA1, 1);
    	//System.out.println(carteMontreeIA2);
    	//System.out.println(Arrays.deepToString(tourIA2.CartesMontrees));
    	
    	//System.out.println(tourIA1.armePossible);
    	//System.out.println(tourIA2.armePossible);
    	//tourIA1.InterpreterCarte(carteMontreeJoueur, HypotheseIA1);
    	//System.out.println(tourIA1.armePossible);
    	//System.out.println(tourIA2.armePossible);
    		
    	
    	
    	
	}
}
	
	
