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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PCrearProyecto extends JPanel implements ActionListener
{
    private VentanaMenuPrincipal ventanaMenuPrincipal;
    private JLabel label;
    private JPanel panelCentral;
    private JPanel panelAbajo;
    private JTextField textoNombre;
    private JTextField textoDescripcion;
    private JTextField textoParticipante;
    private JTextField textoCorreo;
    private JFormattedTextField textoFecha;
    private JTextField textoTipos;

    public final String MENU = "MENU";
    public final String CREAR = "CREAR"; 

    public PCrearProyecto(VentanaMenuPrincipal ventanaMenuPrincipal){

        this.ventanaMenuPrincipal = ventanaMenuPrincipal;
        this.setBackground(new Color(02,28, 30) );
        this.setLayout(new BorderLayout());
        label = new JLabel("Crear Proyecto", SwingConstants.CENTER);
        label.setFont(new Font("Aharoni", Font.BOLD, 20));
        label.setBorder(new EmptyBorder(50, 0, 0, 0));
        label.setBackground(new Color(02,28, 30) );
        label.setForeground( new Color(44,120, 115) );
        this.add(label, BorderLayout.NORTH);

        panelCentral = new JPanel();
        panelCentral.setBackground(new Color(02,28, 30) );
        GridLayout grid = new GridLayout(6, 2, 0, 15);
        panelCentral.setLayout(grid);

        textoNombre = new JTextField(SwingConstants.CENTER);
        JLabel lblNombre = new JLabel("Ingrese el nombre del proyecto", SwingConstants.LEFT);
        lblNombre.setBackground(new Color(02,28, 30) ); //fondo principal
        lblNombre.setForeground( new Color(111,185, 143) );

        textoDescripcion = new JTextField();
        JLabel lblDescripcion = new JLabel("Ingrese la descripción del proyecto", SwingConstants.LEFT);
        lblDescripcion.setBackground(new Color(02,28, 30) ); //fondo principal
        lblDescripcion.setForeground( new Color(111,185, 143) );

        textoParticipante = new JTextField();
        JLabel lblParticipante = new JLabel("Ingrese el nombre completo del participante", SwingConstants.LEFT);
        lblParticipante.setBackground(new Color(02,28, 30) ); //fondo principal
        lblParticipante.setForeground( new Color(111,185, 143) );

        textoCorreo = new JTextField();
        JLabel lblCorreo = new JLabel("Ingrese el correo del participante", SwingConstants.LEFT);
        lblCorreo.setBackground(new Color(02,28, 30) ); //fondo principal
        lblCorreo.setForeground( new Color(111,185, 143) );

        textoFecha = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        textoFecha.setText("aaaa-mm-dd");
        JLabel lblFecha = new JLabel("Ingrese la fecha de inicio", SwingConstants.LEFT);
        lblFecha.setBackground(new Color(02,28, 30) ); //fondo principal
        lblFecha.setForeground( new Color(111,185, 143) );

        textoTipos = new JTextField();
        JLabel lblTipos = new JLabel("Ingrese los tipos de actividad separados por comas", SwingConstants.LEFT);
        lblTipos.setBackground(new Color(02,28, 30) );
        lblTipos.setForeground( new Color(111,185, 143) );

        panelCentral.setBorder(new EmptyBorder(50, 100, 50, 50));

        panelCentral.add(lblNombre);
        panelCentral.add(textoNombre);
        panelCentral.add(lblDescripcion);
        panelCentral.add(textoDescripcion);
        panelCentral.add(lblParticipante);
        panelCentral.add(textoParticipante);
        panelCentral.add(lblCorreo);
        panelCentral.add(textoCorreo);
        panelCentral.add(lblFecha);
        panelCentral.add(textoFecha);
        panelCentral.add(lblTipos);
        panelCentral.add(textoTipos);
 
        this.add(panelCentral, BorderLayout.CENTER);

        panelAbajo = new JPanel();
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setBorder(new EmptyBorder(10, 0, 30, 0));
        JButton btnMenu = new JButton("Menú Principal");
        btnMenu.setActionCommand(MENU);
        btnMenu.addActionListener(this);
        panelAbajo.add(btnMenu);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(CREAR);
        btnAceptar.addActionListener(this);
        panelAbajo.add(btnAceptar);
        this.add(panelAbajo, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            ventanaMenuPrincipal.cambiarPanel(comando);
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        if (comando==CREAR){
            String nombre = textoNombre.getText();
            String descripcion = textoDescripcion.getText();
            String participante = textoParticipante.getText();
            String correo = textoCorreo.getText();
            String fecha = textoFecha.getText();
            String tipos = textoTipos.getText();

            if (nombre.length()==0 || descripcion.length()==0|| participante.length()==0|| correo.length()==0|| fecha.length()==0 || tipos.length()==0 ){
                JOptionPane.showMessageDialog(panelCentral, "Por favor escriba en todos los campos antes de continuar",
				"Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
            try {
                ventanaMenuPrincipal.CrearProyecto(nombre, descripcion, participante, correo, fecha, tipos);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
        }
        
    }
    
}