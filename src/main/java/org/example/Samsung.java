package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Samsung implements Phone {

    List<Contact> contactList = new ArrayList<>();
    List<String> callHistoryList = new ArrayList<>();
    Map<String, ArrayList<String>> messageHistoryMap = new HashMap<>();
    Map<String, ArrayList<String>> callHistoryMap = new HashMap<>();
    final int batteryLife;
    int currentBatteryLife;
    String color;
    String material;
    final String IMEI;

    Samsung(int batteryLife, int currentBatteryLife, String color, String material, String IMEI) {
        this.batteryLife = batteryLife;
        this.currentBatteryLife = currentBatteryLife;
        this.color = color;
        this.material = material;
        this.IMEI = IMEI;
    }

    public void addContact(String contactNumber, String phoneNumber, String firstName, String lastName) {
        this.contactList.add(new Contact(contactNumber, phoneNumber, firstName, lastName));
        this.messageHistoryMap.put(phoneNumber, new ArrayList<String>());
        this.callHistoryMap.put(phoneNumber, new ArrayList<String>());
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        if (messageContent.toCharArray().length >= 500) {
            System.out.println("Message is too long");
            return;
        }
        System.out.println("Sent message to:" + phoneNumber + ":" + messageContent);
        messageHistoryMap.get(phoneNumber).add(messageContent);
        currentBatteryLife -= 1;
    }

    public void getMessageListForContact(String phoneNumber) {
        if (!messageHistoryMap.containsKey(phoneNumber)) {
            System.out.println("Contact not found");
            return;
        }
        for (int i = 0; i < messageHistoryMap.get(phoneNumber).size(); ++i) {
            System.out.println(messageHistoryMap.get(phoneNumber).get(i));
        }
    }

    public void call(String phoneNumber) {
        if (!callHistoryMap.containsKey(phoneNumber)) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Calling:" + phoneNumber);
        callHistoryMap.get(phoneNumber).add(phoneNumber);
        callHistoryList.add(phoneNumber);
        currentBatteryLife -= 2;
    }

    public void viewCallHistory() {
        if (callHistoryMap.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for(String s : callHistoryList) {
            System.out.println(s);
        }
    }

    public void getFirstMessage(String phoneNumber) {
        if (!messageHistoryMap.containsKey(phoneNumber)) {
            System.out.println("Contact not found");
            return;
        }
        if (messageHistoryMap.get(phoneNumber).isEmpty()) {
            System.out.println("No messages found");
            return;
        }
        System.out.println("First message:" + messageHistoryMap.get(phoneNumber).get(0));
    }

    public void getSecondMessage(String phoneNumber) {
        if (!messageHistoryMap.containsKey(phoneNumber)) {
            System.out.println("Contact not found");
            return;
        }
        if (messageHistoryMap.get(phoneNumber).isEmpty()) {
            System.out.println("No message found");
            return;
        }
        if (messageHistoryMap.get(phoneNumber).size() <= 1) {
            System.out.println("No second message found");
            return;
        }
        System.out.println("Second message:" + messageHistoryMap.get(phoneNumber).get(1));
    }

    public void getFirstContact() {
        if (contactList.isEmpty()) {
            System.out.println("You have no contacts!");
            return;
        }
        System.out.println("First contact:" + contactList.get(0).firstName + " " + contactList.get(0).lastName + " " + contactList.get(0).phoneNumber);
    }

    public void getLastContact() {
        if (contactList.isEmpty()) {
            System.out.println("You have no contacts!");
            return;
        }
        System.out.println("Last contact:" +
                contactList.get(contactList.size() - 1).firstName + " " +
                contactList.get(contactList.size() - 1).lastName + " " +
                contactList.get(contactList.size() - 1).phoneNumber);
    }

    public void getContactList() {
        if (contactList.isEmpty()) {
            System.out.println("You have no contacts!");
            return;
        }

        for(Contact contact : contactList) {
            System.out.println(contact.firstName + " " + contact.lastName + " " + contact.phoneNumber);
        }
    }

    public int getBatteryLife() {
        return this.currentBatteryLife;
    }

}
