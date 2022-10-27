package histoire;
import personnages.*;

/**
 * @author Simon
 *
 */

public class HistoireTP4 {
	
public static void main(String[] args) {
	
	Humain prof = new Humain ("Prof", "kombucha", 54);
	prof.acheter("une boisson", 12);
	prof.boire();
	prof.acheter("un jeu", 2);
	prof.acheter("un kimono", 50);
	Commercant marco = new Commercant("Marco", 15);
	marco.seFaireExtorquer();
	marco.recevoir(15);
	marco.boire();
	Yakuza yaku = new Yakuza("Yaku le Noir", "whisky", 30, "Warsong");
	yaku.direBonjour();
	yaku.extorquer(marco);
	Ronin roro = new Ronin("Roro", "shochu", 60);
	roro.donner(marco);
}

}