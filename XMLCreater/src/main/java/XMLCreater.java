//
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
//
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import MyMath.User;
import MyMath.Users;
import org.json.XML; // для маршалинга

//нужны для сохранения JSON в BEAN class

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class XMLCreater {

    public static void main(String[] args){
        System.out.println("Hello from XMLCreater");

        User user1 = new User();
        user1.setId(100);
        user1.setName("Ivan");
        user1.setAge(29);

        Users users = new Users();
        users.getUsers().add(user1);
        user1.setId(200);
        users.getUsers().add(user1);

        try {
            File file = new File("C:\\MyData\\usersxml.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(users, file);
            jaxbMarshaller.marshal(users, System.out);
            //
            Path path = file.toPath();
            String tmps = Files.lines(path).collect(Collectors.joining("\n"));
            org.json.JSONObject xmlToJSon = XML.toJSONObject(tmps);
            String jsonString = xmlToJSon.toString();
            System.out.println(jsonString);
            //

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
