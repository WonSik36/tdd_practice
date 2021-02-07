package ch05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PracticeTest {

    @Test
    void 주요_단언_메서드() {
        assertEquals(2, 1 + 1);

        Integer x1 = 3;
        Integer x2 = 3;
        Integer x3 = 5;
        assertSame(x1, x2, "Not Same");

        assertTrue(x1 == x2);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException();
                });

        assertAll(
                () -> assertEquals(3, 6 / 2),
                () -> assertEquals(4, 2 * 2),
                () -> assertEquals(6, 13 / 2)
        );
    }
}
