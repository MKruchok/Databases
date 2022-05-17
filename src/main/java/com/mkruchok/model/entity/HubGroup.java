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
public final class HubGroup {
    private Integer id;
    private String groupName;
    private String groupDescription;
    private Integer hubId;

    public HubGroup(String groupName, String groupDescription, Integer hubId) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.hubId = hubId;
    }

    @Override
    public String toString() {
        return "\n\nGroup: id: " + id + ", name: " + groupName + ", description: " + groupDescription + ", hub_id: " +
                hubId;
    }
}
