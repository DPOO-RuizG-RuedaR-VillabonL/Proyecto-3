package Interfaz;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.*;
import javax.swing.*;


public class PAgregaTipoActividad extends JPanel implements ActionListener{
    private JPanel panelNorte;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private JTextField cuadroTexto;
    private VentanaMenuProyectos ventanaMenuProyectos;
    public final String AGREGAR_P = "AGREGAR_P";
    public final String MENU = "MENU";

    public PAgregaTipoActividad(VentanaMenuProyectos ventanaMenuProyectos) {
        this.ventanaMenuProyectos = ventanaMenuProyectos;

        this.setBackground(new Color(02,28, 30) ); //fondo principal
        GridLayout grid = new GridLayout(3, 1, 5, 20);
        this.setLayout(grid);
        //crear panel norte
        panelNorte = new JPanel();
        panelNorte.setBackground(new Color(02,28, 30) ); //fondo principal
        //crear y agregar elementos de panel norte
        JLabel titulo = new JLabel("Introduzca los datos:", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 25));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        panelNorte.add(titulo);
        //crear panel central
        panelCentral = new JPanel();
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo principal
        GridLayout grid1 = new GridLayout(1, 2, 0, 5); 
        panelCentral.setLayout(grid1);
        //crear y agregar elementos de panel central
        JLabel elemento = new JLabel("Seleccione una opción: ", SwingConstants.CENTER);
        elemento.setOpaque(true);
        elemento.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
        elemento.setBackground(new Color(02,28, 30) ); //fondo principal
        elemento.setForeground( new Color(111,185, 143) ); //letra principal
        cuadroTexto = new JTextField();
        cuadroTexto.setOpaque(true);
        panelCentral.add(elemento);
        panelCentral.add(cuadroTexto);
        //crear panel sur
        panelAbajo = new JPanel();
        JButton boton1 = (new JButton("Agregar"));
        boton1.setActionCommand(AGREGAR_P);
        boton1.addActionListener((ActionListener) this);
        JButton boton2 = (new JButton("Menu Proyectos"));
        boton2.setActionCommand(MENU);
        boton2.addActionListener((ActionListener) this);
        panelAbajo.add(boton1, BorderLayout.WEST);
        panelAbajo.add(boton2, BorderLayout.EAST);
        panelAbajo.setBorder(new EmptyBorder(50, 0, 50, 0));
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setForeground( new Color(111,185, 143) );

        this.add(panelAbajo, BorderLayout.SOUTH);
        
        //agregar paneles secudarios a paneles principalesP
        this.add(panelNorte);
        this.add(panelCentral);
        this.add(panelAbajo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            ventanaMenuProyectos.cambiarPanel(comando);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if (comando==AGREGAR_P){
            String tipo = cuadroTexto.getText();

            if (tipo.length()==0){
                JOptionPane.showMessageDialog(panelCentral, "Por favor escriba en el campos antes de continuar",
				"Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            try {
                ventanaMenuProyectos.AgregarTipo(tipo);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        
    }


    
}}
