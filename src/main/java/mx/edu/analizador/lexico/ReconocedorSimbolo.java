package mx.edu.analizador.lexico;

/** Reconoce los símbolos de un solo carácter: ( ) { } [ ] ; , */
public class ReconocedorSimbolo implements ReconocedorToken {
    private static final String SIMBOLOS = "(){}[];,";

    @Override
    public boolean puedeIniciar(Cursor cursor) {
        return !cursor.fin() && SIMBOLOS.indexOf(cursor.actual()) >= 0;
    }

    @Override
    public Token leer(Cursor cursor) {
        int linea = cursor.linea();
        int inicio = cursor.columna();
        String lexema = String.valueOf(cursor.actual());
        cursor.avanzar();
        int fin = cursor.columna() - 1;
        return new Token(lexema, TipoToken.SIMBOLO, linea, inicio, fin);
    }
}
