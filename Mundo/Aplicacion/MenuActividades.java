package Mundo.Aplicacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import Mundo.Actividades.Actividad;
import Mundo.Actividades.Participante;
import Mundo.Proyectos.Proyecto;

public class MenuActividades
{
    Participante participante;
    private ArrayList<String> tiposActividad;
	
	public boolean ejecutarCrearActividad(String titulo, String descripcion, String tipo, List<ArrayList<LocalTime>> listaTiempos, 
                                         List<ArrayList<LocalDate>> listaFechas, Participante participante)
	{
            Actividad nuevaActividad = new Actividad(titulo, descripcion, tipo, listaFechas, listaTiempos, participante);
            this.participante.agregarActividad(nuevaActividad);
            return true;
	}

    public Participante elegirParticipante(Proyecto proyecto, int num)
    {   
        this.tiposActividad = proyecto.getTiposActividad();
        ArrayList<Participante> participantes = proyecto.getParticipantes();
        Participante participante = participantes.get(num-1);
        this.participante = participante;
        return participante;
    }
}


