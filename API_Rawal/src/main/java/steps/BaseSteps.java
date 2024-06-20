package steps;

import configs.ScenarioContext;
import services.BaseRestService;

public class BaseSteps {
    protected final ScenarioContext scenarioContext;
    public BaseSteps(){
        this.scenarioContext = ScenarioContext.getInstance();
    }
}
