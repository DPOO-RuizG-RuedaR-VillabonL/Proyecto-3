package Interfaz;

import java.awt.*;
import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.border.*;
import Mundo.Proyectos.Tarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class PMenuTarea extends JPanel implements ActionListener
{
    private VentanaMenuTareas ventanaMenuTareas;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private Tarea tarea;

    public final String MENU = "MENU";
    public final String MENUANTERIOR = "MENUANTERIOR";
    public final String CREAR = "CREAR";
    public final String RESPONSABLES = "RESPONSABLES";
    public final String TIPO = "TIPO";
    public final String DESCRIPCION = "DESCRIPCION";
    public final String VERTIEMPOTAREA = "VERTIEMPOTAREA";
    public final String VERFECHATAREA = "VERFECHATAREA";
    public final String GESTIONARACTIVIDAD = "GESTIONARACTIVIDAD";

    public PMenuTarea (VentanaMenuTareas ventanaMenuTareas, Tarea tarea)
    {
        this.ventanaMenuTareas = ventanaMenuTareas;
        this.tarea = tarea;
    
        this.setBackground(new Color(02,28, 30) ); //fondo color principal
        BorderLayout grid = new BorderLayout();
        this.setLayout(grid);
        JLabel titulo = new JLabel("Gestionar "+ this.tarea.getNombre(), SwingConstants.CENTER);
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
        JButton boton1 = (new JButton("Consultar descripción de la tarea"));
        JButton boton2 = (new JButton("Consultar responsables"));
        JButton boton3 = (new JButton("Consultar fecha estimada finalización"));
        JButton boton4 = (new JButton("Consultar tiempo realización"));
        JButton boton5 = (new JButton("Gestionar actividades"));

        boton1.setBackground(new Color(111,185, 143)  ); //fondo botones
        boton1.setForeground(new Color(02,28, 30) ); //letra botones
        boton1.setActionCommand(DESCRIPCION);
        boton1.addActionListener(this);

        boton2.setBackground(new Color(111,185, 143)  );
        boton2.setForeground(new Color(02,28, 30) );
        boton2.setActionCommand(RESPONSABLES);
        boton2.addActionListener(this);

        boton3.setBackground(new Color(111,185, 143)  );
        boton3.setForeground(new Color(02,28, 30) );
        boton3.setActionCommand(VERFECHATAREA);
        boton3.addActionListener(this);

        boton4.setBackground(new Color(111,185, 143)  );
        boton4.setForeground(new Color(02,28, 30) );
        boton4.setActionCommand(VERTIEMPOTAREA);
        boton4.addActionListener(this);

        boton5.setBackground(new Color(111,185, 143)  );
        boton5.setForeground(new Color(02,28, 30) );
        boton5.setActionCommand(GESTIONARACTIVIDAD);
        boton5.addActionListener(this);

        
        
        panelCentral.add(instruccion, BorderLayout.CENTER);
        panelCentral.add (boton1, BorderLayout.CENTER);      
        panelCentral.add (boton2, BorderLayout.CENTER);
        panelCentral.add (boton3, BorderLayout.CENTER);
        panelCentral.add (boton4, BorderLayout.CENTER);
        panelCentral.add (boton5, BorderLayout.CENTER);
        
        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 300 , 0, 300 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar
        panelAbajo = new JPanel();
        JButton btnMenu = new JButton("Menú");
        btnMenu.setActionCommand(MENUANTERIOR);
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
        } catch (IOException e2)
        {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }   
}
