package javareflectiontest;

//каждый класс в java

import java.util.Objects;

//должен быть оформлен как BEAN
//класс
public class User extends MyParent{

    public User(Long id, String email, String password) {
        System.out.println("User(...)");
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User() {
        System.out.println("User()");
    }

    public Long getId() {
        System.out.println("getId(...)");
        return id;
    }

    public void setId(Long id) {
        System.out.println("setId(...)");
        this.id = id;
    }

    public String getEmail() {
        System.out.println("getEmail(...)");
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setEmail(...)");
        this.email = email;
    }

    public String getPassword() {
        System.out.println("getPassword(...)");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword(...)");
        this.password = password;
    }

    @Override
    public String toString() {
        System.out.println("toString(...)");
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }

    //Используем, если класс должен выполнять роль ключа
    //HasMap map
    /*
    User user = new User();
    map[user] = "123" 
    
    */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.password);
        return hash;
    }

    
    //для для методов contains в коллекция = ответ на впопрос как различать
    //одинаковых. Полне однофамильцы
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        //instanceof
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
     
    private Long id;//get/setId
    private String email;//set/setEmail
    private String password;
}
