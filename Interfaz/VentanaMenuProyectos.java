package Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuActividades;
import Mundo.Aplicacion.MenuProyectos;
import Mundo.Proyectos.Proyecto;


public class VentanaMenuProyectos extends JFrame{
    MenuProyectos menuProyectos;
    MenuActividades menuActividades;
    PMenuProyectos pMenuProyectos;
    PElegirParticipante pElegirParticipante;
    PDescripcion pDescripcion;
    PParticipantes pParticipantes;
    PAgregarParticipante pAgregarParticipante;
    PInicio pInicio;
    PFin pFin;
    PAgregaTipoActividad pAgregaTipoActividad;
    PAgregarFechaF pAgregarFechaF;
    Proyecto proyecto;
    Participante participante;
 
    public final String MENU = "MENU";
    public final String MENUPPAL = "MENUPRINCIPAL";
    public final String AGREGAR_PARTICIPANTES = "AGREGARPARTICIPANTES";
    public final String AGREGAR_P = "AGREGAR_P";
    public final String AGREGAR_TIPO = "AGREGARTIPO";
    public final String GESTIONAR = "GESTIONAR";
    public final String MODIFICAR_FIN = "MODIFICARFIN";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String PARTICIPANTES = "PARTICIPANTES";
    public final String FINICIO = "F_INICIO";
    public final String FFIN = "F_FIN";

    VentanaMenuProyectos(MenuProyectos menuProyectos, Proyecto proyecto) throws FileNotFoundException, IOException{
        this.menuProyectos = menuProyectos;
        this.proyecto = proyecto;
        pMenuProyectos = new PMenuProyectos(this, proyecto);
        pDescripcion = new PDescripcion(this, proyecto);
        pParticipantes = new PParticipantes(this, proyecto);
        pInicio = new PInicio(this, proyecto);
        pFin = new PFin(this, proyecto);
        pElegirParticipante = new PElegirParticipante(this, proyecto.getParticipantes());
        pAgregarParticipante = new PAgregarParticipante(this, proyecto);
        pAgregaTipoActividad = new PAgregaTipoActividad(this);
        pAgregarFechaF = new PAgregarFechaF(this, proyecto);
        
        setTitle("Menu Proyectos");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuProyectos, BorderLayout.CENTER);
    }

    public void cambiarPanel(String comando) throws FileNotFoundException, IOException {
        if (comando == MENU){
            this.remove(pElegirParticipante);
            this.remove(pDescripcion);
            this.remove(pParticipantes);
            this.remove(pInicio);
            this.remove(pFin);
            this.remove(pAgregarParticipante);
            this.remove(pAgregaTipoActividad);
            this.remove(pAgregarFechaF);
            this.add(pMenuProyectos);

        }else if (comando == MENUPPAL){
            this.setVisible(false);

        }else if (comando == GESTIONAR){
            this.remove(pMenuProyectos);
            pElegirParticipante = new PElegirParticipante(this, proyecto.getParticipantes());
            this.add(pElegirParticipante);
            
        }else if (comando == DESCRIPCION){
            this.remove(pMenuProyectos);
            this.add(pDescripcion);

        }else if (comando == PARTICIPANTES){
            pParticipantes = new PParticipantes(this, proyecto);
            this.remove(pMenuProyectos);
            this.add(pParticipantes);

        }else if (comando == FINICIO){
            this.remove(pMenuProyectos);
            this.add(pInicio);

        }else if (comando == FFIN ){
            this.remove(pMenuProyectos);
            this.add(pFin);

        }else if (comando == AGREGAR_PARTICIPANTES ){
            this.remove(pMenuProyectos);
            this.add(pAgregarParticipante);
        
        }else if (comando == AGREGAR_TIPO ){
            this.remove(pMenuProyectos);
            this.add(pAgregaTipoActividad);
        
        }else if (comando == MODIFICAR_FIN ){
            this.remove(pMenuProyectos);
            this.add(pAgregarFechaF);
        
        }else if (comando == AGREGAR_P){

        }else{
            ElegirParticipante(comando);
        }
        setSize(getWidth()-1, getHeight()-1);
    }

    public void cambiarFechaFinalizacion(Proyecto proyecto, String fecha) throws FileNotFoundException, IOException {
        Boolean respuesta = menuProyectos.cambiarFechaFinalizacion(proyecto, fecha);
        if (respuesta==true){
            JOptionPane.showMessageDialog(pAgregarParticipante, "La fecha fue cambiada exitosamente",
				"Proyecto Creado", JOptionPane.INFORMATION_MESSAGE);     
        }
        else {
            JOptionPane.showMessageDialog(pAgregarParticipante, "No se pudo cambiar la fecha",
				"Error", JOptionPane.ERROR_MESSAGE);
        }
        cambiarPanel(MENU);
    }

    public void AgregarParticipante(String nombre, String correo) throws FileNotFoundException, IOException{
        Boolean respuesta = menuProyectos.ejecutarAgregarParticipante(proyecto, nombre, correo);
        if (respuesta==true){
            JOptionPane.showMessageDialog(pAgregarParticipante, "El participante fue añadido exitosamente",
				"Proyecto Creado", JOptionPane.INFORMATION_MESSAGE);     
        }
        else {
            JOptionPane.showMessageDialog(pAgregarParticipante, "No se pudo añadir el participante",
				"Error", JOptionPane.ERROR_MESSAGE);
        }
        cambiarPanel(MENU);
    }
    public void AgregarTipo(String tipo) throws FileNotFoundException, IOException{
        Boolean respuesta = menuProyectos.ejecutarAgregarTipo(proyecto, tipo);
        if (respuesta==true){
            JOptionPane.showMessageDialog(pAgregarParticipante, "El tipo fue añadido exitosamente",
				"Proyecto Creado", JOptionPane.INFORMATION_MESSAGE);     
        }
        else {
            JOptionPane.showMessageDialog(pAgregarParticipante, "No se pudo añadir el tipo",
				"Error", JOptionPane.ERROR_MESSAGE);
        }
        cambiarPanel(MENU);
    }

    public void ElegirParticipante(String boton) throws FileNotFoundException, IOException{
        int num = Integer.parseInt(boton.replace("PARTICIPANTE ", ""));
        menuActividades = new MenuActividades();
        participante = menuActividades.elegirParticipante(proyecto, num);
        cambiarPanel(MENU);
        new VentanaMenuActividades(menuActividades, participante);
    }
    
}
