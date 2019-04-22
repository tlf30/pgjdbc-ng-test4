package io.tlf.sqltest2;

import com.impossibl.postgres.api.jdbc.PGType;
import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Chara implements SQLData {
  private static final String TYPE_NAME = "public.chara";

  private Ii[] a;

  private Q[] b;

  private S[] c;

  private L d;

  private M e;

  @Override
  public String getSQLTypeName() throws SQLException {
    return TYPE_NAME;
  }

  public Ii[] getA() {
    return a;
  }

  public void setA(Ii[] a) {
    this.a = a;
  }

  public Q[] getB() {
    return b;
  }

  public void setB(Q[] b) {
    this.b = b;
  }

  public S[] getC() {
    return c;
  }

  public void setC(S[] c) {
    this.c = c;
  }

  public L getD() {
    return d;
  }

  public void setD(L d) {
    this.d = d;
  }

  public M getE() {
    return e;
  }

  public void setE(M e) {
    this.e = e;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.a = in.readObject(Ii[].class);
    this.b = in.readObject(Q[].class);
    this.c = in.readObject(S[].class);
    this.d = in.readObject(L.class);
    this.e = in.readObject(M.class);
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeObject(this.a, JDBCType.ARRAY);
    out.writeObject(this.b, JDBCType.ARRAY);
    out.writeObject(this.c, JDBCType.ARRAY);
    out.writeObject(this.d, PGType.RECORD);
    out.writeObject(this.e, PGType.RECORD);
  }
}
