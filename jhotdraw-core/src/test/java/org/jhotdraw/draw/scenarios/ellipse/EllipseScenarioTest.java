package org.jhotdraw.draw.scenarios.ellipse;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class EllipseScenarioTest extends ScenarioTest<GivenEllipse, WhenEllipse, ThenEllipse> {

    @Test
    public void creating_an_ellipse_should_add_it_to_the_drawing() {
        given()
                .no_ellipse_exists();

        when()
                .the_user_creates_an_ellipse(10, 20, 30, 50);

        then()
                .an_ellipse_should_exist_in_the_drawing();
    }

    @Test
    public void creating_an_ellipse_should_still_have_positive_size() {
        given()
                .no_ellipse_exists();

        when()
                .the_user_creates_an_ellipse(10, 10, 10, 10);

        then()
                .the_ellipse_should_have_positive_size();
    }
}
