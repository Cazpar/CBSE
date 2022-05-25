package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;
//use this later
// import com.badlogic.gdx.math.MathUtils;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;
    private final Random random = new Random();

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        enemy = createenemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createenemyShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        // update to do this in javalab
        // float x = MathUtils.random(50, 450);
        // float y = MathUtils.random(50, 350);
        float x = random.nextInt(gameData.getDisplayWidth());
        float y = random.nextInt(gameData.getDisplayWidth());
        float radians = 3.1415f / random.nextFloat();
        
        Entity enemyShip = new Enemy();
        enemyShip.add(new LifePart(1,200000));
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }

}
