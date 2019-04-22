package io.tlf.sqltest2;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Qi implements SQLData {
  private static final String TYPE_NAME = "public.qi";

  private String key;

  private Integer value;

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

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.key = in.readString();
    this.value = in.readInt();
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.key);
    out.writeInt(this.value);
  }
}
