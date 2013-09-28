package utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOPush {
	private String PARAM_CONEXION_SERVER = "localhost:3306"; //
	private String PARAM_CONEXION_DB = "push";
	private String PARAM_CONEXION_USER = "root";
	private String PARAM_CONEXION_PWD = "23121984";
	
	private Connection conexion = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private StringBuilder query  = null;
	
	private ArrayList<String> disp = new ArrayList<String>();
	
	
	
	 private Statement obtieneConexion () throws SQLException, ClassNotFoundException{
		    
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conexion = DriverManager.getConnection("jdbc:mysql://"+PARAM_CONEXION_SERVER+"/"+PARAM_CONEXION_DB, PARAM_CONEXION_USER, PARAM_CONEXION_PWD);
	    	statement = conexion.createStatement();
			return statement;
	    }
	    
	    
	    private void cierraConexion(){
	    	try {
	    		 if (conexion != null && !conexion.isClosed()) {
	    	         	resultSet.close();
	    	         	statement.close();
	    	             conexion.close();
	    	         }
	        } catch (SQLException sqle) {
				// TODO: handle exception
			}
	    	
	    }
	    
	    
	    public boolean IngresaDatos(String datos) throws SQLException {
			 
		    try {
		    	
		    	statement = obtieneConexion();
	            StringBuilder query = new StringBuilder("Insert into mobiles (key_android)");
	            query.append("VALUES('").append(datos+"')");
		    	statement.execute(query.toString());
		    	System.out.println("Se registro correctamente: "+datos);
	            
		    	
		    } catch (SQLException sqle) {
		        sqle.printStackTrace(System.out);
		    } catch (Exception e) {
		        e.printStackTrace(System.out);
		    } finally {
		    	cierraConexion();
		    }
		    return false;
		}
	    
	    public ArrayList<String> ObtieneDatos() throws SQLException {
	    	
		    try {
		    	StringBuilder query = new StringBuilder("select * from tbdis001;");
		    	statement = obtieneConexion();
		    	resultSet = statement.executeQuery(query.toString());
		    	
	          while (resultSet.next())

	          {  

	                  String nombre = resultSet.getString("reg_id");
	                  disp.add(nombre);
	                  
	          }
	          
	          
		    	
		    } catch (SQLException sqle) {
		        sqle.printStackTrace(System.out);
		    } catch (Exception e) {
		        e.printStackTrace(System.out);
		    } finally {
		    	cierraConexion();
		    }
		    return disp;
		}

}
