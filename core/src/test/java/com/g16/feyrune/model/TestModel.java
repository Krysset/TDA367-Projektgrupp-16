package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestModel {
    @Test
    public void update() {
        Model model = new Model("../assets/maps/plains1.tmx");
        model.update();
        ModelState test = ModelState.WORLD;
        assertEquals(test, model.getCurrentModelState());
    }

    @Test
    public void testRegisterNewObserver() {

    }

    @Test
    public void testChangeState() {
        Model model = new Model("../assets/maps/plains1.tmx");
        model.changeState(ModelState.COMBAT);
        ModelState test = ModelState.COMBAT;
        assertEquals(test, model.getCurrentModelState());
    }

    @Test
    public void testObserverUpdate() {

    }
}
