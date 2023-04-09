package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        //features = {"c:/features"},                   // feature'lar genellikle test/resources altinda olur
        features = {"src/test/resources/features/Automation_AnaSayfa.feature"},         // feature yolu alinirken content rootdan baslanir
        glue = {"stepdefs"},       // glue'lar, stepdefs ve hooks classlarinin yeridir, sourceroot'dan baslar
        dryRun = false,         // sadece step defsler düzgün hazirlanmismi, yapilandirma uygun mu
       //tags = "@Kurumsal",         // @login tagli senaryolar calistirilin
        plugin = {"pretty",
                "html:test-output/report.html",
                "json:test-output/report.json"
        }
)

public class Runner extends AbstractTestNGCucumberTests {



}









