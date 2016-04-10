package net.serenitybdd.tutorials.features.search.record_items;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.tutorials.questions.TheToDoItems;
import net.serenitybdd.tutorials.tasks.*;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class AddItemsStory {
    Actor jacek = Actor.named("Jacek");

    @Managed
    public WebDriver hisBrowser;

    @Before
    public void justinCanBrowseTheWeb() {
        jacek.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void should_be_able_to_add_an_item_to_the_todo_list() {

        givenThat(jacek).wasAbleTo(StartWith.anEmptyTodoList());

        when(jacek).attemptsTo(AddATodoItem.called("Feed the cat"));

        then(jacek).should(seeThat(TheToDoItems.displayed(), hasItem("Feed the cat")));
    }

    @Test
    public void should_be_able_to_add_additional_todo_items() {

        givenThat(jacek).wasAbleTo(StartWith.aTodoListContaining("Feed the cat","take out the garbage"));

        when(jacek).attemptsTo(AddATodoItem.called("Walk the dog"));

        then(jacek).should(seeThat(TheToDoItems.displayed(), contains("Feed the cat","take out the garbage","Walk the dog")));
    }
}
