package Apartado3;

import java.util.ArrayList;
import java.util.List;

public class AgendaApartado3 {
    private List<Contacto> contactoList;

    public AgendaApartado3(){
        contactoList = new ArrayList<>();
    }

    public boolean addContacto(Contacto contacto){
        return contactoList.add(contacto);
    }

    public ArrayList<Apartado3.Contacto> getListaContactos() {
        ArrayList<Apartado3.Contacto> copia = new ArrayList<>(contactoList);
        return copia;
    }

    public Apartado3.Contacto buscarContacto(String nombre, String apellidos){
        Apartado3.Contacto contactoDevolver;
        for (int i = 0; i<contactoList.size();i++){
            contactoDevolver = contactoList.get(i);
            if (contactoDevolver.getNombre().equalsIgnoreCase(nombre) && contactoDevolver.getNombre().equalsIgnoreCase(apellidos)){
                return contactoDevolver;
            }
        }
        return null;
    }

    public Apartado3.Contacto buscarContacto(String numTel){
        Apartado3.Contacto contactoDevolver;
        for (int i = 0; i<contactoList.size();i++){
            contactoDevolver = contactoList.get(i);
            if (contactoDevolver.getNumTel().equals(numTel)){
                return contactoDevolver;
            }
        }
        return null;
    }
}
