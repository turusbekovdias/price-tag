package kz.datcom.pricetag.dto;

import io.swagger.v3.core.util.Json;
import lombok.Data;

@Data
public class ZkongResponseDTO {

    private Boolean success;
    private Integer code;
    private String message;
    private Object data;
    private Object translate;

}
