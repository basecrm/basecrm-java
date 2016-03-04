// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Note;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Precondition.*;


public class NotesService extends BaseService {

  private static final String NOTES_URL = "/v2/notes";
  private static final String NOTE_URL = "/v2/notes/%d";

  public NotesService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<Note> list(Map<String, Object> params) {
    return JsonDeserializer.deserializeList(this.httpClient.get(NOTES_URL, params).getBody(), Note.class);
  }

  public List<Note> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public Note create(Note note) {
    checkNotNull(note, "note parameter must not be null");

    String serialized = JsonSerializer.serialize(note, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(NOTES_URL, serialized).getBody(), Note.class);
  }

  public Note create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");

    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(NOTES_URL, serialized).getBody(), Note.class);
  }


  public Note get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, NOTE_URL, id);
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Note.class);
  }


  public Note update(Note note) {
    checkNotNull(note, "note parameter must not be null");
    checkNotNull(note.getId(), "note must have id attribute set");
    checkArgument(note.getId() > 0, "note id must be a valid id");

    String url = String.format(Locale.US, NOTE_URL, note.getId());
    String serialized = JsonSerializer.serialize(note, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Note.class);
  }

  public Note update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, NOTE_URL, id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Note.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, NOTE_URL, id);
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

    public SearchCriteria ids(List<Integer> ids) {
      queryParams.put("ids", ids);
      return this;
    }

    public SearchCriteria ids(long... ids) {
      return ids(ids);
    }

    public SearchCriteria creatorId(long creatorId) {
      queryParams.put("creator_id", creatorId);
      return this;
    }

    public SearchCriteria resourceId(long resourceId) {
      queryParams.put("resource_id", resourceId);
      return this;
    }

    public SearchCriteria includes(String includes) {
      queryParams.put("includes", includes);
      return this;
    }

    public SearchCriteria q(String q) {
      queryParams.put("q", q);
      return this;
    }

    public SearchCriteria resourceType(String resourceType) {
      queryParams.put("resource_type", resourceType);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

