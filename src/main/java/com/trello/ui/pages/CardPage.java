package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.*;

/**
 * Created by lolik on 25.06.2019
 */
public class CardPage {

    public Elem checklistBtn = new Elem(By.xpath("//a[@title='Checklist']"), "Checklist Button");

    public void open(String cardUrl){
        get(cardUrl);
        Assert.assertTrue(isOpened(), "Page 'Card' is not opened");
    }

    private boolean isOpened() {
        return checklistBtn.isPresent();
    }

    public void move(String listName){

    }


}
