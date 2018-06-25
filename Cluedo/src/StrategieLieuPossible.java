import java.util.List;
import java.util.LinkedList;

public class StrategieLieuPossible extends Strategie {
	
	private List<String> armeMain;
	private List<String> suspectMain;
	private List<String> armePossible;
	private List<String> suspectPossible;
	private List<String> lieuPossible;
	private List<String> lieuMain;
	private List<Integer> strategieLieuPossible;
	private String position;
	private StrategieBasique strategiebasique;
	
	public StrategieLieuPossible(List<String> ArmeMain, List<String> LieuMain, List<String> SuspectMain, List<String> ArmePossible, List<String> LieuPossible, List<String> SuspectPossible, String Position, List<Integer> strategieLieuPossible) {
		super(ArmeMain, LieuMain, SuspectMain, ArmePossible, LieuPossible, SuspectPossible, Position);
		this.armeMain=ArmeMain;
		this.lieuMain=LieuMain;
		this.suspectMain=SuspectMain;
		this.armePossible=ArmePossible;
		this.lieuPossible=LieuPossible;
		this.suspectPossible=SuspectPossible;
		this.position=Position;
		this.strategieLieuPossible=strategieLieuPossible;
		strategiebasique = new StrategieBasique(armeMain, lieuMain, suspectMain, armePossible, lieuPossible, suspectPossible, position);
	}
	
	
	public List<String> Strategie1() {
		List<String> Hypothese = new LinkedList<String>(); 
		if (armePossible.size()>1 && suspectMain.size()>0) {
			Hypothese.add(armePossible.get((int)(Math.random() * armePossible.size())));              
            Hypothese.add(position);
            Hypothese.add(suspectMain.get((int)(Math.random() * suspectMain.size())));
		}
        else {
        	Hypothese = strategiebasique.Strategie1();
            strategieLieuPossible.remove(new Integer(0));
        }
		return Hypothese;
	}
	
	public List<String> Strategie2() {
		List<String> Hypothese = new LinkedList<String>(); 
		if (armeMain.size()>0 && suspectPossible.size()>1) {
			Hypothese.add(armeMain.get((int)(Math.random() * armeMain.size())));              
            Hypothese.add(position);
            Hypothese.add(suspectPossible.get((int)(Math.random() * suspectPossible.size())));
		}
        else {
        	Hypothese = strategiebasique.Strategie1();
            strategieLieuPossible.remove(new Integer(1));
        }
		return Hypothese;
	}

	public List<String> Strategie3() {
		List<String> Hypothese = new LinkedList<String>(); 
		if (armeMain.size()>0 && suspectMain.size()>0) {
			Hypothese.add(armeMain.get((int)(Math.random() * armeMain.size())));              
            Hypothese.add(position);
            Hypothese.add(suspectMain.get((int)(Math.random() * suspectMain.size())));
		}
        else {
        	Hypothese = strategiebasique.Strategie1();
            strategieLieuPossible.remove(new Integer(2));
            strategieLieuPossible.remove(new Integer(3));
        }
		return Hypothese;
	}
}
