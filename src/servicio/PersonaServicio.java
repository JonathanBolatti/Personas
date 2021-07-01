package servicio;

import daos.PersonaDao;
import entidades.Persona;
import java.sql.SQLException;
import java.util.List;

public class PersonaServicio {

	PersonaDao personaDao = new PersonaDao();

	public void crear(Persona persona) throws ClassNotFoundException, SQLException, Exception {
		//aca validamos el que id no sea nulo
		if (persona.getId() == null) {
			throw new Exception("El id no puede ser nulo");
		}
		// aca validamos que el nombre no sea nulo
		if (persona.getNombre() == null) {
			throw new Exception("EL nombre no puede ser nulo");
		}
		if (personaDao.buscarPorId(persona.getId()) != null) {
			throw new Exception("Ya existe una persona con ese id");
		}
		//Aca vamos a llamar a la personaDAO para que inserte nuestro 
		//objeto Persona en la base de datos personaDao.crear(persona); 
		personaDao.crear(persona);
	}

	public void eliminar(Persona persona) throws ClassNotFoundException, SQLException {
		personaDao.eliminar(persona);

	}

	public void modificar(Persona persona) throws ClassNotFoundException, SQLException {
		personaDao.modificar(persona);
	}

	public void listarPersonas() throws SQLException, ClassNotFoundException {
		// llamamos al listar persona de personaDAO
		List<Persona> personas = personaDao.listarPersonas();
		//Utilizamos un for para mostrar por pantalla la lista de Personas
		for (Persona persona1 : personas) {
			System.out.println("id: " + persona1.getId() + " | nombre: " + persona1.getNombre());
		}
	}

	public void buscarUnaPersona(Persona persona) throws SQLException, ClassNotFoundException {
		persona = personaDao.buscarPorId(persona.getId());
		System.out.println("id: " + persona.getId() + " | nombre: " + persona.getNombre());
		
	}

}
