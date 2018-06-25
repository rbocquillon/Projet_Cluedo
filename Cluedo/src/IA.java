import java.util.List;
import java.util.LinkedList;
public class IA extends Joueur {

	private List<String> main;
	private String personnage;
	private List<String> armeMain;
	private List<String> lieuMain;
	private List<String> suspectMain;
	private List<String> armePossible;
	private List<String> lieuPossible;
	private List<String> suspectPossible;
	private int NumeroJoueur;
	private int[][] CartesMontrees=new int[4][6];
	private int type;
	
 	public IA(Deck deck, List<String> Main, String Personnage, int numeroJoueur, int type) {
		super(deck, Main, Personnage,numeroJoueur, type);
		this.type=1;
		this.NumeroJoueur=numeroJoueur;
		this.main=Main;
		this.personnage=Personnage;
		this.armePossible = new LinkedList<String>();
		armePossible.addAll(deck.getArme());
		this.lieuPossible = new LinkedList<String>();
		lieuPossible.addAll(deck.getLieu());
		this.suspectPossible = new LinkedList<String>();
		suspectPossible.addAll(deck.getSuspect());
		this.armeMain = new LinkedList<String>();
		this.lieuMain = new LinkedList<String>();
		this.suspectMain = new LinkedList<String>();

 		for(int i = 0; i< this.main.size(); i++) {
 			String carte = main.get(i);
 			if (deck.getArme().contains(carte)) {
 				armeMain.add(carte);
 				armePossible.remove(carte);
 			}
 			else if (deck.getLieu().contains(carte)) {
 				lieuMain.add(carte);
 				lieuPossible.remove(carte);
 			}
 			else if (deck.getSuspect().contains(carte)) {
 				suspectMain.add(carte);
 				suspectPossible.remove(carte);
 			}	
 		}
 	}


	public List<String> getArmeMain() {
		return armeMain;
	}

	public void setArmeMain(List<String> armeMain) {
		this.armeMain = armeMain;
	}

	public List<String> getLieuMain() {
		return lieuMain;
	}

	public void setLieuMain(List<String> lieuMain) {
		this.lieuMain = lieuMain;
	}

	public List<String> getSuspectMain() {
		return suspectMain;
	}

	public void setSuspectMain(List<String> suspectMain) {
		this.suspectMain = suspectMain;
	}

	public List<String> getArmePossible() {
		return armePossible;
	}

	public void setArmePossible(List<String> armePossible) {
		this.armePossible = armePossible;
	}

	public List<String> getLieuPossible() {
		return lieuPossible;
	}

	public void setLieuPossible(List<String> lieuPossible) {
		this.lieuPossible = lieuPossible;
	}

	public List<String> getSuspectPossible() {
		return suspectPossible;
	}

	public void setSuspectPossible(List<String> suspectPossible) {
		this.suspectPossible = suspectPossible;
	}
 	
	@Override
	public String ChoixDeplacement(String lieu1, String lieu2, String lieu3) {
		Strategie strategie = new Strategie(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, "");
		int Choix = 0;
		if (armePossible.size()>1 || suspectPossible.size()>1) {
			Choix = strategie.Deplacement1(lieu1, lieu2, lieu3);
		}
		else {
			Choix = strategie.Deplacement2(lieu1, lieu2, lieu3);
		}
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
		    choix=ChoixDeplacement(lieu1, lieu2, lieu3);
		}
		return choix;
	}

	@Override
	public List<String> FormulerHypothese(String position){
		List<String> Hypothese;
		StrategieBasique strategiebasique = new StrategieBasique(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, position);
		Strategie strategie = new Strategie(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, position);
		if (lieuPossible.contains(position)) {
			Hypothese = strategie.StrategieLieuPossible();
		}
		else if (lieuMain.contains(position)){
			Hypothese = strategie.StrategieLieuMain();
		}
		else {
			Hypothese = strategiebasique.Strategie1();
		}
			
		return Hypothese;
	}

	@Override
	public String MontrerCarte(List<String> Hypothese, String Nom, int NumeroJoueur) {
		System.out.println(Nom + " demande les cartes : "+ Hypothese);
		String carte = "";
		List<String> CartesAMontrer = new LinkedList<String>();
		for (int i=0;i<3;i++) {
		if (this.main.contains(Hypothese.get(i)))
			CartesAMontrer.add(Hypothese.get(i)); }
		if (CartesAMontrer.isEmpty())
			System.out.println(this.personnage + " n'a aucune carte à montrer");
		else if (CartesAMontrer.size()==1) {
			System.out.println(this.personnage + " montre une carte.");
			this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(0))]=1;
			carte=CartesAMontrer.get(0);
			}
			else {
				int i=CartesAMontrer.size();
				if (i==2) {
					if (this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(0))]==1)
						{carte=CartesAMontrer.get(0);
						 System.out.println(this.personnage + " montre une carte."); }
					else {
						if (this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(1))]==1)
							{carte=CartesAMontrer.get(1);
							 System.out.println(this.personnage + " montre une carte."); }
						else {
							System.out.println(this.personnage + " montre une carte.");
							int AuPif =(int)(Math.random() * 2);
							this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(AuPif))]=1;
							carte=CartesAMontrer.get(AuPif);
						}
					}
				}
				else {      // size = 3 
					if (this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(0))]==1)
						{carte=CartesAMontrer.get(0);
						 System.out.println(this.personnage + " montre une carte."); }
					else {
						if (this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(1))]==1)
							{carte=CartesAMontrer.get(1);
							System.out.println(this.personnage + " montre une carte."); }
						else {
							if (this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(2))]==1)
								{carte=CartesAMontrer.get(2);
								 System.out.println(this.personnage + " montre une carte."); }
							else {
								System.out.println(this.personnage + " montre une carte.");
								int AuPif =(int)(Math.random() * 3);
								this.CartesMontrees[NumeroJoueur][this.main.indexOf(CartesAMontrer.get(AuPif))]=1;
								carte=CartesAMontrer.get(AuPif);
							}
						}
					}
				}
			}
		return carte;
	}
	
	@Override
	public void InterpreterCarte(String carte, List<String> Hypothese) {
		if (armePossible.contains(carte) ) {
				armePossible.remove(carte);
		}
		else if (lieuPossible.contains(carte)) {
				lieuPossible.remove(carte);
		}
		else if (suspectPossible.contains(carte)) {
				suspectPossible.remove(carte);
		}
		else if (carte=="") {
			if (!armeMain.contains(Hypothese.get(0))) {
				int longueur1 = armePossible.size();
				for (int i=0; i<longueur1;i++) {
					armePossible.remove(0);
				}
				armePossible.add(Hypothese.get(0));
			}
			if (!lieuMain.contains(Hypothese.get(1))) {
				int longueur2 = lieuPossible.size();
				for (int i=0; i<longueur2;i++) {
					lieuPossible.remove(0);
				}
				lieuPossible.add(Hypothese.get(1));
			}
			if (!suspectMain.contains(Hypothese.get(2))) {
				int longueur3 = suspectPossible.size();
				for (int i=0; i<longueur3;i++) {
					suspectPossible.remove(0);
				}
				suspectPossible.add(Hypothese.get(2));
			}
		}
	}

	@Override
	public int Gagner(List<String> solution) { //paramètre inutile mais obligation d'avoir un override
		if (armePossible.size()==1 && lieuPossible.size()==1 && suspectPossible.size()==1)
			return 1;
		return 0;
	}
}
