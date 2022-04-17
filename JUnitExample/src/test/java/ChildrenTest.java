import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ChildrenTest {

    Children ch;

    @BeforeEach
    void setUp() {
        this.ch = new Children("Ivan Petrov", 25);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void Children_inherited_from_Parent_class_expected_pass()
    {
        boolean result = this.ch instanceof Parent;
        assertTrue(result);
    }

    @Test
    void Children_has_method_ToString_expected_pass() {
        boolean result = false;
        String className = "Children";
        Class clazz;
        try {
            clazz = Class.forName(className);
            Method[] methods = clazz.getMethods();
            for(Method function: methods)
            {
                if (function.getName().contains("toString"))
                {
                    result = true;
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            result = false;
            System.out.println("Класс с таким именем не существует");
            e.printStackTrace();
        }
        boolean expected = true;
        assertTrue(expected == result);
    }
}