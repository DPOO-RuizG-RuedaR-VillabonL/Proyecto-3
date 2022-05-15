package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Mundo.Proyectos.Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PAgregarFechaF extends JPanel implements ActionListener
{
    private VentanaMenuProyectos ventanaMenuProyectos;
    private Proyecto proyecto;
    private JLabel label;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private JFormattedTextField textoFecha;

    public final String MENU = "MENU";
    public final String AGREGAR_P = "AGREGAR_P";

    public PAgregarFechaF(VentanaMenuProyectos ventanaMenuProyectos, Proyecto proyecto){

        this.ventanaMenuProyectos = ventanaMenuProyectos;
        this.setBackground(new Color(02,28, 30) );
        this.setLayout(new BorderLayout());
        label = new JLabel("Agregar fecha de finalización", SwingConstants.CENTER);
        label.setFont(new Font("Aharoni", Font.BOLD, 20));
        label.setBorder(new EmptyBorder(50, 0, 0, 0));
        label.setBackground(new Color(02,28, 30) );
        label.setForeground( new Color(44,120, 115) );
        this.add(label, BorderLayout.NORTH);

        panelCentral = new JPanel();
        panelCentral.setBackground(new Color(02,28, 30) );
        GridLayout grid = new GridLayout(1, 2, 0, 15);
        panelCentral.setLayout(grid);

        textoFecha = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        textoFecha.setText("aaaa-mm-dd");
        JLabel lblFecha = new JLabel("Ingrese la fecha de finalización", SwingConstants.LEFT);
        lblFecha.setBackground(new Color(02,28, 30) ); 
        lblFecha.setForeground( new Color(111,185, 143) );

        panelCentral.setBorder(new EmptyBorder(50, 100, 50, 50));

        panelCentral.add(lblFecha);
        panelCentral.add(textoFecha);
 
        this.add(panelCentral, BorderLayout.CENTER);

        panelAbajo = new JPanel();
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setBorder(new EmptyBorder(10, 0, 30, 0));
        JButton btnMenu = new JButton("Menú Proyectos");
        btnMenu.setActionCommand(MENU);
        btnMenu.addActionListener(this);
        panelAbajo.add(btnMenu);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(AGREGAR_P);
        btnAceptar.addActionListener(this);
        panelAbajo.add(btnAceptar);
        this.add(panelAbajo, BorderLayout.SOUTH);

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
            String fecha = textoFecha.getText();

            if (fecha.length()==0){
                JOptionPane.showMessageDialog(panelCentral, "Por favor escriba en el campo antes de continuar",
				"Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
            try {
                ventanaMenuProyectos.cambiarFechaFinalizacion(proyecto, fecha);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        }
        
    }
    
}
