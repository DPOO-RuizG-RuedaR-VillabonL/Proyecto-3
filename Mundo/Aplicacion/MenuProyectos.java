package Mundo.Aplicacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Mundo.Actividades.Participante;
import Mundo.Proyectos.PaqueteTrabajo;
import Mundo.Proyectos.Proyecto;

public class MenuProyectos
{
    ArrayList<Proyecto> proyectos;
    File fichero = new File("proyectos.txt");

    public MenuProyectos()
    {
        proyectos = new ArrayList<Proyecto>();
    }
	
	public Boolean ejecutarCrearProyecto(String nombre, String descripcion, String participante, String correo, String fecha, String tiposActividad, String tiposTarea)
	{
        try {
            String[] tiposA = tiposActividad.toLowerCase().replace(" ", "").split(", ");
            ArrayList<String> tiposAct = new ArrayList<String>();
            for (String tipo : tiposA)
            {
                tiposAct.add(tipo.strip());
            }
            
            String[] tiposT = tiposTarea.toLowerCase().split(", ");
            ArrayList<String> tiposTa = new ArrayList<String>();
            for (String tipo : tiposT)
            {
                tiposTa.add(tipo.strip());
            }
            LocalDate fechaInicio = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE );

            Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, participante, correo, fechaInicio, tiposAct, tiposTa);
            nuevoProyecto.setFechaFinal(31, 12, 3022);
            proyectos.add(nuevoProyecto);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
	}

    public ArrayList<Proyecto> getProyectos() 
    {
        return proyectos;
    }

    public Proyecto elegirProyecto(int num)
    {
        Proyecto proyecto = proyectos.get(num-1);
        return proyecto;
    }

    public Boolean ejecutarAgregarTipo(Proyecto proyecto, String tipo) 
    {
        try
        {
            proyecto.getTiposActividad().add(tipo);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Boolean ejecutarAgregarParticipante(Proyecto proyecto, String nombre, String correo) throws Exception 
    {
        ArrayList<Participante> participantes = proyecto.getParticipantes();
        Boolean encontro = false;
        for (Participante participante : participantes){
            String nombreP = participante.getNombre();
            String correoP = participante.getCorreo();
            if (nombreP.equals(nombre) && correoP.equals(correo)){
                encontro = true;
            }
        }
        if (encontro == false)
        {
            Participante nuevoParticipante = new Participante(nombre, correo);
            proyecto.agregarParticipante(nuevoParticipante);
            return true;
        }
        else{
            throw new Exception("Ya existe un participante con ese nombre y correo");
        }
        
    }
    public Boolean ejecutarAgregarPTrabajo(Proyecto proyecto, String nombre, String descripcion) throws Exception 
    {   
        ArrayList<PaqueteTrabajo> paquetes = proyecto.getPaquetesTrabajo();
        Boolean encontro = false;
        for (PaqueteTrabajo paquete : paquetes){
            String nombreP = paquete.getNombre();
            String descripcionP = paquete.getDescripcion();
            if (nombreP.equals(nombre) && descripcionP.equals(descripcion)){
                encontro = true;
            }
        }
        if (encontro == false)
        {
            PaqueteTrabajo nuevoPaquete = new PaqueteTrabajo(nombre, descripcion, proyecto);
            proyecto.agregarPaquete(nuevoPaquete);
            return true;
        }
        else{
            throw new Exception("Ya existe un paquete con ese nombre y descripción");
        }
        
    }

    public Boolean cambiarFechaFinalizacion(Proyecto proyecto, String fecha) 
    {
            LocalDate fechaInicial = proyecto.getFechaInicial();
            LocalDate fechaFinal = LocalDate.parse(fecha);
            if (fechaFinal.isAfter(fechaInicial))
            {
                proyecto.setFechaFinal(fechaFinal);
                return true;
            }
            else
            {
                return false; 
            }

    }

    public void guardarProgreso() throws FileNotFoundException, IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero)))
        {
            for (Proyecto proyecto: proyectos)
            {
                oos.writeObject(proyecto);
            }
        }
    }

    public void cargarProyectos() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        if (fichero.exists())
        {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero)))
        {
                while(true)
                {
                    try
                    {
                        Proyecto proyecto = (Proyecto) ois.readObject();
                        proyectos.add(proyecto);
                    }
                    catch (EOFException eofException)
                    {
                        break;
                    }
                }
            }
        }
    }
    
    public void generarReporte(Proyecto proyecto)
    {
    }
}