package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;

/**
 * Created by lolik on 20.06.2019
 */
public class BoardsPage {

    private static final String PATH = "sviatoslav69/boards";


    public Elem boardByUrlName(String urlName){
        return new Elem(By.cssSelector(".board-tile[href*='"+urlName+"']"), urlName);
    }


    public void open(){

    }

    public void isOpened(){

    }

    public void openBoard(String urlName){
        boardByUrlName(urlName).click();
    }


}
