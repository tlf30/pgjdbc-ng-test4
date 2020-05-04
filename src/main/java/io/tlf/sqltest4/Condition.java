package io.tlf.sqltest4;

import com.impossibl.postgres.api.jdbc.PGAnyType;

public enum Condition {
  GOOD("good"),

  BAD("bad"),

  UNKNOWN("unknown");

  private static final String TYPE_NAME = "public.condition";

  public static final PGAnyType TYPE = new PGAnyType() {
    @Override
    public String getName() {
      return Condition.TYPE_NAME;
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
      return Condition.class;
    }
  };

  private String label;

  Condition(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public static Condition valueOfLabel(String label) {
    for (Condition value : values()) {
      if (value.label.equals(label)) return value;
    }
    throw new IllegalArgumentException("Invalid label");}
}
