package minizoo.c.animal;

import minizoo.c.Animal;
import minizoo.c.animal.bear.Bear;
import minizoo.i.AnimalFactory;

public class BearFactory implements AnimalFactory {

    @Override
    public Animal build() {
        return new Bear("Bear");
    }
}
