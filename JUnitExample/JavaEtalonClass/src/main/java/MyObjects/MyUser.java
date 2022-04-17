package MyObjects;

import java.util.Objects;

//этот класс является BEAN классом
// Comparable<MyUser> для сортировки Collections.Sort
public class MyUser implements Comparable<MyUser>{
    String name;
    int age;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof MyUser)) return false;
//        MyUser myUser = (MyUser) o;
//        return getAge() == myUser.getAge() && getName().equals(myUser.getName());
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyUser other = (MyUser) obj;
        if (this.age != other.age) {
            return false;
        }

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }



    // оригинал от IDE
//    @Override
//    public int hashCode() {
//        return Objects.hash(getName(), getAge());
//    }

    // реализация по умолчанию от NetBean
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + this.age;
        return hash;
    }


// equals - детальное сравнение объектов
    // позволяет сравнивать только значения определенных частей
    // например, только возраст или только имя
    //нужен обязательно для ...
    // hashCode для коллекции типа Map

    @Override
    public int compareTo(MyUser o) {
        return this.age - o.age;
        // return o.compareTo(this);
    }

    // это конструктор нужен рефлексии для исследования содержимого
    //Class.forName...
    public MyUser() {
        this.setAge(0);
        this.setName("");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if ( age <= 0 )
            this.age = 18;
        else
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() == 0)
            this.name = "NoName";
        else
        this.name = name;
    }

    //для преобразования в строку для любого вывода вывода
    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // нужен программисту - осмысленное создание класса
    public MyUser(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }


}
