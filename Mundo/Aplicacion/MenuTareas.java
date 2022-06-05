package Mundo.Aplicacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Mundo.Actividades.Participante;
import Mundo.Proyectos.PaqueteTrabajo;
import Mundo.Proyectos.Proyecto;
import Mundo.Proyectos.Tarea;

public class MenuTareas
{
    PaqueteTrabajo paqueteTrabajo;
    ArrayList<Tarea> tareas;

    public MenuTareas(){
        tareas = new ArrayList<Tarea>();
        this.paqueteTrabajo = paqueteTrabajo;
    }
	
	public Boolean ejecutarCrearTarea(String nombre, String descripcion, String fechaFinalE, String tipoTarea, ArrayList<Participante> responsables, String tiposTarea)
	{
        try {
            Proyecto proyecto = paqueteTrabajo.getProyecto();
            LocalDate inicioProyecto = proyecto.getFechaInicial();
            LocalDate finProyecto = proyecto.getFechaFinal();
            LocalDate fechaFinalEstimada = LocalDate.parse(fechaFinalE, DateTimeFormatter.ISO_LOCAL_DATE );
            if ((fechaFinalEstimada.isBefore(finProyecto)|| fechaFinalEstimada.isEqual(finProyecto)) && (fechaFinalEstimada.isAfter(inicioProyecto)))
            {
                Tarea nuevaTarea = new Tarea(nombre, descripcion, fechaFinalEstimada, tipoTarea, responsables);
                this.tareas.add(nuevaTarea);
                return true;
            }
            else 
            {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

	}
    public ArrayList<Tarea> getTareas() 
    {
        return tareas;
    }

    public PaqueteTrabajo elegirPaqueteTrabajo(Proyecto proyecto, int num) {
        return null;
    }





}
