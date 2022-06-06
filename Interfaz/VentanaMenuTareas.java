package Interfaz;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuActividades;
import Mundo.Aplicacion.MenuTareas;
import Mundo.Proyectos.Tarea;

public class VentanaMenuTareas extends JFrame
{
    Tarea tarea;
    MenuTareas menuTareas;
    MenuActividades menuActividades;
    PMenuTarea pMenuTarea;
    PResponsablesTarea pResponsablesTarea;
    PDescripcionTarea pDescripcionTarea;
    PFechaFinalizacionTarea pFechaFinalizacionTarea;
    PConsultarTiempoRealizacionTarea pConsultarTiempoRealizacionTarea;
    PTipoTarea pTipoTarea;
    PElegirParticipante pElegirParticipante;
    

    Participante participante;
    
    public final String MENU = "MENU";
    public final String MENUANTERIOR = "MENUANTERIOR";
    public final String CREAR = "CREAR";
    public final String RESPONSABLES = "RESPONSABLES";
    public final String TIPO = "TIPO";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String VERTIEMPOTAREA = "VERTIEMPOTAREA";
    public final String VERFECHATAREA = "VERFECHATAREA";
    public final String GESTIONARACTIVIDAD = "GESTIONARACTIVIDAD";

    VentanaMenuTareas(MenuTareas menuTareas, Tarea tarea) throws FileNotFoundException, IOException
    {
        this.menuTareas = menuTareas;
        this.tarea = tarea;
        pMenuTarea = new PMenuTarea(this, tarea);
        pDescripcionTarea = new PDescripcionTarea(this, tarea);
        pFechaFinalizacionTarea = new PFechaFinalizacionTarea(this, tarea);
        pConsultarTiempoRealizacionTarea = new PConsultarTiempoRealizacionTarea(this, tarea);
        pResponsablesTarea = new PResponsablesTarea(this, tarea);
        pElegirParticipante = new PElegirParticipante(this, tarea.getResponsables());

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
            this.remove(pConsultarTiempoRealizacionTarea);
            this.remove(pFechaFinalizacionTarea);
            this.remove(pResponsablesTarea);
            this.add(pMenuTarea);
        }
        else if (comando == MENUANTERIOR){
            this.setVisible(false);
        }
        else if(comando == RESPONSABLES)
        {
            pResponsablesTarea = new PResponsablesTarea(this, tarea);
            this.remove(pMenuTarea);
            this.add(pResponsablesTarea);
        }
        else if(comando == TIPO)
        {
            this.remove(pMenuTarea);
            this.add(pTipoTarea);
        }
        else if(comando == DESCRIPCION)
        {
            this.remove(pMenuTarea);
            this.add(pDescripcionTarea);
        }
        else if(comando == VERFECHATAREA)
        {
            this.remove(pMenuTarea);
            this.add(pFechaFinalizacionTarea);
        }
        else if(comando == VERTIEMPOTAREA)
        {
            this.remove(pMenuTarea);
            this.add(pConsultarTiempoRealizacionTarea);
        }
        else if(comando == GESTIONARACTIVIDAD)
        {
            pElegirParticipante = new PElegirParticipante(this, tarea.getResponsables());
            this.remove(pMenuTarea);
            this.add(pElegirParticipante);

        }else{

            elegirParticipante(comando);
        }
        setSize(getWidth()-1, getHeight()-1);
    }

    public void elegirParticipante(String boton) throws FileNotFoundException, IOException{
        int num = Integer.parseInt(boton.replace("PARTICIPANTE ", ""));
        menuActividades = new MenuActividades();
        participante = menuActividades.elegirParticipante(tarea, num);
        cambiarPanel(MENU);
        new VentanaMenuActividades(menuActividades, participante);
}
}
