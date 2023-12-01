package classes;

public class EtudiantAlternance extends Etudiant {
	private int salaire;
	
    public EtudiantAlternance(int identifiant, String nom, String prenom, float moyenne, int salaire) {
        super(identifiant, nom, prenom, moyenne);
        this.salaire = salaire;
    }

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
    @Override
    public void ajouterUneAbsence() {
        setMoyenne(getSalaire() - 0.5f);
        System.out.println("0.5 point de la moyenne de l'étudiant du 3ème est enlevé ");
    }

    @Override
    public String toString() {
        return "EtudiantAlternance{" +
                "identifiant=" + getIdentifiant() +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", moyenne=" + getMoyenne() +
                ", salaire=" + salaire +
                '}';
    }    

}
