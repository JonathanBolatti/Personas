package daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	
	private String user = "root";
	private String password = "root";
	private String schema = "personas"; //aca debemos colocar siempre el nombre de la base de datos que vamos a usar (scrip)

	//metodo para hacer la conexion a la base de datos
	public void conectarse() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*acá construimos el url que nos va permitir
			  conectarnos con la base de datos*/
			String url = "jdbc:mysql://localhost:3306/" + schema + "?useSSL=false";
			/*Acá usamos el DriverManager para hacer la conexion con el servidor
			y la base de datos*/
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new SQLException("Hubo un error al conectarse con la base de datos");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			throw new ClassCastException("No se encontro la Clase Driver");
		}
	}
	
	public void desconectarse() throws SQLException{
		try {
			if(resultSet != null){
				resultSet.close();
			}
			if(statement != null){
				statement.close(); 
			}
			if(connection != null){
				connection.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Ocurrio un Error al intentar desconectarse"); 
			
		}
	}
	
	// ABM Alta Baja Modificación
   // CRUD Create Read Update Delete
   public void insertarModificarEliminar(String query) throws ClassNotFoundException, SQLException {
        try {
          conectarse();
            try {
                statement = connection.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new SQLException("Ocurrio un error al intentar hacer un CRUD");
            } finally {
                desconectarse();
            }
        } catch (Exception e) {
            throw e;
        } finally {
                desconectarse();
        }
   }
   
   public void consultar(String query) throws SQLException, ClassNotFoundException {
        
        try {
            conectarse();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Ocurrio un error al intentar hacer la consulta");
        } 
   }

}// fin class
