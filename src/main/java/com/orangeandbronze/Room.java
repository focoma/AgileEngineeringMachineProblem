package com.orangeandbronze;

import com.orangeandbronze.utils.EnlistmentUtils;

import java.util.Collection;

/**
 * Created by training on 2/19/16.
 */
public class Room {
    private final String roomName;
    private final int maxCapacity;


    public Room(String roomName, int maxCapacity) {
        if(!roomName.matches(EnlistmentUtils.alphanumeric)) {
            throw new IllegalArgumentException("Room name is not acceptable, " + roomName);
        }
        this.roomName = roomName;
        this.maxCapacity = maxCapacity;

    }

    public String getRoomName() {
        return roomName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public String toString() {
        return "Room name " + roomName;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return roomName.equals(room.roomName);

    }

    @Override
    public int hashCode() {
        return roomName.hashCode();
    }
}
