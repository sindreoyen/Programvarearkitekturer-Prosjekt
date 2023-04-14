package com.rocketracer.game.ECS.Entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.rocketracer.game.ECS.Components.CleanupComponent;
import com.rocketracer.game.ECS.Components.PositionComponent;
import com.rocketracer.game.ECS.Components.SpriteComponent;
import com.rocketracer.game.ECS.Components.VelocityComponent;

public class PlaneEntity implements IGameObject {
    private Entity entity;
    private SpriteComponent spriteComponent;
    private PositionComponent positionComponent;
    private VelocityComponent velocityComponent;
    private CleanupComponent cleanupComponent;
    private Texture plane = new Texture(Gdx.files.internal("plane.png"));

    public PlaneEntity(float x, float y){
        this.entity = new Entity();
        this.spriteComponent = new SpriteComponent(plane);
        this.positionComponent = new PositionComponent(x,y);
        this.velocityComponent = new VelocityComponent();
        this.cleanupComponent = new CleanupComponent();

        entity.add(spriteComponent);
        entity.add(positionComponent);
        entity.add(velocityComponent);
        entity.add(cleanupComponent);
    }

    public Entity getEntity(){ return entity;}

    @Override
    public void build() {
        System.out.println("Build Plane");
    }
}
