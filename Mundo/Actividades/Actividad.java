package Mundo.Actividades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Actividad implements Serializable
{
    private String titulo;
    private String descripcion;
    private String tipo;
    private double duracionSegundos;
    private Participante participante;
    private List<ArrayList<LocalDate>> listaFechas;
    private List<ArrayList<LocalTime>> listaTiempos;

    public Actividad(String titulo, String descripcion, String tipo, List<ArrayList<LocalDate>> listaFechas,
            List<ArrayList<LocalTime>> listaTiempos, Participante participante) 
    {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.duracionSegundos = duracionSegundos(listaFechas, listaTiempos);
        this.participante = participante;
        this.listaFechas = listaFechas;
        this.listaTiempos = listaTiempos;
    }
        
    public String getTitulo()
    {
        return titulo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public String getTipo()
    {
        return tipo;
    }

    public double getDuracionSegundos()
    {
        return duracionSegundos;
    }

    public Participante getParticipante()
    {
        return participante;
    }

    public List<ArrayList<LocalDate>> getListFecha()
    {
        return listaFechas;
    }

    public List<ArrayList<LocalTime>> getListTiempo()
    {
        return listaTiempos;
    }

    private double duracionSegundos(List<ArrayList<LocalDate>> listaFechas,List<ArrayList<LocalTime>> listaTiempos)
    {
        /** Creacion de iterators */
        Iterator <ArrayList<LocalDate>> itFecha = listaFechas.iterator();
        Iterator<ArrayList<LocalTime>> itHora = listaTiempos.iterator();

        /** Inicializacion de duracion */
        double duracionSegundos = 0.;

        /** Solucion problema de reduccion de tiempo */
        /** Iterar las listas */
        ArrayList<LocalDate> fechas = itFecha.next();
        ArrayList<LocalTime> horas = itHora.next();

        /** Obtencion del tiempo total tardado en la actividad */
        LocalDate fechaInicial = fechas.get(0);
        LocalDate fechaFinal = fechas.get(1);
        LocalTime horaInicial = horas.get(0);
        LocalTime horaFinal = horas.get(1);

        /** Diferencia de fechas y hora en dias y segundos */
        double fechaDiffInicialFinal = (double) fechaInicial.until(fechaFinal, ChronoUnit.DAYS);
        double horaDiffInicialFinal = (double) horaInicial.until(horaFinal, ChronoUnit.SECONDS);

        /** Pasar dias a segundos */
        double diffFechas = fechaDiffInicialFinal * 86400;
        double diffHoras = horaDiffInicialFinal;
        double diffsSegundos = diffFechas + diffHoras;
        duracionSegundos = diffsSegundos;

        while(itFecha.hasNext())
        {
            /** Reduccion de la duraccion al tiempo real tardado */
            /** Iteracion de fechas y horas */
            ArrayList<LocalDate> fecha = itFecha.next();
            ArrayList<LocalTime> hora = itHora.next();

            /** Obtencion del tiempo de parada y de finalizacion */
            LocalDate fechaInicialIterador = fecha.get(0);
            LocalDate fechaFinalIterador = fecha.get(1);
            LocalTime horaInicialIterador = hora.get(0);
            LocalTime horaFinalIterador = hora.get(1);

            /** Diferencia de fechas y tiempos en dias y segundos */
            double fechaDiffParadaInicialFinal = (double) fechaInicialIterador.until(fechaFinalIterador, ChronoUnit.DAYS);
            double horaDiffParadaInicialFinal = (double) horaInicialIterador.until(horaFinalIterador, ChronoUnit.SECONDS);

            /** Pasar dias a segundos */
            double diffFechaParada = fechaDiffParadaInicialFinal * 86400;
            double diffHoraParada = horaDiffParadaInicialFinal;
            double diffSegundosParadas = diffFechaParada + diffHoraParada;
            duracionSegundos = duracionSegundos - diffSegundosParadas;
        }
        return duracionSegundos;
    }
}
