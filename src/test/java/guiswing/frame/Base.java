package guiswing.frame;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.timing.Condition;

import javax.swing.*;

import static org.assertj.swing.edt.GuiActionRunner.execute;
import static org.assertj.swing.timing.Pause.pause;
import static org.assertj.swing.timing.Timeout.timeout;

public class Base {

    protected FrameFixture window;

    public void close(){
        window.cleanUp();
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

    public GenericTypeMatcher<JButton> getButtonByText(String text) {
        return new GenericTypeMatcher<JButton>(JButton.class) {
            @Override protected boolean isMatching(JButton button) {
                return text.equals(button.getText());
            }
        };
    }

    public GenericTypeMatcher<JTextArea> getTextAreaByType() {
        return new GenericTypeMatcher<JTextArea>(JTextArea.class) {
            @Override
            protected boolean isMatching(JTextArea textArea) {
                return textArea instanceof JTextArea;
            }
        };
    }
}
