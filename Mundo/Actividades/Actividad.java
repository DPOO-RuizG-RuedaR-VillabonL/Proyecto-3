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
    private double duracion;

    public Actividad(String titulo, String descripcion, String tipo, List<ArrayList<LocalDate>> listaFechas,
            List<ArrayList<LocalTime>> listaTiempos) 
            {
                this.titulo = titulo;
                this.descripcion = descripcion;
                this.tipo = tipo;
                this.duracion = duracion(listaFechas, listaTiempos);
            }
        
    public String getTitulo(){
        return titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getTipo(){
        return tipo;
    }

    public double getDuracion() {
        return duracion;
    }

    private double duracion(List<ArrayList<LocalDate>> listaFechas,List<ArrayList<LocalTime>> listaTiempos)
    {
        /** creacion de iterators */
        Iterator <ArrayList<LocalDate>> itFecha = listaFechas.iterator();
        Iterator<ArrayList<LocalTime>> itHora = listaTiempos.iterator();

        /** inicializacion de duracion */
        double duracion = 0.;
        ArrayList<LocalDate> fechass = itFecha.next();
        ArrayList<LocalTime> horass = itHora.next();
        LocalDate fechaIns = fechass.get(0);
        LocalDate fechaFins = fechass.get(1);
        LocalTime horaIns = horass.get(0);
        LocalTime horaFins = horass.get(1);
        double fechasss = (double) fechaIns.until(fechaFins, ChronoUnit.DAYS);
        double horasss = (double) horaIns.until(horaFins, ChronoUnit.SECONDS);
        double diffFechas = fechasss * 86400;
        double diffHoras = horasss;
        double diffs = diffFechas + diffHoras;
        duracion = diffs;

        while(itFecha.hasNext())
        {
            ArrayList<LocalDate> fechas = itFecha.next();
            ArrayList<LocalTime> horas = itHora.next();
            LocalDate fechaIn = fechas.get(0);
            LocalDate fechaFin = fechas.get(1);
            LocalTime horaIn = horas.get(0);
            LocalTime horaFin = horas.get(1);
            double fecha = (double) fechaIn.until(fechaFin, ChronoUnit.DAYS);
            double hora = (double) horaIn.until(horaFin, ChronoUnit.SECONDS);
            double diffFecha = fecha * 86400;
            double diffHora = hora;
            double diff = diffFecha + diffHora;
            duracion = duracion - diff;
        }

        return duracion;
    }

}
