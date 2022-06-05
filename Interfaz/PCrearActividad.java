package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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

public class PCrearActividad extends JPanel implements ActionListener
{
    /* creacion paneles **/
    private VentanaMenuActividades ventanaMenuActividades;
    private JLabel label;
    private JPanel panelCentral;
    private JPanel panelAbajo;

    /* variables swing **/
    private JTextField textoTitulo;
    private JTextField textoDescripcion;
    private JTextField textoTipo;
    private JTextField textoFechaInicial;
    private JTextField textoHoraInicial;
    private JTextField textoFechaFinal;
    private JTextField textoHoraFinal;
    private JFormattedTextField textoPausas;

    public final String MENU = "MENU";
    public final String CREAR = "CREAR"; 
    public final String PAUSAS = "PAUSAS";

    public PCrearActividad(VentanaMenuActividades ventanaMenuActividades)
    {
        /** Inicio */
        this.ventanaMenuActividades = ventanaMenuActividades;
        this.setBackground(new Color(02,28, 30) );
        this.setLayout(new BorderLayout());
        label = new JLabel("Crear Actividad", SwingConstants.CENTER);
        label.setFont(new Font("Aharoni", Font.BOLD, 20));
        label.setBorder(new EmptyBorder(50, 0, 0, 0));
        label.setBackground(new Color(02,28, 30) );
        label.setForeground( new Color(44,120, 115) );
        this.add(label, BorderLayout.NORTH);

        /** Creacion panel */
        panelCentral = new JPanel();
        panelCentral.setBackground(new Color(02,28, 30) );
        GridLayout grid = new GridLayout(8, 2, 0, 15);
        panelCentral.setLayout(grid);

        /** Titulo */
        textoTitulo = new JTextField(SwingConstants.CENTER);
        JLabel lblTitulo = new JLabel("Ingrese el titulo de la actividad", SwingConstants.LEFT);
        lblTitulo.setBackground(new Color(02,28, 30) ); //fondo principal
        lblTitulo.setForeground( new Color(111,185, 143) );

        /** Descripcion */
        textoDescripcion = new JTextField();
        JLabel lblDescripcion = new JLabel("Ingrese la descripción de la actividad", SwingConstants.LEFT);
        lblDescripcion.setBackground(new Color(02,28, 30) ); //fondo principal
        lblDescripcion.setForeground( new Color(111,185, 143) );

        /** Tipo */
        textoTipo = new JTextField();
        JLabel lblTipo = new JLabel("Ingrese el tipo", SwingConstants.LEFT);
        lblTipo.setBackground(new Color(02,28, 30) ); //fondo principal
        lblTipo.setForeground( new Color(111,185, 143) );

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

        /** Pausas */
        textoPausas = new JFormattedTextField();
        JLabel lblPausas = new JLabel("Ingrese la cantidad de pausas realizadas", SwingConstants.LEFT);
        lblPausas.setBackground(new Color(02,28, 30) );
        lblPausas.setForeground( new Color(111,185, 143) );

        panelCentral.setBorder(new EmptyBorder(50, 100, 50, 50));

        panelCentral.add(lblTitulo);
        panelCentral.add(textoTitulo);
        panelCentral.add(lblDescripcion);
        panelCentral.add(textoDescripcion);
        panelCentral.add(lblTipo);
        panelCentral.add(textoTipo);

        panelCentral.add(lblFechaInicio);
        panelCentral.add(textoFechaInicial);
        panelCentral.add(lblHoraInicial);
        panelCentral.add(textoHoraInicial);
        panelCentral.add(lblFechaFinal);
        panelCentral.add(textoFechaFinal);
        panelCentral.add(lblHoraFinal);
        panelCentral.add(textoHoraFinal);

        panelCentral.add(lblPausas);
        panelCentral.add(textoPausas);
 
        this.add(panelCentral, BorderLayout.CENTER);

        /** Panel abajo */
        panelAbajo = new JPanel();
        panelAbajo.setBackground(new Color(02,28, 30) );
        panelAbajo.setBorder(new EmptyBorder(10, 0, 30, 0));

        JButton btnMenu = new JButton("Menu actividades");
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
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        if (comando==CREAR)
        {
            /** Creacion Variables */
            String titulo = textoTitulo.getText();
            String descripcion = textoDescripcion.getText();
            String tipo = textoTipo.getText();

            String fechaInicial = textoFechaInicial.getText();
            String horaInicial = textoHoraInicial.getText();
            String fechaFinal = textoFechaFinal.getText();
            String horaFinal = textoHoraFinal.getText();

            String pausas = textoPausas.getText();
            int cantidadPausas = Integer.parseInt(pausas);

            if (titulo.length()==0 || descripcion.length()==0 || tipo.length()==0 || fechaInicial.length()==0 || 
                horaInicial.length()==0 || fechaFinal.length()==0 || horaFinal.length()==0 || textoPausas.getText().length()==0)
            {
                JOptionPane.showMessageDialog(panelCentral, "Por favor escriba en todos los campos antes de continuar",
                "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (cantidadPausas > 0)
            {
                /** Listas de listas */
                ArrayList<LocalDate> fecha0 = new ArrayList<LocalDate>();
                ArrayList<LocalTime> hora0 = new ArrayList<LocalTime>();

                LocalDate fechaIni = LocalDate.parse(fechaInicial);
                fecha0.add(fechaIni);
                LocalDate fechaFin = LocalDate.parse(fechaFinal);
                fecha0.add(fechaFin);

                LocalTime horaIni = LocalTime.parse(horaInicial);
                hora0.add(horaIni);
                LocalTime horaFin = LocalTime.parse(horaFinal);
                hora0.add(horaFin);

                List<ArrayList<LocalDate>> listaFechas = new ArrayList<ArrayList<LocalDate>>();
                List<ArrayList<LocalTime>> listaHoras = new ArrayList<ArrayList<LocalTime>>();

                listaFechas.add(fecha0);
                listaHoras.add(hora0);
                int i = 0;
                while (i <= cantidadPausas)
                {
                    ventanaMenuActividades.cambiarPanel(PAUSAS);
                    PPausas pPausas = new PPausas(ventanaMenuActividades);
                    listaFechas.add(pPausas.getListFecha());
                    listaHoras.add(pPausas.getListHora());
                    i++;
                }
                ventanaMenuActividades.CrearActividad(titulo, descripcion, tipo, listaFechas, listaHoras);
            }
            else if(cantidadPausas == 0)
            {
                /** Listas de listas */
                ArrayList<LocalDate> fecha0 = new ArrayList<LocalDate>();
                ArrayList<LocalTime> hora0 = new ArrayList<LocalTime>();

                LocalDate fechaIni = LocalDate.parse(fechaInicial);
                fecha0.add(fechaIni);
                LocalDate fechaFin = LocalDate.parse(fechaFinal);
                fecha0.add(fechaFin);

                LocalTime horaIni = LocalTime.parse(horaInicial);
                hora0.add(horaIni);
                LocalTime horaFin = LocalTime.parse(horaFinal);
                hora0.add(horaFin);

                List<ArrayList<LocalDate>> listaFechas = new ArrayList<ArrayList<LocalDate>>();
                List<ArrayList<LocalTime>> listaHoras = new ArrayList<ArrayList<LocalTime>>();

                listaFechas.add(fecha0);
                listaHoras.add(hora0);

                ventanaMenuActividades.CrearActividad(titulo, descripcion, tipo, listaFechas, listaHoras);
            }
        }
        else if (comando==MENU)
        {
            ventanaMenuActividades.cambiarPanel(MENU);
        }
    }
}
