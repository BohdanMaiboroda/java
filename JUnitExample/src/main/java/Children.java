public class Children extends Parent {
    public Children(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Children{" +
                "age=" + age +
                '}';
    }

    int age;
}
