package org.springlab.enemysystem;

import org.springlab.data.Entity;
import org.springlab.data.GameData;
import org.springlab.data.World;
import org.springlab.data.entityparts.LifePart;
import org.springlab.data.entityparts.MovingPart;
import org.springlab.data.entityparts.PositionPart;
import org.springlab.services.IGamePluginService;

import java.util.Random;

public class EnemyPlugin implements IGamePluginService
{
    private Entity enemy;
    
    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }
    
    private Entity createEnemyShip(GameData gameData) {
        
        float deacceleration = 10;
        float acceleration = 150;
        float maxSpeed = 200;
        float rotationSpeed = 5;
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();
        float radians = 3.1415f / 2;
        
        float[] colour = new float[4];
        colour[0] = 1.0f;
        colour[1] = 0.0f;
        colour[2] = 0.0f;
        colour[3] = 1.0f;
        
        Entity enemyShip = new Enemy();
        enemyShip.setRadius(8);
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(1));
        
        return enemyShip;
    }
    
    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }
}
