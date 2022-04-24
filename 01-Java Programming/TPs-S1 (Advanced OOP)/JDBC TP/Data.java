
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Data {
	ResultSet rs = null;
	PreparedStatement st = null;
	
	
	public Data() {	
	}
    private Connection connexion() { 
    	Connection connect = null;
	    String url = "jdbc:mysql://localhost:3306/inpt";
		
		try {
			connect = DriverManager.getConnection(url,"root","2201");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de connexion");
		}
		return connect;
	}
    public ArrayList<Filiere> listeFiliere(){
    	ArrayList<Filiere> listFiliere = new ArrayList<Filiere>();
    	Connection con = this.connexion();
    	
    	String select =" SELECT description FROM filiere";
    	try {
    		st = con.prepareStatement(select);
    		rs = st.executeQuery(select);
    		while(rs.next()) {
    			Filiere fil = new Filiere();
    			//fil.setId_filiere(rs.getInt("id_filiere"));
    			fil.setDescription(rs.getString("description"));
    			listFiliere.add(fil);
    		}
    		st.close();
    		con.close();
    	}
    	catch(SQLException ex) {
    		ex.printStackTrace();
    		System.out.println("Erreur au niveau BD filiere");		
    	}
    	
    	return listFiliere;
    }
    public ArrayList<Etudiant> listeEtudiant() throws Exception{
    	ArrayList<Etudiant> ListEtudiant = new ArrayList<Etudiant>();
    	Connection con = this.connexion();
    	
    	String select = "select etudiant.nom AS Nom , etudiant.id_etudiant AS ID,  etudiant.prenom AS Prenom , filiere.description AS Filiere  from etudiant join filiere on etudiant.filiere = filiere.id_filiere; ";
    	try {
    		st = con.prepareStatement(select);
    		rs =st.executeQuery();
    		while(rs.next()) {
    			Etudiant etud = new Etudiant();
    			Filiere fili =  new Filiere();
    			etud.setIdEudiant(rs.getInt("ID"));
    			etud.setNom(rs.getString("Nom"));
    			etud.setPrenom(rs.getString("Prenom"));
    			fili.setDescription(rs.getString("Filiere"));
    			etud.setfiliere(fili);
    			ListEtudiant.add(etud);
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("Erreur au niveau BD etudiant");
    	}
    	return ListEtudiant;
    }
    public void ajouterEtudiant(Etudiant etudiant) {
    	Connection con = this.connexion();
    	
    	String insert = "INSERT INTO etudiant (id_etudiant, nom, prenom, filiere) VALUES(?,?,?,?)";     
    	try {
            st = con.prepareStatement(insert);
            st.setInt(1, etudiant.getIdEtudiant());
            st.setString(2, etudiant.getNom());
            st.setString(3, etudiant.getPrenom());
            st.setInt(4, etudiant.getfiliere().getId_filiere());
            st.executeUpdate();
        }
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public void supprimerEtudiant(Etudiant etudiant) {
    	Connection con = this.connexion();
    	String delete =  "DELETE FROM etudiant WHERE id_etudiant = ? ";
    	
    	try {
            st = con.prepareStatement(delete);
            st.setInt(1, etudiant.getIdEtudiant());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    public Etudiant rechercherEtudiant(int numEtudiant) throws Exception{
    	Connection con = this.connexion();
    	String find = "SELECT etudiant.id_etudiant AS ID , etudiant.nom AS Nom, etudiant.prenom AS Prenom, filiere.description AS Filiere FROM etudiant JOIN filiere ON etudiant.id_etudiant = ?  WHERE etudiant.filiere = filiere.id_filiere ";
    	Etudiant etud = new Etudiant();
    	try {
    		st = con.prepareStatement(find);
    		st.setInt(1,numEtudiant);
    		rs =st.executeQuery();	
    		
			Filiere fili =  new Filiere();
			rs.next();
			etud.setIdEudiant(rs.getInt("ID"));
			etud.setNom(rs.getString("Nom"));
			etud.setPrenom(rs.getString("Prenom"));
			fili.setDescription(rs.getString("Filiere"));
			etud.setfiliere(fili);
    	}
    	catch(SQLException e) {
    		
    	}
    	return etud;
    }
  
    
}
