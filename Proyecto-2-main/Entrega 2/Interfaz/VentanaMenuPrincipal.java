package Interfaz;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Mundo.Aplicacion.MenuProyectos;
import Mundo.Proyectos.Proyecto;

@SuppressWarnings("serial")
public class VentanaMenuPrincipal extends JFrame {
    public MenuProyectos menuProyectos;
    private PCrearProyecto pCrearProyecto;
    private PMenuPrincipal pMenuPrincipal;
    private PElegirProyecto pElegirProyecto;
    Proyecto proyecto;
    public final String CREAR = "CREAR";
    public final String GESTIONAR = "GESTIONAR"; 
    public final String MENU = "MENU";
    public final String ACEPTAR = "ACEPTAR";
    public final String GUARDAR = "GUARDAR"; 
    
    public VentanaMenuPrincipal() throws FileNotFoundException, IOException, ClassNotFoundException{
        menuProyectos = new MenuProyectos();
        pCrearProyecto = new PCrearProyecto(this);
        pMenuPrincipal = new PMenuPrincipal(this);
        pElegirProyecto = new PElegirProyecto(this, menuProyectos.getProyectos());
        menuProyectos.cargarProyectos();

        setTitle("Menu principal");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuPrincipal, BorderLayout.CENTER);
         
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		new VentanaMenuPrincipal();
	}

    public void cambiarPanel(String comando) throws FileNotFoundException, IOException {
        if (comando == CREAR){
            this.remove(pMenuPrincipal);
            this.add(pCrearProyecto);

        }else if (comando == GESTIONAR){
            this.remove(pMenuPrincipal);
            pElegirProyecto = new PElegirProyecto(this, menuProyectos.getProyectos());
            this.add(pElegirProyecto);

        }else if (comando == MENU){
            this.remove(pCrearProyecto);
            this.remove(pElegirProyecto);
            this.add(pMenuPrincipal);

        }else if (comando == GUARDAR){
            menuProyectos.guardarProgreso();

        }else{
            ElegirProyecto(comando);
        }
        setSize(getWidth()-1, getHeight()-1);
    } 

    public void CrearProyecto(String nombre, String descripcion, String participante, String correo, String fecha, String tipos) throws FileNotFoundException, IOException{
        Boolean respuesta = menuProyectos.ejecutarCrearProyecto(nombre, descripcion, participante, correo, fecha, tipos);
        if (respuesta==true){
            JOptionPane.showMessageDialog(pCrearProyecto, "El proyecto fue creado exitosamente",
				"Proyecto Creado", JOptionPane.INFORMATION_MESSAGE);     
        }
        else {
            JOptionPane.showMessageDialog(pCrearProyecto, "No se pudo crear el proyecto",
				"Error", JOptionPane.ERROR_MESSAGE);
        }
        cambiarPanel(MENU);
    }

    public void ElegirProyecto(String boton) throws FileNotFoundException, IOException{
        int num = Integer.parseInt(boton.replace("PROYECTO ", ""));
        proyecto = menuProyectos.elegirProyecto(num);
        cambiarPanel(MENU);
        new VentanaMenuProyectos(menuProyectos, proyecto);
    }
}
