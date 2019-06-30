package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import com.trello.api.models.CardBadges;
import com.trello.api.models.Labels;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import okhttp3.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CardActions extends BrowserFactory {

    public TrelloRestClient client = new TrelloRestClient();

    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();

    Card card = new Card("Test_Card_" + new Date().getTime());
    CardBadges cardBadges = new CardBadges();

    @BeforeTest
    public void prepareData() throws IOException {
        card = client.cardsService.createCard("5d1252f75c6b0e48b985b108", card).execute().body();
        login();
        openCard();
        System.out.println("id" + card.id);
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
        boardsPage.openBoard("testboardmain");
        cardPage.open(card.url);
    }

    @Test
    public void closeCard() {
        cardPage.closeCard();
    }

    @Test
    public void addLabel() throws IOException {
        cardPage.addLabel("LabelTest");
        closeCard();
        List<Labels> labels = client.cardsService.getCardLabel(card.id).execute().body();
        Assert.assertEquals(labels.get(0).name, "LabelTest", "Label name is not \"LabelTest\"");
    }

    @Test
    public void addChecklist() throws IOException {
        cardPage.addChecklist();
        closeCard();
        //To Do: API assert
    }

    @Test
    public void addDueDate() throws IOException {
        cardPage.addDueDate();
        closeCard();
        card = client.cardsService.getCard(card.id).execute().body();
        Assert.assertFalse(card.due.isEmpty(), "Card Due is empty");
    }

    @Test
    public void addAttachment() throws IOException {
        cardPage.addAttachment();
        closeCard();
        cardBadges = client.cardsService.getCardBadges(card.id).execute().body();
        Assert.assertEquals(cardBadges.attachments, 1,"Attachment is not added (attachment == 0)");
    }

    @Test
    public void addComment() throws IOException {
        cardPage.addComment();
        closeCard();
        cardBadges = client.cardsService.getCardBadges(card.id).execute().body();
        Assert.assertEquals(cardBadges.comments, 1,"Comment is not added (comments == 0)");
    }

    @Test
    public void addDescription() throws IOException {
        cardPage.addDescription();
        closeCard();
        cardBadges = client.cardsService.getCardBadges(card.id).execute().body();
        Assert.assertTrue(cardBadges.description, "Description is not added (description == false");
    }

    @Test
    public void moveCard(){
     //   cardPage.moveToList(""):

    }

    @Test
    public void rename(){

    }
}
