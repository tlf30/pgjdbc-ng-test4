package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class G implements SQLData {
  private static final String TYPE_NAME = "public.g";

  private String a;

  private String b;

  private String[] c;

  private Mo[] d;

  @Override
  public String getSQLTypeName() throws SQLException {
    return TYPE_NAME;
  }

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }

  public String getB() {
    return b;
  }

  public void setB(String b) {
    this.b = b;
  }

  public String[] getC() {
    return c;
  }

  public void setC(String[] c) {
    this.c = c;
  }

  public Mo[] getD() {
    return d;
  }

  public void setD(Mo[] d) {
    this.d = d;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.a = in.readString();
    this.b = in.readString();
    this.c = in.readObject(String[].class);
    this.d = in.readObject(Mo[].class);
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.a);
    out.writeString(this.b);
    out.writeObject(this.c, JDBCType.ARRAY);
    out.writeObject(this.d, JDBCType.ARRAY);
  }
}
