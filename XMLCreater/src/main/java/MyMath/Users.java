package MyMath;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
//класс обертка над коллекцией, нужен для того, чтобы сохранить массив в файд xml
//просто массив нельзя - бтблиотек не поддерживают

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Users {
    @XmlElement(name = "user")
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
