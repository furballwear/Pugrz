package com.furballwear.apps.pugrz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

import com.furballwear.apps.pugrz.model.TableSchema;
public class TableSchemas {
  /* An array of table definitions. */
  @JsonProperty("table")
  private List<TableSchema> table = new ArrayList<TableSchema>();
  public List<TableSchema> getTable() {
    return table;
  }
  public void setTable(List<TableSchema> table) {
    this.table = table;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableSchemas {\n");
    sb.append("  table: ").append(table).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

