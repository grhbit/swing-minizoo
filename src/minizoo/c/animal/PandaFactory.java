package minizoo.c.animal;

import minizoo.c.Animal;
import minizoo.c.animal.panda.Panda;
import minizoo.i.AnimalFactory;

public class PandaFactory implements AnimalFactory {

    @Override
    public Animal build() {
        return new Panda("Panda");
    }
}
