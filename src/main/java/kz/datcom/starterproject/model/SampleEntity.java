package kz.datcom.starterproject.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class SampleEntity extends BaseEntity {
  private String name;
  private Integer value;
}
