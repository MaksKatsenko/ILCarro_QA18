package models;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setName("John");
        user.setLastName("Silver");

        User user1 = new User().withName("Jack").withLastName("Sparrow");

    }


}
