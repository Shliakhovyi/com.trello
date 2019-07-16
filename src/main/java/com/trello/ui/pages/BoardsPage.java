package com.trello.ui.pages;

import com.trello.ui.core.Constants;
import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import static com.trello.ui.core.BrowserFactory.*;

/**
 * Created by lolik on 20.06.2019
 */
public class BoardsPage {

    private static final String PATH = "sviatoslav69/boards";

    public Elem profile = new Elem(By.xpath("//*[@class='_24AWINHReYjNBf']"), "Profile Logo");
    public Elem logoutBtn = new Elem(By.xpath("//*[@data-test-id='header-member-menu-logout']"), "Logout Button");
    public Elem signupBtn = new Elem(By.xpath("//*[@class='global-header-section-button mod-primary']"), "Sign Up Button");

    public Elem boardByUrlName(String urlName){
        return new Elem(By.cssSelector(".board-tile[href*='"+urlName+"']"), urlName);
    }


    public void open(){

    }

    public boolean isOpened(){
        return driver().getCurrentUrl().equals(Constants.URL+PATH);
    }

    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }

    public void logout() {
        profile.click();
        logoutBtn.isPresent();
        logoutBtn.click();
        signupBtn.isPresent();
    }


}
