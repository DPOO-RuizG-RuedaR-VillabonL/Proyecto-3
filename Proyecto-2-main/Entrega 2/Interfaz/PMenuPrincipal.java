package Interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.border.*;
import javax.swing.*;

import javax.swing.JPanel;

public class PMenuPrincipal extends JPanel implements ActionListener
{
    private VentanaMenuPrincipal ventanaMenuPrincipal;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    public final String CREAR = "CREAR";
    public final String GESTIONAR = "GESTIONAR";
    public final String MENU = "MENU"; 
    public final String GUARDAR = "GUARDAR";

    public PMenuPrincipal(VentanaMenuPrincipal ventanaMenuPrincipal) {
        this.ventanaMenuPrincipal = ventanaMenuPrincipal;
        this.setBackground(new Color(02,28, 30) ); //fondo color principal

        GridLayout grid = new GridLayout(3, 1, 0, 0);
        this.setLayout(grid);
        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(4, 1, 0, 5);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal
        //Se crea y se añade el titulo en el panel principal
        JLabel titulo = new JLabel("¡Bienvenido al Gestor de proyectos!", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 26 ));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        this.add(titulo, BorderLayout.NORTH);
        //se crea texto instrucción, boton1 y boton2 y se añaden al panel central
        JLabel instruccion = new JLabel("Seleccione una opción: ", SwingConstants.CENTER);
        instruccion.setOpaque(true);
        instruccion.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
        instruccion.setBackground(new Color(02,28, 30) ); //fondo principal
        instruccion.setForeground( new Color(111,185, 143) ); //letra principal

        JButton boton1 = (new JButton("Crear un nuevo proyecto"));
        JButton boton2 = (new JButton("Gestionar un  proyecto"));

        boton1.setBackground(new Color(111,185, 143)  ); //fondo botones
        boton1.setForeground(new Color(02,28, 30) ); //letra botones
        boton1.setActionCommand(CREAR);
        boton1.addActionListener(this);
        

        boton2.setBackground(new Color(111,185, 143)  );
        boton2.setForeground(new Color(02,28, 30) );
        boton2.setActionCommand(GESTIONAR);
        boton2.addActionListener(this);


        panelCentral.add(instruccion, BorderLayout.CENTER);
        panelCentral.add (boton1, BorderLayout.CENTER);      
        panelCentral.add (boton2, BorderLayout.CENTER);
        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 120 , 0, 120 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar
        panelAbajo = new JPanel();

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setActionCommand(GUARDAR);
        btnGuardar.addActionListener(this);
        panelAbajo.add(btnGuardar, BorderLayout.SOUTH);
        
        panelAbajo.setBorder(new EmptyBorder(50, 0, 50, 0));
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setForeground( new Color(111,185, 143) );

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
        }}}