// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Product;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;
import com.getbase.utils.Joiner;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.*;


public class ProductsService extends BaseService {
  public ProductsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<Product> list(Map<String, Object> params) {
    String url = "/v2/products";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), Product.class);
  }

  public List<Product> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public Product create(Product product) {
    checkNotNull(product, "product parameter must not be null");

    String url = "/v2/products";
    String serialized = JsonSerializer.serialize(product, Views.ReadWrite.class, "product");
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Product.class);
  }

  public Product create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = "/v2/products";
    String serialized = JsonSerializer.serialize(attributes, "product");
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Product.class);
  }


  public Product get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/v2/products/%d", id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Product.class);
  }


  public Product update(Product product) {
    checkNotNull(product, "product parameter must not be null");
    checkNotNull(product.getId(), "product must have id attribute set");
    checkArgument(product.getId() > 0, "product id must be a valid id");

    String url = String.format(Locale.US, "/v2/products/%d", product.getId());
    String serialized = JsonSerializer.serialize(product, Views.ReadWrite.class, "product");
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Product.class);
  }

  public Product update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, "/v2/products/%d", id);
    String serialized = JsonSerializer.serialize(attributes, "product");
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Product.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, "/v2/products/%d", id);
    return this.httpClient.delete(url, null).getHttpStatus() == 204;
  }



  public static class SearchCriteria {
    private Map<String, Object> queryParams;

    public SearchCriteria() {
      this.queryParams = new HashMap<String, Object>();
    }

    public SearchCriteria page(long page) {
      queryParams.put("page", page);
      return this;
    }

    public SearchCriteria perPage(long perPage) {
      queryParams.put("per_page", perPage);
      return this;
    }

    public SearchCriteria sortBy(String criteria, String order) {
      queryParams.put("sort_by", criteria + ":" + order);
      return this;
    }

    public SearchCriteria sortBy(String criteria) {
      return sortBy(criteria, "asc");
    }

    public SearchCriteria ids(List<Long> ids) {
      queryParams.put("ids", Joiner.join(",", ids));
      return this;
    }

    public SearchCriteria ids(Long... ids) {
      return ids(asList(ids));
    }

    public SearchCriteria organizationId(long organizationId) {
      queryParams.put("organization_id", organizationId);
      return this;
    }

    public SearchCriteria ownerId(long ownerId) {
      queryParams.put("owner_id", ownerId);
      return this;
    }

    public SearchCriteria active(boolean active) {
      queryParams.put("active", active);
      return this;
    }

    public SearchCriteria name(String name) {
      queryParams.put("name", name);
      return this;
    }

    public SearchCriteria sku(String sku) {
      queryParams.put("sku", sku);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

