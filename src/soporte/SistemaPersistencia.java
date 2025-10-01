package soporte;

import java.io.*;

public class SistemaPersistencia implements Persistente {

    @Override
    public void guardar(Object objeto, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto guardado en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el objeto: " + e.getMessage());
        }
    }

    @Override
    public Object leer(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Object obj = ois.readObject();
            System.out.println("Objeto leído desde " + archivo);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al leer el objeto: " + e.getMessage());
        }
    }
}