package myobjects;

import java.util.List;

public class MyBean {

    @Override
    public String toString() {
        return "MyBean{" + "data=" + data + ", name=" + name + ", mesage=" + mesage + ", result=" + result + '}';
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    private List data;
    public String name;
    public String mesage;
    public String result;

    public MyBean()
    {
        this.name = "test 1";
        this.mesage = "success";
        this.result = "executed";
    }
}

