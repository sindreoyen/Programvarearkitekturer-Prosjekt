package com.rocketracer.game.ECS.Entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.rocketracer.game.ECS.Components.BoundsCircleComponent;
import com.rocketracer.game.ECS.Components.CleanupComponent;
import com.rocketracer.game.ECS.Components.CollisionComponent;
import com.rocketracer.game.ECS.Components.PositionComponent;
import com.rocketracer.game.ECS.Components.SpecificTypeComponent;
import com.rocketracer.game.ECS.Components.SpriteComponent;
import com.rocketracer.game.ECS.Components.TypeComponent;
import com.rocketracer.game.ECS.Components.VelocityComponent;


public class SatelliteEntity implements IGameObject {

    // Attributes
    private Entity entity;
    private SpriteComponent spriteComponent;
    private PositionComponent positionComponent;
    private VelocityComponent velocityComponent;
    private CleanupComponent cleanupComponent;
    private TypeComponent typeComponent;
    private SpecificTypeComponent obstacleTypeComponent;
    private CollisionComponent collisionComponent;
    private BoundsCircleComponent boundsCircleComponent;
    private Texture satellite = new Texture(Gdx.files.internal("satellite.png"));

    // Constructor
    public SatelliteEntity(float x, float y){

        //Initiate entity with components
        this.entity = new Entity();
        this.spriteComponent = new SpriteComponent(satellite);
        this.positionComponent = new PositionComponent(x,y);
        this.velocityComponent = new VelocityComponent();
        this.cleanupComponent = new CleanupComponent();
        this.collisionComponent = new CollisionComponent();
        this.boundsCircleComponent = new BoundsCircleComponent(Math.round(spriteComponent.sprite.getWidth()/5));

        //Define types
        this.typeComponent = TypeComponent.OBSTACLE;
        this.obstacleTypeComponent = SpecificTypeComponent.SATELLITE;

        //Add components to entity
        entity.add(spriteComponent);
        entity.add(positionComponent);
        entity.add(velocityComponent);
        entity.add(cleanupComponent);
        entity.add(typeComponent);
        entity.add(obstacleTypeComponent);
        entity.add(collisionComponent);
        entity.add(boundsCircleComponent);
    }

    //Methods
    public Entity getEntity(){ return entity;}
    @Override
    public void build() {
        System.out.println("Build Satellite");
    }
}
