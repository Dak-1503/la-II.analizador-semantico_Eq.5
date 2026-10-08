package mx.edu.analizador.lexico;

public record Token(String lexema, TipoToken tipo, int linea, int inicio, int fin) {}
