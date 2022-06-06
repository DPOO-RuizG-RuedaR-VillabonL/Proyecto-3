package Interfaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuTareas;
import Mundo.Proyectos.PaqueteTrabajo;
import Mundo.Proyectos.Tarea;


public class VentanaMenuPTrabajo extends JFrame{
    MenuTareas menuTareas;
    PaqueteTrabajo paqueteTrabajo;
    PMenuProyectos pMenuProyectos;
    PDescripcionPP pDescripcionPP;
    PElegirPaquetesProyecto pElegirPaquetesProyecto;
    PElegirTareas pElegirTareas;
    PAgregarTarea pAgregarTarea;
    //PAgregarPTrabajo pAgregarPTrabajo;
    PMenuPProyectos pMenuPProyectos;

    public final String MENU = "MENU";
    public final String MENUPPAL = "MENUPRINCIPAL";
    public final String AGREGAR_TAREA = "AGREGARPTAREA";
    public final String CONSULTAR_TAREA = "CONSULTARTAREA";
    public final String DESCRIPCIONPP = "DESCRIPCIONPP";
    

    VentanaMenuPTrabajo (MenuTareas menuTareas, PaqueteTrabajo paquete) throws FileNotFoundException, IOException{
        this.menuTareas = menuTareas;
        this.paqueteTrabajo = paquete;
        pMenuPProyectos = new PMenuPProyectos(this, paquete);
        pDescripcionPP = new PDescripcionPP(this, paquete);
        //pElegirPaquetesProyecto = new pElegirPaquetesProyecto(this);
        pElegirTareas = new PElegirTareas(this, paquete.getTareas());
        //pAgregarPTrabajo = new PAgregarPTrabajo(this);
        pAgregarTarea = new PAgregarTarea(this, paquete);
        


        setTitle("Menu Paquetes de Trabajo");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuPProyectos, BorderLayout.CENTER);
    }
        public void cambiarPanel(String comando) throws FileNotFoundException, IOException {
            if (comando == MENU){
                this.remove(pDescripcionPP);
                this.remove(pElegirTareas);
                this.remove(pAgregarTarea);
                this.add(pMenuPProyectos);

            }else if (comando == AGREGAR_TAREA){
                this.remove(pMenuPProyectos);
                this.add(pAgregarTarea);

            }else if (comando == DESCRIPCIONPP){
                this.remove(pMenuPProyectos);
                this.add(pDescripcionPP);

            }else if (comando == CONSULTAR_TAREA){
                pElegirTareas = new PElegirTareas(this, paqueteTrabajo.getTareas());
                this.remove(pMenuPProyectos);
                this.add(pElegirTareas);

            }else if (comando.contains("TAREA ")){
                elegirTarea(comando);
            }
            setSize(getWidth()-1, getHeight()-1);
        }

        private void elegirTarea(String boton) throws FileNotFoundException, IOException {
            int num = Integer.parseInt(boton.replace("TAREA ", ""));
            Tarea tarea = menuTareas.elegirTarea(paqueteTrabajo, num);
            cambiarPanel(MENU);
            new VentanaMenuTareas(menuTareas, tarea);
        }

        public void AgregarTarea(String nombre, String descripcion, String fecha, String tipo, ArrayList<Participante> responsables1) throws FileNotFoundException, IOException{
            Boolean respuesta = false;
            try {
                respuesta = menuTareas.ejecutarAgregarTarea(paqueteTrabajo, nombre,  descripcion, fecha, tipo, responsables1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(pAgregarTarea, e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            if (respuesta==true){
                JOptionPane.showMessageDialog(pAgregarTarea, "La tarea fue añadida exitosamente",
                    "Tarea Añadida", JOptionPane.INFORMATION_MESSAGE);     
            }   
            else {
                JOptionPane.showMessageDialog(pAgregarTarea, "No se pudo añadir la tarea",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            cambiarPanel(MENU);
        }
    
}
