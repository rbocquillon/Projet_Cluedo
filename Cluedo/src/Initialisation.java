import java.util.Scanner;
import java.util.List;
//import java.util.ListIterator;
import java.util.LinkedList;

public class Initialisation {

	private List<String> arme;
	private List<String> lieu;
	private List<String> suspect;
	
	public Initialisation(Deck deck) {
		this.arme=deck.getArme();
		this.lieu=deck.getLieu();
		this.suspect=deck.getSuspect();
	}
	
	public List<Integer> ChoixType(List<Integer> joueur) {
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Bienvenue au jeu de Cluedo à 4! Combien de joueurs êtes vous ?");
		int Choix = Saisie.nextInt();
		switch (Choix)
		{
		  case 0:
			joueur.add(1);
			joueur.add(1);
			joueur.add(1);
			joueur.add(1);
		    break;
		  case 1:
			joueur.add(0);
			joueur.add(1);
			joueur.add(1);
			joueur.add(1);
		    break;
		  case 2:
			joueur.add(0);
			joueur.add(0);
			joueur.add(1);
			joueur.add(1);
		    break;
		  case 3:
        	joueur.add(0);
			joueur.add(0);
			joueur.add(0);
			joueur.add(1);
			break;
		  case 4:
			joueur.add(0);
			joueur.add(0);
			joueur.add(0);
			joueur.add(0);
			break;
		  default:
		    System.out.println("Veuillez choisir un nombre de joueurs existant !");
		    joueur=ChoixType(joueur);
		}
		
		return joueur;
	}
	
	public String ChoixPersonnage(List<String> Personnage) {
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Veuillez saisir votre personnage (0-"+(Personnage.size()-1)+") :" + Personnage);
		int Choix = Saisie.nextInt();
		String choix = "";	
		switch (Choix)
		{
		  case 0:
		    choix = Personnage.get(0);
		    Personnage.remove(0);
		    break;
		  case 1:
			choix = Personnage.get(1);
			Personnage.remove(1);
		    break;
		  case 2:
			choix = Personnage.get(2);
			Personnage.remove(2);
		    break;
		  case 3:
			choix = Personnage.get(3);
			Personnage.remove(3);
			break;
		  case 4:
			choix = Personnage.get(4);
			Personnage.remove(4);
			break;
		  case 5:
			choix = Personnage.get(5);
			Personnage.remove(5);
			break;
		  default:
		    System.out.println("Veuillez choisir un personnage existant !");
		    choix=ChoixPersonnage(Personnage);
		}
		return choix;
	}
	
	public String AttributionPersonnage(List<String> Personnage) {
		int perso = (int)(Math.random() * Personnage.size());
		String personnage = Personnage.get(perso);
		Personnage.remove(perso);
		return personnage;
	}
	
	public List<String> Solution() {
		List<String> solution = new LinkedList<String>();
		int solutionarme =(int)(Math.random() * 11);
		solution.add(arme.get(solutionarme));
		
		int solutionlieu =(int)(Math.random() * 10);
		solution.add(lieu.get(solutionlieu));
		
		int solutionsuspect =(int)(Math.random() * 6);
		solution.add(suspect.get(solutionsuspect));
		
		return solution;
	}
	
	public List<String> Jeu(List<String> solution){
		List<String> Jeu = new LinkedList<String>();
		Jeu.addAll(arme);
		Jeu.addAll(lieu);
		Jeu.addAll(suspect);
		for (int i=0; i<3; i++) {
			Jeu.remove(solution.get(i));
		}
		return Jeu;
	}
	
	public List<String> Distribution(List<String> Jeu){
		List<String> main = new LinkedList<String>();
		for (int i=0; i<6; i++) {
			int carte = (int)(Math.random() * Jeu.size());
			main.add(Jeu.get(carte));
			Jeu.remove(carte);
		}
		return main;
	}
}
