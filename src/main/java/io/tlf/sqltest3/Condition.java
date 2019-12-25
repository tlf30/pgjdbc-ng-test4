package io.tlf.sqltest3;

public enum Condition {
  GOOD("good"),

  BAD("bad"),

  UNKNOWN("unknown");

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
