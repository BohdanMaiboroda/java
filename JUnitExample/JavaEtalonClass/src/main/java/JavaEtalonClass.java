import MyObjects.MyUser;

import java.util.*;

public class JavaEtalonClass {

    public static void printArray(MyUser[] array)
    {
        for (MyUser u: array)
        {
            System.out.println(u);
        }
    }


    public static <boolaen> void main(String[] args)
    {
        System.out.println("Hello from JavaEtalonClass");
        MyUser user1 = new MyUser();
        MyUser user2 = new MyUser("Ivan Petrov",14);
        MyUser user3 = new MyUser("Peter Ivanov",28);

        System.out.println(user1);
        List<MyUser> users = new ArrayList<>();// array ??
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.println("До сортировки:");
        System.out.println(users);
//        users.forEach( u -> System.out.println(u));
//        if (users.contains(user1))
//        {
//            System.out.println("user1 принадлежит коллекции");
//        }
//        else
//        {
//            System.out.println("user1 не коллекции");
//        }
//        Collections.sort(users);
//        System.out.println("После сортировки:");
//        System.out.println(users);
        MyUser[] arrUsers = new MyUser[3];
        arrUsers[0] = user1;
        arrUsers[1] = user2;
        arrUsers[2] = user3;
        System.out.println("Массив MyUser[] до сортировки");
        //java 1.7
        // printArray(arrUsers);
        //java 1.8+
        /**
               имя функции (параметры функции)
         {
             тело функции
         }

                   (MyUser[] array) -> {for...}


         */
        // Arrays.asList(arrUsers).forEach(  (MyUser item) -> { System.out.println (item);} );
        Arrays.asList(arrUsers).forEach(  item -> System.out.println (item) );
        Map<MyUser,String> map = new HashMap();// hasCode
        Map<String,MyUser> dictionary = new HashMap();
        //
        MyUser keyUser = new MyUser("Ivan Petrov",14);
        boolean searchresult = Arrays.asList(arrUsers).contains(keyUser);// equals
        System.out.println(searchresult);
        // поиск элемента
        for (MyUser u: arrUsers)
        {
            if (u == user1) // операция сравнения == для ссылочных типов
                // сравнивает ссылки = адреса, а НЕ значения!
            {
                System.out.println("Элемент user 1 найден в массиве");
            }
        }
    }
}
