package com.vml.usmc.events.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vml.usmc.events.entity.EventEntity;

@Repository
public interface IEventRepository extends JpaRepository<EventEntity, UUID> {
    //custom queries can go here
    //crud supported by id inherited

    List<EventEntity> findByfkPromotionId(UUID fkPromotionId);
}
