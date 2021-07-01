package daos;

import entidades.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao extends Dao {

	public void crear(Persona persona) throws ClassNotFoundException, SQLException {
		String query = "insert into persona values(" + persona.getId() + ",'" + persona.getNombre() + "')";
		insertarModificarEliminar(query);
	}

	public void modificar(Persona persona) throws ClassNotFoundException, SQLException {
		String query = "update persona set nombre = '" + persona.getNombre() + "'where id_persona = " + persona.getId() + "";
		insertarModificarEliminar(query);
	}

	public void eliminar(Persona persona) throws ClassNotFoundException, SQLException {
		String query = "delete from persona where id_persona = " + persona.getId() + "";
		insertarModificarEliminar(query);
	}

	public List<Persona> listarPersonas() throws SQLException, ClassNotFoundException {
		try {
			String query = "SELECT id_persona, nombre FROM persona";
			consultar(query);
			Persona persona = null;
			List<Persona> personas = new ArrayList<>();
			while (resultSet.next()) {
				persona = new Persona();
				persona.setId(Integer.parseInt(resultSet.getString(1)));
				persona.setNombre(resultSet.getString(2));
				personas.add(persona);
			}
			return personas;
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} finally {
			desconectarse();
		}
	}

	public Persona buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
		try {
			String query = "SELECT id_persona, nombre FROM persona WHERE id_persona = " + id + "";
			consultar(query);
			Persona persona = null;
			while (resultSet.next()) {
				persona = new Persona();
				persona.setId(Integer.parseInt(resultSet.getString(1)));
				persona.setNombre(resultSet.getString(2));
			}
			return persona;
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} finally {
			desconectarse();

		}
	}
}//fin class
