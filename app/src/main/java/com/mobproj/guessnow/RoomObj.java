package com.mobproj.guessnow;

import java.util.HashMap;
import java.util.Map;

public class RoomObj {
    private String room;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getRoom() { return room; }

    public void setRoom(String room) { this.room = room; }

    public Map<String, Object> getAdditionalProperties() { return this.additionalProperties; }

    public void setAdditionalProperty(String name, Object value) { this.additionalProperties.put(name, value); }
}
