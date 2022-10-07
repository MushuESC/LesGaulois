package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] listeEquipement;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>0;
		this.listeEquipement=new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int forceInit = force;
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		assert force<forceInit;
	}
	
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
		Romain romain = new Romain("Minus", 6);
		System.out.println(romain.prendreParole());
		System.out.println(romain.sEquiper(Equipement.CASQUE));
		System.out.println(romain.sEquiper(Equipement.CASQUE));
		System.out.println(romain.sEquiper(Equipement.BOUCLIER));
		System.out.println(romain.sEquiper(Equipement.CASQUE));
		romain.parler("Je vais te d�truire!");
		romain.recevoirCoup(4);
		romain.recevoirCoup(5);
	}
}
