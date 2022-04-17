
import java.sql.*;

public class MySQLiteDataBase {
    int num ;

    public void setNum(int num) {
        this.num = num;
    }

    public static String getSelect()
    {
        StringBuilder sb = new StringBuilder();
        Connection conn = null;
        //
        //+ШАГ 0 подключение драйвера - тип проекта, СУБД
        //+Шаг 1 регистрирую драйвер в проекте
        //+ШАГ 2 Устанавливаем соединение Connection (путь-адрес к базе)
        //+ШАГ 3 Создаю команду Statement для выполнения SQL
        //+ШАГ 4 Обработка результата (if, while)
        try {
            Statement stm = connect().createStatement();
            String allProduct = "select ProductName, QuantityPerUnit from Products\n" +
                    "order by ProductName";
            ResultSet rs = stm.executeQuery(allProduct);


            while (rs.next())//просматриваем все строчки результата
            {
                String sResult = rs.getString("ProductName");
                String sResult1 = rs.getString("QuantityPerUnit");

                // String position = rs.getString("POSITIONS");
                // System.out.println("Имя :" + str);
                sb.append(" \nТовар ").append(sResult).append("\nКоличество =  ").append(sResult1);
                // System.out.println("Заработная плата = "+salary);
            }
            stm.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Ошибка с именем файла драйвера");
            e.printStackTrace();
            System.out.println("Класс драйвера найден");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //
        return sb.toString();
        //
    }
    public static String customerById(String id) throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        String customer = "SELECT CompanyName, Address, City FROM northwind.customers where CustomerID = ?;";
        PreparedStatement stm = connect().prepareStatement(customer);
        stm.setString(1,id);
        ResultSet rs = stm.executeQuery();
        while (rs.next())//просматриваем все строчки результата
        {
            String sResult = rs.getString("CompanyName");
            String sResult1 = rs.getString("Address");
            String sResult2 = rs.getString("City");

            // String position = rs.getString("POSITIONS");
            // System.out.println("Имя :" + str);
            sb.append("Компания = ").append(sResult);
            //System.out.println("Возраст = "+age);
            sb.append("\nГород =  ").append(sResult2);
            sb.append("\nАдрес =  ").append(sResult1);
            // System.out.println("Заработная плата = "+salary);
            System.out.println(sb);
        }
        stm.close();
        if(sb.toString().isEmpty()){
            sb.append("No such company");
        }
        return sb.toString();

    }

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind","root","1991an09");
    }


}
