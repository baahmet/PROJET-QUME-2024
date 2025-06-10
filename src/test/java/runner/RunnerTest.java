package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

// Configuration Cucumber avec JUnit 5
import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;


/**
 * Classe de lancement des tests Cucumber.
 * Elle utilise JUnit Platform + Cucumber pour exécuter tous les scénarios .feature
 */
@Suite
@IncludeEngines("cucumber") // Indique d'utiliser le moteur Cucumber
@SelectClasspathResource("features") // Indique où se trouvent les fichiers .feature (dans resources/features/)
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "runner.steep" // Indique où se trouvent les classes StepDefinitions (package contenant les @Given, @When, @Then)
)
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/cucumber-report.html" // Génère un rapport HTML lisible
)
public class RunnerTest {
    // Cette classe ne contient aucun code, elle sert uniquement à lancer Cucumber via JUnit
}
