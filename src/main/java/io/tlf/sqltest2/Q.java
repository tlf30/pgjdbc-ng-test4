package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Q implements SQLData {
  private static final String TYPE_NAME = "public.q";

  private String a;

  private String b;

  private String c;

  private Boolean d;

  private Boolean e;

  private Boolean f;

  private String[] g;

  private String h;

  private Qi[] i;

  private Qf[] j;

  private Qs[] k;

  private Integer l;

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

  public String getC() {
    return c;
  }

  public void setC(String c) {
    this.c = c;
  }

  public Boolean getD() {
    return d;
  }

  public void setD(Boolean d) {
    this.d = d;
  }

  public Boolean getE() {
    return e;
  }

  public void setE(Boolean e) {
    this.e = e;
  }

  public Boolean getF() {
    return f;
  }

  public void setF(Boolean f) {
    this.f = f;
  }

  public String[] getG() {
    return g;
  }

  public void setG(String[] g) {
    this.g = g;
  }

  public String getH() {
    return h;
  }

  public void setH(String h) {
    this.h = h;
  }

  public Qi[] getI() {
    return i;
  }

  public void setI(Qi[] i) {
    this.i = i;
  }

  public Qf[] getJ() {
    return j;
  }

  public void setJ(Qf[] j) {
    this.j = j;
  }

  public Qs[] getK() {
    return k;
  }

  public void setK(Qs[] k) {
    this.k = k;
  }

  public Integer getL() {
    return l;
  }

  public void setL(Integer l) {
    this.l = l;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.a = in.readString();
    this.b = in.readString();
    this.c = in.readString();
    this.d = in.readObject(Boolean.class);
    this.e = in.readObject(Boolean.class);
    this.f = in.readObject(Boolean.class);
    this.g = in.readObject(String[].class);
    this.h = in.readString();
    this.i = in.readObject(Qi[].class);
    this.j = in.readObject(Qf[].class);
    this.k = in.readObject(Qs[].class);
    this.l = in.readObject(Integer.class);
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.a);
    out.writeString(this.b);
    out.writeString(this.c);
    out.writeObject(this.d, JDBCType.BOOLEAN);
    out.writeObject(this.e, JDBCType.BOOLEAN);
    out.writeObject(this.f, JDBCType.BOOLEAN);
    out.writeObject(this.g, JDBCType.ARRAY);
    out.writeString(this.h);
    out.writeObject(this.i, JDBCType.ARRAY);
    out.writeObject(this.j, JDBCType.ARRAY);
    out.writeObject(this.k, JDBCType.ARRAY);
    out.writeObject(this.l, JDBCType.INTEGER);
  }
}
