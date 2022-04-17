
package javareflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaReflectionTest {


    public static void main(String[] args) {
        System.out.println("Hello from JavaReflectionTest");
        User user = new User();
        user.setEmail("ivan.peteov@gmail.com");
        //
        String className = "javareflectiontest.User";
        System.out.println("class name is " + className);
        Class clazz;
        try {
            //
            clazz = Class.forName(className);//аналог конструктора
            Class superClass = clazz.getSuperclass();
            System.out.println("У класса "+className + " родитель " + superClass);
            System.out.println("Все Методы класса:");
            int i = 1;
            for(Method m : clazz.getMethods())
            {
                System.out.println(i + " " + m.toString());
                i++;
            }
            // 11 
            System.out.println("Методы этого класса:");
            i = 1;
            for(Method m : clazz.getDeclaredMethods())
            {
                System.out.println(i + " " +m.toString());
                i++;
            }
           //
           Constructor[] contrs = clazz.getConstructors();
             System.out.println("список конструкторов");
             for(Constructor c : contrs)
             {
                 System.out.println(c.toString());
             }
           //
           System.out.println("вызов всех методов get");
           for(Method m : clazz.getDeclaredMethods())
            {
                String methodName = m.toString();
                if (methodName.contains("get"))
                {
                    System.out.println("вызываем метод "+m);
                    m.invoke(user);
                }
            }
           /*
           mycmd.txt
           javareflectiontest.User
           toString
           getEmail
           getPassword
           */
        } catch (ClassNotFoundException ex) {
           System.out.println("Внутри jar файла класс "+className+" не найден");
        } catch (IllegalAccessException ex) {
           System.out.println("Вызываем метод из недоступной области "+className+".");
        } catch (IllegalArgumentException ex) {
            System.out.println("вызываем метод из "+className+" не с теми параметрами");
        } catch (InvocationTargetException ex) {
             System.out.println("Вызов не с тем this "+className+" не найден");
        }
    }
    
}
