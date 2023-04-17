package com.rocketracer.game.ECS.Entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.rocketracer.game.ECS.Components.CleanupComponent;
import com.rocketracer.game.ECS.Components.PositionComponent;
import com.rocketracer.game.ECS.Components.SpecificTypeComponent;
import com.rocketracer.game.ECS.Components.SpriteComponent;
import com.rocketracer.game.ECS.Components.TypeComponent;
import com.rocketracer.game.ECS.Components.VelocityComponent;



public class AsteroidEntity implements IGameObject {

    private Entity entity;
    private SpriteComponent spriteComponent;
    private PositionComponent positionComponent;
    private VelocityComponent velocityComponent;
    private CleanupComponent cleanupComponent;
    private TypeComponent typeComponent;
    private SpecificTypeComponent obstacleTypeComponent;
    private Texture asteroid = new Texture(Gdx.files.internal("asteroid.png"));

    public AsteroidEntity(float x, float y){
        this.entity = new Entity();
        this.spriteComponent = new SpriteComponent(asteroid);
        this.positionComponent = new PositionComponent(x,y);
        this.velocityComponent = new VelocityComponent();
        this.cleanupComponent = new CleanupComponent();
        this.typeComponent = TypeComponent.OBSTACLE;
        this.obstacleTypeComponent = SpecificTypeComponent.ASTEROID;


        entity.add(spriteComponent);
        entity.add(positionComponent);
        entity.add(velocityComponent);
        entity.add(cleanupComponent);
        entity.add(typeComponent);
        entity.add(obstacleTypeComponent);

    }

    public Entity getEntity(){ return entity;}

    @Override
    public void build() {

    }
}
