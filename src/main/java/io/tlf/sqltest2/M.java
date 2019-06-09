package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class M implements SQLData {
  private static final String TYPE_NAME = "public.m";

  private String a;

  private Float b;

  private Float x;

  private Float y;

  private Float z;

  private Float i;

  private Float j;

  private Float k;

  private G[] c;

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

  public Float getB() {
    return b;
  }

  public void setB(Float b) {
    this.b = b;
  }

  public Float getX() {
    return x;
  }

  public void setX(Float x) {
    this.x = x;
  }

  public Float getY() {
    return y;
  }

  public void setY(Float y) {
    this.y = y;
  }

  public Float getZ() {
    return z;
  }

  public void setZ(Float z) {
    this.z = z;
  }

  public Float getI() {
    return i;
  }

  public void setI(Float i) {
    this.i = i;
  }

  public Float getJ() {
    return j;
  }

  public void setJ(Float j) {
    this.j = j;
  }

  public Float getK() {
    return k;
  }

  public void setK(Float k) {
    this.k = k;
  }

  public G[] getC() {
    return c;
  }

  public void setC(G[] c) {
    this.c = c;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.a = in.readString();
    this.b = in.readObject(Float.class);
    this.x = in.readObject(Float.class);
    this.y = in.readObject(Float.class);
    this.z = in.readObject(Float.class);
    this.i = in.readObject(Float.class);
    this.j = in.readObject(Float.class);
    this.k = in.readObject(Float.class);
    this.c = in.readObject(G[].class);
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.a);
    out.writeObject(this.b, JDBCType.REAL);
    out.writeObject(this.x, JDBCType.REAL);
    out.writeObject(this.y, JDBCType.REAL);
    out.writeObject(this.z, JDBCType.REAL);
    out.writeObject(this.i, JDBCType.REAL);
    out.writeObject(this.j, JDBCType.REAL);
    out.writeObject(this.k, JDBCType.REAL);
    out.writeObject(this.c, JDBCType.ARRAY);
  }
}
