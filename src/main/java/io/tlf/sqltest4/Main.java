package io.tlf.sqltest4;

import com.impossibl.postgres.jdbc.PGDataSource;
import com.impossibl.postgres.jdbc.PGDriver;
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
        System.out.println("**** Running Test4");
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
            map.put("TEST_OBJ", TestObj.class);
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
            TestObj data = null;
            if (result.next()) {
                data = result.getObject("obj", TestObj.class);
                result.close();
            }
            pstmt1.close();
            if (data == null) {
                System.out.println("DID NOT GET DATA");
                //return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            TestObj data = new TestObj();
            data.setCond(Condition.GOOD);
            System.out.println("Writing test data");
            PreparedStatement pstmt2 = con.prepareStatement("UPDATE data SET tag=?, val=?, obj=?, ts=now()");
            pstmt2.setString(1, "XI_9945");
            pstmt2.setDouble(2, Math.random());
            pstmt2.setObject(3, data);
            pstmt2.executeUpdate();
            pstmt2.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Build udt
        //System.out.println("Generating");
        //executeGenerator(con, Arrays.asList(new String[]{"CONDITION", "TEST_OBJ"}));
        //Done
        con.close();
        PGDriver.cleanup();
    }

    public static void executeGenerator(Connection connection, List<String> typeNames) {
        new UDTGenerator(connection, "io.tlf.sqltest4", typeNames).generate(new File("src/main/java"));
    }
}
