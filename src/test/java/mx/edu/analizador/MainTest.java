package mx.edu.analizador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void mainSeEjecuta() {
        assertDoesNotThrow(() -> Main.main(new String[0]));
    }
}
