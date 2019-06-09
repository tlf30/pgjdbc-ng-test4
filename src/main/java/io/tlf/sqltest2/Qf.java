package io.tlf.sqltest2;

import java.sql.JDBCType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Qf implements SQLData {
  private static final String TYPE_NAME = "public.qf";

  private String key;

  private Float value;

  @Override
  public String getSQLTypeName() throws SQLException {
    return TYPE_NAME;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.key = in.readString();
    this.value = in.readObject(Float.class);
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.key);
    out.writeObject(this.value, JDBCType.REAL);
  }
}
