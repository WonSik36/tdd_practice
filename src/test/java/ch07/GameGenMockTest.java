package ch07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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

    @DisplayName("특정한 인자값이 아닌 경우 null 반환")
    @Test
    void notMathingParameter() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(GameLevel.LOW)).willReturn("123");

        String num = genMock.generate(GameLevel.MID);
        assertNull(num);
    }

    @DisplayName("AnyMatcher 사용")
    @Test
    void anyMatchTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(any())).willReturn("456");

        String num = genMock.generate(GameLevel.LOW);
        assertEquals("456", num);

        String num2 = genMock.generate(GameLevel.MID);
        assertEquals("456", num2);
    }

    @Test
    void mixAnyAndEq() {
        List<String> mockList = mock(List.class);

        given(mockList.set(anyInt(), eq("123"))).willReturn("456");

        String old = mockList.set(5, "123");
        assertEquals("456", old);
    }
}
