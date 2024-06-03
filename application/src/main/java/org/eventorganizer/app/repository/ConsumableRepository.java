package org.eventorganizer.app.repository;

import org.eventorganizer.app.entity.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumableRepository extends JpaRepository<Consumable, Long> {

    List<Consumable> searchConsumablesByNameContains(String stringContainedInName);
}
