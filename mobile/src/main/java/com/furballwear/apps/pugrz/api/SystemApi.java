package com.furballwear.apps.pugrz.api;

import com.furballwear.apps.pugrz.client.ApiException;
import com.furballwear.apps.pugrz.client.ApiInvoker;
import com.furballwear.apps.pugrz.model.EventsResponse;
import com.furballwear.apps.pugrz.model.Register;
import com.furballwear.apps.pugrz.model.Constant;
import com.furballwear.apps.pugrz.model.ScriptsResponse;
import com.furballwear.apps.pugrz.model.RolesResponse;
import com.furballwear.apps.pugrz.model.AppGroupsResponse;
import com.furballwear.apps.pugrz.model.CustomSettings;
import com.furballwear.apps.pugrz.model.EventResponse;
import com.furballwear.apps.pugrz.model.ProviderUsersRequest;
import com.furballwear.apps.pugrz.model.ProviderUsersResponse;
import com.furballwear.apps.pugrz.model.ProviderUserRequest;
import com.furballwear.apps.pugrz.model.ProvidersRequest;
import com.furballwear.apps.pugrz.model.ProviderRequest;
import com.furballwear.apps.pugrz.model.ProvidersResponse;
import com.furballwear.apps.pugrz.model.EnvironmentResponse;
import com.furballwear.apps.pugrz.model.ScriptOutput;
import com.furballwear.apps.pugrz.model.EventsRequest;
import com.furballwear.apps.pugrz.model.Login;
import com.furballwear.apps.pugrz.model.PasswordResponse;
import com.furballwear.apps.pugrz.model.ProfileResponse;
import com.furballwear.apps.pugrz.model.UsersRequest;
import com.furballwear.apps.pugrz.model.Session;
import com.furballwear.apps.pugrz.model.EmailTemplateRequest;
import com.furballwear.apps.pugrz.model.DeviceResponse;
import com.furballwear.apps.pugrz.model.UserRequest;
import com.furballwear.apps.pugrz.model.ConfigResponse;
import com.furballwear.apps.pugrz.model.EmailTemplatesRequest;
import com.furballwear.apps.pugrz.model.CustomSetting;
import com.furballwear.apps.pugrz.model.ServiceResponse;
import com.furballwear.apps.pugrz.model.PasswordRequest;
import com.furballwear.apps.pugrz.model.ServiceRequest;
import com.furballwear.apps.pugrz.model.DeviceRequest;
import com.furballwear.apps.pugrz.model.RoleRequest;
import com.furballwear.apps.pugrz.model.ServicesResponse;
import com.furballwear.apps.pugrz.model.ScriptResponse;
import com.furballwear.apps.pugrz.model.AppsRequest;
import com.furballwear.apps.pugrz.model.AppGroupResponse;
import com.furballwear.apps.pugrz.model.EmailTemplatesResponse;
import com.furballwear.apps.pugrz.model.Constants;
import com.furballwear.apps.pugrz.model.Resources;
import com.furballwear.apps.pugrz.model.AppsResponse;
import com.furballwear.apps.pugrz.model.EmailTemplateResponse;
import com.furballwear.apps.pugrz.model.ProviderUserResponse;
import com.furballwear.apps.pugrz.model.Success;
import com.furballwear.apps.pugrz.model.ServicesRequest;
import com.furballwear.apps.pugrz.model.EventCacheResponse;
import com.furballwear.apps.pugrz.model.AppRequest;
import com.furballwear.apps.pugrz.model.RolesRequest;
import com.furballwear.apps.pugrz.model.AppGroupsRequest;
import com.furballwear.apps.pugrz.model.AppGroupRequest;
import com.furballwear.apps.pugrz.model.UserResponse;
import com.furballwear.apps.pugrz.model.ProfileRequest;
import com.furballwear.apps.pugrz.model.ProviderResponse;
import com.furballwear.apps.pugrz.model.DevicesResponse;
import com.furballwear.apps.pugrz.model.EventRequest;
import com.furballwear.apps.pugrz.model.AppResponse;
import com.furballwear.apps.pugrz.model.UsersResponse;
import com.furballwear.apps.pugrz.model.RoleResponse;
import com.furballwear.apps.pugrz.model.ConfigRequest;
import java.util.*;

