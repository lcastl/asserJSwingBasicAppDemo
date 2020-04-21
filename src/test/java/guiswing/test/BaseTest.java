package guiswing.test;

import guiswing.frame.Main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private  Main mainFrame;

    @BeforeMethod
    protected void setUp() {
        mainFrame = new Main();
    }

    @AfterMethod
    protected void tearDown() {
        mainFrame.close();
    }

    public Main getMainFrame() {
        return mainFrame;
    }
}
