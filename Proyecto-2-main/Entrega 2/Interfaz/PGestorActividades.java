package Interfaz;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton; 
import javax.swing.JLabel;
import javax.swing.border.*;
import javax.swing.*;

public class PGestorActividades extends JPanel implements ActionListener{
    private VentanaMenuActividades ventanaMenuActividades;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    public final String MENU = "MENU";
    public final String CREAR = "CREAR";
    public final String ESTADISTICAS = "ESTADISTICAS";

    public PGestorActividades(VentanaMenuActividades ventanaMenuActividades) {
        this.ventanaMenuActividades= ventanaMenuActividades;
    
        this.setBackground(new Color(02,28, 30) ); //fondo color principal

        GridLayout grid = new GridLayout(3, 1, 0, 0);
        this.setLayout(grid);
        //se crea un panel central de una columna y dos filas 
        panelCentral = new JPanel(); 
        GridLayout grid1 = new GridLayout(3, 1, 0, 5);
        panelCentral.setLayout(grid1);
        panelCentral.setBackground(new Color(02,28, 30) ); //fondo color principal
        //Se crea y se añade el titulo en el panel principal
        JLabel titulo = new JLabel("Gestor de actividades", SwingConstants.CENTER);
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
        JButton boton1 = (new JButton("Crear actividad"));
        boton1.setActionCommand(CREAR);
        boton1.addActionListener(this);
        JButton boton2 = (new JButton("Consultar las estadisticas de un participante"));
        boton2.setActionCommand(ESTADISTICAS);
        boton2.addActionListener(this);
        boton1.setBackground(new Color(111,185, 143)  ); //fondo botones
        boton1.setForeground(new Color(02,28, 30) ); //letra botones
        boton2.setBackground(new Color(111,185, 143)  );
        boton2.setForeground(new Color(02,28, 30) );
        panelCentral.add(instruccion, BorderLayout.CENTER);
        panelCentral.add (boton1, BorderLayout.CENTER);      
        panelCentral.add (boton2, BorderLayout.CENTER);
        //se crean las margenes y se agrega el panel central al panel principal
        panelCentral.setBorder(new EmptyBorder(0, 120 , 0, 120 ));
        this.add(panelCentral, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        ventanaMenuActividades.cambiarPanel(comando);
        
    }

 
    
}