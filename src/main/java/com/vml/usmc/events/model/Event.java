package com.vml.usmc.events.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Event {
    private UUID id;
    @NotBlank(message = "Name is not allowed to be blank!")
    @NotNull(message = "Name is not allowed to be missing!")
    private String name;
    private boolean includesBattlePositions;
    private Type type;
    private UUID promotionId;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event myObject = (Event) obj;
        return id.equals(myObject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
