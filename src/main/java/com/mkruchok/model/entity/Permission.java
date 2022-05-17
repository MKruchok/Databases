package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressFBWarnings
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Permission {
    private Integer id;
    private String permissionName;
    private String description;

    public Permission(String permissionName, String description) {
        this.permissionName = permissionName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n\nPermission: id: " + id + ", name: " + permissionName + ", description: " + description;
    }
}
