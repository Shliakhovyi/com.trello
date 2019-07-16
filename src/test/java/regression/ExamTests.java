package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.models.Labels;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.trello.api.TrelloAutoLogin.loginByApi;

public class ExamTests extends BrowserFactory {

    private LoginPage loginPage = new LoginPage();
    private BoardsPage boardsPage = new BoardsPage();
    private CardPage cardPage = new CardPage();
    private TrelloRestClient client = new TrelloRestClient();
    private Card card = new Card("Test_Card_" + new Date().getTime());

    @Test
    public void login() {
        loginPage.open();
        loginPage.login("shliakhovyi.sviatoslav@pdffiller.team", "1qaz2WSX3edc");
    }

    @Test
    public void logout() {
        login();
        boardsPage.logout();
        Assert.assertTrue(driver().getCurrentUrl().equals("https://trello.com/logged-out"));
    }

    @Test
    public void addLabel() throws IOException {
        card = client.cardsService.createCard("5d1252f75c6b0e48b985b108", card).execute().body();
        loginByApi();
        boardsPage.openBoard("testboardmain");
        cardPage.open(card.url);
        cardPage.addLabel("LabelTest");
        cardPage.closeCard();
        List<Labels> labels = client.cardsService.getCardLabel(card.id).execute().body();
        Assert.assertEquals(labels.get(0).name, "LabelTest", "Label name is not \"LabelTest\"");
    }

    @Test
    public void renameLabel() throws IOException {
        card = client.cardsService.createCard("5d1252f75c6b0e48b985b108", card).execute().body();
        loginByApi();
        boardsPage.openBoard("testboardmain");
        cardPage.open(card.url);
        cardPage.addLabel("LabelNameForRename");
        cardPage.renameLabel("LabelNameForRename", "NewLabelNameAfterRename");
        cardPage.closeCard();
        List<Labels> labels = client.cardsService.getCardLabel(card.id).execute().body();
        Assert.assertEquals(labels.get(0).name, "NewLabelNameAfterRename", "Label name is not \"NewLabelNameAfterRename\"");
    }

    @Test
    public void deleteLabel() throws IOException {
        card = client.cardsService.createCard("5d1252f75c6b0e48b985b108", card).execute().body();
        loginByApi();
        boardsPage.openBoard("testboardmain");
        cardPage.open(card.url);
        cardPage.addLabel("LabelTestForDelete");
        cardPage.deleteLabel("LabelTestForDelete");
        cardPage.closeCard();
        List<Labels> labels = client.cardsService.getCardLabel(card.id).execute().body();
        Assert.assertTrue(labels.isEmpty(), "Label name is not empty");
    }

}
