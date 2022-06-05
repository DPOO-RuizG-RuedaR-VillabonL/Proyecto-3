package Mundo.Proyectos;

public class PaqueteTrabajo {
    private String nombre;
    private String descripcion; 
    private Proyecto proyecto;

    public PaqueteTrabajo(String nombre, String descripcion, Proyecto proyecto) 
    {
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.proyecto = proyecto;
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
    
}
