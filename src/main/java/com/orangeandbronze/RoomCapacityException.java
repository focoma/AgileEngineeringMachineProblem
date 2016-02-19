package com.orangeandbronze;

/**
 * Created by training on 2/19/16.
 */
public class RoomCapacityException extends RuntimeException {

    public RoomCapacityException(Room thisRoom) {
        super("This room " + thisRoom + "  had reached it's max capacity");
    }

    public RoomCapacityException(String message) {
        super(message);
    }
}
