package Interfaz;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuTareas;
import Mundo.Proyectos.Tarea;

public class VentanaMenuTareas extends JFrame
{
    Tarea tarea;
    MenuTareas menuTareas;
    PMenuTarea pMenuTarea;
    PParticipantesTarea pParticipantesTarea;
    PDescripcionTarea pDescripcionTarea;
    PFechaFinalizacionTarea pFechaFinalizacionTarea;
    PConsultarTiempoFinalizacion pConsultarTiempoFinalizacion;
    

    Participante participante;
    
    public final String MENU = "MENU";
    public final String CREAR = "CREAR";
    public final String RESPONSABLES = "RESPONSABLES";
    public final String TIPO = "TIPO";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String VERTIEMPOTAREA = "VERTIEMPOTAREA";
    public final String VERFECHATAREA = "VERFECHATAREA";
    public final String GESTIONARACTIVIDAD = "GESTIONARACTIVIDAD";

    VentanaMenuTareas(MenuTareas menuTareas, Tarea tarea)
    {
        this.menuTareas = menuTareas;
        this.tarea = tarea;
        pMenuTarea = new PMenuTarea(this, tarea);
        pDescripcionTarea = new PDescripcionTarea(this, tarea);
        pFechaFinalizacionTarea = new PFechaFinalizacionTarea(this, tarea);
        pConsultarTiempoFinalizacion = new PConsultarTiempoFinalizacion(this, tarea);
        pParticipantesTarea = new PParticipantesTarea(this, tarea);

        setTitle("Menu Tareas");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuTarea, BorderLayout.CENTER);
    }
    public void cambiarPanel(String comando) throws FileNotFoundException, IOException
    {
        if(comando == MENU)
        {
            this.remove(pFechaFinalizacionTarea);
            this.remove(pDescripcionTarea);
            this.remove(pConsultarTiempoFinalizacion);
            this.remove(pFechaFinalizacionTarea);
            this.add(pMenuTarea);
        }
        else if(comando == RESPONSABLES)
        {
            pParticipantesTarea = new PParticipantesTarea(this, tarea);
            this.remove(pMenuTarea);
            this.add(pParticipantesTarea);
        }
        else if(comando == DESCRIPCION)
        {
            this.remove(pMenuTarea);
            this.remove(pDescripcionTarea);
        }
        else if(comando == VERFECHATAREA)
        {
            this.remove(pMenuTarea);
            this.add(pFechaFinalizacionTarea);
        }
        else if(comando == VERTIEMPOTAREA)
        {
            this.remove(pMenuTarea);
            this.add(pConsultarTiempoFinalizacion);
        }
    }
}