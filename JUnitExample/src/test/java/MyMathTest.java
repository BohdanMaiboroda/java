import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    MyMath math;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //соединение с базой данных
        System.out.println("call setUp()");
        this.math = new MyMath();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        // закрытие соединения с базой данных
        System.out.println("call tearDown()");
        this.math.toString();
    }

    @org.junit.jupiter.api.Test
    void getPi_method_return_expected_value_pass() {
        double expected = 3.14;
        double result = math.getMyPi();
        boolean pass = expected == result;

        assertTrue(pass);
    }
    @org.junit.jupiter.api.Test
    void test_ToString_method_expected_result_pass() {
        String expected = "MyMath{" +
                "MyPi=" + math.getMyPi() +
                '}';
        String result = math.toString();
        boolean pass = expected.equals(result);

        assertTrue(pass);
    }
}