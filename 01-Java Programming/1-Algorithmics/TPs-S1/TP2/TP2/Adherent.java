package TP2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Adherent extends Personne{
	private int codeAdherent;
	private Date dateAdhesion;
	private static int nbreAdherents=0;
	
	public Adherent(String nom, String prenom, Date dateAdhesion) {
		super(nom,prenom);
		this.dateAdhesion=dateAdhesion;
		this.codeAdherent=++Adherent.nbreAdherents;
	}
	public Adherent(String nom, String prenom) {
		this(nom,prenom,new Date());
	}
	
	public int getCodeAdherent() {
		return codeAdherent;
	}
	public void setCodeAdherent(int codeAdherent) {
		this.codeAdherent = codeAdherent;
	}
	public Date getDateAdhesion() {
		return dateAdhesion;
	}
	public void setDateAdhesion(Date dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		return super.toString()+"_"+this.getCodeAdherent()+" "+sdf.format(this.getDateAdhesion());
	}
	@Override
	public int hashCode() {
		return Objects.hash(codeAdherent);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adherent other = (Adherent) obj;
		return codeAdherent == other.codeAdherent;
	}
	
}
