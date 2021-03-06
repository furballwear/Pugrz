package com.furballwear.apps.pugrz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

import com.furballwear.apps.pugrz.model.Metadata;
import com.furballwear.apps.pugrz.model.ProviderUserResponse;
public class ProviderUsersResponse {
  /* Array of system provider user records. */
  @JsonProperty("record")
  private List<ProviderUserResponse> record = new ArrayList<ProviderUserResponse>();
  /* Array of metadata returned for GET requests. */
  @JsonProperty("meta")
  private Metadata meta = null;
  public List<ProviderUserResponse> getRecord() {
    return record;
  }
  public void setRecord(List<ProviderUserResponse> record) {
    this.record = record;
  }

  public Metadata getMeta() {
    return meta;
  }
  public void setMeta(Metadata meta) {
    this.meta = meta;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProviderUsersResponse {\n");
    sb.append("  record: ").append(record).append("\n");
    sb.append("  meta: ").append(meta).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

