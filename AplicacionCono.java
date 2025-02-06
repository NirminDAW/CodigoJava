

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Clase principal que contiene la aplicación de consola.
 */
public class AplicacionCono {
    public static void main(String[] args) {
        // Solicitar valores al usuario
        float radioBase1 = solicitarValor("Ingrese el radio de la base del primer cono: ");
        float altura1 = solicitarValor("Ingrese la altura del primer cono: ");
        float radioBase2 = solicitarValor("Ingrese el radio de la base del segundo cono: ");
        float altura2 = solicitarValor("Ingrese la altura del segundo cono: ");
        float radioBase3 = solicitarValor("Ingrese el radio de la base del tercer cono: ");
        float altura3 = solicitarValor("Ingrese la altura del tercer cono: ");
        float radioBase4 = solicitarValor("Ingrese el radio de la base del cuarto cono: ");
        float altura4 = solicitarValor("Ingrese la altura del cuarto cono: ");

        // Crear los objetos Cono
        Cono cono1 = new Cono(radioBase1, altura1);
        Cono cono2 = new Cono(radioBase2, altura2);
        Cono cono3 = new Cono(radioBase3, altura3);
        Cono cono4 = new Cono(radioBase4, altura4);

        // Imprimir el área de la base de cada cono
        System.out.println("Área de la base del primer cono: " + cono1.calcularAreaBase());
        System.out.println("Área de la base del segundo cono: " + cono2.calcularAreaBase());
        System.out.println("Área de la base del tercer cono: " + cono3.calcularAreaBase());
        System.out.println("Área de la base del cuarto cono: " + cono4.calcularAreaBase());

        // Imprimir el volumen de cada cono
        System.out.println("Volumen del primer cono: " + cono1.calcularVolumen());
        System.out.println("Volumen del segundo cono: " + cono2.calcularVolumen());
        System.out.println("Volumen del tercer cono: " + cono3.calcularVolumen());
        System.out.println("Volumen del cuarto cono: " + cono4.calcularVolumen());

        // Crear una lista de conos y ordenarla de mayor a menor por volumen
        ArrayList<Cono> conos = new ArrayList<>();
        conos.add(cono1);
        conos.add(cono2);
        conos.add(cono3);
        conos.add(cono4);

        Collections.sort(conos, new Comparator<Cono>() {
            @Override
            public int compare(Cono c1, Cono c2) {
                // Orden descendente por volumen
                return Float.compare(c2.calcularVolumen(), c1.calcularVolumen());
            }
        });

        System.out.println("Conos ordenados de mayor a menor volumen:");
        for (Cono cono : conos) {
            System.out.println("Volumen: " + cono.calcularVolumen());
        }
    }

    /**
     * Método para solicitar un valor numérico al usuario.
     *
     * @param mensaje el mensaje para solicitar el valor.
     * @return el valor numérico ingresado por el usuario.
     */
    private static float solicitarValor(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextFloat();
    }
}

/**
 * Clase que representa un cono.
 */
class Cono {
    private float radioBase;
    private float altura;

    /**
     * Constructor de la clase Cono.
     *
     * @param radioBase el radio de la base del cono.
     * @param altura    la altura del cono.
     */
    public Cono(float radioBase, float altura) {
        this.radioBase = radioBase;
        this.altura = altura;
    }

    // Getters y Setters

    /**
     * Obtiene el radio de la base del cono.
     *
     * @return el radio de la base del cono.
     */
    public float getRadioBase() {
        return radioBase;
    }

    /**
     * Establece el radio de la base del cono.
     *
     * @param radioBase el radio de la base del cono.
     */
    public void setRadioBase(float radioBase) {
        this.radioBase = radioBase;
    }

    /**
     * Obtiene la altura del cono.
     *
     * @return la altura del cono.
     */
    public float getAltura() {
        return altura;
    }

    /**
     * Establece la altura del cono.
     *
     * @param altura la altura del cono.
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * Calcula el área de la base del cono.
     *
     * @return el área de la base del cono.
     */
    public float calcularAreaBase() {
        return (float) (Math.PI * Math.pow(radioBase, 2));
    }

    /**
     * Calcula el volumen del cono.
     *
     * @return el volumen del cono.
     */
    public float calcularVolumen() {
        return (float) (Math.PI * Math.pow(radioBase, 2) * altura / 3);
    }
}
