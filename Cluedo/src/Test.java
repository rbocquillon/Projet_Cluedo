import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {  
		Deck deck = new Deck();                     // préparation des cartes et du lancement du jeu 
		Lancement lancement = new Lancement(deck);
		lancement.commencer();
		Scanner Saisie = new Scanner(System.in);    // proposition de rejouer
		int volontee=0;
		while(volontee==0) {                          
			System.out.println("Voulez vous rejouer : Oui/Non (0/1)");
			int Choix = Saisie.nextInt();
			switch (Choix)
			{
			  case 0:
				for(int i=0;i<40;i++) 
					System.out.println("\n" );
				lancement.commencer();
				volontee=0;
			    break;
			  case 1:
				System.out.println("A bientôt !");
				volontee=1;
			    break;
			  default:
			    System.out.println("Je prends ça pour un Non ! A bientôt !");
			    volontee=1;
			}
		}
	}	
}
