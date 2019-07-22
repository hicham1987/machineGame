package com.machine.game.web.controller;


import com.machine.game.common.Constant;
import com.machine.game.web.service.GameApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/" + GameController.URL)
public class GameController {

    public final static String URL = "machine";

    protected  final GameApplicationService gameApplicationService;

    @Autowired
    public GameController(GameApplicationService gameApplicationService) {
        this.gameApplicationService = gameApplicationService;
    }

    @PutMapping(value = Constant.PUT_STEPS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateSteps(@Valid @PathVariable("steps") Integer steps ) {

        gameApplicationService.updateStepsValue(steps);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
