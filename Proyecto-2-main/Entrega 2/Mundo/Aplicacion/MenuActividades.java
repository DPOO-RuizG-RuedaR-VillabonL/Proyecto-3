package Mundo.Aplicacion;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Mundo.Actividades.Actividad;
import Mundo.Actividades.Participante;
import Mundo.Actividades.ReporteActividades;
import Mundo.Proyectos.Proyecto;


public class MenuActividades
{
    Participante participante;
    private ArrayList<String> tiposActividad;

    public void setParticipante(Participante participante) 
    {
        this.participante = participante;
    }
	
	public boolean ejecutarCrearActividad(String titulo, String descripcion, String tipo, List<ArrayList<String>> listaTiempos, List<ArrayList<String>> listaFechas)
	{
        try 
        {
            List<ArrayList<LocalDate>> listaFechasC = new ArrayList<ArrayList<LocalDate>>();
            List<ArrayList<LocalTime>> listaTiemposC = new ArrayList<ArrayList<LocalTime>>();
            int i = 0;
            while ( i < listaTiempos.size())
            {
                LocalDate fechaInicio = LocalDate.parse(listaFechas.get(i).get(0), DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate fechaFinal = LocalDate.parse(listaFechas.get(i).get(1), DateTimeFormatter.ISO_LOCAL_DATE);
                LocalTime horaInicio = LocalTime.parse(listaTiempos.get(i).get(0));
                LocalTime HoraFinal= LocalTime.parse(listaTiempos.get(i).get(1));

                ArrayList<LocalDate> fechas = new ArrayList<LocalDate>();
                ArrayList<LocalTime> horas = new ArrayList<LocalTime>();

                fechas.add(fechaInicio);
                fechas.add(fechaFinal);

                horas.add(horaInicio);
                horas.add(HoraFinal);

                listaFechasC.add(fechas);
                listaTiemposC.add(horas);

                i++;
            }
            Actividad nuevaActividad = new Actividad(titulo, descripcion, tipo, listaFechasC, listaTiemposC);
            this.participante.agregarActividad(nuevaActividad);
            return true;
        }
        catch (Exception e) 
        {
            return false;
        }
	}

    public Participante elegirParticipante(Proyecto proyecto, int num)
    {   
        this.tiposActividad = proyecto.getTiposActividad();
        ArrayList<Participante> participantes = proyecto.getParticipantes();
 
        Participante participante = participantes.get(num-1);

        return participante;
        
    }
    
    private String input(String mensaje)
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

    void mostrarMenuActividades() {
		System.out.println("1. Crear una actividad");
		System.out.println("2. Consultar las estadisticas de un participante");
		System.out.println("3. Volver al menu proyecto\n");
    }

    private void mostrarEstadisticas(Participante participante, ArrayList<String> tiposActividad)
    {
        ReporteActividades Estadisticas = participante.getReporteActividades();
        System.out.println("El tiempo promedio por actividad es de "+Estadisticas.calcularTiempoPromedioPorActividad()+"s");
        System.out.println("El tiempo promedio por tipo de actividad es de \n");
        HashMap<String, Double> estadisticasPorTipo = Estadisticas.calcularTiempoPromedioPorTipo(tiposActividad);
        for (String tipo : tiposActividad)
        {
            System.out.println(tipo + "  "+ estadisticasPorTipo.get(tipo)+ " s");
        }
    }

    public void gestionarMenuActividades(Participante participante)
    {
        boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuActividades();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
                if (opcion_seleccionada == 1)
                    ejecutarCrearActividad(null, null, null, null, null);
				else if (opcion_seleccionada == 2)
                {
                    mostrarEstadisticas(participante, tiposActividad);
                }
                else if (opcion_seleccionada == 3)
                {
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
}


