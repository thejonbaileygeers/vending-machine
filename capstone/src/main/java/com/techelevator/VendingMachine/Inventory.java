package com.techelevator.VendingMachine;

import com.techelevator.VendingMachine.Purchasables;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

   private final File fileReader = new File("C:\\Users\\Student\\workspace\\capstone-1-team-0\\capstone\\vendingmachine.csv");

    public Map<String, Purchasables> getVendingItems() {
        return vendingItems;
    }

    public List<String> getVendingDisplay() {
        return vendingDisplay;
    }

    private Map<String, Purchasables> vendingItems = new HashMap<>();
    private List<String> vendingDisplay = new ArrayList<>();

    public void stockMachine() {
        try(Scanner pullManifest = new Scanner(fileReader)) {
            while (pullManifest.hasNextLine()) {
                String lineOfInput = pullManifest.nextLine();
                String[] value_split = lineOfInput.split("\\|");
                Purchasables vendingItem = new Purchasables(value_split[0], value_split[1], new BigDecimal(String.valueOf(value_split[2])), value_split[3]);
                vendingItems.put(value_split[0], vendingItem);
                vendingDisplay.add(lineOfInput);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
