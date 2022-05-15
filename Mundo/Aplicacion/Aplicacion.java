/*package Mundo.Aplicacion;
<<<<<<< HEAD

=======
>>>>>>> origin/Pipe
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import Mundo.Proyectos.Proyecto;
public class Aplicacion {
    //Prueba rama Mariana
    /*
	 * Ejecuta la aplicación: le muestra el menú al usuario y la pide que ingrese
	 * una opción, y ejecuta la opción seleccionada por el usuario. Este proceso se
	 * repite hasta que el usuario seleccione la opción de abandonar la aplicación.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
	 
	public void ejecutarAplicacion() throws FileNotFoundException, IOException, ClassNotFoundException
	{
        MenuProyectos menuProyectos = new MenuProyectos();
		menuProyectos.cargarProyectos();
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
                if (opcion_seleccionada == 1)
                    menuProyectos.ejecutarCrearProyecto();
				else if (opcion_seleccionada == 2)
                {
                    Proyecto proyecto = menuProyectos.elegirProyecto();
                    menuProyectos.gestionarProyecto(proyecto);
                }
                else if (opcion_seleccionada == 3) 
				{
					menuProyectos.guardarProgreso();
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	public void mostrarMenu()
	{
		System.out.println("\nBienvenido al gestor de proyectos\n");
		System.out.println("1. Crear un nuevo proyecto");
		System.out.println("2. Gestionar proyecto"); 
		System.out.println("3. Salir de la aplicación\n");
	}
    public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Aplicacion consola = new Aplicacion();
        consola.ejecutarAplicacion();
    }
    
     
}
*/
