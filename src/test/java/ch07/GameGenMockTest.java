package ch07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {

    @DisplayName("특정 값을 리턴하게 하려면")
    @Test
    void mockTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(GameLevel.LOW)).willReturn("123");

        String num = genMock.generate(GameLevel.LOW);
        assertEquals("123", num);
    }

    @DisplayName("익셉션을 발생시키려면")
    @Test
    void mockThrowTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(null)).willThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            genMock.generate(null);
        });
    }

    @DisplayName("리턴 타입이 void인 메서드에 대해 익셉션을 발생시키려면")
    @Test
    void voidMethodWillThrowTest() {
        List<String> mockList = mock(List.class);
        willThrow(UnsupportedOperationException.class)
                .given(mockList)
                .clear();

        assertThrows(UnsupportedOperationException.class, () -> mockList.clear() );
    }
}
