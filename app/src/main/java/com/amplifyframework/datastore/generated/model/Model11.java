package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Model11 type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Model11s", authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Model11 implements Model {
  public static final QueryField ID = field("Model11", "id");
  public static final QueryField UPDATED = field("Model11", "updated");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean updated;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Boolean getUpdated() {
      return updated;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Model11(String id, Boolean updated) {
    this.id = id;
    this.updated = updated;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Model11 model11 = (Model11) obj;
      return ObjectsCompat.equals(getId(), model11.getId()) &&
              ObjectsCompat.equals(getUpdated(), model11.getUpdated()) &&
              ObjectsCompat.equals(getCreatedAt(), model11.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), model11.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUpdated())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Model11 {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("updated=" + String.valueOf(getUpdated()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static UpdatedStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Model11 justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Model11(
      id,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      updated);
  }
  public interface UpdatedStep {
    BuildStep updated(Boolean updated);
  }
  

  public interface BuildStep {
    Model11 build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements UpdatedStep, BuildStep {
    private String id;
    private Boolean updated;
    @Override
     public Model11 build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Model11(
          id,
          updated);
    }
    
    @Override
     public BuildStep updated(Boolean updated) {
        Objects.requireNonNull(updated);
        this.updated = updated;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Boolean updated) {
      super.id(id);
      super.updated(updated);
    }
    
    @Override
     public CopyOfBuilder updated(Boolean updated) {
      return (CopyOfBuilder) super.updated(updated);
    }
  }
  
}
