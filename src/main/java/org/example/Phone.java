package org.example;

public interface Phone {

    void addContact(String contactNumber, String phoneNumber, String firstName, String lastName);

    void sendMessage(String phoneNumber, String messageContent);
    void getMessageListForContact(String phoneNumber);
    void getFirstMessage(String phoneNumber);
    void getSecondMessage(String phoneNumber);

    void call(String phoneNumber);
    void viewCallHistory();

    void getFirstContact();
    void getLastContact();
    void getContactList();

    int getBatteryLife();
}
