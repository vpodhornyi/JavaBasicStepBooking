import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import controller.UserController;

import java.io.IOException;
import java.util.Arrays;

public class Loop {
  UserController userController;

  public Loop(UserController userController) {
    this.userController = userController;
  }


  public void run() throws IOException {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    screen.startScreen();

    // Create panel to hold components
    Panel panel = new Panel();
    panel.setLayoutManager(new GridLayout(2));

    panel.addComponent(new Label("Login"));
    panel.addComponent(new TextBox());

    panel.addComponent(new Label("Password"));
    panel.addComponent(new TextBox());

    panel.addComponent(new EmptySpace(new TerminalSize(10,0))); // Empty space underneath labels
    panel.addComponent(new Button("Submit"));

    // Create window to hold the panel
    BasicWindow window = new BasicWindow();
    window.setComponent(panel);
    window.setHints(Arrays.asList(Window.Hint.CENTERED));

    // Create gui and start gui
    MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
    gui.addWindowAndWait(window);
  }
}
