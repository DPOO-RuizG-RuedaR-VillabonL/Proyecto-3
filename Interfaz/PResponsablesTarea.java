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

import Mundo.Actividades.Participante;
import Mundo.Proyectos.Tarea;

import javax.swing.*;

import javax.swing.JPanel;

public class PResponsablesTarea extends JPanel implements ActionListener
{
    private VentanaMenuTareas ventanaMenuTareas;
    ArrayList<Participante> Responsables;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private Tarea tarea;
    public final String CREAR = "CREAR";
    public final String GESTIONAR = "GESTIONAR";
    public final String MENU = "MENU"; 
    public final String GUARDAR = "GUARDAR";


    public PResponsablesTarea(VentanaMenuTareas ventanaMenuTareas, Tarea tarea) throws FileNotFoundException, IOException {
        this.tarea = tarea;
        this.ventanaMenuTareas = ventanaMenuTareas;
    
        this.setBackground(new Color(02,28, 30) ); //fondo color principal

        BorderLayout grid = new BorderLayout();
        this.setLayout(grid);
        JLabel titulo = new JLabel("Responsables  "+ this.tarea.getNombre(), SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 26 ));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        this.add(titulo, BorderLayout.NORTH);

        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(0, 2, 0, 10);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal

        //se crea texto nombre al panel central
        ArrayList<Participante> participantes = tarea.getResponsables();
        int i;
        for (i = 0; i < participantes.size(); i++)
        {
            String nombre = participantes.get(i).getNombre();
            String correo = participantes.get(i).getCorreo();

            JLabel nombreT = new JLabel(nombre, SwingConstants.CENTER);
            nombreT.setOpaque(true);
            nombreT.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
            nombreT.setBackground(new Color(02,28, 30) ); //fondo principal
            nombreT.setForeground( new Color(111,185, 143) ); //letra principal
            panelCentral.add(nombreT, BorderLayout.CENTER);

            JLabel correoT = new JLabel(correo, SwingConstants.CENTER);
            correoT.setOpaque(true);
            correoT.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
            correoT.setBackground(new Color(02,28, 30) ); //fondo principal
            correoT.setForeground( new Color(111,185, 143) ); //letra principal
            panelCentral.add(correoT, BorderLayout.CENTER);
        }
        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 300 , 0, 300 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar
        panelAbajo = new JPanel();
        JButton btnMenu = new JButton("Menú Tarea");
        btnMenu.setActionCommand(MENU);
        btnMenu.addActionListener(this);
        panelAbajo.add(btnMenu);
        panelAbajo.setBorder(new EmptyBorder(50, 0, 50, 0));
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setForeground( new Color(111,185, 143) );

        this.add(panelAbajo, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        try
        {
            ventanaMenuTareas.cambiarPanel(comando);
        }
        catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }

}   
