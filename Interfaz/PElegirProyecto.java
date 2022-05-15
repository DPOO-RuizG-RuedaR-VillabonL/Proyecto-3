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

import Mundo.Proyectos.Proyecto;

import javax.swing.*;

import javax.swing.JPanel;

public class PElegirProyecto extends JPanel implements ActionListener
{
    private VentanaMenuPrincipal ventanaMenuPrincipal;
    ArrayList<Proyecto> proyectos;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    public final String CREAR = "CREAR";
    public final String GESTIONAR = "GESTIONAR";
    public final String MENU = "MENU"; 
    public final String GUARDAR = "GUARDAR";

    public PElegirProyecto(VentanaMenuPrincipal ventanaMenuPrincipal, ArrayList<Proyecto> proyectos) throws FileNotFoundException, IOException {
        this.proyectos = proyectos;
        this.ventanaMenuPrincipal = ventanaMenuPrincipal;
        this.setBackground(new Color(02,28, 30) ); //fondo color principal
        this.setLayout(new BorderLayout());
  
        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid = new GridLayout(0, 1);
        panelCentral.setLayout(grid); 
        panelCentral = new JPanel(); 
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal
        //Se crea y se añade el titulo en el panel principal
        JLabel titulo = new JLabel("Elegir Proyecto", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 26 ));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        this.add(titulo, BorderLayout.NORTH);

        if (proyectos.size()==0){
            JLabel lblError = new JLabel("Todavía no ha creado proyectos para gestionar");
            lblError.setBackground(new Color(02,28, 30) );
            lblError.setForeground( new Color(111,185, 143) );
            panelCentral.add(lblError);
        }
        else {
            for (int i=0; i<proyectos.size(); i++){
                Proyecto proyecto = proyectos.get(i);
                JButton boton = (new JButton(proyecto.getNombre()));
                boton.setBackground(new Color(111,185, 143)  );
                boton.setForeground(new Color(02,28, 30) ); 
                boton.setActionCommand("PROYECTO " + Integer.toString(i+1));
                boton.addActionListener(this);
                panelCentral.add(boton);      
        }}

        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 0 , 0, 0 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar

        panelAbajo = new JPanel();
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setBorder(new EmptyBorder(10, 0, 30, 0));
        JButton btnMenu = new JButton("Menú Principal");
        btnMenu.setActionCommand(MENU);
        btnMenu.addActionListener(this);
        panelAbajo.add(btnMenu);

        this.add(panelAbajo, BorderLayout.SOUTH);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            ventanaMenuPrincipal.cambiarPanel(comando);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

}   
