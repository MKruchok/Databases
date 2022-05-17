package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;

@SuppressFBWarnings
@Getter
@Setter
public final class Rex {
    private Integer id;
    private String name;
    private String range;
    private Integer hubId;

    public Rex(Integer id, String name, String range, Integer hubId) {
        this.id = id;
        this.name = name;
        this.range = range;
        this.hubId = hubId;
    }

    public Rex(String name, String range, Integer hubId) {
        this.name = name;
        this.range = range;
        this.hubId = hubId;
    }

    @Override
    public String toString() {
        return "\n\nRex: id: " + id + ", name: " + name + ", range: " + range + ", hub_id: " +
                hubId;
    }
}
