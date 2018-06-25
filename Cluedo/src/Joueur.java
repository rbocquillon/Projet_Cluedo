import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Joueur {
	
	private List<String> arme;
	private List<String> lieu;
	private List<String> suspect;
	private List<String> main;
	private String personnage;
	private List<String> accusation;
	private int type;
	private int NumeroJoueur;
	public Joueur(Deck deck, List<String> Main, String Personnage, int numeroJoueur, int type) {
		this.arme=deck.getArme();
		this.lieu=deck.getLieu();
		this.suspect=deck.getSuspect();
		this.NumeroJoueur=numeroJoueur;
		this.main=Main;
		this.personnage=Personnage;
		this.accusation= new LinkedList<String>();
		this.type=type;
	}
	
	public int getNumeroJoueur() {
		return NumeroJoueur;
	}

	public void setNumeroJoueur(int numeroJoueur) {
		NumeroJoueur = numeroJoueur;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<String> getMain() {
		return main;
	}

	public void setMain(List<String> suspect) {
		this.main = suspect;
	}

	public String getPersonnage() {
		return personnage;
	}

	public void setPersonnage(String personnage) {
		this.personnage = personnage;
	}

	public List<String> getAccusation() {
		return accusation;
	}

	public void setAccusation(List<String> accusation) {
		this.accusation = accusation;
	}
	
	public String PositionDepart() {
		String position="";
		switch (personnage)
		{
		  case "Major Mayo":
			position="Salon";
		    break;
		  case "Mme Bleuet":
			position="Hall";
		    break;
		  case "Dr Pistache":
			position="Salle de billard";
		    break;
		  case "Mlle Camélia":
			position="Salle de Sport";
			break;
		  case "Prof Mauve":
			position="Cuisine";
			break;
		  case "Mme Gypse":
			position="Chambre";
			break;
		  default:
			position="Salon";
		}
		return position;
	}

	public String Deplacement(String position) {
		switch (position)
		{
		  case "Cuisine":
			position=ChoixDeplacement("Salon","Salle à Manger","Chambre");
		    break;
		  case "Hall":
			position=ChoixDeplacement("Chambre","Véranda","Salle de billard");
		    break;
		  case "Salon":
			position=ChoixDeplacement("Cuisine","Salle de Bain","Salle de billard");
		    break;
		  case "Salle à Manger":
			position=ChoixDeplacement("Cuisine","Véranda","Salle de billard");
			break;
		  case "Chambre":
	     	position=ChoixDeplacement("Cuisine","Hall","Salle de Sport");
			break;
		  case "Bureau":
			position=ChoixDeplacement("Salle de Sport","Salle de Bain","Salle de billard");
			break;
		  case "Salle de billard":
			position=ChoixDeplacement("Hall","Salon","Salle à Manger");
			break;
		  case "Salle de Bain":
			position=ChoixDeplacement("Salon","Bureau","Véranda");
			break;
		  case "Véranda":
			position=ChoixDeplacement("Hall","Salle de Bain","Salle à Manger");
			break;
		  case "Salle de Sport":
			position=ChoixDeplacement("Bureau","Chambre","Salle de billard");
				break;
		  default:
			position="Salle de billard";
		}
		return position;
	}

	public String ChoixDeplacement(String lieu1, String lieu2, String lieu3) {
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Veuillez saisir votre destination (1-3) :" + lieu1 + ", " + lieu2 + ", " + lieu3);
		int Choix = Saisie.nextInt();
		String choix = "";	
		switch (Choix)
		{
		  case 1:
			choix = lieu1;
		    break;
		  case 2:
			choix = lieu2;
		    break;
		  case 3:
			choix = lieu3;
			break;
		  default:
		    System.out.println("Veuillez choisir un lieu existant !");
		    choix=ChoixDeplacement(lieu1, lieu2, lieu3);
		}
		return choix;
	}

	public List<String> FormulerHypothese(String position){
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Vous êtes dans la pièce : " + position + ". Veuillez proposer l'arme du crime (0-10): " + this.arme);
		int Choixarme = Saisie.nextInt();
		List<String> Hypothese = new LinkedList<String>();	
		if (Choixarme>=0 && Choixarme<10)
			Hypothese.add(arme.get(Choixarme));
		else
			Hypothese.add(arme.get(0)); //arme prise par défaut si le joueur rentre une donnée erronée
		
		Hypothese.add(position);
		
		Scanner Saisie2 = new Scanner(System.in);
		System.out.println("Veuillez proposer le suspect (0-5): " + suspect);
		int Choixsuspect = Saisie2.nextInt();
		if (Choixsuspect>=0 && Choixsuspect<6)
			Hypothese.add(suspect.get(Choixsuspect));
		else
			Hypothese.add(suspect.get(0)); //suspect pris par défaut si le joueur rentre une donnée erronée
		
		return Hypothese;
	}
	
	public String DeplacementparHypothese(String position, List<String> Hypothese) {
		if (personnage==Hypothese.get(2))
			position = Hypothese.get(1);
		return position;
	}
	
	public String MontrerCarte(List<String> Hypothese, String Nom, int NumeroJoueur) {
		System.out.println(Nom + " vous demande les cartes : "+ Hypothese);
		String carte = "";
		List<String> CartesAMontrer = new LinkedList<String>();
		for (int i=0;i<3;i++) {
		if (this.main.contains(Hypothese.get(i)))
			CartesAMontrer.add(Hypothese.get(i)); }
		if (CartesAMontrer.isEmpty())
			System.out.println("je n'ai aucune carte à montrer");
		else if (CartesAMontrer.size()==1) {
			System.out.println("Vous n'avez qu'une carte à montrer.");
			System.out.println("Saisissez un nb pour montrer la carte : " + CartesAMontrer.get(0));
			Scanner Saisie3 = new Scanner(System.in);
			int IndiceAMontrer = Saisie3.nextInt();
				System.out.println("Vous montrez la carte : " + CartesAMontrer.get(0) + " à " + Nom);
				carte=CartesAMontrer.get(0);
			}
			else {
			System.out.println("Veuillez saisir la carte que vous souhaitez montrer (0-" + ((CartesAMontrer.size())-1)  + ") :" + CartesAMontrer);
			Scanner Saisie3 = new Scanner(System.in);
			int IndiceAMontrer = Saisie3.nextInt();
				if (IndiceAMontrer<0 || IndiceAMontrer>(CartesAMontrer.size())-1) { 
					System.out.println("Erreur! Veuillez entrer un nombre correct");
					carte = MontrerCarte(Hypothese,Nom,0);
				}
				else {
					System.out.println("Vous montrez la carte : " + CartesAMontrer.get(IndiceAMontrer) + " à " + Nom);
					carte=CartesAMontrer.get(IndiceAMontrer);
					}
			}
		return carte;
	}

	public void InterpreterCarte(String carte, List<String> Hypothese) {
		
	}
	
	public int FaireAccusation() {
		Scanner Saisie = new Scanner(System.in);
		System.out.println("Voulez vous porter une accusation ? [Oui(0)/Non(1)])");
		int Choix = Saisie.nextInt();
		return Choix;
	}
	
	public void Accusation() {
		Scanner Saisie1 = new Scanner(System.in);
		System.out.println("Veuillez proposer l'arme du crime (0-10): " + this.arme);
		int Choixarme = Saisie1.nextInt();	
		if (Choixarme>=0 && Choixarme<11)
			accusation.add(arme.get(Choixarme));
		else
			accusation.add(arme.get(0)); //arme prise par défaut si le joueur rentre une donnée erronée
		
		Scanner Saisie2 = new Scanner(System.in);
		System.out.println("Veuillez proposer le lieu du crime (0-9): " + this.lieu);
		int Choixlieu = Saisie2.nextInt();	
		if (Choixlieu>=0 && Choixlieu<10)
			accusation.add(lieu.get(Choixlieu));
		else
			accusation.add(lieu.get(0)); //lieu pris par défaut si le joueur rentre une donnée erronée
		
		Scanner Saisie3 = new Scanner(System.in);
		System.out.println("Veuillez proposer le suspect (0-5): " + suspect);
		int Choixsuspect = Saisie3.nextInt();
		if (Choixsuspect>=0 && Choixsuspect<6)
			accusation.add(suspect.get(Choixsuspect));
		else
			accusation.add(suspect.get(0)); //suspect pris par défaut si le joueur rentre une donnée erronée
	}

	public int Gagner(List<String> solution) {
		if (accusation.get(0)==solution.get(0) && accusation.get(1)==solution.get(1) && accusation.get(2)==solution.get(2))
			return 1;
		return 2;
	}
}
