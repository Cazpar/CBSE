package dk.sdu.mmmi.osgiplayer;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.player.Player;
import dk.sdu.mmmi.cbse.osgiplayer.PlayerPlugin;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerProcessorTest {
    public PlayerProcessorTest() {
    
    }
    
    @BeforeAll
    public static void setUpClass() throws Exception {}
    
    @AfterAll
    public static void tearDownClass() throws Exception {}
    
    @BeforeEach
    public void setUp() throws Exception {}
    
    @AfterEach
    public void tearDown() throws Exception {}
    
    @Test
    public void testSpawnPosition() {
        System.out.println("Movement test start");
    
        World world = new World();
        GameData data = new GameData();
        data.setDisplayWidth(100);
        data.setDisplayHeight(100);
    
        PlayerPlugin player = new PlayerPlugin();
        player.start(data, world);
        
        float startX = 0.f;
        float startY = 0.f;
        
        for (Entity entity : world.getEntities(Player.class)) {
            PositionPart positionPart = entity.getPart(PositionPart.class);
            startX = positionPart.getX();
            startY = positionPart.getY();
        }
    
        assertEquals(startX, data.getDisplayWidth() / 2.f);
        assertEquals(startY, data.getDisplayHeight() / 2.f);
    
        System.out.println("Movement test done");
    }
}