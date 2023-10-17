package Apartado3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AgendaXML {
    public static void guardarAgendaComoXML(AgendaApartado3 agenda, String nombreArchivo) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Crear el elemento raíz "Agenda"
            Element agendaElement = document.createElement("Agenda");
            document.appendChild(agendaElement);

            ArrayList<Contacto> contactos = agenda.getListaContactos();

            for (Contacto contacto : contactos) {
                // Crear elementos para los atributos del contacto
                Element contactoElement = document.createElement("Contacto");
                agendaElement.appendChild(contactoElement);

                Element nombreElement = document.createElement("Nombre");
                nombreElement.appendChild(document.createTextNode(contacto.getNombre()));
                contactoElement.appendChild(nombreElement);

                Element apellidosElement = document.createElement("Apellidos");
                apellidosElement.appendChild(document.createTextNode(contacto.getApellidos()));
                contactoElement.appendChild(apellidosElement);

                Element correoElement = document.createElement("Correo");
                correoElement.appendChild(document.createTextNode(contacto.getCorreo()));
                contactoElement.appendChild(correoElement);

                Element numTelElement = document.createElement("NumTel");
                numTelElement.appendChild(document.createTextNode(contacto.getNumTel()));
                contactoElement.appendChild(numTelElement);

                Element descripcionElement = document.createElement("Descripcion");
                descripcionElement.appendChild(document.createTextNode(contacto.getDescripcion()));
                contactoElement.appendChild(descripcionElement);
            }

            // Crear el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(nombreArchivo));

            transformer.transform(source, result);
            System.out.println("Agenda guardada como XML en " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AgendaApartado3 leerContactosDesdeXML(String nombreArchivo) {
        AgendaApartado3 agenda = new AgendaApartado3();
        try {
            File file = new File(nombreArchivo);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList contactNodes = document.getElementsByTagName("Contacto");

            for (int i = 0; i < contactNodes.getLength(); i++) {
                Element contactElement = (Element) contactNodes.item(i);

                String nombre = contactElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String apellidos = contactElement.getElementsByTagName("Apellidos").item(0).getTextContent();
                String correo = contactElement.getElementsByTagName("Correo").item(0).getTextContent();
                String numTel = contactElement.getElementsByTagName("NumTel").item(0).getTextContent();
                String descripcion = contactElement.getElementsByTagName("Descripcion").item(0).getTextContent();
                Contacto contacto = new Contacto(nombre, apellidos, correo, numTel, descripcion);
                agenda.addContacto(contacto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agenda;
    }

}
