package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PPausas extends JPanel implements ActionListener
{
    /* creacion paneles **/
    private VentanaMenuActividades ventanaMenuActividades;
    private JLabel label;
    private JPanel panelCentral;
    private JPanel panelAbajo;

    /** Creacion Variables */

    private JFormattedTextField textoFechaInicial;
    private JFormattedTextField textoHoraInicial;
    private JFormattedTextField textoFechaFinal;
    private JFormattedTextField textoHoraFinal;
    private ArrayList<String> fecha0 = new ArrayList<String>();
    private ArrayList<String> hora0 = new ArrayList<String>();

    public final String TERMINADO = "ACEPTAR"; 

    public PPausas(VentanaMenuActividades ventanaMenuActividades)
    {
        /** Inicio */
        this.ventanaMenuActividades = ventanaMenuActividades;
        this.setBackground(new Color(02,28, 30) );
        this.setLayout(new BorderLayout());
        label = new JLabel("Pausas", SwingConstants.CENTER);
        label.setFont(new Font("Aharoni", Font.BOLD, 20));
        label.setBorder(new EmptyBorder(50, 0, 0, 0));
        label.setBackground(new Color(02,28, 30) );
        label.setForeground( new Color(44,120, 115) );
        this.add(label, BorderLayout.NORTH);

        /** Creacion panel */
        panelCentral = new JPanel();
        panelCentral.setBackground(new Color(02,28, 30) );
        GridLayout grid = new GridLayout(4, 2, 0, 15);
        panelCentral.setLayout(grid);
            
        /** Fecha inicio */
        textoFechaInicial = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        textoFechaInicial.setText("aaaa-mm-dd");
        JLabel lblFechaInicio = new JLabel("Ingrese la fecha de inicio", SwingConstants.LEFT);
        lblFechaInicio.setBackground(new Color(02,28, 30) ); //fondo principal
        lblFechaInicio.setForeground( new Color(111,185, 143) );

        /** Hora inicio */
        textoHoraInicial = new JFormattedTextField(new SimpleDateFormat("hh-MM-ss"));
        textoHoraInicial.setText("hh-mm-ss");
        JLabel lblHoraInicial = new JLabel("Ingrese la hora de inicio", SwingConstants.LEFT);
        lblHoraInicial.setBackground(new Color(02,28, 30) ); //fondo principal
        lblHoraInicial.setForeground( new Color(111,185, 143) );

        /** Fecha final */
        textoFechaFinal = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        textoFechaFinal.setText("aaaa-mm-dd");
        JLabel lblFechaFinal = new JLabel("Ingrese la fecha de finalizacion", SwingConstants.LEFT);
        lblFechaFinal.setBackground(new Color(02,28, 30) ); //fondo principal
        lblFechaFinal.setForeground( new Color(111,185, 143) );

        /** Hora final */
        textoHoraFinal = new JFormattedTextField(new SimpleDateFormat("hh-MM-ss"));
        textoHoraFinal.setText("hh-mm-ss");
        JLabel lblHoraFinal = new JLabel("Ingrese la hora de finalizacion", SwingConstants.LEFT);
        lblHoraFinal.setBackground(new Color(02,28, 30) ); //fondo principal
        lblHoraFinal.setForeground( new Color(111,185, 143) );

        panelCentral.add(lblFechaInicio);
        panelCentral.add(textoFechaInicial);
        panelCentral.add(lblHoraInicial);
        panelCentral.add(textoHoraInicial);
        panelCentral.add(lblFechaFinal);
        panelCentral.add(textoFechaFinal);
        panelCentral.add(lblHoraFinal);
        panelCentral.add(textoHoraFinal);

        this.add(panelCentral, BorderLayout.CENTER);

        /** Panel abajo */
        panelAbajo = new JPanel();
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setBorder(new EmptyBorder(10, 0, 30, 0));

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(TERMINADO);
        btnAceptar.addActionListener(this);
        panelAbajo.add(btnAceptar);

        this.add(panelAbajo, BorderLayout.SOUTH);
    }

    public ArrayList<String> getListFecha()
    {
        return fecha0;
    }

    public ArrayList<String> getListHora()
    {
        return hora0;
    }

    @Override

    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        if (comando == TERMINADO)
        {
            /** Creacion Variables */
            String fechaInicial = textoFechaInicial.getText();
            String horaInicial = textoHoraInicial.getText();
            String fechaFinal = textoFechaFinal.getText();
            String horaFinal = textoHoraFinal.getText();

            /** Listas de listas */

            fecha0.add(fechaInicial);
            fecha0.add(fechaFinal);

            hora0.add(horaInicial);
            hora0.add(horaFinal);
        }
    }
}