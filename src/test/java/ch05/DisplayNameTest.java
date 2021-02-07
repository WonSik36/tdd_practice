package ch05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("@DisplayName 테스트")
public class DisplayNameTest {
    @DisplayName("값 같은지 비교")
    @Test
    void assertEqualsMethod() {
        assertEquals(2, 1+1);
    }
}
