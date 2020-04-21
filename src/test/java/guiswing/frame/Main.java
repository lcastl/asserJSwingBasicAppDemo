package guiswing.frame;

import guiswing.ui.controller.MainFrameController;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;

public class Main extends Base {

    private JButtonFixture button;
    private JTextComponentFixture textArea;

    public Main() {
        MainFrameController mainFrame = new MainFrameController();
        mainFrame.showMainFrameWindow();
        window = new FrameFixture(mainFrame.mainFrame);
        button = window.button(getButtonByText("Say Welcome"));
        textArea = window.textBox(getTextAreaByType());
    }

    public void clickButton() {
        waitForButtonEnabled(button);
        button.click();
    }

    public String getText() {
        waitForTextAreaIsVisible(textArea);
        return textArea.text();
    }

}
