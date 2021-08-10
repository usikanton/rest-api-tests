package qase;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import qase.model.Project;
import qase.model.responses.ProjectResponse;
import qase.model.Suite;
import qase.model.responses.SuiteResponse;
import qase.services.ProjectService;
import qase.services.SuiteService;

public class QaseProjectTest {

  private static final String CODE = generateProjectCode();

  @Test
  public void createQaseProjectTest() {
    Project project = Project.builder().
        title("AQA11_AUE").
        code(CODE).
        build();
    ProjectService projectService = new ProjectService();
    ProjectResponse response = projectService.post(project);
    Assert.assertEquals(response.getResult().getCode(), CODE);
    Assert.assertEquals(response.isStatus(), true);
  }

  @Test
  public void createSuiteTest() {
    Suite suite = Suite.builder().
        title("Some test title").
        build();
    SuiteService suiteService = new SuiteService();
    SuiteResponse response = suiteService.post(CODE, suite);
    Assert.assertNotNull(response.getResult().getId(), "No id. Nothing has been created");
  }

  private static String generateProjectCode() {
    return RandomStringUtils.randomAlphabetic(2, 5).toUpperCase();
  }
}