package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static  Connection con= null;
    private static  ConnectDB instance= new ConnectDB();

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        ConnectDB.con = con;
    }

    public static ConnectDB getInstance() {
        return instance;
    }

    public static void setInstance(ConnectDB instance) {
        ConnectDB.instance = instance;
    }
    public void connect() throws SQLException{
        String url= "jdbc:sqlserver://localhost:1433;databasename=SQL_QLXe";
        String user="sa";
        String password="123";
        con=DriverManager.getConnection(url,user,password);
    }
    public void disconnect(){
        if(con!=null)
            try {
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

