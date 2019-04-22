package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class R implements SQLData {
  private static final String TYPE_NAME = "public.r";

  private Long a;

  private Long b;

  private String c;

  private Integer[] d;

  @Override
  public String getSQLTypeName() throws SQLException {
    return TYPE_NAME;
  }

  public Long getA() {
    return a;
  }

  public void setA(Long a) {
    this.a = a;
  }

  public Long getB() {
    return b;
  }

  public void setB(Long b) {
    this.b = b;
  }

  public String getC() {
    return c;
  }

  public void setC(String c) {
    this.c = c;
  }

  public Integer[] getD() {
    return d;
  }

  public void setD(Integer[] d) {
    this.d = d;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.a = in.readLong();
    this.b = in.readLong();
    this.c = in.readString();
    this.d = in.readObject(Integer[].class);
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeLong(this.a);
    out.writeLong(this.b);
    out.writeString(this.c);
    out.writeObject(this.d, JDBCType.ARRAY);
  }
}