public class SystemApi {
	String basePath = "http://www.primetruckinginc.com:8080/rest";
	String serviceName = "/system";
	ApiInvoker apiInvoker = ApiInvoker.getInstance();

	public void addHeader(String key, String value) {
		getInvoker().addDefaultHeader(key, value);
	}

	public ApiInvoker getInvoker() {
		return apiInvoker;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getBasePath() {
		return basePath;
	}
	
	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}

	public String getServiceName(){
		return this.serviceName;
	}

	public Resources getResources () throws ApiException {
		// create path and map variables
		String path = serviceName.replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (Resources) ApiInvoker.deserialize(response, "", Resources.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppsResponse getApps (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema) throws ApiException {
		// create path and map variables
		String path = serviceName + "/app".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppsResponse) ApiInvoker.deserialize(response, "", AppsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppsResponse createApps (AppsRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (AppsResponse) ApiInvoker.deserialize(response, "", AppsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppsResponse updateApps (AppsRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (AppsResponse) ApiInvoker.deserialize(response, "", AppsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppsResponse deleteApps (String ids, Boolean force, String fields, String related, Boolean delete_storage) throws ApiException {
		// create path and map variables
		String path = serviceName + "/app".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(delete_storage)))
			queryParams.put("delete_storage", String.valueOf(delete_storage));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppsResponse) ApiInvoker.deserialize(response, "", AppsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppResponse getApp (String id, String fields, String related, Boolean pkg, Boolean include_files, Boolean include_services, Boolean include_schema, Boolean sdk) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(pkg)))
			queryParams.put("pkg", String.valueOf(pkg));
		if(!"null".equals(String.valueOf(include_files)))
			queryParams.put("include_files", String.valueOf(include_files));
		if(!"null".equals(String.valueOf(include_services)))
			queryParams.put("include_services", String.valueOf(include_services));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		if(!"null".equals(String.valueOf(sdk)))
			queryParams.put("sdk", String.valueOf(sdk));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppResponse) ApiInvoker.deserialize(response, "", AppResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppResponse updateApp (String id, AppRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (AppResponse) ApiInvoker.deserialize(response, "", AppResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppResponse deleteApp (String id, String fields, String related, Boolean delete_storage) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(delete_storage)))
			queryParams.put("delete_storage", String.valueOf(delete_storage));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppResponse) ApiInvoker.deserialize(response, "", AppResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppGroupsResponse getAppGroups (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema) throws ApiException {
		// create path and map variables
		String path = serviceName + "/app_group".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppGroupsResponse) ApiInvoker.deserialize(response, "", AppGroupsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppGroupsResponse createAppGroups (AppGroupsRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app_group".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (AppGroupsResponse) ApiInvoker.deserialize(response, "", AppGroupsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppGroupsResponse updateAppGroups (AppGroupsRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app_group".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (AppGroupsResponse) ApiInvoker.deserialize(response, "", AppGroupsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppGroupsResponse deleteAppGroups (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/app_group".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppGroupsResponse) ApiInvoker.deserialize(response, "", AppGroupsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppGroupResponse getAppGroup (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app_group/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppGroupResponse) ApiInvoker.deserialize(response, "", AppGroupResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppGroupResponse updateAppGroup (String id, AppGroupRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app_group/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (AppGroupResponse) ApiInvoker.deserialize(response, "", AppGroupResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public AppGroupResponse deleteAppGroup (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/app_group/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (AppGroupResponse) ApiInvoker.deserialize(response, "", AppGroupResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ConfigResponse getConfig () throws ApiException {
		// create path and map variables
		String path = serviceName + "/config".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ConfigResponse) ApiInvoker.deserialize(response, "", ConfigResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ConfigResponse setConfig (ConfigRequest body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/config".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ConfigResponse) ApiInvoker.deserialize(response, "", ConfigResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Constants getConstants () throws ApiException {
		// create path and map variables
		String path = serviceName + "/constant".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (Constants) ApiInvoker.deserialize(response, "", Constants.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Constant getConstant (String type) throws ApiException {
		// verify required params are set
		if(type == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/constant/{type}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "type" + "\\}", apiInvoker.escapeString(type.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (Constant) ApiInvoker.deserialize(response, "", Constant.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public CustomSettings getCustomSettings () throws ApiException {
		// create path and map variables
		String path = serviceName + "/custom".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (CustomSettings) ApiInvoker.deserialize(response, "", CustomSettings.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success setCustomSettings (CustomSettings body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/custom".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public CustomSetting getCustomSetting1(String setting) throws ApiException {
		// verify required params are set
		if(setting == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/custom/{setting}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "setting" + "\\}", apiInvoker.escapeString(setting.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (CustomSetting) ApiInvoker.deserialize(response, "", CustomSetting.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success deleteCustomSetting1 (String setting) throws ApiException {
		// verify required params are set
		if(setting == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/custom/{setting}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "setting" + "\\}", apiInvoker.escapeString(setting.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public DevicesResponse getDevices (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema) throws ApiException {
		// create path and map variables
		String path = serviceName + "/device".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (DevicesResponse) ApiInvoker.deserialize(response, "", DevicesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public DevicesResponse deleteDevices (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/device".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (DevicesResponse) ApiInvoker.deserialize(response, "", DevicesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public DeviceResponse getDevice (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/device/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (DeviceResponse) ApiInvoker.deserialize(response, "", DeviceResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public DeviceResponse deleteDevice (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/device/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (DeviceResponse) ApiInvoker.deserialize(response, "", DeviceResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EmailTemplatesResponse getEmailTemplates (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema) throws ApiException {
		// create path and map variables
		String path = serviceName + "/email_template".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (EmailTemplatesResponse) ApiInvoker.deserialize(response, "", EmailTemplatesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EmailTemplatesResponse createEmailTemplates (EmailTemplatesRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/email_template".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EmailTemplatesResponse) ApiInvoker.deserialize(response, "", EmailTemplatesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EmailTemplatesResponse updateEmailTemplates (EmailTemplatesRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/email_template".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EmailTemplatesResponse) ApiInvoker.deserialize(response, "", EmailTemplatesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EmailTemplatesResponse deleteEmailTemplates (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/email_template".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (EmailTemplatesResponse) ApiInvoker.deserialize(response, "", EmailTemplatesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EmailTemplateResponse getEmailTemplate (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/email_template/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (EmailTemplateResponse) ApiInvoker.deserialize(response, "", EmailTemplateResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EmailTemplateResponse updateEmailTemplate (String id, EmailTemplateRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/email_template/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EmailTemplateResponse) ApiInvoker.deserialize(response, "", EmailTemplateResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EmailTemplateResponse deleteEmailTemplate (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/email_template/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (EmailTemplateResponse) ApiInvoker.deserialize(response, "", EmailTemplateResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EnvironmentResponse getEnvironment () throws ApiException {
		// create path and map variables
		String path = serviceName + "/environment".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (EnvironmentResponse) ApiInvoker.deserialize(response, "", EnvironmentResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EventCacheResponse getEvents (Boolean all_events, Boolean as_cached) throws ApiException {
		// create path and map variables
		String path = serviceName + "/event".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(all_events)))
			queryParams.put("all_events", String.valueOf(all_events));
		if(!"null".equals(String.valueOf(as_cached)))
			queryParams.put("as_cached", String.valueOf(as_cached));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (EventCacheResponse) ApiInvoker.deserialize(response, "", EventCacheResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EventsResponse registerEvents (EventsRequest body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/event".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EventsResponse) ApiInvoker.deserialize(response, "", EventsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EventsResponse unregisterEvents (EventsRequest body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/event".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EventsResponse) ApiInvoker.deserialize(response, "", EventsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EventResponse getEvent (String event_name) throws ApiException {
		// verify required params are set
		if(event_name == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/event/{event_name}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "event_name" + "\\}", apiInvoker.escapeString(event_name.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (EventResponse) ApiInvoker.deserialize(response, "", EventResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EventResponse registerEvent (EventRequest body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/event/{event_name}".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EventResponse) ApiInvoker.deserialize(response, "", EventResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EventResponse updateEvent (String id, EventRequest body) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/event/{event_name}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EventResponse) ApiInvoker.deserialize(response, "", EventResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public EventResponse unregisterEvent (String id, EventRequest body) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/event/{event_name}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, body, headerParams, contentType);
			if(response != null){
				return (EventResponse) ApiInvoker.deserialize(response, "", EventResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProvidersResponse getProviders (Long user_id) throws ApiException {
		// create path and map variables
		String path = serviceName + "/provider".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(user_id)))
			queryParams.put("user_id", String.valueOf(user_id));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProvidersResponse) ApiInvoker.deserialize(response, "", ProvidersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProvidersResponse createProviders (ProvidersRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ProvidersResponse) ApiInvoker.deserialize(response, "", ProvidersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProvidersResponse updateProviders (ProvidersRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ProvidersResponse) ApiInvoker.deserialize(response, "", ProvidersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProvidersResponse deleteProviders (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/provider".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProvidersResponse) ApiInvoker.deserialize(response, "", ProvidersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderResponse getProvider (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProviderResponse) ApiInvoker.deserialize(response, "", ProviderResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderResponse updateProvider (String id, ProviderRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ProviderResponse) ApiInvoker.deserialize(response, "", ProviderResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderResponse deleteProvider (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProviderResponse) ApiInvoker.deserialize(response, "", ProviderResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderUsersResponse getProviderUsers (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema, String file) throws ApiException {
		// create path and map variables
		String path = serviceName + "/provider_user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		if(!"null".equals(String.valueOf(file)))
			queryParams.put("file", String.valueOf(file));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProviderUsersResponse) ApiInvoker.deserialize(response, "", ProviderUsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderUsersResponse createProviderUsers (ProviderUsersRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider_user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ProviderUsersResponse) ApiInvoker.deserialize(response, "", ProviderUsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderUsersResponse updateProviderUsers (ProviderUsersRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider_user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ProviderUsersResponse) ApiInvoker.deserialize(response, "", ProviderUsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderUsersResponse deleteProviderUsers (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/provider_user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProviderUsersResponse) ApiInvoker.deserialize(response, "", ProviderUsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderUserResponse getProviderUser (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider_user/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProviderUserResponse) ApiInvoker.deserialize(response, "", ProviderUserResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderUserResponse updateProviderUser (String id, ProviderUserRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider_user/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ProviderUserResponse) ApiInvoker.deserialize(response, "", ProviderUserResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProviderUserResponse deleteProviderUser (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/provider_user/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProviderUserResponse) ApiInvoker.deserialize(response, "", ProviderUserResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public RolesResponse getRoles (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema) throws ApiException {
		// create path and map variables
		String path = serviceName + "/role".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (RolesResponse) ApiInvoker.deserialize(response, "", RolesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public RolesResponse createRoles (RolesRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/role".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (RolesResponse) ApiInvoker.deserialize(response, "", RolesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public RolesResponse updateRoles (RolesRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/role".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (RolesResponse) ApiInvoker.deserialize(response, "", RolesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public RolesResponse deleteRoles (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/role".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (RolesResponse) ApiInvoker.deserialize(response, "", RolesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public RoleResponse getRole (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/role/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (RoleResponse) ApiInvoker.deserialize(response, "", RoleResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public RoleResponse updateRole (String id, RoleRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/role/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (RoleResponse) ApiInvoker.deserialize(response, "", RoleResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public RoleResponse deleteRole (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/role/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (RoleResponse) ApiInvoker.deserialize(response, "", RoleResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ScriptsResponse getScripts (Boolean include_script_body, Boolean include_user_scripts, Boolean include_only_user_scripts) throws ApiException {
		// create path and map variables
		String path = serviceName + "/script".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(include_script_body)))
			queryParams.put("include_script_body", String.valueOf(include_script_body));
		if(!"null".equals(String.valueOf(include_user_scripts)))
			queryParams.put("include_user_scripts", String.valueOf(include_user_scripts));
		if(!"null".equals(String.valueOf(include_only_user_scripts)))
			queryParams.put("include_only_user_scripts", String.valueOf(include_only_user_scripts));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ScriptsResponse) ApiInvoker.deserialize(response, "", ScriptsResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ScriptResponse getScript (String script_id, Boolean is_user_script, Boolean include_script_body) throws ApiException {
		// verify required params are set
		if(script_id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/script/{script_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "script_id" + "\\}", apiInvoker.escapeString(script_id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(is_user_script)))
			queryParams.put("is_user_script", String.valueOf(is_user_script));
		if(!"null".equals(String.valueOf(include_script_body)))
			queryParams.put("include_script_body", String.valueOf(include_script_body));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ScriptResponse) ApiInvoker.deserialize(response, "", ScriptResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ScriptOutput runScript (String script_id, Boolean is_user_script) throws ApiException {
		// verify required params are set
		if(script_id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/script/{script_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "script_id" + "\\}", apiInvoker.escapeString(script_id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(is_user_script)))
			queryParams.put("is_user_script", String.valueOf(is_user_script));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ScriptOutput) ApiInvoker.deserialize(response, "", ScriptOutput.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ScriptResponse writeScript (String script_id, String body, Boolean is_user_script) throws ApiException {
		// verify required params are set
		if(script_id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/script/{script_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "script_id" + "\\}", apiInvoker.escapeString(script_id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(is_user_script)))
			queryParams.put("is_user_script", String.valueOf(is_user_script));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ScriptResponse) ApiInvoker.deserialize(response, "", ScriptResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ScriptResponse deleteScript (String script_id, Boolean is_user_script) throws ApiException {
		// verify required params are set
		if(script_id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/script/{script_id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "script_id" + "\\}", apiInvoker.escapeString(script_id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(is_user_script)))
			queryParams.put("is_user_script", String.valueOf(is_user_script));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ScriptResponse) ApiInvoker.deserialize(response, "", ScriptResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ServicesResponse getServices (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema, Boolean include_components) throws ApiException {
		// create path and map variables
		String path = serviceName + "/service".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		if(!"null".equals(String.valueOf(include_components)))
			queryParams.put("include_components", String.valueOf(include_components));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ServicesResponse) ApiInvoker.deserialize(response, "", ServicesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ServicesResponse createServices (ServicesRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/service".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ServicesResponse) ApiInvoker.deserialize(response, "", ServicesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ServicesResponse updateServices (ServicesRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/service".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ServicesResponse) ApiInvoker.deserialize(response, "", ServicesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ServicesResponse deleteServices (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/service".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ServicesResponse) ApiInvoker.deserialize(response, "", ServicesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ServiceResponse getService (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/service/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ServiceResponse) ApiInvoker.deserialize(response, "", ServiceResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ServiceResponse updateService (String id, ServiceRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/service/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (ServiceResponse) ApiInvoker.deserialize(response, "", ServiceResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ServiceResponse deleteService (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/service/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ServiceResponse) ApiInvoker.deserialize(response, "", ServiceResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public UsersResponse getUsers (String ids, String filter, Integer limit, String order, Integer offset, String fields, String related, Boolean include_count, Boolean include_schema, String file) throws ApiException {
		// create path and map variables
		String path = serviceName + "/user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(filter)))
			queryParams.put("filter", String.valueOf(filter));
		if(!"null".equals(String.valueOf(limit)))
			queryParams.put("limit", String.valueOf(limit));
		if(!"null".equals(String.valueOf(order)))
			queryParams.put("order", String.valueOf(order));
		if(!"null".equals(String.valueOf(offset)))
			queryParams.put("offset", String.valueOf(offset));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		if(!"null".equals(String.valueOf(include_count)))
			queryParams.put("include_count", String.valueOf(include_count));
		if(!"null".equals(String.valueOf(include_schema)))
			queryParams.put("include_schema", String.valueOf(include_schema));
		if(!"null".equals(String.valueOf(file)))
			queryParams.put("file", String.valueOf(file));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (UsersResponse) ApiInvoker.deserialize(response, "", UsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public UsersResponse createUsers (UsersRequest body, String fields, String related, String XHTTPMETHOD) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		headerParams.put("X-HTTP-METHOD", XHTTPMETHOD);
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (UsersResponse) ApiInvoker.deserialize(response, "", UsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public UsersResponse updateUsers (UsersRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (UsersResponse) ApiInvoker.deserialize(response, "", UsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public UsersResponse deleteUsers (String ids, Boolean force, String fields, String related) throws ApiException {
		// create path and map variables
		String path = serviceName + "/user".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(ids)))
			queryParams.put("ids", String.valueOf(ids));
		if(!"null".equals(String.valueOf(force)))
			queryParams.put("force", String.valueOf(force));
		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (UsersResponse) ApiInvoker.deserialize(response, "", UsersResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public UserResponse getUser (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/user/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (UserResponse) ApiInvoker.deserialize(response, "", UserResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public UserResponse updateUser (String id, UserRequest body, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null || body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/user/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "PATCH", queryParams, body, headerParams, contentType);
			if(response != null){
				return (UserResponse) ApiInvoker.deserialize(response, "", UserResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public UserResponse deleteUser (String id, String fields, String related) throws ApiException {
		// verify required params are set
		if(id == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/user/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(fields)))
			queryParams.put("fields", String.valueOf(fields));
		if(!"null".equals(String.valueOf(related)))
			queryParams.put("related", String.valueOf(related));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (UserResponse) ApiInvoker.deserialize(response, "", UserResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public CustomSettings getCustomSettings1() throws ApiException {
		// create path and map variables
		String path = serviceName + "/custom".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (CustomSettings) ApiInvoker.deserialize(response, "", CustomSettings.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success setCustomSettings1 (CustomSettings body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/custom".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public CustomSetting getCustomSetting (String setting) throws ApiException {
		// verify required params are set
		if(setting == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/custom/{setting}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "setting" + "\\}", apiInvoker.escapeString(setting.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (CustomSetting) ApiInvoker.deserialize(response, "", CustomSetting.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success deleteCustomSetting (String setting) throws ApiException {
		// verify required params are set
		if(setting == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/custom/{setting}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "setting" + "\\}", apiInvoker.escapeString(setting.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public DevicesResponse getDevices () throws ApiException {
		// create path and map variables
		String path = serviceName + "/device".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (DevicesResponse) ApiInvoker.deserialize(response, "", DevicesResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success setDevice (DeviceRequest body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/device".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public PasswordResponse changePassword (Boolean reset, Boolean login, PasswordRequest body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/password".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(reset)))
			queryParams.put("reset", String.valueOf(reset));
		if(!"null".equals(String.valueOf(login)))
			queryParams.put("login", String.valueOf(login));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (PasswordResponse) ApiInvoker.deserialize(response, "", PasswordResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public ProfileResponse getProfile () throws ApiException {
		// create path and map variables
		String path = serviceName + "/profile".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (ProfileResponse) ApiInvoker.deserialize(response, "", ProfileResponse.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success updateProfile (ProfileRequest body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/profile".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success register (Boolean login, Register body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/register".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		if(!"null".equals(String.valueOf(login)))
			queryParams.put("login", String.valueOf(login));
		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Session getSession () throws ApiException {
		// create path and map variables
		String path = serviceName + "/session".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, contentType);
			if(response != null){
				return (Session) ApiInvoker.deserialize(response, "", Session.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Session login (Login body) throws ApiException {
		// verify required params are set
		if(body == null ) {
			throw new ApiException(400, "missing required params");
		}
		// create path and map variables
		String path = serviceName + "/session".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, body, headerParams, contentType);
			if(response != null){
				return (Session) ApiInvoker.deserialize(response, "", Session.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
	public Success logout () throws ApiException {
		// create path and map variables
		String path = serviceName + "/session".replaceAll("\\{format\\}","json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();

		String contentType = "application/json";

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, null, headerParams, contentType);
			if(response != null){
				return (Success) ApiInvoker.deserialize(response, "", Success.class);
			}
			else {
				return null;
			}
		} catch (ApiException ex) {
			if(ex.getCode() == 404) {
				return null;
			}
			else {
				throw ex;
			}
		}
	}
}

