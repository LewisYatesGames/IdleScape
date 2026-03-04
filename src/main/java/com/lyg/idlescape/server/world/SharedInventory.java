package com.lyg.idlescape.server.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Shared inventory mapping itemIds to quantities.
 * Invariants:
 *  Quantities are always positive
 *  Zero quantity items are removed
 *  Operations reject non positive quantities
 *
 * Concurrency should be handled outside of this class
 */

public class SharedInventory {
    private final Map<String, Integer> inventory = new HashMap<>();

    public boolean addItem(ItemEntry query) {
        if (query.quantity <= 0) {
            return false;
        }

        var newQuantity = query.quantity;

        if (inventory.containsKey(query.itemID)) {
            newQuantity += inventory.get(query.itemID);
        }

        inventory.put(query.itemID, newQuantity);
        return true;
    }

    public boolean addItems(ItemEntry[] queries) {
        for (var query : queries) {
            if (query.quantity <= 0) {
                return false;
            }
        }

        for (var query : queries){
            addItem(query);
        }

        return true;
    }

    public boolean removeItem(ItemEntry query) {
        if(query.quantity <= 0) {
            return false;
        }

        var newQuantity = 0;
        if (inventory.containsKey(query.itemID) && inventory.get(query.itemID) - query.quantity >= 0) {
            newQuantity = inventory.get(query.itemID) - query.quantity;
        } else {
            return false;
        }

        if(newQuantity <= 0){
            inventory.remove(query.itemID);
        } else {
            inventory.put(query.itemID, newQuantity);
        }

        return true;
    }

    public boolean removeItems(ItemEntry[] queries) {
        int[] updatedQuantities = new int[queries.length];
        for (var i = 0; i < queries.length; i++) {
            if(queries[i].quantity <= 0) {
                return false;
            }

            if (inventory.containsKey(queries[i].itemID) && inventory.get(queries[i].itemID) - queries[i].quantity >= 0) {
                updatedQuantities[i] = inventory.get(queries[i].itemID) - queries[i].quantity;
            } else {
                return false;
            }
        }

        for (var i = 0; i < queries.length; i++) {
            if(updatedQuantities[i] <= 0){
                inventory.remove(queries[i].itemID);
            } else {
                inventory.put(queries[i].itemID, updatedQuantities[i]);
            }
        }
        return true;
    }

    public int getItemQuantity(String itemID) {
        return inventory.getOrDefault(itemID, 0);
    }
    public int getItemQuantity(ItemEntry query) {
        return inventory.getOrDefault(query.itemID, 0);
    }

    public List<Integer> getItemQuantities(String[] itemIDs) {
        List<Integer> itemQuantities = new ArrayList<>();
        for (String id : itemIDs) {
            itemQuantities.add(getItemQuantity(id));
        }

        return itemQuantities;
    }
    public List<Integer> getItemQuantities(ItemEntry[] entries) {
        List<Integer> itemQuantities = new ArrayList<>();
        for (var query : entries) {
            itemQuantities.add(getItemQuantity(query.itemID));
        }

        return itemQuantities;
    }
}
