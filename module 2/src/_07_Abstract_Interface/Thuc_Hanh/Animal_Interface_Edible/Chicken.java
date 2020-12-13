package _07_Abstract_Interface.Thuc_Hanh.Animal_Interface_Edible;

public class Chicken extends Animal implements Interface_Edible {

    @Override
    public String makeSound() {
        return "chippppp .....";
    }

    @Override
    public String howToEat() {
        return "KFC";
    }
}
