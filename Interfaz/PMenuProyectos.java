package Interfaz;

import java.awt.*;
import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.border.*;
import Mundo.Proyectos.Proyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class PMenuProyectos extends JPanel implements ActionListener
{
    private VentanaMenuProyectos ventanaMenuProyectos;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private Proyecto proyecto;

    public final String MENUPPAL = "MENUPRINCIPAL";
    public final String AGREGAR_PARTICIPANTES = "AGREGARPARTICIPANTES";
    public final String AGREGAR_TIPO = "AGREGARTIPO";
    public final String GESTIONAR = "GESTIONAR";
    public final String MODIFICAR_FIN = "MODIFICARFIN";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String PARTICIPANTES = "PARTICIPANTES";
    public final String FINICIO = "F_INICIO";
    public final String FFIN = "F_FIN";
    public final String P_TRABAJO = "P_TRABAJO";
    public final String AGREGAR_PAQUETES = "AGREGAR_P";

    public PMenuProyectos (VentanaMenuProyectos ventanaMenuProyectos, Proyecto proyecto)
    {
        this.ventanaMenuProyectos = ventanaMenuProyectos;
        this.proyecto = proyecto;
    
        this.setBackground(new Color(02,28, 30) ); //fondo color principal
        BorderLayout grid = new BorderLayout();
        this.setLayout(grid);
        JLabel titulo = new JLabel("Gestionar "+ this.proyecto.getNombre(), SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 26 ));
        titulo.setBorder(new EmptyBorder(50, 0, 20, 0));
        titulo.setBackground(new Color(02,28, 30) );
        titulo.setForeground( new Color(44,120, 115) );
        this.add(titulo, BorderLayout.NORTH);

        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(11, 1, 0, 10);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal

        //se crea texto instrucción, boton1 y boton2 y se añaden al panel central
        JLabel instruccion = new JLabel("Seleccione una opción: ", SwingConstants.CENTER);
        instruccion.setOpaque(true);
        instruccion.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
        instruccion.setBackground(new Color(02,28, 30) ); //fondo principal
        instruccion.setForeground( new Color(111,185, 143) ); //letra principal
        JButton boton1 = (new JButton("Consultar descripción del proyecto"));
        JButton boton2 = (new JButton("Consultar participantes"));
        JButton boton3 = (new JButton("Consultar fecha inicio"));
        JButton boton4 = (new JButton("Consultar fecha finalización"));
        JButton boton5 = (new JButton("Agregar participantes"));
        JButton boton6 = (new JButton("Agregar tipo actividad admitida "));
        JButton boton7 = (new JButton("Agregar fecha finalización proyecto"));
        JButton boton8 = (new JButton("Consultar Paquetes de Trabajo"));
        JButton boton9 = (new JButton("Agregar Paquete de Trabajo"));
        JButton boton10 = (new JButton("Gestionar Paquetes de Trabajo"));

        boton1.setBackground(new Color(111,185, 143)  ); //fondo botones
        boton1.setForeground(new Color(02,28, 30) ); //letra botones
        boton1.setActionCommand(DESCRIPCION);
        boton1.addActionListener(this);

        boton2.setBackground(new Color(111,185, 143)  );
        boton2.setForeground(new Color(02,28, 30) );
        boton2.setActionCommand(PARTICIPANTES);
        boton2.addActionListener(this);

        boton3.setBackground(new Color(111,185, 143)  );
        boton3.setForeground(new Color(02,28, 30) );
        boton3.setActionCommand(FINICIO);
        boton3.addActionListener(this);

        boton4.setBackground(new Color(111,185, 143)  );
        boton4.setForeground(new Color(02,28, 30) );
        boton4.setActionCommand(FFIN);
        boton4.addActionListener(this);

        boton5.setBackground(new Color(111,185, 143)  );
        boton5.setForeground(new Color(02,28, 30) );
        boton5.setActionCommand(AGREGAR_PARTICIPANTES);
        boton5.addActionListener(this);

        boton6.setBackground(new Color(111,185, 143)  );
        boton6.setForeground(new Color(02,28, 30) );
        boton6.setActionCommand(AGREGAR_TIPO);
        boton6.addActionListener(this);

        boton7.setBackground(new Color(111,185, 143)  );
        boton7.setForeground(new Color(02,28, 30) );
        boton7.setActionCommand(MODIFICAR_FIN);
        boton7.addActionListener(this);

        boton8.setBackground(new Color(111,185, 143)  );
        boton8.setForeground(new Color(02,28, 30) );
        boton8.setActionCommand(P_TRABAJO);
        boton8.addActionListener(this);

        boton9.setBackground(new Color(111,185, 143)  );
        boton9.setForeground(new Color(02,28, 30) );
        boton9.setActionCommand(AGREGAR_PAQUETES);
        boton9.addActionListener(this);

        boton10.setBackground(new Color(111,185, 143)  );
        boton10.setForeground(new Color(02,28, 30) );
        boton10.setActionCommand(GESTIONAR);
        boton10.addActionListener(this);
        
        panelCentral.add(instruccion, BorderLayout.CENTER);
        panelCentral.add (boton1, BorderLayout.CENTER);      
        panelCentral.add (boton2, BorderLayout.CENTER);
        panelCentral.add (boton3, BorderLayout.CENTER);
        panelCentral.add (boton4, BorderLayout.CENTER);
        panelCentral.add (boton5, BorderLayout.CENTER);
        panelCentral.add (boton6, BorderLayout.CENTER);
        panelCentral.add (boton7, BorderLayout.CENTER);
        panelCentral.add (boton8, BorderLayout.CENTER);
        panelCentral.add (boton9, BorderLayout.CENTER);
        panelCentral.add (boton10, BorderLayout.CENTER);
        
        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 300 , 0, 300 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar
        panelAbajo = new JPanel();
        JButton btnMenu = new JButton("Menú Principal");
        btnMenu.setActionCommand(MENUPPAL);
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
            ventanaMenuProyectos.cambiarPanel(comando);
        } catch (IOException e2)
        {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }   
}

