package myobjects;

public class BeanA {

    //fields
    @Override
    public String toString() {
        return "BeanA{" + "flag=" + flag + ", index=" + index + ", str=" + str + ", bool=" + bool + ", integer=" + integer + ", string=" + string + '}';
    }
    public boolean flag;
    public Integer index;
    public String str;

    //property - это fields на которые создали set/get methods
    public boolean bool;
    public int integer;
    public String string;

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public String getString() {
        return string;
    }

    //bool:true,integer:1,string:\"json\"}
    public void setString(String string) {
        this.string = string;
    }

}
