package Interfaz;

import java.awt.*;

import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.border.*;

import Mundo.Proyectos.PaqueteTrabajo;
import Mundo.Proyectos.Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class PPaquetesTrabajo extends JPanel implements ActionListener{
    private VentanaMenuProyectos ventanaMenuProyectos;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private Proyecto proyecto;

    public final String MENUPPAL = "MENUPRINCIPAL";
    public final String MENU = "MENU";
    public final String AGREGAR_PARTICIPANTES = "AGREGARPARTICIPANTES";
    public final String AGREGAR_TIPO = "AGREGARTIPO";
    public final String GESTIONAR = "GESTIONAR";
    public final String MODIFICAR_FIN = "MODIFICARFIN";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String PARTICIPANTES = "PARTICIPANTES";
    public final String FINICIO = "F_INICIO";
    public final String FFIN = "F_FIN";

    public PPaquetesTrabajo(VentanaMenuProyectos ventanaMenuProyectos, Proyecto proyecto) {
        this.ventanaMenuProyectos = ventanaMenuProyectos;
        this.proyecto = proyecto;

        this.setBackground(new Color(02,28, 30) ); //fondo color principal

        

        BorderLayout grid = new BorderLayout();
        this.setLayout(grid);
        JLabel titulo = new JLabel("Paquetes de Trabajo  "+ this.proyecto.getNombre(), SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 26 ));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        this.add(titulo, BorderLayout.NORTH);

        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(0, 1, 0, 10);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal

        //se crea texto nombre al panel central
        ArrayList<PaqueteTrabajo> paquetes = proyecto.getPaquetesTrabajo();
        int i;
        for (i = 0; i < paquetes.size(); i++){
            String nombre = paquetes.get(i).getNombre();

            JLabel nombreT = new JLabel(nombre, SwingConstants.CENTER);
            nombreT.setOpaque(true);
            nombreT.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
            nombreT.setBackground(new Color(02,28, 30) ); //fondo principal
            nombreT.setForeground( new Color(111,185, 143) ); //letra principal
            panelCentral.add(nombreT, BorderLayout.CENTER);
            
        }

        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 300 , 0, 300 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar
        panelAbajo = new JPanel();
        JButton btnMenu = new JButton("Menú Proyectos");
        btnMenu.setActionCommand(MENU);
        btnMenu.addActionListener(this);
        panelAbajo.add(btnMenu);
        panelAbajo.setBorder(new EmptyBorder(50, 0, 50, 0));
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setForeground( new Color(111,185, 143) );

        this.add(panelAbajo, BorderLayout.SOUTH);

    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            ventanaMenuProyectos.cambiarPanel(comando);
        } 
        catch (IOException e2) 
        {
            e2.printStackTrace();
        }
        
    }

}
