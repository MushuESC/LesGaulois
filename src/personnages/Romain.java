/**
 * 
 */
package personnages;

/**
 * @author prn3318a
 *
 */
public class Romain extends Humain {
	private String texte;
	private int force;
	private Equipement[] listeEquipement;
	private int nbEquipement;

	public Romain(String nom, int force,String boisson, int argent) {
		super(nom,boisson,argent);
		this.force = force;
		assert force>0;
		this.listeEquipement=new Equipement[2];
		this.nbEquipement = 0;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	@Override
	public String prendreParole() {
		return "Le romain " + this.getNom() + " : ";
	}
	
	//
	//m�thode ajout�e pour TP3
	//
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminu�
		assert force < oldForce;
		return equipementEjecte;
		}
	
	//
	//m�thode ajout�e pour TP3
	//
	
	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((listeEquipement[i] != null &&
					listeEquipement[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}
	
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[this.nbEquipement];
			System.out.println("L'�quipement de " + this.getNom() + " s'envole sous la force du coup.");
			int nbEquipementEjecte = 0;
			for (int i = 0; i < this.nbEquipement; i++) {
				if (listeEquipement[i] != null) {
					equipementEjecte[nbEquipementEjecte] = listeEquipement[i];
					nbEquipementEjecte++;
					listeEquipement[i] = null;
				}
			}
		return equipementEjecte;
		}
		

//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int forceInit = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force<forceInit;
//	}
	
	private String ajouterEquipement(Equipement equipement, String texte) {
		this.listeEquipement[this.nbEquipement]=equipement;
		this.nbEquipement++;
		texte += " s'�quipe avec un " + equipement.getEquipement() + "!";
		return texte;
	}
	
	public String sEquiper(Equipement equipement) {
		String texte = "Le soldat ";
		texte+=this.getNom();
		switch (this.nbEquipement) {
		case 2: {
			texte+= " est d�j� bien prot�g�!";
			return texte;
		}
		case 1: if (this.listeEquipement[this.nbEquipement-1]==equipement) {
			texte+= " a d�j� un " + equipement.getEquipement() + "!";
			return texte;
		}else {
			return ajouterEquipement(equipement,texte);
		}
		case 0:
			return ajouterEquipement(equipement,texte);
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.nbEquipement);
		}
	}
	
	public static void main(String[] args) {
		/*Romain romain = new Romain("Minus", 6);
		System.out.println(romain.prendreParole());
		System.out.println(romain.sEquiper(Equipement.CASQUE));
		System.out.println(romain.sEquiper(Equipement.CASQUE));
		System.out.println(romain.sEquiper(Equipement.BOUCLIER));
		System.out.println(romain.sEquiper(Equipement.CASQUE));
		romain.parler("Je vais te d�truire!");
		romain.recevoirCoup(4);
		romain.recevoirCoup(5);*/
	}
}