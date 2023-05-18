package fooddeliveryexam.common;

import fooddeliveryexam.SummaryApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { SummaryApplication.class })
public class CucumberSpingConfiguration {}
