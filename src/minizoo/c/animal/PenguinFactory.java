package minizoo.c.animal;

import minizoo.c.Animal;
import minizoo.c.animal.penguin.Penguin;
import minizoo.i.AnimalFactory;

public class PenguinFactory implements AnimalFactory {
    @Override
    public Animal build() {
        return new Penguin("penguin");
    }
}
