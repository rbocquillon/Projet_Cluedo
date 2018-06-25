import java.util.List;
import java.util.LinkedList;

public class Fin {

	private int gagneJoueur1;
	private int gagneJoueur2;
	private int gagneJoueur3;
	private int gagneJoueur4;
	private List<String> arme;
	private List<String> lieu;
	private List<String> suspect;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueur3;
	private Joueur joueur4;
	private Deck deck;
	
	public Fin(int GagneJoueur1, int GagneJoueur2, int GagneJoueur3, int GagneJoueur4, Deck deck, Joueur Joueur1, Joueur Joueur2, Joueur Joueur3, Joueur Joueur4) {
		this.gagneJoueur1=GagneJoueur1;
		this.gagneJoueur2=GagneJoueur2;
		this.gagneJoueur3=GagneJoueur3;
		this.gagneJoueur4=GagneJoueur4;
		this.arme=deck.getArme();
		this.lieu=deck.getLieu();
		this.suspect=deck.getSuspect();
		this.joueur1=Joueur1;
		this.joueur2=Joueur2;
		this.joueur3=Joueur3;
		this.joueur4=Joueur4;
		this.deck=deck;
	}
	
	public void Conclusion(List<String> solution) {
		String NomJoueur1=joueur1.getPersonnage();
		String NomJoueur2=joueur2.getPersonnage();
		String NomJoueur3=joueur3.getPersonnage();
		String NomJoueur4=joueur4.getPersonnage();
		
		int j1=joueur1.getType();
		int j2=joueur2.getType();
		int j3=joueur3.getType();
		int j4=joueur4.getType();
		if (gagneJoueur1==1) {
			if (j1==0)
				System.out.println("Bravo, tu as gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
			else
				System.out.println("Dommage, tu as perdu!! "+NomJoueur1+" a gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		}
		else if (gagneJoueur1==2) {
			System.out.println("Dommage, tu t'es trompé!!");
			if (j4==0&&joueur4.getNumeroJoueur()!=4||j2==0&&joueur2.getNumeroJoueur()!=4||j3==0&&joueur3.getNumeroJoueur()!=4) {
				Fantome Joueur1 = new Fantome(deck, joueur1.getMain() , joueur1.getPersonnage(), 4, 0);
				Jeu jeu = new Jeu(deck, Joueur1, joueur2, joueur3, joueur4, solution);
				jeu.Jouer();
			}
			else
				System.out.println("Il fallait trouver "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		}
		
		
		else if (gagneJoueur2==1) {
			if (j2==0)
				System.out.println("Bravo, tu as gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
			else
				System.out.println("Dommage, tu as perdu!! "+NomJoueur2+" a gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		}
		else if (gagneJoueur2==2) { 
			System.out.println("Dommage, tu t'es trompé!!");
			if (j1==0&&joueur1.getNumeroJoueur()!=4||j4==0&&joueur4.getNumeroJoueur()!=4||j3==0&&joueur3.getNumeroJoueur()!=4) {
				Fantome Joueur2 = new Fantome(deck, joueur2.getMain()  , joueur2.getPersonnage(), 4,0);
				Jeu jeu = new Jeu(deck, joueur1, Joueur2, joueur3, joueur4, solution);
				jeu.Jouer();
			}
			else
				System.out.println("Il fallait trouver "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		}
		
		
		else if (gagneJoueur3==1) {
			if (j3==0)
				System.out.println("Bravo, tu as gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
			else
				System.out.println("Dommage, tu as perdu!! "+NomJoueur3+" a gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		}
		else if (gagneJoueur3==2) {
			System.out.println("Dommage, tu t'es trompé!!");
			if (j1==0&&joueur1.getNumeroJoueur()!=4||j2==0&&joueur2.getNumeroJoueur()!=4||j4==0&&joueur4.getNumeroJoueur()!=4) {
				Fantome Joueur3 = new Fantome(deck, joueur3.getMain()  , joueur3.getPersonnage(), 4,0);
				Jeu jeu = new Jeu(deck, joueur1, joueur2, Joueur3, joueur4, solution);
				jeu.Jouer();
			}
			else
				System.out.println("Il fallait trouver "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		}
		
		else if (gagneJoueur4==1)
			if (j4==0)
				System.out.println("Bravo, tu as gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
			else
				System.out.println("Dommage, tu as perdu!! "+NomJoueur4+" a gagné en démasquant "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		else if (gagneJoueur4==2) {
			System.out.println("Dommage, tu t'es trompé!!");
			if (j1==0&&joueur1.getNumeroJoueur()!=4||j2==0&&joueur2.getNumeroJoueur()!=4||j3==0&&joueur3.getNumeroJoueur()!=4) {
				Fantome Joueur4 = new Fantome(deck, joueur4.getMain()  , joueur4.getPersonnage(), 4,0);
				Jeu jeu = new Jeu(deck, joueur1, joueur2, joueur3, Joueur4, solution);
				jeu.Jouer();
			}
			else
				System.out.println("Il fallait trouver "+solution.get(2)+" dans la pièce "+solution.get(1)+" avec comme arme du crime : "+solution.get(0));
		}
	}
}
