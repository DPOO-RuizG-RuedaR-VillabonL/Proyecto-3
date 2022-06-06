package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Mundo.Proyectos.Tarea;

public class PTipoTarea extends JPanel implements ActionListener
{
    public final String MENU = "MENU";
    VentanaMenuTareas ventanaMenuTareas;
    JLabel label;
    JPanel panelCentral;
    JPanel panelAbajo;
    Tarea tarea;

    public PTipoTarea(VentanaMenuTareas ventanaMenuTareas, Tarea tarea)
    {
        /** Inicio */
        this.ventanaMenuTareas = ventanaMenuTareas;
        this.tarea = tarea;

        this.setBackground(new Color(02,28, 30));
        this.setLayout(new BorderLayout());
        label = new JLabel("Descripcion", SwingConstants.CENTER);
        label.setFont(new Font("Aharoni", Font.BOLD, 20));
        label.setBorder(new EmptyBorder(50, 0, 0, 0));
        label.setBackground(new Color(02,28, 30) );
        label.setForeground( new Color(44,120, 115) );
        this.add(label, BorderLayout.NORTH);

        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(9, 1, 0, 10);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal

        //se crea texto instrucción, boton1 y boton2 y se añaden al panel central
        JLabel instruccion = new JLabel(tarea.getDescripcion(), SwingConstants.CENTER);
        instruccion.setOpaque(true);
        instruccion.setFont(new Font("Congenial SemiBold", Font.PLAIN, 20));
        instruccion.setBackground(new Color(02,28, 30) ); //fondo principal
        instruccion.setForeground( new Color(111,185, 143) ); //letra principal
        panelCentral.add(instruccion, BorderLayout.CENTER);

        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 300 , 0, 300 ));
        this.add(panelCentral, BorderLayout.CENTER);
        //Se crea panel sur y se le añade boton guardar
        panelAbajo = new JPanel();
        JButton btnMenu = new JButton("Menu Tarea");
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
        // TODO Auto-generated method stub
        
    }
}
