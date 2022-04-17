package org.itstep.kharkov;

import java.sql.DriverManager;//управление версиями драйевров

import java.sql.Connection;//механизмы соединения БД
import java.sql.Statement;//для запросов select (update)
import java.sql.CallableStatement;//для работы с ХП
import java.sql.ResultSet;//хранилище результата выборки
import java.sql.SQLException;

public class jdbcSQLiteConnection {

	public static void main(String[] args){
		System.out.println("Hello from jdbcSQLiteConnection");
		//+ШАГ 0 подключение драйвера - тип проекта, СУБД
		//+Шаг 1 регистрирую драйвер в проекте
		//+ШАГ 2 Устанавливаем соединение Connection (путь-адрес к базе)
		//+ШАГ 3 Создаю команду Statement для выполнения SQL
		//+ШАГ 4 Обработка результата (if, while) 
		try {
			Class.forName("org.sqlite.JDBC");//ШАГ 1
			   Connection conn = null;
			   String connTxt = "jdbc:sqlite:C:\\MyData\\test.db";
			   
	           conn = DriverManager.getConnection(connTxt);
	           Statement stm = conn.createStatement();
	             // String selectText = "SELECT NAME, AGE, SALARY FROM EMPLOYEES";
	             String selectText = "SELECT" +
	                                 "  NAME," +
	                                 "  AGE," +
	                                 "  POSITIONS," +
	                                 "  AVG(SALARY * 27.25) AS SALARY" +
	                                 " FROM" +
	                                 "  Employees" +
	                                 " GROUP BY POSITIONS " +
	                                 " ORDER BY POSITIONS ASC, SALARY DESC";
	             ResultSet rs = stm.executeQuery(selectText);
	             int num = 0;
	             //Scanner 
	             while (rs.next())//просматриваем все строчки результата
	             {
	                double salary = rs.getFloat("SALARY");
	                String str = rs.getString("NAME");
	                int age = rs.getInt("AGE");
	                String position = rs.getString("POSITIONS");
	                System.out.println("Имя :" + str);
	                System.out.println("Возраст = "+age);
	                System.out.println("Заработная плата = "+salary);
	             }
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ошибка с именем файла драйвера");
			e.printStackTrace();
			System.out.println("Класс драйвера найден");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

}
