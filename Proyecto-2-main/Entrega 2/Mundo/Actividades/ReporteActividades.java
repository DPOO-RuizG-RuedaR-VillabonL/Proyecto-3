package Mundo.Actividades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ReporteActividades implements Serializable{

    private ArrayList<Actividad> actividades;

    public ReporteActividades(ArrayList<Actividad> actividades)
    {
        this.actividades = actividades;
    }

    public double calcularTiempoPromedioPorActividad()
    {
        double promedio = 0;
        int cantidadActividades = actividades.size();
        int sumaTiempos = 0;

        for (int i = 0; i < cantidadActividades; i++)
        {
            Actividad actividad = actividades.get(i);
            double duracion = actividad.getDuracion();
            sumaTiempos += duracion;
        }
        if (cantidadActividades != 0)
        {
            promedio = sumaTiempos/cantidadActividades;
        }
        return promedio;
    }

    public HashMap<String, Double> calcularTiempoPromedioPorTipo(ArrayList<String> tiposActividad)
    {
        HashMap<String, Double> mapaPorTipo = new HashMap<String, Double>();
        for (String tipo : tiposActividad)
        {
            int cant = 0; 
            double suma = 0; 
            for (Actividad actividad : actividades)
            {
                if (actividad.getTipo().equals(tipo))
                {
                    cant++;
                    suma+= actividad.getDuracion();
                }
            }
            if (cant!=0)
            {
                double promedio = suma/cant;
                mapaPorTipo.put(tipo, promedio);
            }

        }
        return mapaPorTipo;

    

    }
    
    
}
