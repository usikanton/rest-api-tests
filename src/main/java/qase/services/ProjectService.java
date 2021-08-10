package qase.services;

import qase.model.Project;
import qase.model.responses.ProjectResponse;

public class ProjectService extends BaseService {

  public ProjectResponse post(Project project) {
    return gson.fromJson(post("project", gson.toJson(project), 200), ProjectResponse.class);
  }
}