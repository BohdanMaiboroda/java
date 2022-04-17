import MyMath.QEquation;

public class UnitTestExample {
      //ДЗ четверг: работающий телеграм бот.
      // или вопросы, что не так.
      //отправляете неработающий проект.

      // + логику Unit (модульные тесты), что такое разработка через тестирование

      // что такое postmat (для создание mock) = json формат
      // ?? HttpClient
      // ?? JUnit ()
     public static void main(String args[])
     {
         //разработка через тестирование
         //организационные шаги
         //среда IDE поддержка полного Refactoring
         //generate Class (construtor) и извлечение Interface 2) intoduce method

         //Пример
         //квадратное уравнение
         //как считать
         //a*a + b*b != 0 - математическое требование
         //a - есть всегда! мир программирования
         //D = b * b - 4 * a * c
         //D >= 0 - есть всегда!
         //x1 = (-b + sqrt(D))/(2 * a)
         //x2 = (-b - sqrt())/ (2 * a)

         //1. Готовлю тестовые данные
         /*
         x1 = 3, x2 = 4
         (x - x1 )( x - x2)
         (x - 3)(x - 4)
         x2 -7x + 12
         a = 1, b = -7, c = 12
          */
         //я пишу внешний вид результата
         //вначале не компилируется
         test_for_values_a_1_b_minus_7_c_12_expected_passed();
         test_for_a_zero_expected_exception_passed();

     }

    private static void test_for_values_a_1_b_minus_7_c_12_expected_passed() {
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
            if (result.equals( expect ))
            {
                System.out.println("test calc solution for D > 0 passed");
            }
            else
            {
                System.out.println("test calc solution for D > 0 failed");
            }
        }
        catch (Exception e)
        {
            System.out.println("Не введены данные. У вас неквадратное уравнение");
        }
    }
    private static void test_for_a_zero_expected_exception_passed() {
        double a = 0;
        double b = -7;
        double c = 12;
        try {
            QEquation equation = QEquation.createInstance(a, b, c);
        }
        catch (Exception e)
        {
            System.out.println("test calc solution for a = 0 passed");
            System.out.println("Не введены данные. У вас неквадратное уравнение");
        }
    }
}
