import entity.Animal;
import org.jboss.logging.Logger;

import java.util.Iterator;
import java.util.List;

public class Main {

    //private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        AnimalHelper  animalHelper = new AnimalHelper();
        Animal[] authors = new Animal[]{new Animal(10,"Zebta",true), new Animal(8,"Dog",true), new Animal(7,"Cat",true)};
        Animal[] var3 = authors;
        int var4 = authors.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Animal animal = var3[var5];
            animalHelper.addAnimal(animal);
        }

        List<Animal> authorList = animalHelper.getAnimalList();
        Iterator var8 = authorList.iterator();

        while(var8.hasNext()) {
            Animal animal = (Animal)var8.next();
            System.out.println(animal.getId() + " " + animal.getName() + " " + animal.getAge()+ " " +animal.isTail());
        }
    }
}
