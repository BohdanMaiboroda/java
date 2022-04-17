package myobjects;

import java.util.List;
import java.util.Objects;

public class MyBean2 {
    private List data;// Person это тип элемента (фактический)

    public List getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MyBean2{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyBean2)) return false;
        MyBean2 myBean2 = (MyBean2) o;
        return Objects.equals(getData(), myBean2.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData());
    }

    public void setData(List data) {
        this.data = data;
    }

    public MyBean2(List data) {
        this.data = data;
    }

    public MyBean2() {
    }
}
