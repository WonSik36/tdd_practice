package ch05;

import org.junit.jupiter.api.*;

public class LifeCycleTest {
    public LifeCycleTest() {
        System.out.println("new LifeCycleTest");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("----- BeforeAll -----");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("----- BeforeEach -----");
    }

    @Test
    void a() {
        System.out.println("----- Test A -----");
    }

    @Test
    void b() {
        System.out.println("----- Test B -----");
    }

    @Test
    void c() {
        System.out.println("----- Test C -----");
    }

    @AfterEach
    void afterEach() {
        System.out.println("----- AfterEach -----");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("----- AfterAll -----");
    }
}
