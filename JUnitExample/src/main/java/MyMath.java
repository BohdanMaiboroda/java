public class MyMath {

    public MyMath()
    {
        System.out.println("call MyMath()");
    }
    private double MyPi = 3.14;
    public double getMyPi(){
        System.out.println("call getMyPi()");
        return this.MyPi;
    }

    @Override
    public String toString() {
        System.out.println("call toString()");
        return "MyMath{" +
                "MyPi=" + MyPi +
                '}';
    }
}
