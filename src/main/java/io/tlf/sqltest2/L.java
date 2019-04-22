package io.tlf.sqltest2;

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
    this.x = in.readFloat();
    this.y = in.readFloat();
    this.z = in.readFloat();
    this.i = in.readFloat();
    this.j = in.readFloat();
    this.k = in.readFloat();
    this.a = in.readString();
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeFloat(this.x);
    out.writeFloat(this.y);
    out.writeFloat(this.z);
    out.writeFloat(this.i);
    out.writeFloat(this.j);
    out.writeFloat(this.k);
    out.writeString(this.a);
  }
}
