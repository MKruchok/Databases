package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;

@SuppressFBWarnings
@Getter
@Setter
public final class Group {
    private Integer id;
    private String name;
    private String description;
    private Integer hubId;

    public Group(Integer id, String name, String description, Integer hubId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hubId = hubId;
    }

    public Group(String name, String description, Integer hubId) {
        this.name = name;
        this.description = description;
        this.hubId = hubId;
    }

    @Override
    public String toString() {
        return "\n\nGroup: id: " + id + ", name: " + name + ", description: " + description + ", hub_id: " +
                hubId;
    }
}
