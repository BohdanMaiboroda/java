
package filesinjavaexample;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;// чтение клавиатуры (консоли), запроса из инета (HttpClient)



public class FilesInJavaExample {


    public static void main(String[] args) {
         //чтение данных из консоли
         Scanner input = new Scanner (System.in);
         System.out.println("Введите целое число");
         // int x = input.nextInt();
         int x = 0;
         //System.out.println("Введите целое дробное число");
         // double y = input.nextDouble();//при вводе символ разделитель опеределен настройками OS
         double y = 3.14;//разделитель между целой и дробной частями точка
         System.out.println("Введите строку");
         // String str = input.nextLine();//считывает строка до конца (аналог endl в с++)
         String str = input.next();// Читаем до симола разделителя пробела
         System.out.println("Вы ввели целое = "+x+"дробное = "+y+" и строку '"+str+"'");
         //запись данных в файл
         PrintWriter output = null;
         BufferedReader INPUT = new BufferedReader( new InputStreamReader(System.in)  );
         System.out.println("Введите содержимое файла mydata.txt (или слово stop для остановки)");
         try {
            output = new PrintWriter ( new FileWriter ("mydata.txt"));
            //
            while (true)
            {
                String strTmp = INPUT.readLine();
                if (strTmp.equals("stop"))
                {
                    break;
                }
                output.println(strTmp);
            }
            output.close();
            //
         } catch (IOException ex) {
            System.out.println("Ошибка записи в файл, подробности "+ex);
         }
         finally
         {
             output.close();
         }
         
         
         
         output.close();
         
         
         
         
        //чтение файла
        System.out.println("вывод файла data.txt");
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("data.txt"));
            String strtmp2;
            while ((strtmp2 = inputFile.readLine()) != null) {
                System.out.println(strtmp2);
                //double d = Double.parseDouble(strtmp2);
            }
            inputFile.close();
        } catch (Exception e) {
            System.out.println("Не могу открыть файл. Нет прав или файл не существует.");
        }
        //  
        
        
        
        
    }
    
}
