package com.furballwear.apps.pugrz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

//import com.dreamfactory.model.Date;
import com.furballwear.apps.pugrz.model.ProviderConfigSettings;
public class ProviderResponse {
  /* Identifier of this provider. */
  @JsonProperty("id")
  private Integer id = null;
  /* The name of this provider */
  @JsonProperty("provider_name")
  private String provider_name = null;
  /* The "api_name" or endpoint of this provider. */
  @JsonProperty("api_name")
  private String api_name = null;
  /* If true, this provider is active and available for use. */
  @JsonProperty("is_active")
  private Boolean is_active = null;
  /* If true, this provider can be used to authenticate users. */
  @JsonProperty("is_login_provider")
  private Boolean is_login_provider = null;
  /* If true, this provider is a system provider and cannot be changed. */
  @JsonProperty("is_system")
  private Boolean is_system = null;
  /* The ID of the provider upon which this provider is based. This parameter is deprecated in favor of the new "provider_name" field. */
  @JsonProperty("base_provider_id")
  private Long base_provider_id = null;
  /* An array of configuration settings for this provider. */
  @JsonProperty("config_text")
  private ProviderConfigSettings config_text = null;
  /* Date this record was created. */
  @JsonProperty("created_date")
  private Date created_date = null;
  /* User Id of who created this record. */
  @JsonProperty("created_by_id")
  private Integer created_by_id = null;
  /* Date this record was last modified. */
  @JsonProperty("last_modified_date")
  private Date last_modified_date = null;
  /* User Id of who last modified this record. */
  @JsonProperty("last_modified_by_id")
  private Integer last_modified_by_id = null;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getProvider_name() {
    return provider_name;
  }
  public void setProvider_name(String provider_name) {
    this.provider_name = provider_name;
  }

  public String getApi_name() {
    return api_name;
  }
  public void setApi_name(String api_name) {
    this.api_name = api_name;
  }

  public Boolean getIs_active() {
    return is_active;
  }
  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }

  public Boolean getIs_login_provider() {
    return is_login_provider;
  }
  public void setIs_login_provider(Boolean is_login_provider) {
    this.is_login_provider = is_login_provider;
  }

  public Boolean getIs_system() {
    return is_system;
  }
  public void setIs_system(Boolean is_system) {
    this.is_system = is_system;
  }

  public Long getBase_provider_id() {
    return base_provider_id;
  }
  public void setBase_provider_id(Long base_provider_id) {
    this.base_provider_id = base_provider_id;
  }

  public ProviderConfigSettings getConfig_text() {
    return config_text;
  }
  public void setConfig_text(ProviderConfigSettings config_text) {
    this.config_text = config_text;
  }

  public Date getCreated_date() {
    return created_date;
  }
  public void setCreated_date(Date created_date) {
    this.created_date = created_date;
  }

  public Integer getCreated_by_id() {
    return created_by_id;
  }
  public void setCreated_by_id(Integer created_by_id) {
    this.created_by_id = created_by_id;
  }

  public Date getLast_modified_date() {
    return last_modified_date;
  }
  public void setLast_modified_date(Date last_modified_date) {
    this.last_modified_date = last_modified_date;
  }

  public Integer getLast_modified_by_id() {
    return last_modified_by_id;
  }
  public void setLast_modified_by_id(Integer last_modified_by_id) {
    this.last_modified_by_id = last_modified_by_id;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProviderResponse {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  provider_name: ").append(provider_name).append("\n");
    sb.append("  api_name: ").append(api_name).append("\n");
    sb.append("  is_active: ").append(is_active).append("\n");
    sb.append("  is_login_provider: ").append(is_login_provider).append("\n");
    sb.append("  is_system: ").append(is_system).append("\n");
    sb.append("  base_provider_id: ").append(base_provider_id).append("\n");
    sb.append("  config_text: ").append(config_text).append("\n");
    sb.append("  created_date: ").append(created_date).append("\n");
    sb.append("  created_by_id: ").append(created_by_id).append("\n");
    sb.append("  last_modified_date: ").append(last_modified_date).append("\n");
    sb.append("  last_modified_by_id: ").append(last_modified_by_id).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

