package mx.edu.analizador.lexico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class LexerTest {
    private Lexer lexer() {
        return new Lexer(List.of(new ReconocedorSimbolo()));
    }

    @Test
    void reconoceSimbolosConPosicion() {
        List<Token> tokens = lexer().analizar("(){\n  ;");
        assertEquals(4, tokens.size());
        assertEquals(new Token("(", TipoToken.SIMBOLO, 1, 1, 1), tokens.get(0));
        assertEquals(new Token("{", TipoToken.SIMBOLO, 1, 3, 3), tokens.get(2));
        assertEquals(new Token(";", TipoToken.SIMBOLO, 2, 3, 3), tokens.get(3));
    }

    @Test
    void caracterDesconocidoLanzaExcepcion() {
        assertThrows(IllegalStateException.class, () -> lexer().analizar("(@)"));
    }
}
