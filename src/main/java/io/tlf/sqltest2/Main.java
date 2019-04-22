package io.tlf.sqltest2;

import com.impossibl.postgres.jdbc.PGDataSource;
import com.impossibl.postgres.tools.UDTGenerator;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tlfal
 */
public class Main {

    private static PGDataSource ds = new PGDataSource();

    public static void main(String[] args) throws SQLException {
        System.out.println("**** Running Test2");
        test2();

    }

    public static void test2() throws SQLException {

        //Create DB connection
        try {
            Class.forName("com.impossibl.postgres.jdbc.PGConnectionPoolDataSource");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }

        System.out.println("Connecting to db...");
        Connection con = null;
        try {
            ds.setServerName("localhost");
            ds.setPort(5432);
            ds.setDatabaseName("test2");
            ds.setUser("test2");
            ds.setPassword("test2");
            con = ds.getConnection();
            //Create mappings
            Map map = con.getTypeMap();
            map.put("CHARA", Chara.class);
            map.put("G", G.class);
            map.put("II", Ii.class);
            map.put("L", L.class);
            map.put("M", M.class);
            map.put("MO", Mo.class);
            map.put("Q", Q.class);
            map.put("QF", Qf.class);
            map.put("QI", Qi.class);
            map.put("QS", Qs.class);
            map.put("R", R.class);
            map.put("S", S.class);
            con.setTypeMap(map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (con == null) {
            System.out.println("Connection null");
            return;
        }

        try {
            System.out.println("Reading test data");
            Chara data = null;
            PreparedStatement pstmt1 = con.prepareStatement("SELECT * FROM users LIMIT 1");
            ResultSet result = pstmt1.executeQuery();
            if (result.next()) {
                data = result.getObject("data", Chara.class);
                result.close();
            }
            pstmt1.close();
            if (data == null) {
                System.out.println("DID NOT GET DATA");
                return;
            }

            System.out.println("Writing test data");
            PreparedStatement pstmt2 = con.prepareStatement("UPDATE users SET data=?");
            pstmt2.setObject(1, data);
            pstmt2.executeUpdate();
            pstmt2.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Build udt
        executeGenerator(con, Arrays.asList(new String[]{"CHARA", "G", "II", "L", "M", "MO", "Q", "QF", "QI", "QS", "R", "S"}));
        //Done
        con.close();
    }

    public static void executeGenerator(Connection connection, List<String> typeNames) {
        new UDTGenerator(connection, "io.tlf.sqltest2", typeNames).generate(new File("src/main/java"));
    }
}
