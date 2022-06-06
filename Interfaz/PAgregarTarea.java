package Interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.border.*;

import Mundo.Actividades.Participante;
import Mundo.Proyectos.PaqueteTrabajo;

import javax.swing.*;

public class PAgregarTarea extends JPanel implements ActionListener{
    private VentanaMenuPTrabajo ventanaMenuPTrabajo;
    private PaqueteTrabajo paqueteTrabajo;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private JTextField nombre;
    private JTextField descripcion;
    private JFormattedTextField fecha;
    private JTextField tipo;
    private JPanel responsables;
    private ArrayList<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();

    public final String AGREGAR_P = "AGREGAR_P";
    public final String MENU = "MENU";


    public PAgregarTarea (VentanaMenuPTrabajo ventanaMenuPTrabajo, PaqueteTrabajo paqueteTrabajo) {
        this.ventanaMenuPTrabajo = ventanaMenuPTrabajo;
        this.paqueteTrabajo = paqueteTrabajo;
        this.setBackground(new Color(02,28, 30) ); //fondo color principal

        GridLayout grid = new GridLayout(3, 1, 0, 0);
        this.setLayout(grid);
        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(5, 2, 0, 5);
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
        JLabel Inst2 = (new JLabel("Descripción: "));
        JLabel Inst3 = (new JLabel("Fecha Estimada: "));
        JLabel Inst4 = (new JLabel("Tipo: "));
        JLabel Inst5 = (new JLabel("Responsables: "));

        Inst1.setBorder(new EmptyBorder(50, 0, 20, 0));
        Inst1.setBackground(new Color(02,28, 30) );
        Inst1.setForeground( new Color(44,120, 115) );

        Inst2.setBorder(new EmptyBorder(50, 0, 20, 0));
        Inst2.setBackground(new Color(02,28, 30) );
        Inst2.setForeground( new Color(44,120, 115) );

        Inst3.setBorder(new EmptyBorder(50, 0, 20, 0));
        Inst3.setBackground(new Color(02,28, 30) );
        Inst3.setForeground( new Color(44,120, 115) );

        Inst4.setBorder(new EmptyBorder(50, 0, 20, 0));
        Inst4.setBackground(new Color(02,28, 30) );
        Inst4.setForeground( new Color(44,120, 115) );

        Inst5.setBorder(new EmptyBorder(50, 0, 20, 0));
        Inst5.setBackground(new Color(02,28, 30) );
        Inst5.setForeground( new Color(44,120, 115) );

        nombre = (new JTextField());
        descripcion = (new JTextField());
        fecha = (new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd")));
        fecha.setText("aaaa-mm-dd");
        tipo = new JTextField();
        
        responsables = new JPanel();
        ArrayList<Participante> participantes = paqueteTrabajo.getProyecto().getParticipantes();
        ArrayList<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();
        for (Participante participante : participantes){
            JCheckBox checkBox = new JCheckBox(participante.getNombre(), false);
            checkBox.addActionListener((ActionListener) this);
            checkBox.setActionCommand(participante.getNombre());
            responsables.add(checkBox);
            checkBoxs.add(checkBox);
        }
        this.checkBoxs = checkBoxs;

        panelCentral.add (Inst1, BorderLayout.CENTER);
        panelCentral.add (nombre, BorderLayout.CENTER);      
        panelCentral.add (Inst2, BorderLayout.CENTER); 
        panelCentral.add (descripcion, BorderLayout.CENTER);
        panelCentral.add (Inst3, BorderLayout.CENTER); 
        panelCentral.add (fecha, BorderLayout.CENTER);
        panelCentral.add (Inst4, BorderLayout.CENTER); 
        panelCentral.add (tipo, BorderLayout.CENTER);
        panelCentral.add (Inst5, BorderLayout.CENTER); 
        panelCentral.add (responsables, BorderLayout.CENTER);

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

    public PAgregarTarea(VentanaMenuPTrabajo ventanaMenuPProyectos2) {
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            ventanaMenuPTrabajo.cambiarPanel(comando);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if (comando==AGREGAR_P){
            String nombre = this.nombre.getText();
            String descripcion = this.descripcion.getText();
            String fecha = this.fecha.getText();
            String tipo = this.tipo.getText();
            ArrayList<Participante> responsables1 = new ArrayList<Participante>();
            for (JCheckBox cb : checkBoxs)
            {
                if (cb.isSelected()){
                    String nombreP = cb.getActionCommand();
                    ArrayList<Participante> participantes = paqueteTrabajo.getProyecto().getParticipantes();
                    for (Participante participante: participantes){
                        if (participante.getNombre().equals(nombreP)){
                            responsables1.add(participante);
                        }
                    }
                }

            }

            if (nombre.length()==0 || descripcion.length()==0 || fecha.length()==0 || responsables1.size()==0){
                JOptionPane.showMessageDialog(panelCentral, "Por favor complete todos los campos antes de continuar",
				"Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            try {
                ventanaMenuPTrabajo.AgregarTarea(nombre, descripcion, fecha, tipo, responsables1);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        }
        
    }
}