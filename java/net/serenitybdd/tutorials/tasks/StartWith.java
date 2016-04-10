package net.serenitybdd.tutorials.tasks;


import com.google.common.collect.Lists;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.tutorials.ui.TodoMvcApplicationHomePage;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWith implements Task {

    TodoMvcApplicationHomePage todoMvcApplicationHomePage;

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(todoMvcApplicationHomePage));
    }

    public static StartWithAnEmptyList anEmptyTodoList(){
        return instrumented(StartWithAnEmptyList.class);
    }

    public static StartWithATodoListContaining aTodoListContaining(String... todos) {
        return Instrumented.instanceOf(StartWithATodoListContaining.class).withProperties(Lists.newArrayList(todos));
    }
}
