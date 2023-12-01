package classes;

import java.util.ArrayList;
import java.util.List;

public class Ecole {
	private String nom;
    private List<Etudiant> listeEtudiants;
    
    public Ecole(String nom) {
        this.nom = nom;
        this.listeEtudiants = new ArrayList<>(500);
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}
    
    public int rechercherEtudiant(Etudiant e) {
        for (int i = 0; i < listeEtudiants.size(); i++) {
            if (listeEtudiants.get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }
        
    public void ajouterEtudiant(Etudiant etudiant) {
        if (!listeEtudiants.contains(etudiant)) {
            listeEtudiants.add(etudiant);
            System.out.println("Étudiant ajouté à l'école : " + etudiant.getNom() + " " + etudiant.getPrenom());
        } else {
            System.out.println("Impossible d'ajouter l'étudiant. Il est déjà inscrit à l'école !");
        }
    }
    
    public float getMoyenneDes3A() {
        int count = 0;
        float totalMoyenne = 0;

        for (Etudiant etudiant : listeEtudiants) {
            if (etudiant instanceof Etudiant3eme) {
                totalMoyenne += etudiant.getMoyenne();
                count++;
            }
        }
        return (count != 0) ? totalMoyenne / count : 0;
    }
    
    public float moyenneSalaireAlternants() {
        int count = 0;
        int totalSalaire = 0;

        for (Etudiant etudiant : listeEtudiants) {
            if (etudiant instanceof EtudiantAlternance) {
                totalSalaire += ((EtudiantAlternance) etudiant).getSalaire();
                count++;
            }
        }
        return (count != 0) ? totalSalaire / (float) count : 0;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Ecole : " + nom + "\n");

        for (Etudiant etudiant : listeEtudiants) {
            result.append(etudiant.toString()).append("\n");
        }

        return result.toString();
    }
    
    public void changerEcole(Etudiant etd, Ecole nouvelleEcole) {
        int indiceEtudiant = listeEtudiants.indexOf(etd);
        if (indiceEtudiant != -1) {
            listeEtudiants.remove(indiceEtudiant);
            nouvelleEcole.ajouterEtudiant(etd);
            System.out.println("Étudiant " + etd.getNom() + " " + etd.getPrenom() +
                    " a changé d'école de " + this.nom + " à " + nouvelleEcole.getNom());
        } else {
            System.out.println("Étudiant non trouvé dans cette école !");
        }
    }    
}
