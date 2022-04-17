/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcmssqlserverconnectiontest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcMsSQLServerConnectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       //1 Присоединяю драйвер нужной СУБД +
        //2. регистрирую класс драйвера в проекте
        //3.создаем Connection
            Connection conn = null;
            try {
            //String dbURL = "jdbc:sqlserver://azure2700.database.windows.net:1433;database=azuredb2700;user=artimed@azure2700;password={Azure$13};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            //String dbURL = "jdbc:sqlserver://azurehibernatetestsrv.database.windows.net:1433;database=AZURENHIBERNATETEST;user=artimed@azurehibernatetestsrv;password={Azure$13};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
           //String dbURL = "jdbc:sqlserver://PC-T530\\MSSQLSERVER;database=AdventureWorks2008;integratedSecurity=true;";
           String dbURL = "jdbc:sqlserver://localhost:1433;database=NORTHWIND;integratedSecurity=true;";
           
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                Statement stmt = conn.createStatement();
                try {
                    //stmt.setQueryTimeout(iTimeout);
                    ResultSet rs = stmt.executeQuery("select OrderID as ID, [ShipName] from [dbo].[orders]");
                    try {
                        while (rs.next()) {
                            String sResult = rs.getString("ShipName");
                            int nResult = rs.getInt("ID");
                            
                            System.out.print(sResult);
                            System.out.print(" ");
                            System.out.println(nResult);
                        }
                    } finally {
                        try {
                            rs.close();
                        } catch (Exception ignore) {
                        }
                    }
                } finally {
                    try {
                        stmt.close();
                    } catch (Exception ignore) {
                    }
                }
                //
            
            }
        } catch (SQLException ex) 
        {
            System.out.println("ошибка с соединением.");
        }
        
        //4.из Connection получаем команду (Statement)
        //5.выполняю текст запроса
    }
    
}
