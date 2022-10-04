import org.iesch.AD.modelo.Empleado;

import java.io.*;
import java.util.Stack;

public class FicheroBinario {

    public static void testEscribirFicheroBinario(){
        ObjectOutputStream f = null;
        File fichero = null;

        Empleado e1 = new Empleado("Juan", "Morena", 3, 600);
        Empleado e2 = new Empleado("Carmen", "NetBeans", 25, 900);
        Empleado e3 = new Empleado("Mario", "Intell", 35, 200);


        Stack<Empleado> pila = new Stack<>();

        pila.add(e1);
        pila.add(e2);
        pila.add(e3);

        try{
            fichero = new File("empleados");
            f = new ObjectOutputStream(new FileOutputStream(fichero));
            System.out.println("Escribiendo objetos en binario en: " + fichero.getAbsolutePath());
            f.writeObject(e1);
            f.writeObject(e2);
            f.writeObject(e3);
            f.writeObject(pila);
            System.out.println("Todo escrito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(f != null){
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                System.out.println("Fichero cerrado");
            }
        }
    }

    public static void testLeerFicheroBinario() {
        ObjectInputStream f = null;
        File fichero = null;
        try{
            fichero = new File("empleados");
            f = new ObjectInputStream(new FileInputStream(fichero));
            System.out.println("Escribiendo objetos en binario en: " + fichero.getAbsolutePath());
            String e1 = (String) f.readObject();
    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
