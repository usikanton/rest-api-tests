package qase.model.responses;

import lombok.Data;

@Data
public abstract class BaseResponse<R> {

  boolean status;
  R result;

}
