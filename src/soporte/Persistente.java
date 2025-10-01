package soporte;

public interface Persistente {
    void guardar(Object objeto, String archivo);
    Object leer(String archivo);
}

