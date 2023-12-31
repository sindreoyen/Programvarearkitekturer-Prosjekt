package com.rocketracer.game.ECS.Systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.systems.IntervalSystem;
import com.badlogic.gdx.math.MathUtils;
import com.rocketracer.game.SharedData.GameConfig;
import com.rocketracer.game.factory.AsteroidFactory;
import com.rocketracer.game.factory.BirdFactory;
import com.rocketracer.game.factory.FuelcanFactory;
import com.rocketracer.game.factory.GameObjectFactory;
import com.rocketracer.game.factory.PlaneFactory;
import com.rocketracer.game.factory.SatelliteFactory;

/**
 * Deals with how often the obstacles and power up appears
 */
public class ObstacleSpawnSystem extends IntervalSystem {

    //Attributes
    private GameObjectFactory objectFactory;
    private Engine engine;
    private int counter = 0;
    private int fuelSpawnRate = 23;
    private int obstacleSpawnRate = 1;

    //Constructor
    public ObstacleSpawnSystem(Engine engine) {
        super(GameConfig.OBSTACLE_SPAWN_TIME);
        this.engine = engine;
    }

    //Method
    @Override
    protected void updateInterval() {

        float min = 0;
        float max = GameConfig.FRUSTUM_WIDTH ;

        //Sets x-coordinate
        float obstacleX = MathUtils.random(min,max);

        //Sets y-coordinate to screen-width
        float obstacleY = GameConfig.FRUSTUM_HEIGHT;

        //Creates entities and speeds based on the set difficulty
        switch (GameConfig.DIFFICULTY) {

            case 1:
                objectFactory = new BirdFactory(obstacleX, obstacleY);
                Entity bird = objectFactory.create().getEntity();
                engine.addEntity(bird);
                break;

            case 2:
                obstacleSpawnRate = 2;
                if (counter % 2 == 0) {
                    objectFactory = new PlaneFactory(obstacleX, obstacleY);
                    Entity plane = objectFactory.create().getEntity();
                    engine.addEntity(plane);
                }
                break;

            case 3:
                obstacleSpawnRate = 2;
                if (counter % 2 == 0) {
                    objectFactory = new SatelliteFactory(obstacleX, obstacleY);
                    Entity satellite = objectFactory.create().getEntity();
                    engine.addEntity(satellite);
                }
                break;

            case 4:
                obstacleSpawnRate = 1;
                objectFactory = new AsteroidFactory(obstacleX, obstacleY);
                Entity asteroid = objectFactory.create().getEntity();
                engine.addEntity(asteroid);
                break;
        }

        //Spawn fuel can
        if (counter % fuelSpawnRate == 0) {
            objectFactory = new FuelcanFactory(obstacleX, obstacleY);
            Entity fuelcan = objectFactory.create().getEntity();
            engine.addEntity(fuelcan);
        }
        counter ++;
    }
}
