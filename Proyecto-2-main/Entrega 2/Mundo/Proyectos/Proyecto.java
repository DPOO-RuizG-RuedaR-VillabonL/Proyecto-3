package Mundo.Proyectos;

import java.util.ArrayList;

import Mundo.Actividades.Participante;

import java.io.Serializable;
import java.time.LocalDate;

public class Proyecto implements Serializable{
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private ArrayList<Participante> participantes;
    private ArrayList<String> tiposActividad;

    public Proyecto(String nombre, String descripcion, String nombreParticipante, String correoParticipante, LocalDate fechaInicio, ArrayList<String> tiposActividad)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicio;
        this.tiposActividad = tiposActividad;
        participantes = new ArrayList<Participante>();
        Participante primerParticipante = new Participante(nombreParticipante, correoParticipante);
        participantes.add(primerParticipante);

    }
    
    public String getNombre()
    {
        return nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public LocalDate getFechaInicial()
    {
        return fechaInicial;
    }

    public LocalDate getFechaFinal()
    {
        return fechaFinal;
    }

    public ArrayList<Participante> getParticipantes()
    {
        return participantes;
    }

    public ArrayList<String> getTiposActividad() {
        return tiposActividad;
    }

    public void agregarParticipante(Participante participante)
    {
        this.participantes.add(participante);
    }

    public void setFechaFinal(int dia, int mes, int anio)
    {
        this.fechaFinal = LocalDate.of(anio, mes, dia);
    }

    public void setTiposActividad(ArrayList<String> tiposActividad) {
        this.tiposActividad = tiposActividad;
    }

    public void setFechaFinal(LocalDate parse) {
    }
}
