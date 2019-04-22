package io.tlf.sqltest2;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Mo implements SQLData {
  private static final String TYPE_NAME = "public.mo";

  private String name;

  private Float value;

  @Override
  public String getSQLTypeName() throws SQLException {
    return TYPE_NAME;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.name = in.readString();
    this.value = in.readFloat();
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeString(this.name);
    out.writeFloat(this.value);
  }
}
