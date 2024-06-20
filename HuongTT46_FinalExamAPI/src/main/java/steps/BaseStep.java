package steps;

import configs.ScenarioContext;

public class BaseStep {
    protected final ScenarioContext scenarioContext;

    public BaseStep(){
        this.scenarioContext = ScenarioContext.getInstance();
    }
}
