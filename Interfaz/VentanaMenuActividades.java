package Interfaz;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Mundo.Actividades.Participante;
import Mundo.Aplicacion.MenuActividades;

public class VentanaMenuActividades extends JFrame 
{
    public MenuActividades menuActividades;
    private PCrearActividad pCrearActividad;
    private PGestorActividades pMenuActividades;
    private PPausas pPausas;
    private Participante participante;
    public final String CREAR = "CREAR";
    public final String MENU = "MENU";
    public final String PAUSAS = "PAUSAS";


    public VentanaMenuActividades(MenuActividades menuActividades, Participante participante) 
    {
        this.menuActividades = menuActividades;
        this.participante = participante;
        pCrearActividad = new PCrearActividad(this);
        pMenuActividades = new PGestorActividades(this);
        pPausas = new PPausas(this);
        
        setTitle("Menu Actividades");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(pMenuActividades);
    }

    public void cambiarPanel(String comando) 
    {
        if (comando == CREAR)
        {
            this.remove(pMenuActividades);
            this.add(pCrearActividad);
        }
        else if (comando == MENU)
        {
            this.remove(pCrearActividad);
            this.add(pMenuActividades);
        }
        else if (comando == PAUSAS)
        {
            this.remove(pCrearActividad);
            this.remove(pMenuActividades);
            this.remove(pPausas);
            this.add(pPausas);
        }
        setSize(getWidth()-1, getHeight()-1);
    }
    
    public void CrearActividad(String nombre, String descripcion, String tipo, List<ArrayList<String>> listaFechas, List<ArrayList<String>> ListaHoras) 
    {
        Boolean respuesta = menuActividades.ejecutarCrearActividad(nombre, descripcion, tipo, listaFechas, ListaHoras);
        if (respuesta==true)
        {
            JOptionPane.showMessageDialog(pCrearActividad, "La actividad fue creada exitosamente",
				"Actividad Creada", JOptionPane.INFORMATION_MESSAGE);     
        }
        else 
        {
            JOptionPane.showMessageDialog(pCrearActividad, "No se pudo crear la actividad", "Error", JOptionPane.ERROR_MESSAGE);
        }
        cambiarPanel(MENU);
    }
    
}
