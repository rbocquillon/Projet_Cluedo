import java.util.LinkedList;
import java.util.List;

public class Deck {

	private List<String> arme;
	private List<String> lieu;
	private List<String> suspect;
	
	public Deck(){
		this.arme=new LinkedList<String>();
		arme.add("Couteau");
		arme.add("Corde");
    	arme.add("Sarin");
    	arme.add("Pistolet");
    	arme.add("Queue de Billard");
    	arme.add("Po�le");
    	arme.add("Club de Golf");
    	arme.add("Tisonnier");
    	arme.add("Stylo Plume");
    	arme.add("Halt�re");
    	arme.add("Bouteille de vin");
		this.lieu=new LinkedList<String>();
		lieu.add("Cuisine");
		lieu.add("Hall");
    	lieu.add("Salon");
    	lieu.add("Salle � Manger");
    	lieu.add("Chambre");
    	lieu.add("Bureau");
    	lieu.add("Salle de billard");
    	lieu.add("Salle de Bain");
    	lieu.add("V�randa");
    	lieu.add("Salle de Sport");
		this.suspect=new LinkedList<String>();
		suspect.add("Major Mayo");
		suspect.add("Mme Bleuet");
    	suspect.add("Dr Pistache");
    	suspect.add("Mlle Cam�lia");
    	suspect.add("Prof Mauve");
    	suspect.add("Mme Gypse");
	}
	
	public List<String> getArme() {
		return arme;
	}

	public List<String> getLieu() {
		return lieu;
	}

	public List<String> getSuspect() {
		return suspect;
	}

}
