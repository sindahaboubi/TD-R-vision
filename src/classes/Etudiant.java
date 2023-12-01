package classes;

import java.util.Objects;

public abstract class Etudiant {
	private int identifiant;
	private String nom;
	private String prenom;
	private float moyenne;
	
	public Etudiant(int identifiant, String nom, String prenom, float moyenne) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.moyenne = moyenne;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Etudiant etudiant = (Etudiant) obj;

        return identifiant == etudiant.identifiant &&
               Objects.equals(nom, etudiant.nom);
    }    
    
    @Override
    public String toString() {
        return "Etudiant{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }
    
    public abstract void ajouterUneAbsence();
}
