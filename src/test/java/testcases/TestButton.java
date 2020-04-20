package testcases;


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

public class TestButton {

    private FrameFixture window;

    @BeforeMethod
    protected void setUp() {
        MainFrameController mainFrame = new MainFrameController();
        //GuiActionRunner.execute(() -> new MainFrameController());
        mainFrame.showMainFrameWindow();
        window = new FrameFixture(mainFrame.mainFrame);
        //window.show();
    }

    @Test
    public void testClick() {
        JButtonFixture button = window.button(textMatcherButton);
        waitForButtonEnabled(button);
        button.click();
        JTextComponentFixture textArea = window.textBox(textAreaMatcher);
        waitForTextAreaIsVisible(textArea);
        System.out.println(textArea.text());
        Assert.assertEquals(textArea.text(), "Welcome IntelliJ IDEA Swing Creator\n");
    }

    public void waitForButtonEnabled(JButtonFixture button) {
        pause(new Condition("waitButtonEnabled") {
            @Override
            public boolean test() {
                return execute(button::isEnabled);
            }
        }, timeout(1000));
    }

    public void waitForTextAreaIsVisible(JTextComponentFixture textArea) {
        pause(new Condition("waitTextAreaEnabled") {
            @Override
            public boolean test() {
                return !textArea.text().isEmpty();
            }
        }, timeout(1000));
    }

    public GenericTypeMatcher<JButton> textMatcherButton = new GenericTypeMatcher<JButton>(JButton.class) {
        @Override protected boolean isMatching(JButton button) {
            return "Say Welcome".equals(button.getText());
        }
    };

    public GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
        @Override protected boolean isMatching(JTextArea textArea) {
            return textArea instanceof JTextArea;
        }
    };

    @AfterMethod
    protected void tearDown() {
        window.cleanUp();
    }
}