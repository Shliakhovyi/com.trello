package com.trello.api;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class TrelloAutoLogin extends BrowserFactory {

    public static void loginByApi() throws IOException {

        CookieStorage cookieStorage = new CookieStorage();
        OkHttpClient client = new OkHttpClient.Builder().cookieJar(cookieStorage).build();
        Gson gson = new Gson();

        //trello.com
        client.newCall(new Request.Builder().url("https://trello.com").build()).execute().body().string();

        //authentication
        FormBody formData = new FormBody.Builder()
                .add("method", "password")
                .add("factors[user]", "shliakhovyi.sviatoslav@pdffiller.team")
                .add("factors[password]", "1qaz2WSX3edc")
                .build();
        Request request = new Request.Builder().url("https://trello.com/1/authentication").post(formData).build();
        String response = client.newCall(request).execute().body().string();
        System.out.println("RESPONSE: "+response);
        Map<String, String> map = gson.fromJson(response, new TypeToken<Map<String, String>>(){}.getType());
        String code = map.get("code");
        System.out.println("CODE: "+code);

        //session
        String dsc = cookieStorage.cookies.stream().filter(cookie -> cookie.name().equals("dsc")).findFirst().get().value();
        FormBody sessionFormData = new FormBody.Builder()
                .add("authentication", code)
                .add("dsc", dsc)
                .build();
        Request requestSession = new Request.Builder().url("https://trello.com/1/authorization/session").post(sessionFormData).build();
        response = client.newCall(requestSession).execute().body().string();
        System.out.println(response);

        //Selenium
        driver().get("https://trello.com");

        for (Cookie cookie : cookieStorage.cookies) {
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.name(), cookie.value());
            driver().manage().addCookie(seleniumCookie);
        }

        driver().navigate().refresh();

        BoardsPage boardsPage = new BoardsPage();
        Assert.assertTrue(boardsPage.isOpened(), "Boards page is not opened after autologin");
    }
}
