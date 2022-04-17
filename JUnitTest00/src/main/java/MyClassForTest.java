public class MyClassForTest {

    @Override
    public String toString() {
        return "Parent{" + "name=" + name + '}';
    }

    public MyClassForTest(String name) {
        this.name = name;
    }

    private String name;


}
