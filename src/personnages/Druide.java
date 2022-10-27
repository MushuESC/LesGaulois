/**
 * 
 */

package personnages;

import java.util.Random;

/**
 * @author Simon
 *
 */
public class Druide extends Humain {
	private int forcePotion =1;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax,String boisson, int argent) {
		super(nom,boisson,argent);
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force "
				+ effetPotionMin + " � "
				+ effetPotionMax + ".");
	}
	
	public void preparerPotion() {
		Random rand = new Random();
		this.forcePotion = rand.nextInt(effetPotionMax);
		if (forcePotion > 7) {
			parler("J'ai pr�par� une super potion de force " + forcePotion);
		}else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force "
					+ forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Ob�lix")) {
			this.parler("Non, Ob�lix !... Tu n�auras pas de potion magique !");
		}else {
			gaulois.boirePotion(this.forcePotion);
		}
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	@Override
	public String prendreParole() {
		return "Le druide " + this.getNom() + " : ";
	}
	
	public static void main(String[] args) {
		/*Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();*/
	}
}