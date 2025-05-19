package com.vml.usmc.events.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "event-contract")
@Data
public class EventEntity {
    @Id
    private UUID id;
    private String name;
    private String city;
    private Date estimatedEndTime;
    private Date estimatedStartTime;
    private boolean personalInNatureDeliverables;
    private String hheacCode;
    private boolean includesBattlePosition;
    private boolean isForInfluencers;
    @Column(name = "fk_promotionId")
    private UUID fkPromotionId;

}
