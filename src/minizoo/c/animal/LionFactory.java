package minizoo.c.animal;

import minizoo.c.Animal;
import minizoo.c.animal.lion.Lion;
import minizoo.i.AnimalFactory;

public class LionFactory implements AnimalFactory {
    @Override
    public Animal build() {
        return new Lion("lion");
    }
}
