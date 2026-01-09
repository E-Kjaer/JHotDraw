package org.jhotdraw.samples.svg.figures.bdd.rectangle;


import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class RectangleBDDTest extends ScenarioTest<GivenDrawing, WhenUserDraws, ThenRectangle> {

    @Test
    public void drawing_a_rectangle() {
        given().an_empty_drawing();
        when().a_user_drags_mouse(10, 10, 20, 30);
        then().a_rectangle_is_created(10, 10, 10, 20);
    }

    @Test
    public void selecting_a_drawn_rectangle() {
        given().a_rectangle_exist(10, 10, 20, 30);
        when().a_user_selects_rectangle(15, 15);
        then().a_rectangle_is_selected();
    }
}
