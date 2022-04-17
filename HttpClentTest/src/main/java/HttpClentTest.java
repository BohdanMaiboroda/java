import java.io.IOException;
import java.util.Scanner;

import myobjects.MyBean;
import myobjects.MyBean2;
import myobjects.Person;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import myobjects.BeanA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
// import org.json.JSONObject;


public class HttpClentTest {
    public static void main(String[] args) throws IOException {
        //+ 1 создание класса из строки json
        //+ 2 создание строки json на основании класса
        //+ 3 получение данных от мок сервера и преобразование их в класс
        //4 рефакторинг - вынести классы в библиотеку и подключить ее к проекту
        System.out.println("Hello from HttpClentTest!");
        String json = "{bool:true,integer:1,string:\"jsonstr\"}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        BeanA beanA = (BeanA) JSONObject.toBean(jsonObject, BeanA.class);
        System.out.println("JSON create action result test");
        System.out.println(beanA);// toString
        //
        System.out.println("JSON string was created form Bean class test");
        JSONObject jsonObject2 = JSONObject.fromObject( new MyBean());
        String jsonString = jsonObject2.toString();
        System.out.println(jsonString);
        //
        String jsonString2 = "{'data':[{'name':'Ivan'},{'name':'Peter'}]}";
        Map classMap = new HashMap();
        classMap.put("data", Person.class);
        MyBean2 bean2 = (MyBean2) JSONObject.toBean(
          JSONObject.fromObject(jsonString2)  ,// json с данными
          MyBean2.class,// класс, для общей структуры json
          classMap // класс, который описывет саму коллекцию
        );
        System.out.println("inner private collection, test field data");
        System.out.println(bean2);
        //
        // адрес мок сервер
        // https://0aff146f-63f6-4ea5-b05b-0857922e27cc.mock.pstmn.io
        // его json ответ
        /**
         {
         "data":[
         {
         "name": "test 1",
         "mesage": "success",
         "result": "executed"
         },
         {
         "name": "test 2",
         "mesage": "success",
         "result": "executed"
         }
         ]

         }
        */
        //
        //Creating a HttpClient object
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://0aff146f-63f6-4ea5-b05b-0857922e27cc.mock.pstmn.io");
        //Creating a HttpGet object
        // https://api.openweathermap.org/data/2.5/weather?q=London&appid=3ea4abe0212f835881380b8afaa025d4
        // https://api.minfin.com.ua/mb/18b8c97cd7d66e052c2c9e34b801069c8409fb87/2021-04-14?currency=usd
        // HttpGet httpget = new HttpGet("https://api.openweathermap.org/data/2.5/weather?q=London&appid=3ea4abe0212f835881380b8afaa025d4");
        //Printing the method used
        System.out.println("Request Type: "+httpget.getMethod());
        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
        //Printing the status line
        System.out.println(httpresponse.getStatusLine());
        String result = "";
        while(sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(line);
            result+=line;
        }
        //из текста json создаю объект класса
        System.out.println("результат преобразования этого JSON в объект");
        Map classMap2 = new HashMap();
        classMap2.put("data", MyBean.class);
        MyBean2 myBean2 = (MyBean2) JSONObject.toBean(
                JSONObject.fromObject(result),
                MyBean2.class,
                classMap2
        );
        System.out.println(myBean2);
        //
    }
}
