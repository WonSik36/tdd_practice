# TDD 공부

> 본 리포지토리는 테스트 주도 개발 시작하기 (2020.06, 최범균) 을 바탕으로 작성되었습니다.

## TDD 흐름
### 테스트 -> 코딩 -> 리팩토링 -> 테스트
> TDD는 테스트를 먼저 작성하고 테스트를 통과 시킬만큼 코드를 작성하고 리팩토링으로 마무리 하는 과정을 반복한다. (p.57)

## 테스트 코드 작성 순서
* 쉬운 경우에서 어려운 경우로 진행
* 예외적인 경우에서 정상인 경우로 진행
* 완급 조절
    1. 정해진 값을 리턴
    2. 값 비교를 이용해서 정해진 값을 리턴
    3. 다양한 테스트를 추가하면서 구현을 일반화

## 파라미터를 바꾸는 리팩토링 방법
1. 파라미터를 담당하는 클래스를 만든다.
2. 해당 파라미터를 사용하는 오버로딩 된 메서드를 생성한다.
3. 기존 메서드가 새로 만든 메서드를 호출하도록 변경한다. (테스트 실행해서 통과 확인)
4. 기존 메서드를 사용하는 코드를 새로 만든 메서드를 호출하도록 변경. (테스트 실행해서 통과 확인)
5. 기존 메서드 제거

## 시작이 안될때는 단언부터 고민
테스트 코드 작성시, 시작이 잘 안될때는 단언부터 역으로 생각해보자.

## 설계 과정을 지원하는 TDD
* 테스트 코드
    * 테스트할 기능
        * 클래스, 메서드, 함수 이름
        * 파라미터
    * 결과 검증
        * 리턴 값
    
## 필요한 만큼만 설계하기
> TDD는 테스트를 통과할 만큼만 코드를 작성한다. 필요할 것으로 예측해서 미리 코드를 만들지 않는다. (p.105)

## 기능 명세 구체화
> 모호한 상황을 만나면 이를 구체적인 예로 바꾸어 테스트 코드에 반영한다. (p.108)

## 대역의 종류 (p.152)
* 스텁(stub): 구현을 단순한 것으로 대체
* 가짜(fakse): 제품에는 적합하지 않지만, 실제 동작하는 객체
* 스파이(spy): 호출된 내용을 기록. 기록한 내용은 테스트 결과를 검증할때 사용
* 모의(mock): 기대한 대로 상호작용하는지 행위를 검증. 스텁이자 스파이의 역할 모두 가능

## Mockito 사용법 (p.276)
### 의존 설정
```
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>2.28.2</version>
    <scope>test</scope>
</dependency>
```
### 모의 객체 생성
```
@Test
void mockTest() {
    MockedObject obj = mock(MockedObject.class);
}
```
### 특정 값을 리턴하도록
```
@Test
void mockTest() {
    MockedObject obj = mock(MockedObject.class);
    given(obj.someMethod(1)).willReturn("1");
    
    String num = obj.someMethod(1);
    assertEquals("1", num);
}
```
### 특정 예외를 발생시키도록
```
@Test
void mockTest() {
    MockedObject obj = mock(MockedObject.class);
    given(obj.someMethod(1)).willThrow(IllegalArgumentException.class);
    
    assertThrows(
            IllegalArgumentException.class,
            () -> {
                String num = obj.someMethod(1);
            }
    );
}
```
### 인자 매칭 처리
```
@Test
void mockTest() {
    MockedObject obj = mock(MockedObject.class);
    given(obj.someMethod(anyInt())).willReturn("1");
    
    String num = obj.someMethod(1);
    assertEquals("1", num);
    
    String num2 = obj.someMethod(2);
    assertEquals("1", num2);
}
```
### 행위 검증
```
@Test
void mockTest() {
    MockedObject obj = mock(MockedObject.class);
    given(obj.someMethod(anyInt())).willReturn("1");
    
    String num = obj.someMethod(1);
    
    then(obj).should(only()).someMethod("1");
}
```
### 인자 캡쳐
```
@Test
void mockTest() {
    MockedObject obj = mock(MockedObject.class);
    given(obj.someMethod(anyInt())).willReturn("1");
    
    String num = obj.someMethod(1);
    
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    then(obj).should(only()).someMethod(captor.capture());
    
    String realValue = captor.getValue();
    assertEquals("1", realValue);
}
```