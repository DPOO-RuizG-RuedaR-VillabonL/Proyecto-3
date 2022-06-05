package Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import Mundo.Aplicacion.MenuPaqueteTrabajo;
import Mundo.Aplicacion.MenuProyectos;
import Mundo.Aplicacion.MenuTareas;
import Mundo.Proyectos.Proyecto;
import Mundo.Proyectos.PaqueteTrabajo;


public class VentanaMenuPProyectos extends JFrame{
    MenuTareas menuTareas;
    MenuPaqueteTrabajo menuPaqueteTrabajo;
    Proyecto proyecto;
    PMenuProyectos pMenuProyectos;
    PDescripcionPP pDescripcionPP;
    PElegirPaquetesProyecto pElegirPaquetesProyecto;
    PElegirTareas pElegirTareas;
    PAgregarTarea pAgregarTarea;
    //PAgregarPTrabajo pAgregarPTrabajo;
    PMenuPProyectos pMenuPProyectos;

    public final String MENU = "MENU";
    public final String MENUPPAL = "MENUPRINCIPAL";
    //public final String AGREGAR_PTRABAJO = "AGREGARPTRABAJO";
    public final String AGREGAR_TAREA = "AGREGARPTAREA";
    //public final String CONSULTAR_PTRABAJO = "CONSULTARPTRABAJO";
    public final String CONSULTAR_TAREA = "CONSULTARTAREA";
    public final String DESCRIPCIONPP = "DESCRIPCIONPP";
    

    VentanaMenuPProyectos (MenuPaqueteTrabajo menuPaqueteTrabajo, Proyecto proyecto) throws FileNotFoundException, IOException{
        this.menuPaqueteTrabajo = menuPaqueteTrabajo;
        pMenuPProyectos = new PMenuPProyectos(this);
        pDescripcionPP = new PDescripcionPP(this);
        //pElegirPaquetesProyecto = new pElegirPaquetesProyecto(this);
        pElegirTareas = new PElegirTareas(this);
        //pAgregarPTrabajo = new PAgregarPTrabajo(this);
        pAgregarTarea = new PAgregarTarea(this);
        


        setTitle("Menu Paquetes de Tarabajo Proyectos");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuPProyectos, BorderLayout.CENTER);
    }
        public void cambiarPanel(String comando) throws FileNotFoundException, IOException {
            if (comando == MENU){
                this.remove(pDescripcionPP);
                //this.remove(pElegirPaquetesProyecto);
                this.remove(pElegirTareas);
                this.remove(pAgregarTarea);
                //this.remove(pAgregarPTrabajo);
                this.add(pMenuPProyectos);
            }else if (comando == AGREGAR_TAREA){
                this.remove(pDescripcionPP);
                //this.remove(pElegirPaquetesProyecto);
                this.remove(pElegirTareas);
                this.remove(pMenuPProyectos);
                //this.remove(pAgregarPTrabajo);
                this.add(pAgregarTarea);
            }else if (comando == CONSULTAR_TAREA){
                this.remove(pDescripcionPP);       
                this.remove(pAgregarTarea);
                this.remove(pMenuPProyectos);
               // this.remove(pAgregarPTrabajo);
                //this.remove(pElegirPaquetesProyecto);
                this.add(pElegirTareas);
            }

        
        

        }

        public void AgregarTarea(String nombre, String descripcion, String tipo) throws FileNotFoundException, IOException{
            /*Boolean respuesta = menuTareas.ejecutarAgregarTarea( nombre,  descripcion,  tipo);
            if (respuesta==true){
                JOptionPane.showMessageDialog(pAgregarTarea, "La tarea fue añadido exitosamente",
                    "Proyecto Creado", JOptionPane.INFORMATION_MESSAGE);     
            }
            else {
                JOptionPane.showMessageDialog(pAgregarTarea, "No se pudo añadir la tarea",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            cambiarPanel(MENU);*/
        }

        public void AgregarPaqueteTrabajo(String nombre, String descripcion) throws FileNotFoundException, IOException{
            /*Boolean respuesta = menuPaqueteTrabajo.ejecutarAgregarPa( nombre,  descripcion);
            if (respuesta==true){
                JOptionPane.showMessageDialog(pAgregarTarea, "La tarea fue añadido exitosamente",
                    "Proyecto Creado", JOptionPane.INFORMATION_MESSAGE);     
            }
            else {
                JOptionPane.showMessageDialog(pAgregarTarea, "No se pudo añadir la tarea",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            cambiarPanel(MENU);*/
        }
        public String getNombre() {
            return null;
        }
    
}
