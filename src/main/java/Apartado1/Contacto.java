package Apartado1;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String apellidos;
    private String correo;
    private String numTelMovil;
    private String numTelTrabajo;
    private String numTelCasa;
    private String descripcion;

    public Contacto(String nombre, String apellidos, String correo, String numTelMovil, String numTelTrabajo, String numTelCasa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.numTelMovil = numTelMovil;
        this.numTelTrabajo = numTelTrabajo;
        this.numTelCasa = numTelCasa;
    }

    public Contacto(String nombre, String apellidos, String correo, String numTelMovil, String numTelTrabajo, String numTelCasa, String descripcion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.numTelMovil = numTelMovil;
        this.numTelTrabajo = numTelTrabajo;
        this.numTelCasa = numTelCasa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNumeroTelefono() {
        // Devuelve el número de teléfono en el orden móvil, trabajo, casa
        if (numTelMovil != null && !numTelMovil.isEmpty()) {
            return numTelMovil;
        } else if (numTelTrabajo != null && !numTelTrabajo.isEmpty()) {
            return numTelTrabajo;
        } else if (numTelCasa != null && !numTelCasa.isEmpty()) {
            return numTelCasa;
        } else {
            return "N/A"; // Si no se encuentra ningún número de teléfono
        }
    }

    @Override
    public String toString() {
        return "Contacto: " + nombre + " " + apellidos + ", Teléfono: " + getNumeroTelefono();
    }
}
