package mx.edu.analizador.lexico;

public class ReconocedorDirectiva implements ReconocedorToken {

    @Override
    public boolean puedeIniciar(Cursor cursor) {
        return !cursor.fin() && cursor.actual() == '#';
    }

    @Override
    public Token leer(Cursor cursor) {
        int linea = cursor.linea();
        int inicio = cursor.columna();
        StringBuilder lexema = new StringBuilder();

        // El bucle consume el '#' y todos los caracteres alfanuméricos contiguos
        while (!cursor.fin()) {
            char c = cursor.actual();
            if (lexema.isEmpty() || Character.isLetterOrDigit(c)) {
                lexema.append(c);
                cursor.avanzar();
            } else {
                break;
            }
        }

        int fin = cursor.columna() - 1;
        return new Token(lexema.toString(), TipoToken.DIRECTIVA, linea, inicio, fin);
    }
}