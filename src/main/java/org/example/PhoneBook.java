package org.example;

public class PhoneBook {

    public static void main(String[] args) {

        Phone phone = new SamsungGalaxy6(60, 40, "Red", "Aluminium", "9938X982133");

        phone.addContact("1", "0774433222", "Vlad", "Iulian");
        phone.addContact("2", "0778837032", "Mihai", "Adrian");
        phone.addContact("3", "0742200988", "Bill", "Gates");

        phone.getFirstContact();
        phone.getLastContact();

        System.out.println("Current battery life:" + phone.getBatteryLife());
        phone.sendMessage("0742200988", "Hi!");
        phone.getFirstMessage("0742200988");
        phone.sendMessage("0742200988", "Hi!");
        phone.getSecondMessage("0742200988");

        phone.call("0742200988");
        System.out.println("Current battery life:" + phone.getBatteryLife());

        phone.viewCallHistory();
    }

}
