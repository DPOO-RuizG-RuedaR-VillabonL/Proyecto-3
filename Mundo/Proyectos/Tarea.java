package Mundo.Proyectos;

import java.util.ArrayList;

import Mundo.Actividades.Participante;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarea implements Serializable{
    private String nombre;
    private String descripcion;
    private LocalDate fechaFinalReal;
    private LocalDate fechaFinalEstimada;
    private String tipo;
    private ArrayList<Participante> responsables;
    private double tiempoRealizacion;
    private boolean terminada;
    private PaqueteTrabajo paqueteTrabajo;

    public Tarea(String nombre, String descripcion, LocalDate fechaFinalEstimada, String tipo, ArrayList<Participante> responsables, PaqueteTrabajo paqueteTrabajo)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaFinalEstimada = fechaFinalEstimada;
        this.fechaFinalReal = LocalDate.of(3022, 12, 31);
        this.tipo = tipo;
        this.responsables = responsables;
        this.tiempoRealizacion = 0;
        this.terminada = false;
        this.paqueteTrabajo = paqueteTrabajo;

    }
    
    public String getNombre()
    {
        return nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }
    
    public PaqueteTrabajo getPaqueteTrabajo() {
        return paqueteTrabajo;
    }

    public LocalDate getFechaFinalEstimada() 
    {
        return fechaFinalEstimada;
    }

    public LocalDate getFechaFinalReal() 
    {
        return fechaFinalReal;
    }

    public ArrayList<Participante> getResponsables() 
    {
        return responsables;
    }

    public double getTiempoRealizacion() 
    {
        return tiempoRealizacion;
    }

    public String getTipo() 
    {
        return tipo;
    }

    public Boolean getTerminada() 
    {
        return terminada;
    }

    public void setFechaFinalReal(LocalDate fechaFinalReal) {
        this.fechaFinalReal = fechaFinalReal;
    }

    public void setTerminada() {
        this.terminada = true;
    }

    public void agregarTiempoRealizacion(double tiempoRealizacion) {
        this.tiempoRealizacion += tiempoRealizacion;
    }




}
