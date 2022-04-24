
public class Etudiant extends Filiere {
     
    private int id_etudiant;
    private String nom;
    private String prenom;
    
    Filiere fil;
    
    public Etudiant() {
    }
  
	public Etudiant(int id, String nom, String prenom, Filiere f) {
		this.id_etudiant = id;
		this.nom = nom;
		this.prenom = prenom;
		this.fil = f;
	
	}
	public void setfiliere(Filiere f) {
    	fil = (Filiere) f;
    }
    public Filiere getfiliere() {
    	return fil;
    }
    public String getFil(Filiere fil) {
    	return fil.getDescription();
    }
 
    public int getIdEtudiant() {
        return id_etudiant;
    }
 
    public void setIdEudiant(int id) {
        this.id_etudiant = id;
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
	@Override
	public String toString() {
		return "Etudiant [id_etudiant=" + id_etudiant + ", nom=" + nom + ", prenom=" + prenom + ", filiere=" + fil
				+ "]";
	}
	
	

	
 
}