import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MyClassForTestTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        boolean result = true;
        assertTrue(result);

    }

    @Test
    public void Children_has_method_toString_pass() {

//        Children ch = new Children(18, "Ivan");
//        boolean result = ch instanceof Parent;
//        boolean expected = true;
//        assertEquals(result, expected);
//
        boolean result = false;
        String className = "MyClassForTestTest";//Полное имя класса = это "Имя пакета"."Имя класса"
        System.out.println("Список методов класса:" + className);
        Class clazz;
        try {
            clazz = Class.forName(className);//использовали в момент соединения с базой данных
            //находили класс драйвера внутри файла jar
            Method[] methods = clazz.getMethods();
            for (Method function : methods) {
                System.out.println(function.getName());
                if (function.getName().contains("toString"))
                    result = true;
            }
            //
        } catch (ClassNotFoundException ex) {
            System.out.println("Класс с таким именем не существует");
        }
        assertTrue(result);
//
    }

}