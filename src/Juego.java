import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego
{
    private List<Jugador> jugadorList;
    private Tablero tablero;
    private int turno;
    private String nombreJugador1;
    private  String nombreJugador2;
    private int puntajeJugador1;
    private int puntajeJugador2;
    private int ultimoPerdedor;
    private boolean primerPartida;
    Scanner s = new Scanner(System.in);
    public Juego()
    {
        tablero=new Tablero();
        jugadorList=new ArrayList<>();
        turno=0;
        puntajeJugador1=0;
        puntajeJugador2=0;
        ultimoPerdedor=0;
        primerPartida = true;
    }

    public void jugar()
    {
        //tablero.generarTablero();
        Scanner scanner = new Scanner(System.in);
        boolean jugarOtraPartida = true;
        System.out.println("¡Bienvenidos al juego del TA TE TI!");
        while (jugarOtraPartida) {
            if (nombreJugador1 == null || nombreJugador2 == null) {
                System.out.print("Ingrese el nombre del Jugador 1: ");
                nombreJugador1 = scanner.next();

                System.out.print("Ingrese el nombre del Jugador 2: ");
                nombreJugador2 = scanner.next();
            }

            jugadorList.add(new Jugador(nombreJugador1, "X"));
            jugadorList.add(new Jugador(nombreJugador2, "O"));
            if (primerPartida) {
                Random random = new Random();
                turno = random.nextInt(2);
            } else {
                turno = ultimoPerdedor;
            }
            tablero = new Tablero();
            puntajeJugador1 = 0;
            puntajeJugador2 = 0;

            System.out.println("Jugador 1: " + jugadorList.get(0).getNombre());
            System.out.println("Jugador 2: " + jugadorList.get(1).getNombre());
            System.out.println("El jugador que inicia la partida es: " + jugadorList.get(turno).getNombre());

            boolean juegoTerminado = false;
            while (!juegoTerminado) {
                tablero.mostrarTablero();
                int fila = 0;
                int columna = 0;
                do
                {
                    System.out.println("Jugador " + jugadorList.get(turno).getNombre() + " (Ficha " +jugadorList.get(turno).getFicha() +", Ingresar núm del 1-9 según NUMPAD");
                    int j = s.nextInt();
                    switch (j)
                    {
                        default: System.out.print("Valor incorrecto."); break;
                        case 1: fila=2; columna=0; break;
                        case 2: fila=2; columna=1; break;
                        case 3: fila=2; columna=2; break;
                        case 4: fila=1; columna=0; break;
                        case 5: fila=1; columna=1; break;
                        case 6: fila=1; columna=2; break;
                        case 7: fila=0; columna=0; break;
                        case 8: fila=0; columna=1; break;
                        case 9: fila=0; columna=2; break;
                    }
                }
                while (!tablero.movimientoValido(fila, columna));

                tablero.colocarFicha(fila,columna,jugadorList.get(turno).getFicha());

                if(tablero.verificarTateti())
                {
                    tablero.mostrarTablero();
                    System.out.println("¡Felicidades, " + jugadorList.get(turno).getNombre() + ", has ganado la partida!");
                    actualizarPuntaje(jugadorList.get(turno));
                    ultimoPerdedor = (turno + 1) % 2;
                    juegoTerminado = true;
                }
                else if (tablero.estaLLeno() && !tablero.verificarTateti())
                {
                    tablero.mostrarTablero();
                    System.out.println("¡El juego ha terminado en empate!");
                    actualizarPuntaje(null);
                    ultimoPerdedor = turno;
                    juegoTerminado = true;
                }
                else
                {
                    turno = (turno + 1) % 2;
                }
            }

            System.out.println("Puntaje actual:");
            System.out.println(jugadorList.get(0).getNombre() + ": " + puntajeJugador1);
            System.out.println(jugadorList.get(1).getNombre() + ": " + puntajeJugador2);

            String respuesta;
            boolean respuestaValida = false;
            while (!respuestaValida) {
                System.out.print("¿Quieren jugar otra partida? (s/n): ");
                respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("n")) {
                    jugarOtraPartida = false;
                    respuestaValida = true;
                } else if (respuesta.equalsIgnoreCase("s")) {
                    primerPartida = false;
                    tablero = new Tablero();
                    respuestaValida = true;
                } else {
                    System.out.println("Respuesta inválida. Por favor ingrese 's' o 'n'.");
                }
            }
        }

        System.out.println("Puntaje final del juego:");
        System.out.println(jugadorList.get(0).getNombre() + ": " + puntajeJugador1);
        System.out.println(jugadorList.get(1).getNombre() + ": " + puntajeJugador2);
        if (puntajeJugador1 > puntajeJugador2) {
            System.out.println("¡Felicidades, " + jugadorList.get(0).getNombre() + ", has ganado el juego!");
        } else if (puntajeJugador2 > puntajeJugador1) {
            System.out.println("¡Felicidades, " + jugadorList.get(1).getNombre() + ", has ganado el juego!");
        } else {
            System.out.println("¡El juego ha terminado en empate!");
        }
    }

    public void actualizarPuntaje(Jugador jugador) {
        if (jugador != null) {
            if (jugador.getFicha().equals("X")) {
                puntajeJugador1+=3;
                puntajeJugador2++;
            } else if (jugador.getFicha().equals("O")) {
                puntajeJugador2+=4;
                puntajeJugador1++;
            }
        }
        else {
            puntajeJugador1++;
            puntajeJugador2+=2;
        }
    }
}
