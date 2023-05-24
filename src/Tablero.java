import java.util.Objects;

public class Tablero
{
    //matriz 3x3
    /*
      0-1-2
    0-X X X
    1-0 0 0
    2-X X X
     */
    public String[][] Tablero = new String[3][3];
    public Tablero()
    {
        Tablero=new String[3][3];
        limpiarTablero();
    }
    public String fichaGanadora;

    public void generarTablero()
    {
        //Recorrer 3 filas y 3 columnas con for anidados
        for (int f=0; f<Tablero.length; f++)
        {
            for (int c=0; c<Tablero.length; c++)
            {
                //Asignar valor de guion bajo a coordenadas
                Tablero[f][c] = "_";
            }
        }
    }
    public void mostrarTablero()
    {
        System.out.println();
        //Recorrer 3 filas y 3 columnas con for anidados
        for(int f=0; f<Tablero.length; f++)
        {
            for (int c=0; c<Tablero.length; c++)
            {
                //Mostrar en consola valores almacenados en coordenadas
                System.out.print(Tablero[f][c]+" ");
            }
            System.out.println(" ");
        }
    }

    //Recibe posición de fila, columna y coordenadas de ficha
    public boolean ponerFicha(int posFila, int posColumna, String ficha)
    {
        //Si la coordenada no está vacía...
        if(Tablero[posFila][posColumna] != null)
        {
            //Si el valor de la coordenada es "_"...
            if(Objects.equals(Tablero[posFila][posColumna], "_"))
            {
                //Ingresar ficha en dicha coordenada
                Tablero[posFila][posColumna] = ficha;
                //Devolver verdadero
                return true;
            }
            //En otro caso, no se puede ingresar ficha en esa coordenada
            else
            {
                return false;
            }
        }
        //Si la coordenada está vacía
        //Indica que el tablero no se generó y devuelve falso
        else
        {
            System.out.println("El tablero no ha sido generado previamente.");
            return false;
        }
    }

    public boolean verificarTateti()
    {
        //FILA
        if((Tablero[0][0]!= "_" ) && (Tablero[0][0] == Tablero[0][1]) && (Tablero[0][1] == Tablero[0][2]))
        {
            fichaGanadora=Tablero[0][0];
            return true;
        }
        if((Tablero[1][0]!= "_" ) && (Tablero[1][0] == Tablero[1][1]) && (Tablero[1][1] == Tablero[1][2]))
        {
            fichaGanadora=Tablero[1][0];
            return true;
        }
        if((Tablero[2][0]!= "_" ) && (Tablero[2][0] == Tablero[2][1]) && (Tablero[2][1] == Tablero[2][2]))
        {
            fichaGanadora=Tablero[2][0];
            return true;
        }
        //COLUMNA
        if((Tablero[0][0]!= "_" ) && (Tablero[0][0] == Tablero[1][0]) && (Tablero[1][0] == Tablero[2][0]))
        {
            fichaGanadora=Tablero[0][0];
            return true;
        }
        if((Tablero[0][1]!= "_" ) && (Tablero[0][1] == Tablero[1][1]) && (Tablero[1][1] == Tablero[2][1]))
        {
            fichaGanadora=Tablero[0][1];
            return true;
        }
        if((Tablero[0][2]!= "_" ) && (Tablero[0][2] == Tablero[1][2]) && (Tablero[1][2] == Tablero[2][2]))
        {
            fichaGanadora=Tablero[0][2];
            return true;
        }
        //DIAGONAL
        if((Tablero[0][0]!= "_" ) && (Tablero[0][0] == Tablero[1][1]) && (Tablero[1][1] == Tablero[2][2]))
        {
            fichaGanadora=Tablero[0][0];
            return true;
        }
        if((Tablero[2][0]!= "_" ) && (Tablero[2][0] == Tablero[1][1]) && (Tablero[1][1] == Tablero[0][2]))
        {
            fichaGanadora=Tablero[2][0];
            return true;
        }
        return false;
    }

    public boolean estaLLeno()
    {
        for(int f=0;f<Tablero.length;f++)
        {
            for(int c=0;c<Tablero.length;c++)
            {
                if(Tablero[f][c].equals("_"))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean movimientoValido(int fila, int columna)
    {
        if(fila<0 || fila>2 || columna<0 || columna>2)
        {
            System.out.println("Las filas y columnas deben estar entre 1 y 3");
            return false;
        }
        else if(Tablero[fila][columna] != "_")
        {
            System.out.println("La casilla ya esta ocupada");
            return false;
        }
        else {
            return true;
        }
    }

    public void colocarFicha(int fila, int columna,String ficha)
    {
        Tablero[fila][columna]=ficha;
    }

    private void limpiarTablero()
    {
        for(int f=0;f<Tablero.length;f++)
        {
            for(int c=0;c<Tablero.length;c++)
            {
                Tablero[f][c]="_";
            }
        }
    }
}
