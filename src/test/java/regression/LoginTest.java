package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Created by lolik on 20.06.2019
 */
public class LoginTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();

    @Test
    public void login() {
        loginPage.open();
        loginPage.login("shliakhovyi.sviatoslav@pdffiller.team", "1qaz2WSX3edc");
        boardsPage.openBoard("testboardmain");
    }

}
