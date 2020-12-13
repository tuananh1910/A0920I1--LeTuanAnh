package _07_Abstract_Interface.Thuc_Hanh.Animal_Interface_Edible;

public class main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Interface_Edible edible = (Chicken) animal;// ép kiểu tường minh
                System.out.println(edible.howToEat());
            }
        }
    }
}
