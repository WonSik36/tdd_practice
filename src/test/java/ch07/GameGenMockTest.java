package ch07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {
    @Test
    void mockTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(GameLevel.LOW)).willReturn("123");

        String num = genMock.generate(GameLevel.LOW);
        assertEquals("123", num);
    }
}
