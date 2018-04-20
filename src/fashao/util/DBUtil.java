package fashao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ayorfree
 * @create 2018-04-20-下午8:52
 */

public class DBUtil {
    static String ip = "127.0.0.1";
    static int prot = 3306;
    static String database = "fashao";
    static String encoding = "UTF-8";
    static String loginName = "ayor";
    static String password = "ainimi";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d:%s?characterEncoding=%s", ip, prot, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
