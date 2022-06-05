package Mundo.Proyectos;

import java.io.Serializable;
import java.util.ArrayList;

public class PaqueteTrabajo implements Serializable{

    private String nombre;
    private String descripcion;
    

    public PaqueteTrabajo(String nombre, String descripcion, String paqueteTrabajos) {
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public  ArrayList<Tarea> getTarea() {
        return null;
    }

    public  ArrayList<String> getTiposTarea() {
        return null;
    }
    
}
