package com.lyg.idlescape.server.world;

public record ItemEntry(String itemID, int quantity) {

    public ItemEntry {
        if (itemID == null || itemID.isBlank()) {
            throw new IllegalArgumentException("itemID cannot be empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Item quantity cannot be less than 1: " + itemID);
        }
    }
}
