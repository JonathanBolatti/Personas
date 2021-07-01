package principal;

import entidades.Persona;
import servicio.PersonaServicio;

public class principalPersona {

	public static void main(String[] args) {

		try {
			//Intanciamos un objetoServicio
			PersonaServicio personaServicio = new PersonaServicio();

			//Pedimos que nos liste los objetos
			System.out.println("Lista Original de Personas");
			personaServicio.listarPersonas();

//			//creamos un objeto nuevo en la base de datos
//			personaServicio.crear(new Persona(8, "Alejandro"));
//			Persona persona1 = new Persona(5, "JONATHAN");
//			personaServicio.crear(persona1);
//			System.out.print("\nNueva Lista de Personas\n");
//			//Volvemos a pedir que nos liste los objetos para poder ver los cambios
//			personaServicio.listarPersonas();
			//modificamos un objeto de la lista nueva
			System.out.println("\nLista de Personas Modificada");
			personaServicio.modificar(new Persona(5, "Pampita"));
			personaServicio.listarPersonas();

			//eliminamos un objeto de la lista nueva 
			System.out.println("\nLista Final con el Objeto Eliminado");
			personaServicio.eliminar(new Persona(5, "Pampita"));
			personaServicio.listarPersonas();
			
			//buscar una persona por id
			System.out.println("\nREsultado Persona Buscada");
			personaServicio.buscarUnaPersona(new Persona(1,""));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
