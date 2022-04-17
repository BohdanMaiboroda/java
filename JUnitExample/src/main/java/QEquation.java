public class QEquation {

    private double a;
    private double b;
    private double c;
    public QEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static QEquation createInstance(double a, double b, double c)
            throws Exception
    {
        if (a == 0)
        {
            throw new Exception("Exception: a == 0");
        }
        return new QEquation(a, b, c);
    }

    public EquationResult solve() {
        EquationResult result = new EquationResult();
        double D = b * b - 4 * a * c;
        result.X1 = (-b - Math.sqrt(D) )/ (2 * a);
        result.X2 = (-b + Math.sqrt(D) )/ (2 * a);
        return result;
    }



    public class EquationResult {
        public double X1;
        public double X2;
        @Override
        public String toString() {
//        return "QEquation{" +
//                "a=" + a +
//                ", b=" + b +
//                ", c=" + c +
//                '}';
            return String.format("X1 = %s, X2 = %s;",X1, X2);

        }
    }
}
