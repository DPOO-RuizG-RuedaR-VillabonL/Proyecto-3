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
import Mundo.Proyectos.Proyecto;

public class MenuProyectos
{
    ArrayList<Proyecto> proyectos;
    File fichero = new File("proyectos.txt");

    public MenuProyectos(){
        proyectos = new ArrayList<Proyecto>();
    }
	
	public Boolean ejecutarCrearProyecto(String nombre, String descripcion, String participante, String correo, String fecha, String tipos)
	{
        try {
            String[] tiposA = tipos.toLowerCase().replace(" ", "").split(", ");
            ArrayList<String> tiposActividad = new ArrayList<String>();
            for (String tipo : tiposA)
            {tiposActividad.add(tipo);}
		
            LocalDate fechaInicio = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE );

            Proyecto nuevoProyecto = new Proyecto(nombre, descripcion, participante, correo, fechaInicio, tiposActividad);
            nuevoProyecto.setFechaFinal(31, 12, 3022);
            proyectos.add(nuevoProyecto);
            return true;
            
        } catch (Exception e) {
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
        try {
            proyecto.getTiposActividad().add(tipo);
            return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }

    public Boolean ejecutarAgregarParticipante(Proyecto proyecto, String nombre, String correo) 
    {
        try {
        Participante nuevoParticipante = new Participante(nombre, correo);
        proyecto.agregarParticipante(nuevoParticipante);
        return true;
        
    } catch (Exception e) {
        return false;
    }
    }

    public Boolean cambiarFechaFinalizacion(Proyecto proyecto, String fecha) 
    {
        try {
            proyecto.setFechaFinal(LocalDate.parse(fecha));
            return true;
            
        } catch (Exception e) {
            return false;
        }
            

    }


    public void guardarProgreso() throws FileNotFoundException, IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            for (Proyecto proyecto: proyectos)
            {
                oos.writeObject(proyecto);
            }
        }
    }

    public void cargarProyectos() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (fichero.exists()){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                while(true){
                    try{
                        Proyecto proyecto = (Proyecto) ois.readObject();
                        proyectos.add(proyecto);
                    }
                    catch (EOFException eofException)
                    {
                        break;
                    }
                }
            }
        }}
    
    public void generarReporte(Proyecto proyecto){

    }
        

}