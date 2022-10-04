import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EjAleatorio {
    public static void EscribirEnteros() {

        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int numero;

        try {
            fichero = new RandomAccessFile("enteros.dat", "rw" );
            System.out.println("Introduce un número");
            numero = sc.nextInt();
            fichero.seek(fichero.length());
            fichero.writeInt(numero);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void LeerEnteros() {
        RandomAccessFile fichero = null;


        try {
            fichero = new RandomAccessFile("enteros.dat", "rw" );

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int numero;
        try {
            fichero.seek(0);
            while (true) {
                numero = fichero.readInt();
                System.out.println(numero);
            }
        } catch (EOFException e) {
            System.out.println("Fin fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ModificarEnteros() {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int posicion, numero;
        long size;

        try {
            fichero = new RandomAccessFile("enteros.dat", "rw");
            size = fichero.length();
            size = size / 4;
            System.out.println("El fichero tiene " + size + " enteros");

            do {
                System.out.println("Introduce la posición (>=1 y <= " + size + ")");
                posicion = sc.nextInt();
            }while (posicion < 1 || posicion > size);
            posicion--;

            fichero.seek(posicion * 4);

            System.out.println("El valor actual" + fichero.readInt());
            System.out.println("Introduce el nuevo valor: ");
            numero = sc.nextInt();
            fichero.seek(posicion * 4);
            fichero.writeInt(numero);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
