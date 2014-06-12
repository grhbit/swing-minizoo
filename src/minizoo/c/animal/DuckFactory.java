package minizoo.c.animal;

import minizoo.c.Animal;
import minizoo.c.animal.duck.Duck;
import minizoo.i.AnimalFactory;

public class DuckFactory implements AnimalFactory {
    @Override
    public Animal build() {
        return new Duck("duck");
    }
}
