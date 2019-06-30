package com.trello.api.services;

import com.trello.api.models.Card;
import com.trello.api.models.CardBadges;
import com.trello.api.models.Labels;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by lolik on 25.06.2019
 */
public interface CardsService {

    @POST("cards")
    Call<Card> createCard(@Query("idList") String idList, @Body Card card);

    @GET("cards/{id}")
    Call<Card> getCard(@Path("id") String id);

    @GET("cards/{id}/labels")
    Call<List<Labels>> getCardLabel(@Path("id") String id);

    @GET("cards/{id}/badges")
    Call<CardBadges> getCardBadges(@Path("id") String id);

    @DELETE("cards/{id}")
    Call<ResponseBody> deleteCard(@Path("id") String id);


}
