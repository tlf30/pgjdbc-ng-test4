package io.tlf.sqltest3;

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
 * @author tlfal
 */
public class Main {

    private static PGDataSource ds = new PGDataSource();

    public static void main(String[] args) throws SQLException {
        System.out.println("**** Running Test3");
        test3();

    }

    public static void test3() throws SQLException {

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
            ds.setDatabaseName("test3");
            ds.setUser("test1");
            ds.setPassword("test1");
            con = ds.getConnection();
            //Create mappings
            Map map = con.getTypeMap();
            map.put("CONDITION", Condition.class);
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
            PreparedStatement pstmt1 = con.prepareStatement("SELECT * FROM data LIMIT 1");
            ResultSet result = pstmt1.executeQuery();
            Condition cond = null;
            if (result.next()) {
                cond = result.getObject("cond", Condition.class);
                result.close();
            }
            pstmt1.close();
            if (cond == null) {
                System.out.println("DID NOT GET DATA");
                //return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            System.out.println("Writing test data");
            PreparedStatement pstmt2 = con.prepareStatement("UPDATE data SET tag=?, val=?, cond=?, ts=now()");
            pstmt2.setString(1, "XI_9945");
            pstmt2.setDouble(2, Math.random());
            pstmt2.setObject(3, Condition.GOOD);
            pstmt2.executeUpdate();
            pstmt2.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Build udt
        executeGenerator(con, Arrays.asList(new String[]{"CONDITION"}));
        //Done
        con.close();
    }

    public static void executeGenerator(Connection connection, List<String> typeNames) {
        new UDTGenerator(connection, "io.tlf.sqltest3", typeNames).generate(new File("src/main/java"));
    }
}
