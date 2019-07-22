package com.machine.game.application.service;

import com.machine.game.common.util.Simulation;
import com.machine.game.web.service.GameApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.machine.game.common.util.Simulation.printEmptyBoard;
import static com.machine.game.common.util.Simulation.printGrid;

@Service
public class GameApplicationServiceImpl implements GameApplicationService {


    private final Simulation simulation;

    @Autowired
    public GameApplicationServiceImpl(Simulation simulation) {

        this.simulation = simulation;
    }


    @Override
    public void updateStepsValue(Integer steps) {

        printEmptyBoard();
        printGrid(steps);
    }
}
