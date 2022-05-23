package kz.datcom.starterproject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class BaseEntity {
  @Id
  private String id;
  private String owner;
}
