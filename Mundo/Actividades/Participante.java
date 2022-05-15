package Mundo.Actividades;

import java.io.Serializable;
import java.util.ArrayList;


public class Participante implements Serializable{
    private String nombre;
    private String correo;
    private ArrayList<Actividad> actividades;
    private ReporteActividades reporteActividades;

    public Participante(String nombre, String correo)
    {
        this.nombre = nombre;
        this.correo = correo;
        this.actividades = new ArrayList<Actividad>();
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getCorreo()
    {
        return correo;
    }

    public ArrayList<Actividad> getActividades()
    {
        return actividades;
    }

    public ReporteActividades getReporteActividades() 
    {
        return reporteActividades;
    }

    public void agregarActividad(Actividad actividad)
    {
        actividades.add(actividad);
        ReporteActividades reporteActividades = new ReporteActividades(actividades);
        this.reporteActividades = reporteActividades;
    }
    
}
