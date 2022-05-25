package org.springlab.playersystem;

import org.springlab.data.Entity;
import org.springlab.data.GameData;
import org.springlab.data.World;
import org.springlab.data.entityparts.LifePart;
import org.springlab.data.entityparts.MovingPart;
import org.springlab.data.entityparts.PositionPart;
import org.springlab.services.IGamePluginService;

public class PlayerPlugin implements IGamePluginService
{
    private Entity player;
    
    public PlayerPlugin() {
    }
    
    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        player = createPlayerShip(gameData);
        world.addEntity(player);
    }
    
    private Entity createPlayerShip(GameData gameData) {
        
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2;
        float y = gameData.getDisplayHeight() / 2;
        float radians = 3.1415f / 2;
        
        Entity playerShip = new Player();
        playerShip.setRadius(8);
        playerShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        playerShip.add(new PositionPart(x, y, radians));
        playerShip.add(new LifePart(1));
        
        return playerShip;
    }
    
    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }
}
