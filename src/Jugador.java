public class Jugador
{
    private String nombre;
    private String ficha;
    private int puntaje;

    public Jugador(String nombre, String ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
    }

    public String getFicha() {
        return ficha;
    }
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
