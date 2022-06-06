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
                Tarea nuevaTarea = new Tarea(nombre, descripcion, fechaFinalEstimada, tipoTarea, responsables, paqueteTrabajo);
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

        ArrayList<PaqueteTrabajo> paquetes = proyecto.getPaquetesTrabajo();
        PaqueteTrabajo paquete = paquetes.get(num-1);
        this.paqueteTrabajo = paquete;
        return paquete;
    }

    public Boolean ejecutarAgregarTarea(PaqueteTrabajo paqueteTrabajo, String nombre, String descripcion, String fecha,
            String tipo, ArrayList<Participante> responsables) throws Exception 
    {
        ArrayList<Tarea> tareas1 = paqueteTrabajo.getTareas();
        Boolean encontro = false;
        for (Tarea tarea : tareas1){
            String nombreT = tarea.getNombre();
            String tipoT = tarea.getTipo();
            if (nombreT.equals(nombre) && tipoT.equals(tipo)){
                encontro = true;
            }
        }
        if (encontro == false)
        {   
            ArrayList<String> tiposPermitidos = paqueteTrabajo.getProyecto().getTiposTarea();
            if (tiposPermitidos.contains(tipo)){
                LocalDate fechaEstimada = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE );
                Tarea nuevaTarea = new Tarea(nombre, descripcion, fechaEstimada, tipo, responsables, paqueteTrabajo);
                paqueteTrabajo.agregarTarea(nuevaTarea);
                this.tareas.add(nuevaTarea);
                return true;
            }
            else{
                throw new Exception("El tipo de tarea "+ tipo+ " no está dentro de los admitidos");
            }

        }
        else{
            throw new Exception("Ya existe un participante con ese nombre y correo");
        }
    }

    public Tarea elegirTarea(int num) 
    {
        Tarea tarea = this.paqueteTrabajo.getTareas().get(num-1);
        return tarea;
    }





}
