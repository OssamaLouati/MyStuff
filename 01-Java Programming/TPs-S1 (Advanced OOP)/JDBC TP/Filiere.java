

public class Filiere {
	public int id_filiere;
	public String description;
	
	public Filiere() {
	}
	public int getId_filiere() {
		return id_filiere;
	}
	public void setId_filiere(int id_filiere) {
		this.id_filiere = id_filiere;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return description ;
	}
	



}
