import java.util.List;
import java.util.LinkedList;

public class StrategieBasique extends Strategie{
	
	private List<String> armeMain;
	private List<String> suspectMain;
	private List<String> armePossible;
	private List<String> suspectPossible;
	private String position;
	public StrategieBasique(List<String> ArmeMain, List<String> LieuMain, List<String> SuspectMain, List<String> ArmePossible, List<String> LieuPossible, List<String> SuspectPossible, String Position) {
		super(ArmeMain, LieuMain, SuspectMain, ArmePossible, LieuPossible, SuspectPossible, Position);
		this.armeMain=ArmeMain;
		this.suspectMain=SuspectMain;
		this.armePossible=ArmePossible;
		this.suspectPossible=SuspectPossible;
		this.position=Position;
	}
	
	public List<String> Strategie1() {
		List<String> Hypothese = new LinkedList<String>(); 
		Hypothese.add(armePossible.get((int)(Math.random() * armePossible.size())));
		Hypothese.add(position);
		Hypothese.add(suspectPossible.get((int)(Math.random() * suspectPossible.size())));
		return Hypothese;
	}
	
	public List<String> Strategie2() {
		List<String> Hypothese = new LinkedList<String>(); 
		Hypothese.add(armeMain.get((int)(Math.random() * armeMain.size())));
		Hypothese.add(position);
		Hypothese.add(suspectMain.get((int)(Math.random() * suspectMain.size())));
		return Hypothese;
	}

}
