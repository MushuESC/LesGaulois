package personnages;
/**
 * @author Simon
 *
 */
public class Ronin extends Humain {

	private int honneur;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.honneur=1;
	}
	
	public void donner(Commercant beneficiaire) {
		int sous = this.getArgent()/10;
		String texte = beneficiaire.getNom();
		texte += " prends ces ";
		texte += sous;
		texte += " sous.";
		parler(texte);
		beneficiaire.recevoir(sous);
		this.perdreArgent(sous);
	}
	
	public void provoquer(Yakuza yakuza) {
		String texte = "Je t'ai retrouv� vermine, tu vas payer pour ce que tu as fait � ce pauvre marchand!";
		parler(texte);
		if (this.honneur*2 >= yakuza.getReputation()) {
			honneur++;
			texte = "Je t'ai eu petit yakuza!";
			parler(texte);
			this.gagnerArgent(yakuza.getArgent());
			yakuza.perdre();
		} 
	
		
	}

}