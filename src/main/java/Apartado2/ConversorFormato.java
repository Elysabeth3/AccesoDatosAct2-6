package Apartado2;

import Apartado1.Agenda;
import com.thoughtworks.xstream.XStream;
import java.io.*;
public class ConversorFormato {
    public static void objetoAxml(Agenda agenda, String nombreArchivo) {
        try {
            XStream xstream = new XStream();
            String xml = xstream.toXML(agenda);

            // Guardar el XML en un archivo
            try (FileWriter writer = new FileWriter(nombreArchivo)) {
                writer.write(xml);
            }

            System.out.println("Objeto convertido a XML y guardado en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Agenda xmlAObjeto(String nombreArchivo) {
        try {
            XStream xstream = new XStream();
            Agenda agenda;
            try (FileReader reader = new FileReader(nombreArchivo)) {
                agenda = (Agenda) xstream.fromXML(reader);
            }

            System.out.println("XML convertido a objeto");
            return agenda;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
