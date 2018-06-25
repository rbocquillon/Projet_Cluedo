import java.util.Scanner;
import java.util.List;
public class Affichage {

	public Affichage() {
	}
	
	public void Debut(String Nom) {
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Commencer Tour "+Nom+" : (1)");
		int Choix = Saisie.nextInt();
		for(int i=0;i<40;i++) 
	        System.out.println("\n" ); 
	}
	
	public void MainJoueur(List<String> MainJoueur) {
		System.out.println("Votre main : "+MainJoueur);
	}
	
	public void Reprise(String Nom) {
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Reprise du Tour de "+Nom+" : (1)");
		int Choix = Saisie.nextInt();
		for(int i=0;i<40;i++) 
	        System.out.println("\n" ); 
	}
	
	public void Position(String position) {
		System.out.println("Vous êtes dans la pièce : "+ position);
	}
	
	public void suite() {
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Suivant : (1)");
		int Choix = Saisie.nextInt();
		for(int i=0;i<40;i++) 
	        System.out.println("\n" ); 
	}
	
	public void transition1(String Nom1) {
		Scanner Saisie1 = new Scanner(System.in);
		System.out.println("Finir Hypothese "+ Nom1 +" : (1)");
		int Choix = Saisie1.nextInt();
		for(int i=0;i<40;i++) 
			System.out.println("\n" ); 
	}		
	
	public void transition2(String Nom1, String Nom2) {
		Scanner Saisie2 = new Scanner(System.in);
		System.out.println("Commencer la réponse à l'Hypothese de  "+ Nom1 + " : à " + Nom2 + " de répondre! : (1)");
		int Choix2 = Saisie2.nextInt();
	}
	
	public void transition3(String Nom1) {
		Scanner Saisie1 = new Scanner(System.in);
		System.out.println(Nom1 +" : Finir votre réponse à l'hypothèse : (1)");
		int Choix = Saisie1.nextInt();
		for(int i=0;i<40;i++) 
			System.out.println("\n" ); 
	}
	
}
