package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PPausas extends JPanel implements ActionListener
{
    /* creacion paneles **/
    VentanaMenuActividades ventanaMenuActividades;
    JLabel label;
    JPanel panelCentral;
    JPanel panelAbajo;

    /** Creacion Variables */

    JTextField textoFechaInicial;
    JTextField textoHoraInicial;
    JTextField textoFechaFinal;
    JTextField textoHoraFinal;
    ArrayList<LocalDate> fecha0 = new ArrayList<LocalDate>();
    ArrayList<LocalTime> hora0 = new ArrayList<LocalTime>();

    public final String TERMINADO = "ACEPTAR"; 
    public final String CREAR = "CREAR";


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
        textoFechaInicial = new JTextField();
        textoFechaInicial.setText("aaaa-mm-dd");
        JLabel lblFechaInicio = new JLabel("Ingrese la fecha de inicio", SwingConstants.LEFT);
        lblFechaInicio.setBackground(new Color(02,28, 30) ); //fondo principal
        lblFechaInicio.setForeground( new Color(111,185, 143) );

        /** Hora inicio */
        textoHoraInicial = new JTextField();
        textoHoraInicial.setText("hh:mm:ss");
        JLabel lblHoraInicial = new JLabel("Ingrese la hora de inicio", SwingConstants.LEFT);
        lblHoraInicial.setBackground(new Color(02,28, 30) ); //fondo principal
        lblHoraInicial.setForeground( new Color(111,185, 143) );

        /** Fecha final */
        textoFechaFinal = new JTextField();
        textoFechaFinal.setText("aaaa-mm-dd");
        JLabel lblFechaFinal = new JLabel("Ingrese la fecha de finalizacion", SwingConstants.LEFT);
        lblFechaFinal.setBackground(new Color(02,28, 30) ); //fondo principal
        lblFechaFinal.setForeground( new Color(111,185, 143) );

        /** Hora final */
        textoHoraFinal = new JTextField();
        textoHoraFinal.setText("hh:mm:ss");
        JLabel lblHoraFinal = new JLabel("Ingrese la hora de finalizacion", SwingConstants.LEFT);
        lblHoraFinal.setBackground(new Color(02,28, 30) ); //fondo principal
        lblHoraFinal.setForeground( new Color(111,185, 143) );

        panelCentral.setBorder(new EmptyBorder(50, 100, 50, 50));

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

    public ArrayList<LocalDate> getListFecha()
    {
        return fecha0;
    }

    public ArrayList<LocalTime> getListHora()
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

            if (fechaInicial.length()==0 || horaInicial.length()==0 || fechaFinal.length()==0 
                || horaFinal.length()==0)
            {
                JOptionPane.showMessageDialog(panelCentral, "Por favor escriba en todos los campos antes de continuar",
                "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                /** Listas de listas */
                LocalDate fechaIni = LocalDate.parse(fechaInicial);
                fecha0.add(fechaIni);
                LocalDate fechaFin = LocalDate.parse(fechaFinal);
                fecha0.add(fechaFin);

                LocalTime horaIni = LocalTime.parse(horaInicial);
                hora0.add(horaIni);
                LocalTime horaFin = LocalTime.parse(horaFinal);
                hora0.add(horaFin);
            }
            ventanaMenuActividades.cambiarPanel(CREAR);
        }
    }
}