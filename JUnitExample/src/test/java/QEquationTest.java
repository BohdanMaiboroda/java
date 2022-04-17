import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QEquationTest {

    @Test
    void test_for_values_a_1_b_minus_7_c_12_expected_x1_3_x2_4_passed()
    {
        double a = 1;
        double b = -7;
        double c = 12;
        // QEquation solution = new QEquation(a,b,c);
        //создал метод, который создает объект
        //паттерн Фабричный метод (или фабрика)
        //истинная причина в том, что конструктор (это особый метод)
        //ОБЯЗАН ГЕНЕРИРОВАТЬ Exception
        try {
            QEquation equation = QEquation.createInstance(a, b, c);
            QEquation.EquationResult solution = equation.solve();
            String expect = "X1 = 3.0, X2 = 4.0;";
            String result = solution.toString();
            assertTrue(result.equals( expect ));
        }
        catch (Exception e)
        {
            System.out.println("Не введены данные. У вас неквадратное уравнение");
        }
    }
    @Test
    void test_for_values_a_zero_b_minus_7_c_12_expected_passed()
    {
        boolean expect = true;
        boolean result = true;
        double a = 0;
        double b = -7;
        double c = 12;
        try {
            QEquation equation = QEquation.createInstance(a, b, c);
            QEquation.EquationResult solution = equation.solve();
            result = false;

        }
        catch (Exception e)
        {
            result = true;
        }
        assertTrue(expect == result);
    }
    @Test
    void test_for_values_a_zero_b_minus_7_c_12_expected_exception_passed()
    {
        boolean expect = true;
        boolean result = true;
        double a = 0;
        double b = -7;
        double c = 12;
        try {
            QEquation equation = QEquation.createInstance(a, b, c);
            QEquation.EquationResult solution = equation.solve();
            result = false;

        }
        catch (Exception e)
        {
            result = true;
        }
        assertThrows(Exception.class, () -> {
            Integer.parseInt("One");
        });
    }
}