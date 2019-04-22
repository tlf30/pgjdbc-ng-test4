package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class S implements SQLData {
  private static final String TYPE_NAME = "public.s";

  private String a;

  private String b;

  private Long c;

  private Float d;

  private Float e;

  private Float f;

  private R[] g;

  private Boolean h;

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

  public Long getC() {
    return c;
  }

  public void setC(Long c) {
    this.c = c;
  }

  public Float getD() {
    return d;
  }

  public void setD(Float d) {
    this.d = d;
  }

  public Float getE() {
    return e;
  }

  public void setE(Float e) {
    this.e = e;
  }

  public Float getF() {
    return f;
  }

  public void setF(Float f) {
    this.f = f;
  }

  public R[] getG() {
    return g;
  }

  public void setG(R[] g) {
    this.g = g;
  }

  public Boolean getH() {
    return h;
  }

  public void setH(Boolean h) {
    this.h = h;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.a = in.readString();
    this.b = in.readString();
    this.c = in.readLong();
    this.d = in.readFloat();
    this.e = in.readFloat();
    this.f = in.readFloat();
    this.g = in.readObject(R[].class);
    this.h = in.readBoolean();
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.a);
    out.writeString(this.b);
    out.writeLong(this.c);
    out.writeFloat(this.d);
    out.writeFloat(this.e);
    out.writeFloat(this.f);
    out.writeObject(this.g, JDBCType.ARRAY);
    out.writeBoolean(this.h);
  }
}
