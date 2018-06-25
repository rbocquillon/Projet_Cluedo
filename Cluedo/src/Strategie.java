import java.util.LinkedList;
import java.util.List;

public class Strategie {

	private List<String> armeMain;
	private List<String> lieuMain;
	private List<String> suspectMain;
	private List<String> armePossible;
	private List<String> lieuPossible;
	private List<String> suspectPossible;
	private List<Integer> strategieLieuPossible;
	private List<Integer> strategieLieuMain;
	private String position;
	private String[][] TableauVoisins = {
			{"Salon","Chambre","Salle à Manger"},
			{"Chambre","Véranda","Salle de billard"},
			{"Salle de Bain","Cuisine","Salle de billard"},
			{"Cuisine","Salle de billard","Véranda"},
			{"Cuisine","Hall","Salle de Sport"},
			{"Salle de Sport","Salle de Bain","Salle de billard"},
			{"Salon","Salle à Manger","Hall"},
			{"Véranda","Salon","Bureau"},
			{"Hall","Salle à Manger","Salle de Bain"},
			{"Bureau","Chambre","Salle de billard"} };
	
	
	public Strategie(List<String> ArmeMain, List<String> LieuMain, List<String> SuspectMain, List<String> ArmePossible, List<String> LieuPossible, List<String> SuspectPossible, String Position) {
		this.armeMain=ArmeMain;
		this.lieuMain=LieuMain;
		this.suspectMain=SuspectMain;
		this.armePossible=ArmePossible;
		this.lieuPossible=LieuPossible;
		this.suspectPossible=SuspectPossible;
		this.position=Position;
		this.strategieLieuPossible = new LinkedList<Integer>();
		this.strategieLieuMain = new LinkedList<Integer>();
		
		for (int i=0;i<5;i++) {
			strategieLieuPossible.add(i);
		}
		
		for (int i=0;i<5;i++) {
			strategieLieuMain.add(i);
		}
	}
	
	public int Deplacement1(String lieu1, String lieu2, String lieu3) {
		int Choix;
		if (lieuPossible.contains(lieu1))
			Choix = 1;
		else if (lieuPossible.contains(lieu2))
			Choix = 2;
		else if (lieuPossible.contains(lieu3))
			Choix = 3;
		else if (lieuMain.contains(lieu1))
			Choix = 1;
		else if (lieuMain.contains(lieu2))
			Choix = 2;
		else if (lieuMain.contains(lieu3))
			Choix = 3;
		else
			Choix = (int)(Math.random() * 3);
		return Choix;
	}
	
	public int TrouveIndice(String lieu) {
		int indice;
		switch (lieu)
		{ 
			case "Cuisine":
				indice=0;
				break;
			case "Hall":
				indice=1;
				break;
			case "Salon":
				indice=2;
				break;
			case "Salle à Manger":
				indice=3;
				break;
			case "Chambre":
				indice=4;
				break;
			case "Bureau":
				indice=5;
				break;
			case "Salle de billard":
				indice=6;
				break;
			case "Salle de Bain":
				indice=7;
				break;
			case "Véranda":
				indice=8;
				break;
			case "Salle de Sport":
				indice=9;
				break;
			default:
				indice=6;
		}
		return indice;
	}
	
	public int AnticipeIA(String lieu1, String lieu2, String lieu3) {
		int nextRoom=(int)(Math.random() * 3);
		int indice=TrouveIndice(lieu1);
		if (lieuPossible.contains(TableauVoisins[indice][0]) || lieuPossible.contains(TableauVoisins[indice][1]) || lieuPossible.contains(TableauVoisins[indice][2]))
			nextRoom=1;
		else {
			indice=TrouveIndice(lieu2);
			if (lieuPossible.contains(TableauVoisins[indice][0]) || lieuPossible.contains(TableauVoisins[indice][1]) || lieuPossible.contains(TableauVoisins[indice][2]))
				nextRoom=2;
		
			else {
				indice=TrouveIndice(lieu3);
				if (lieuPossible.contains(TableauVoisins[indice][0]) || lieuPossible.contains(TableauVoisins[indice][1]) || lieuPossible.contains(TableauVoisins[indice][2]))
					nextRoom=3;
			}
		}
		return nextRoom;
	}
	
	public int Deplacement2(String lieu1, String lieu2, String lieu3) { // a améliorer!!
		int Choix;
		if (lieuPossible.contains(lieu1))
			Choix = 1;
		else if (lieuPossible.contains(lieu2))
			Choix = 2;
		else if (lieuPossible.contains(lieu3))
			Choix = 3;
		else
			Choix = AnticipeIA(lieu1,lieu2,lieu3);
		return Choix;
	}
	
	public List<String> StrategieLieuPossible(){
		
		List<String> Hypothese = new LinkedList<String>();
		int StrategieP = strategieLieuPossible.get((int)(Math.random() * strategieLieuPossible.size()));
		StrategieBasique strategiebasique = new StrategieBasique(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, position);
		StrategieLieuPossible strategielieupossible = new StrategieLieuPossible(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, position, strategieLieuPossible);
		if (StrategieP==0) {
			Hypothese = strategielieupossible.Strategie1();
		}
		else if(StrategieP==1) {
			Hypothese = strategielieupossible.Strategie2();
		}
		else if(StrategieP==2 || StrategieP==3) {
			Hypothese = strategielieupossible.Strategie3();
		}
		else {
			Hypothese = strategiebasique.Strategie1();
		}
		return Hypothese;
	}
	
	public List<String> StrategieLieuMain(){
		
		List<String> Hypothese = new LinkedList<String>();
		int StrategieM = strategieLieuMain.get((int)(Math.random() * strategieLieuMain.size()));
		StrategieBasique strategiebasique = new StrategieBasique(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, position);
		StrategieLieuMain strategielieumain = new StrategieLieuMain(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, position, strategieLieuMain);
		
		if (StrategieM==0) {
			Hypothese = strategielieumain.Strategie1();	
		}
		else if(StrategieM==1 || StrategieM==2) {
			Hypothese = strategielieumain.Strategie2();
		}
		else if(StrategieM==3 || StrategieM==4) {
			Hypothese = strategielieumain.Strategie3();
		}
		if ((int)(Math.random() * 20)==15 && armeMain.size()>0 && suspectMain.size()>0){
			for (int i=0;i<3;i++)
				Hypothese.remove(0);
			Hypothese = strategiebasique.Strategie2();
		}
	return Hypothese;
	}
}
