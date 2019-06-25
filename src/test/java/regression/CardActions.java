package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created by lolik on 25.06.2019
 */
public class CardActions extends BrowserFactory {

    public TrelloRestClient client = new TrelloRestClient();

    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();

    Card card = new Card("Test_Card_" + new Date().getTime());

    @BeforeTest
    public void prepareData() throws IOException {
        card = client.cardsService.createCard("5d1252f75c6b0e48b985b108", card).execute().body();
    }

    @AfterTest
    public void clearData() throws IOException {
        client.cardsService.deleteCard(card.id).execute();
    }

    @Test
    public void login(){
        loginPage.open();
        loginPage.login("shliakhovyi.sviatoslav@pdffiller.team", "1qaz2WSX3edc");
    }

    @Test
    public void openCard(){
        cardPage.open("");
    }

    @Test
    public void moveCard(){
     //   cardPage.moveToList(""):

    }

    @Test
    public void rename(){

    }
}
