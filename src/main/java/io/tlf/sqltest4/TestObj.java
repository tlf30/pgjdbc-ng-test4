package io.tlf.sqltest4;

import com.impossibl.postgres.api.jdbc.PGAnyType;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class TestObj implements SQLData {
  private static final String TYPE_NAME = "public.test_obj";

  public static final PGAnyType TYPE = new PGAnyType() {
    @Override
    public String getName() {
      return TestObj.TYPE_NAME;
    }

    @Override
    public String getVendor() {
      return "UDT Generated";
    }

    @Override
    public Integer getVendorTypeNumber() {
      return null;
    }

    @Override
    public Class getJavaType() {
      return TestObj.class;
    }
  };

  private Condition cond;

  @Override
  public String getSQLTypeName() throws SQLException {
    return TYPE_NAME;
  }

  public Condition getCond() {
    return cond;
  }

  public void setCond(Condition cond) {
    this.cond = cond;
  }

  @Override
  public void readSQL(SQLInput in, String typeName) throws SQLException {
    this.cond = Condition.valueOfLabel(in.readString());
  }

  @Override
  public void writeSQL(SQLOutput out) throws SQLException {
    out.writeObject(this.cond.getLabel(), Condition.TYPE);
  }
}
