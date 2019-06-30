package com.trello.ui.pages;

import com.trello.ui.core.Constants;
import com.trello.ui.core.Elem;
import org.openqa.selenium.By;

import static com.trello.ui.core.BrowserFactory.driver;

/**
 * Created by lolik on 20.06.2019
 */
public class BoardPage {

    public Elem backHomeBtn = new Elem(By.xpath("//span[@name='house']"), "Back To Home Button");

    public boolean isOpened(){
        return backHomeBtn.isPresent();
    }

}
