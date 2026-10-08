package mx.edu.analizador.lexico;

public class Cursor {
    private final String texto;
    private int posicion;
    private int linea;
    private int inicioLinea;

    public Cursor(String texto) {
        this.texto = texto;
        this.posicion = 0;
        this.linea = 1;
        this.inicioLinea = 0;
    }

    public boolean fin() {
        return this.posicion >= this.texto.length();
    }

    public char actual() {
        return siguiente(0);
    }

    public char siguiente() {
        return siguiente(1);
    }

    // Mira n caracteres adelante de la posición actual sin avanzar.
    public char siguiente(int n) {
        int indice = this.posicion + n;
        if (indice < 0 || indice >= this.texto.length()) return '\0';
        return this.texto.charAt(indice);
    }

    public int linea() {
        return this.linea;
    }

    public int columna() {
        return this.posicion - this.inicioLinea + 1;
    }

    public void avanzar() {
        if (fin()) return;
        boolean saltoDeLinea = actual() == '\n';
        this.posicion++;
        if (saltoDeLinea) {
            this.linea++;
            this.inicioLinea = this.posicion;
        }
    }
}
