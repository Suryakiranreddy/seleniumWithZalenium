package com.automationcalling.testsuites;

import com.automation.pagefactory.Automationcallinghome;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class BasicTests {
    private Automationcallinghome automationcallinghome;

    @Parameters({"browsertype", "executionType"})
    @BeforeClass
    public void init(String browserType, String executionType) throws IOException {
        System.out.println("beforeclass");

        automationcallinghome = new Automationcallinghome(browserType, executionType);
        System.out.println("beforeclass1");
    }

    @Test
    @Parameters({"browsertype", "executionType"})
    public void articleLinkTest() {
        System.out.println("test");
        automationcallinghome.clickArticlelink();
        System.out.println("test");

    }

    @AfterClass
    public void tearDown() {
        automationcallinghome.destroyPage();
        System.out.println("afterclass");

    }

}
