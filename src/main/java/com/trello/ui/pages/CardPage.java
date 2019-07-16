package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.*;

public class CardPage {

    private Elem labelsBtn = new Elem(By.xpath("//a[@title='Labels']"), "Labels Button");
    private Elem searchLabelsFld = new Elem(By.xpath("//input[@class='js-autofocus js-label-search']"), "Search labels Field");
    private Elem newLabelNameFld = new Elem(By.xpath("//input[@id='labelName']"), "Input New Label Name Field");
    private Elem createLabelBtn = new Elem(By.xpath("//input[@class='primary wide js-submit']"), "Create Label Button");
    private Elem createNewLabelBtn = new Elem(By.xpath("//a[@class='subtle button full js-add-label']"),
            "Create a New Label Button");
    private Elem closeBtn = new Elem(By.xpath("//a[@class='icon-lg icon-close dialog-close-button js-close-window']"),
            "Close Button");
    private Elem checklistBtn = new Elem(By.xpath("//a[@title='Checklist']"), "Checklist Button");
    private Elem newChecklistNameFld = new Elem(By.xpath("//input[@id='id-checklist']"), "New Checklist Name Field");
    private Elem addChecklistBtn = new Elem(By.xpath("//input[@value='Add']"), "Add Checklist Button");
    private Elem dueDateBtn = new Elem(By.xpath("//a[@title='Due Date']"), "Due Date Button");
    private Elem saveDueDateBtn = new Elem(By.xpath("//input[@class='primary wide confirm']"), "Save Due Date Button");
    private Elem attachmentBtn = new Elem(By.xpath("//a[@title='Attachment']"), "Attachment Button");
    private Elem attachLinkFld = new Elem(By.xpath("//input[@id='addLink']"), "Attach Link Field");
    private Elem deleteLabelBtn = new Elem(By.xpath("//*[@value='Delete']"), "Delete Label Button");
    private Elem attachBtn = new Elem(By.xpath("//input[@value='Attach']"), "Attach Field");
    private Elem createdLabelBtn = new Elem(By.xpath("//*[@class='u-clearfix js-card-detail-labels-list js-edit-label']//*[@title='LabelNameForRename']"),
            "Created Label Button");
    private Elem commentFld = new Elem(By.xpath("//textarea[@class='comment-box-input js-new-comment-input']"),
            "Comment Field");
    private Elem saveCommentBtn = new Elem(By.xpath("//input[@class='primary confirm mod-no-top-bottom-margin js-add-comment']"),
            "Save Comment Button");
    private Elem descriptionFld = new Elem(By.xpath("//div[@class='u-gutter']//div[@attr='desc']"),
            "Description Field");
    private Elem saveDescriptionBtn = new Elem(By.xpath("//input[@class='primary confirm mod-submit-edit js-save-edit']"),
            "Save Description Button");
    Elem closeLabelPopupBtn = new Elem(By.xpath("//a[@class='pop-over-header-close-btn icon-sm icon-close']"),
            "Close Label Popup Button");

    public void open(String cardUrl){
        get(cardUrl);
        Assert.assertTrue(isOpened(), "Page 'Card' is not opened");
    }

    private boolean isOpened() {
        return checklistBtn.isPresent();
    }

    public void closeCard() {
        closeBtn.click();
        Assert.assertTrue(new BoardPage().isOpened(), "Board page is not opened");
    }

    @Step
    public void addLabel(String labelName) {
        labelsBtn.click();
        createNewLabelBtn.click();
        newLabelNameFld.type(labelName);
        createLabelBtn.click();
        closeLabelPopupBtn.click();
    }

    @Step
    public void deleteLabel(String labelName) {
        Elem searchLabelFld = new Elem(By.xpath("//*[@placeholder='Search labels…']"),
                "Search Label Field");
        Elem editLabelBtn = new Elem(By.xpath("//*[@class='card-label-edit-button icon-sm icon-edit js-edit-label']"),
                "Edit Label");
        Elem createdLabelForDeleteBtn = new Elem(By.xpath("//*[@class='u-clearfix js-card-detail-labels-list js-edit-label']//*[@title='LabelTestForDelete']"),
                "Created Label Button");
        Elem lastDeleteLabelBtn = new Elem(By.xpath("//*[@class='js-confirm full negate']"),
                "Last Delete Label Button");
        createdLabelForDeleteBtn.click();
        searchLabelFld.type(labelName);
        editLabelBtn.click();
        deleteLabelBtn.click();
        lastDeleteLabelBtn.click();
        closeLabelPopupBtn.click();
    }

    @Step
    public void renameLabel(String oldLabelName, String newLabelName) {
        Elem searchLabelFld = new Elem(By.xpath("//*[@placeholder='Search labels…']"),
                "Search Label Field");
        Elem editLabelBtn = new Elem(By.xpath("//*[@class='card-label-edit-button icon-sm icon-edit js-edit-label']"),
                "Edit Label");
        createdLabelBtn.click();
        searchLabelFld.type(oldLabelName);
        editLabelBtn.click();
        newLabelNameFld.type(newLabelName);
        createLabelBtn.click();
        closeLabelPopupBtn.click();
    }

    public void addChecklist() {
        checklistBtn.click();
        newChecklistNameFld.type("ChecklistNameTest");
        addChecklistBtn.click();
    }

    public void addDueDate() {
        Elem dueDateTitle = new Elem(By.xpath("//h3[contains(@class, 'card-detail-item-header') and text() = 'Due Date']"),
                "Due Date Title");
        dueDateBtn.click();
        saveDueDateBtn.click();
        dueDateTitle.isPresent();
    }

    public void addAttachment() {
        Elem closeAttachmentPopupBtn = new Elem(By.xpath("//a[@class='pop-over-header-close-btn icon-sm icon-close']"),
                "Close Label Popup Button");
        attachmentBtn.click();
        attachLinkFld.type("google.com");
        attachBtn.click();
        closeAttachmentPopupBtn.click();
    }

    public void addComment() {
        commentFld.type("CommentTest");
        saveCommentBtn.click();
    }

    public void addDescription() {
        Elem activatedDescriptionFld = new Elem(By.xpath("//textarea[@class='field field-autosave js-description-draft description card-description']"),
                "Activated Description Field");
        descriptionFld.click();
        activatedDescriptionFld.type("DescriptionTest");
        saveDescriptionBtn.click();
    }
}
