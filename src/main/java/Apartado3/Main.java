package Apartado3;

import Apartado1.Agenda;
import Apartado1.Contacto;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);




    public static int menu() {

        int opcion = 0;

        do {
            System.out.println(" -- MENU --");
            System.out.println("1. Introducir contacto");
            System.out.println("2. Buscar contacto por el nombre");
            System.out.println("3. Buscar contacto por el numero");
            System.out.println("4. Mostrar lista contactos");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
        } while ((opcion < 0) || (opcion > 6));

        return opcion;
    }

    public static void main(String[] args) {
        File archivoContactos = new File("agenda.xml");
        AgendaApartado3 agenda;
        int opcion;

        if (archivoContactos.exists()){
            agenda = AgendaXML.leerContactosDesdeXML("agenda.xml");
        } else {
            agenda = new AgendaApartado3();
        }

        do {
            opcion = menu();
            switch (opcion) {
                case 1 -> {
                  Apartado3.Contacto contacto = crearContacto();
                    if (agenda.addContacto(contacto)) {
                        System.out.println("Contacto introducido con exito");
                    } else {
                        System.out.println("No se ha podido introducir el contacto");
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el nombre del contacto");
                    String nombre = teclado.nextLine();
                    System.out.println("Introduce los apellidos del contacto");
                    String apellidos = teclado.nextLine();

                    Apartado3.Contacto contacto = agenda.buscarContacto(nombre,apellidos);
                    if (contacto != null){
                        System.out.println(contacto);
                    }
                }
                case 3 -> {
                    System.out.println("Introduce el numero del contacto");
                    String numero = teclado.nextLine();
                    Apartado3.Contacto contacto = agenda.buscarContacto(numero);
                    if (contacto != null){
                        System.out.println(contacto);
                    }
                }
                case 4 -> {
                    List<Apartado3.Contacto> contactoList = agenda.getListaContactos();
                    for (int i = 0; i<contactoList.size();i++){
                        System.out.println(contactoList.get(i));
                    }
                }
                case 0 -> {
                    AgendaXML.guardarAgendaComoXML(agenda,"agenda.xml");
                }
            }
        } while (opcion != 0);
    }

    private static Apartado3.Contacto crearContacto() {
        String nombre;
        String apellidos;
        String correo;
        String numTel;
        String descripcion;

        System.out.print("Introduce el nombre del Contacto: ");
        nombre = teclado.next();

        System.out.print("Introduce los apellidos del Contacto: ");
        apellidos = teclado.next();

        System.out.print("Introduce el correo electronico del Contacto: ");
        correo = teclado.next();

        System.out.print("Introduce el numero de telefono movil del Contacto: ");
        numTel= teclado.next();

        System.out.print("Introduce la descripcion del Contacto: ");
        descripcion = teclado.next();


        return new Apartado3.Contacto(nombre,apellidos,correo,numTel,descripcion);
    }
}