/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author admin
 */
public class DBUtils {
    public static Connection getConnection() throws /*ClassNotFoundException,*/ SQLException, NamingException {
//        Connection connect=null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url="jdbc:sqlserver://localhost:1433;databaseName=Hana_Shop";
//        connect=DriverManager.getConnection(url, "sa", "123456789");
//        return connect;
        Context context=new InitialContext();
        Context tomCatContext=(Context) context.lookup("java:comp/env");
        DataSource ds=(DataSource) tomCatContext.lookup("Hana_Shop");
        Connection connect=ds.getConnection();
        return connect;
    }
    
//    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
//        Connection con=DBUtils.getConnection();
//        if(con!=null){
//            System.out.println("Thanh cong");
//        }else{
//            System.out.println("That bai");
//        }
//    }
    
}
