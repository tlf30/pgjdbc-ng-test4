package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class L implements SQLData {
  private static final String TYPE_NAME = "public.l";

  private Float x;

  private Float y;

  private Float z;

  private Float i;

  private Float j;

  private Float k;

  private String a;

  @Override
  public String getSQLTypeName() throws SQLException {
    return TYPE_NAME;
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

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.x = in.readObject(Float.class);
    this.y = in.readObject(Float.class);
    this.z = in.readObject(Float.class);
    this.i = in.readObject(Float.class);
    this.j = in.readObject(Float.class);
    this.k = in.readObject(Float.class);
    this.a = in.readString();
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeObject(this.x, JDBCType.REAL);
    out.writeObject(this.y, JDBCType.REAL);
    out.writeObject(this.z, JDBCType.REAL);
    out.writeObject(this.i, JDBCType.REAL);
    out.writeObject(this.j, JDBCType.REAL);
    out.writeObject(this.k, JDBCType.REAL);
    out.writeString(this.a);
  }
}
