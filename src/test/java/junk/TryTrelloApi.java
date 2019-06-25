package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Card;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by lolik on 25.06.2019
 */
public class TryTrelloApi {

    TrelloRestClient client = new TrelloRestClient();


    @Test
    public void callIt() throws IOException, InterruptedException {
        Card card = new Card();
        card.name = "My New CARD 2";
        Card createdCard = client.cardsService.createCard("5d1252f75c6b0e48b985b108", card).execute().body();
        client.cardsService.deleteCard(createdCard.id).execute();
    }

}
