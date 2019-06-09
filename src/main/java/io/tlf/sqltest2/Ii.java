package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Ii implements SQLData {
  private static final String TYPE_NAME = "public.ii";

  private String a;

  private Integer b;

  private S[] c;

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

  public Integer getB() {
    return b;
  }

  public void setB(Integer b) {
    this.b = b;
  }

  public S[] getC() {
    return c;
  }

  public void setC(S[] c) {
    this.c = c;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.a = in.readString();
    this.b = in.readObject(Integer.class);
    this.c = in.readObject(S[].class);
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.a);
    out.writeObject(this.b, JDBCType.INTEGER);
    out.writeObject(this.c, JDBCType.ARRAY);
  }
}
