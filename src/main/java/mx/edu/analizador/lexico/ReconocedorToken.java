package mx.edu.analizador.lexico;

/**
 * Reconoce un tipo de token a partir de la posición actual del cursor.
 *
 * Reglas:
 * - puedeIniciar NO consume nada (no debe llamar a cursor.avanzar()).
 * - leer consume exactamente el lexema y devuelve un Token con linea, inicio y fin.
 *   Columnas desde 1 y fin inclusivo. Para calcular inicio, lee cursor.columna()
 *   ANTES de consumir; el fin es cursor.columna() - 1 DESPUES del último carácter.
 * - leer puede devolver null si lo consumido no genera token (ej. comentarios).
 */
public interface ReconocedorToken {
    boolean puedeIniciar(Cursor cursor);

    Token leer(Cursor cursor);
}
