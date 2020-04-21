package guiswing.test;


import guiswing.frame.Main;
import guiswing.ui.controller.MainFrameController;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.timing.Condition;
import org.testng.Assert;
import org.testng.annotations.*;
import javax.swing.*;
import static org.assertj.swing.edt.GuiActionRunner.execute;
import static org.assertj.swing.timing.Pause.pause;
import static org.assertj.swing.timing.Timeout.timeout;

public class TestButton extends BaseTest {

    @Test
    public void testClick() {
        Main mainFrame = getMainFrame();
        mainFrame.clickButton();
        Assert.assertEquals(mainFrame.getText(), "Welcome IntelliJ IDEA Swing Creator\n");
    }

}