package qase.services;

import qase.model.Suite;
import qase.model.responses.SuiteResponse;

public class SuiteService extends BaseService {

  public SuiteResponse post(String code, Suite suite) {
    return gson.fromJson(post(String.format("suite/%s", code), gson.toJson(suite), 200),
        SuiteResponse.class);
  }
}