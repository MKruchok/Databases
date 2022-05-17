package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;

@SuppressFBWarnings
@Getter
@Setter
public final class Permission {
    private Integer id;
    private String name;
    private String description;

    public Permission(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n\nPermission: id: " + id + ", name: " + name + ", description: " + description;
    }
}
