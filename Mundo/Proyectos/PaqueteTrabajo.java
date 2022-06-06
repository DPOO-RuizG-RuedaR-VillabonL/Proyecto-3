package Mundo.Proyectos;

import java.io.Serializable;
import java.util.ArrayList;

public class PaqueteTrabajo implements Serializable{
    private String nombre;
    private String descripcion; 
    private Proyecto proyecto;
    private ArrayList<Tarea> tareas;

    public PaqueteTrabajo(String nombre, String descripcion, Proyecto proyecto) 
    {
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.proyecto = proyecto;
        this.tareas = new ArrayList<Tarea>();
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea nuevaTarea) {
        tareas.add(nuevaTarea);
    }
    
}
