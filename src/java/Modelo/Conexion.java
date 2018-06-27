package Modelo;

import java.sql.*;


public class Conexion {
    private Connection con;
    
    public Connection Conectar() {
        try {
            //Class.forName("org.postgresql.Driver");                           //PostGres JDBC
            //Class.forName("com.mysql.jdbc.Driver");                           //MySql JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      //SQL Server JDBC

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            String driver = "mysql";    //postgresql
            String host = "localhost";  //
            String puerto = "3306";     //5432
            String bd = "testconexion"; // 
            String user = "root";       //postgres
            String pw = "";             //
            String sqlser= "jdbc:sqlserver://equipopc:1433;databaseName=localMedico";
            
            con = DriverManager.getConnection(sqlser,"sa","123");                                               //SQL Server
            //con = DriverManager.getConnection("jdbc:"+driver+"://"+host+":"+puerto+"/"+bd+"", user, pw);      //MySql - PostGres
        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
        return con;
    }
    
}