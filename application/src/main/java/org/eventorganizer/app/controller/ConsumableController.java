package org.eventorganizer.app.controller;


import org.eventorganizer.app.entity.Consumable;
import org.eventorganizer.app.service.ConsumableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/consumables")
public class ConsumableController {

    private final ConsumableService consumableService;

    public ConsumableController(ConsumableService consumableService){
        this.consumableService = consumableService;
    }

    @GetMapping
    List<Consumable> getAllConsumables(){return consumableService.getConsumables();}
}
