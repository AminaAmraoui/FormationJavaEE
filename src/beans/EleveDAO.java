package beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ConnectionManager;
import beans.Eleve;

public class EleveDAO {
	private Connection connection;
	
	public EleveDAO(){
		connection=ConnectionManager.getConnection();
	}
	
	public void AjoutEleve(Eleve eleve){
		
		try{ 
			 connection = ConnectionManager.getConnection();
			 PreparedStatement ps=connection.prepareStatement("insert into eleve values(?,?,?)");  
			 ps.setInt(1,eleve.getId());  
			 ps.setString(2,eleve.getNom());  
			 ps.setString(3,eleve.getPrenom());  
			               
			 ps.executeUpdate();  
			 }catch(Exception e){}  
	}
	
	public void SupprEleve(int EleveId){
		try {
			connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from eleve where id=?");
            
            preparedStatement.setInt(1, EleveId);
            preparedStatement.executeUpdate();
  
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void UpdateEleve(Eleve eleve){
		 try {
			 connection = ConnectionManager.getConnection();
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update eleve set nom=?, prenom=?" +
	                            "where id=?");
	           
	            preparedStatement.setInt(3, eleve.getId());
	            preparedStatement.setString(1, eleve.getNom());
	            preparedStatement.setString(2, eleve.getPrenom());
	           
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	public List<Eleve> getAllEleve(){
		List<Eleve> eleves = new ArrayList<Eleve>();
        try {
        	connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from eleve");
            while (rs.next()) {
                Eleve eleve = new Eleve();
                eleve.setId(rs.getInt("id"));
                eleve.setNom(rs.getString("nom"));
                eleve.setPrenom(rs.getString("prenom"));
               
                eleves.add(eleve);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eleves;
	}
	
	public Eleve getEleveById(int id){
		Eleve eleve = new Eleve();      
	      
	    try {
	    	connection = ConnectionManager.getConnection();
	       ResultSet result = connection.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE id = " + id);
	      if(result.first())
	        eleve = new Eleve(
	          id,
	          result.getString("nom"),
	          result.getString("prenom"
	        ));         
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return eleve;
	}
}
