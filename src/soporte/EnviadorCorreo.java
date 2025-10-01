package soporte;


public interface EnviadorCorreo {
    void enviar(String destinatario, String asunto, String cuerpo, String adjunto);
}
