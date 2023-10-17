package Apartado2;

import Apartado1.Contacto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda implements Serializable {
    private List<Apartado1.Contacto> listaContactos;

    public boolean addContacto(Apartado1.Contacto contacto){
        return listaContactos.add(contacto);
    }

    public List<Apartado1.Contacto> getListaContactos() {
        List<Apartado1.Contacto> copia = new ArrayList<>(listaContactos);
        return copia;
    }

    public Apartado1.Contacto buscarContacto(String nombre, String apellidos){
        Apartado1.Contacto contactoDevolver;
        for (int i = 0; i<listaContactos.size();i++){
            contactoDevolver = listaContactos.get(i);
            if (contactoDevolver.getNombre().equalsIgnoreCase(nombre) && contactoDevolver.getNombre().equalsIgnoreCase(apellidos)){
                return contactoDevolver;
            }
        }
        return null;
    }

    public Apartado1.Contacto buscarContacto(String numTel){
        Contacto contactoDevolver;
        for (int i = 0; i<listaContactos.size();i++){
            contactoDevolver = listaContactos.get(i);
            if (contactoDevolver.getNumeroTelefono().equals(numTel)){
                return contactoDevolver;
            }
        }
        return null;
    }

    public static void guardarContactos(Agenda agenda) {
        try (ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream("contactos.obj"))) {
            guardar.writeObject(agenda);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Agenda cargarContactos() {
        Agenda agendaCargada = new Agenda();
        try (ObjectInputStream cargar = new ObjectInputStream(new FileInputStream("contactos.obj"))) {
            agendaCargada = (Agenda) cargar.readObject();
        } catch (FileNotFoundException exception) {
            System.out.println("Archivo no encontrado");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return agendaCargada;
    }

}
