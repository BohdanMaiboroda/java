package MyMath;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class User {
    @XmlElement
    private String name;
    @XmlElement
    int age;
    @XmlAttribute(name = "IDENTITY", required = true)
    int id;
    @Override
    public String toString() {
        return "User{" + "name=" + name + '}';
    }
    public User() {

    }
    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
