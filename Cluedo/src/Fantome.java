import java.util.LinkedList;
import java.util.List;

public class Fantome extends Joueur{

	private int type;
	public Fantome(Deck deck, List<String> Main, String Personnage, int Numerojoueur, int type) {
		super(deck, Main, Personnage, Numerojoueur, type);
		this.type=type;
	}
	
	@Override
	public String Deplacement(String position) {
		return position;
	}

	@Override
	public List<String> FormulerHypothese(String position){
		List<String> Hypothese = new LinkedList<String>();	
		return Hypothese;
	}
	
	@Override
	public void InterpreterCarte(String carte, List<String> Hypothese) {
	}
	
	@Override
	public int Gagner(List<String> solution) {
		return 0;
	}
}
