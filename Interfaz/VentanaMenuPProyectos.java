package Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import Mundo.Aplicacion.MenuPaqueteTrabajo;
import Mundo.Aplicacion.MenuProyectos;
import Mundo.Proyectos.Proyecto;
import Mundo.Proyectos.PaqueteTrabajo;

public class VentanaMenuPProyectos extends JFrame{
    MenuPaqueteTrabajo menuPaqueteTrabajo;
    Proyecto proyecto;

    public final String MENU = "MENU";
    public final String MENUPPAL = "MENUPRINCIPAL";
    public final String AGREGAR_PTRABAJO = "AGREGARPTRABAJO";
    public final String AGREGAR_TAREA = "AGREGARPTAREA";
    public final String CONSULTAR_PTRABAJO = "CONSULTARPTRABAJO";
    public final String CONSULTAR_TAREA = "CONSULTARTAREA";
    

    VentanaMenuPProyectos (MenuPaqueteTrabajo menuPaqueteTrabajo, Proyecto proyecto) throws FileNotFoundException, IOException{
        this.menuPaqueteTrabajo = menuPaqueteTrabajo;
        pMenuPProyectos = new PMenuPProyectos(this);
        pDescripcionPP = new PDescripcionPP(this);
        pAgregarPTrabajo = new PAgregarPTrabajo(this);
        pAgregarTarea = new PAgregarTarea(this);
        //pPaquetesProyecto = new PPaquetesProyecto(this);
        //pTareas = new PTareas(this);
        pCrearPProyecto = new PCrearPProyecto(this);

        setTitle("Menu Paquetes de Tarabajo Proyectos");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuPProyectos, BorderLayout.CENTER);

        public void cambiarPanel(String comando) throws FileNotFoundException, IOException {
            if (comando == MENU){
                this.remove(pDescripcionPP);
                this.remove(pPaquetesProyecto);
                this.remove(pTareas);
                this.remove(pCrearPProyecto);
                this.remove(pAgregarTarea);
                this.remove(pAgregarPTrabajo);
                this.add(pMenuPProyectos);

            }else if (comando == AGREGAR_PTRABAJO){
                this.remove(pDescripcionPP);
                this.remove(pPaquetesProyecto);
                this.remove(pTareas);
                this.remove(pCrearPProyecto);
                this.remove(pMenuPProyectos);
                this.remove(pAgregarTarea);
                this.add(pAgregarPTrabajo);
            }else if (comando == AGREGAR_TAREA){
                this.remove(pDescripcionPP);
                this.remove(pPaquetesProyecto);
                this.remove(pTareas);
                this.remove(pCrearPProyecto);
                this.remove(pMenuPProyectos);
                this.remove(pAgregarPTrabajo);
                this.add(pAgregarTarea);
            }else if (comando == pCrearPProyecto){
                this.remove(pDescripcionPP);
                this.remove(pPaquetesProyecto);
                this.remove(pTareas);
                this.remove(pAgregarTarea);
                this.remove(pMenuPProyectos);
                this.remove(pAgregarPTrabajo);
                this.add(pCrearPProyecto);
            }

        
        


    
}
