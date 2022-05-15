package Mundo.Aplicacion;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import Mundo.Actividades.Participante;
import Mundo.Proyectos.Proyecto;

public class MenuProyectos
{
    ArrayList<Proyecto> proyectos;
    File fichero = new File("proyectos.txt");

    public MenuProyectos(){
        proyectos = new ArrayList<Proyecto>();
    }
	
	public Boolean ejecutarCrearProyecto(String nombre, String descripcion, String participante, String correo, String fecha, String tipos)
	{
        try {
            String[] tiposA = tipos.toLowerCase().replace(" ", "").split(", ");
            ArrayList<String> tiposActividad = new ArrayList<String>();
            for (String tipo : tiposA)
            {tiposActividad.add(tipo);}
		
            LocalDate fechaInicio = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE );

            Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, participante, correo, fechaInicio, tiposActividad);
            nuevoProyecto.setFechaFinal(31, 12, 3022);
            proyectos.add(nuevoProyecto);
            return true;
            
        } catch (Exception e) {
            return false;
        }

	}

    public ArrayList<Proyecto> getProyectos() 
    {
        return proyectos;
    }

    public Proyecto elegirProyecto(int num)
    {
        Proyecto proyecto = proyectos.get(num-1);
        return proyecto;
        
    }

    public void gestionarProyecto(Proyecto proyecto)
    {
        MenuActividades menuActividades = new MenuActividades();
        boolean continuar = true;
		while (continuar && proyecto!=null)
		{
			try
			{
				mostrarMenuProyectos(proyecto);
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));

                if (opcion_seleccionada == 1)
                    System.out.println(proyecto.getDescripcion());

				else if (opcion_seleccionada == 2)
                    ejecutarConsultarParticipantes(proyecto);

                else if (opcion_seleccionada == 3)
                    ejecutarConsultarFechaInicio(proyecto);

                else if (opcion_seleccionada == 4)
                    ejecutarConsultarFechaFin(proyecto);

                else if (opcion_seleccionada == 5)
                    ejecutarAgregarParticipante(proyecto, null, null);
                
                else if (opcion_seleccionada == 6)
                    ejecutarAgregarTipo(proyecto, null);
                
                else if (opcion_seleccionada == 7)
                {
                    Participante participante = menuActividades.elegirParticipante(proyecto, opcion_seleccionada);
                    menuActividades.gestionarMenuActividades(participante);
                }
                else if (opcion_seleccionada == 8)
					cambiarFechaFinalizacion(proyecto, null);
				else if (opcion_seleccionada == 9) {
					System.out.println("Volviendo al menú principal ...");
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

    public Boolean ejecutarAgregarTipo(Proyecto proyecto, String tipo) 
    {
        try {
            proyecto.getTiposActividad().add(tipo);
            return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }

    public Boolean ejecutarAgregarParticipante(Proyecto proyecto, String nombre, String correo) 
    {
        try {
        Participante nuevoParticipante = new Participante(nombre, correo);
        proyecto.agregarParticipante(nuevoParticipante);
        return true;
        
    } catch (Exception e) {
        return false;
    }
    }

    private void ejecutarConsultarParticipantes(Proyecto proyecto) 
    {
        ArrayList<Participante> participantes = proyecto.getParticipantes();
        for(int i=0; i<participantes.size(); i++)
            {
                Participante participante = participantes.get(i);
                System.out.println((i+1) +". "+ participante.getNombre()+ "\t" + participante.getCorreo());
            }
    }

    private void ejecutarConsultarFechaInicio (Proyecto proyecto) 
    {                
        LocalDate rta = proyecto.getFechaInicial();
        System.out.println(rta);
            
    }
    private void ejecutarConsultarFechaFin (Proyecto proyecto) 
    {
        LocalDate rta = proyecto.getFechaFinal();
        LocalDate fechaEstandar = LocalDate.parse("3022-12-31");
        if (fechaEstandar.equals(rta))
            System.out.println("Todavía no tiene fecha de finalización");
        else
            System.out.println(rta);

    }

    public Boolean cambiarFechaFinalizacion(Proyecto proyecto, String fecha) 
    {
        try {
            proyecto.setFechaFinal(LocalDate.parse(fecha));
            return true;
            
        } catch (Exception e) {
            return false;
        }
            

    }

    public void mostrarMenuProyectos(Proyecto proyecto)
	{
		System.out.println("\nGestionar Proyecto "+proyecto.getNombre()+"\n");
		System.out.println("1. Consultar descripcion del proyecto");
		System.out.println("2. Consultar participantes");
        System.out.println("3. Consultar fecha de inicio");
        System.out.println("4. Consultar fecha de finalización");
        System.out.println("5. Agregar participante");
        System.out.println("6. Agregar tipo de actividad admitida");
        System.out.println("7. Gestionar Actividades");
        System.out.println("8. Agregar o Modificar la fecha de finalización del proyecto");
		System.out.println("9. Volver al menu principal\n");
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

    public void guardarProgreso() throws FileNotFoundException, IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            for (Proyecto proyecto: proyectos)
            {
                oos.writeObject(proyecto);
            }
        }
    }

    public void cargarProyectos() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (fichero.exists()){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                while(true){
                    try{
                        Proyecto proyecto = (Proyecto) ois.readObject();
                        proyectos.add(proyecto);
                    }
                    catch (EOFException eofException)
                    {
                        break;
                    }
                }
            }
        }}
    

}