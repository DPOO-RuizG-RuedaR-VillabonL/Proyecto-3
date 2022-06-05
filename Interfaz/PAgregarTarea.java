package Interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.border.*;

import Mundo.Proyectos.PaqueteTrabajo;

import javax.swing.*;

import javax.swing.JPanel;

public class PAgregarTarea extends JPanel implements ActionListener{
    private VentanaMenuPProyectos ventanaMenuPProyectos;
    private PaqueteTrabajo paqueteTrabajo;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private JTextField rta1;
    private JTextField rta2;
    public final String AGREGAR_P = "AGREGAR_P";
    public final String MENU = "MENU";


    public PAgregarTarea (VentanaMenuPProyectos ventanaMenuPProyectos, PaqueteTrabajo paqueteTrabajo) {
        this.ventanaMenuPProyectos= ventanaMenuPProyectos;
        this.setBackground(new Color(02,28, 30) ); //fondo color principal

        GridLayout grid = new GridLayout(3, 1, 0, 0);
        this.setLayout(grid);
        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(2, 2, 0, 5);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal
        //Se crea y se añade el titulo en el panel principal
        JLabel titulo = new JLabel("Introduzca los datos", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 26 ));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        this.add(titulo, BorderLayout.NORTH);
        //se crea texto los dos titulos a llenar con sus respectivos cuadros de texto y se añaden al panel central
        JLabel Inst1 = (new JLabel("Nombre: "));
        JLabel Inst2 = (new JLabel("Correo: "));
        Inst1.setBorder(new EmptyBorder(50, 0, 20, 0));
        Inst1.setBackground(new Color(02,28, 30) );
        Inst1.setForeground( new Color(44,120, 115) );
        Inst2.setBorder(new EmptyBorder(50, 0, 20, 0));
        Inst2.setBackground(new Color(02,28, 30) );
        Inst2.setForeground( new Color(44,120, 115) );
        rta1 = (new JTextField());
        rta2 = (new JTextField());
        panelCentral.add (Inst1, BorderLayout.CENTER);
        panelCentral.add (rta1, BorderLayout.CENTER);      
        panelCentral.add (Inst2, BorderLayout.CENTER); 
        panelCentral.add (rta2, BorderLayout.CENTER);
        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 120 , 0, 120 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton Agregar
        panelAbajo = new JPanel();
        JButton boton1 = (new JButton("Agregar"));
        boton1.setActionCommand(AGREGAR_P);
        boton1.addActionListener((ActionListener) this);
        JButton boton2 = (new JButton("Menu Paquete proyectos"));
        boton2.setActionCommand(MENU);
        boton2.addActionListener((ActionListener) this);
        panelAbajo.add(boton1, BorderLayout.WEST);
        panelAbajo.add(boton2, BorderLayout.EAST);
        panelAbajo.setBorder(new EmptyBorder(50, 0, 50, 0));
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setForeground( new Color(111,185, 143) );

        this.add(panelAbajo, BorderLayout.SOUTH);

    }

    public PAgregarTarea(VentanaMenuPProyectos ventanaMenuPProyectos2) {
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        /*String comando = e.getActionCommand();
        try {
            ventanaMenuPProyectos.cambiarPanel(comando);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if (comando==AGREGAR_P){
            String nombre = rta1.getText();
            String correo = rta2.getText();

            if (nombre.length()==0 || correo.length()==0){
                JOptionPane.showMessageDialog(panelCentral, "Por favor escriba en todos los campos antes de continuar",
				"Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            try {
                ventanaMenuPProyectos.AgregarTarea(nombre, correo);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        }
        
    */}
}