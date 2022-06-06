package Mundo.Aplicacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import Mundo.Actividades.Actividad;
import Mundo.Actividades.Participante;
import Mundo.Proyectos.Tarea;

public class MenuActividades
{
    Participante participante;
	
	public boolean ejecutarCrearActividad(String titulo, String descripcion, String tipo, List<ArrayList<LocalTime>> listaTiempos, 
                                         List<ArrayList<LocalDate>> listaFechas, Participante participante)
	{
            Actividad nuevaActividad = new Actividad(titulo, descripcion, tipo, listaFechas, listaTiempos, participante);
            this.participante.agregarActividad(nuevaActividad);
            return true;
	}

    public Participante elegirParticipante(Tarea tarea, int num)
    {   
        ArrayList<Participante> responsables = tarea.getResponsables();
        Participante participante = responsables.get(num-1);
        this.participante = participante;
        return participante;
    }
}


