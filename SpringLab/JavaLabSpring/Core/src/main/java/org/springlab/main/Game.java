package org.springlab.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springlab.data.Entity;
import org.springlab.data.GameData;
import org.springlab.data.World;
import org.springlab.managers.GameInputProcessor;
import org.springlab.services.IEntityProcessingService;
import org.springlab.services.IGamePluginService;
import org.springlab.services.IPostEntityProcessingService;

import java.util.ArrayList;

public class Game implements ApplicationListener
{
    private static OrthographicCamera cam;
    private ShapeRenderer sr;
    private final GameData gameData = new GameData();
    private World world = new World();
    
    private ArrayList<IEntityProcessingService> entityProcessors;
    private ArrayList<IGamePluginService> gamePlugins;
    private ArrayList<IPostEntityProcessingService> postEntityProcessors;
    
    public Game() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
        entityProcessors = new ArrayList(context.getBeansOfType(IEntityProcessingService.class).values());
        gamePlugins = new ArrayList(context.getBeansOfType(IGamePluginService.class).values());
        postEntityProcessors = new ArrayList(context.getBeansOfType(IPostEntityProcessingService.class).values());
    }
    
    @Override
    public void create() {
        gameData.setDisplayWidth(Gdx.graphics.getWidth());
        gameData.setDisplayHeight(Gdx.graphics.getHeight());
        
        cam = new OrthographicCamera(gameData.getDisplayWidth(), gameData.getDisplayHeight());
        cam.translate(gameData.getDisplayWidth() / 2, gameData.getDisplayHeight() / 2);
        cam.update();
        
        sr = new ShapeRenderer();
        
        Gdx.input.setInputProcessor(new GameInputProcessor(gameData));
        
        for (IGamePluginService plugin : gamePlugins) {
            plugin.start(gameData, world);
            System.out.println("Found gameplugin: " + plugin.getClass().getName());
        }
    }
    
    @Override
    public void resize(int i, int i1) {
    
    }
    
    @Override
    public void render() {
        // clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        gameData.setDelta(Gdx.graphics.getDeltaTime());
        gameData.getKeys().update();
        
        update();
        draw();
    }
    
    private void update() {
        // Update
        for (IEntityProcessingService entityProcessorService : entityProcessors) {
            entityProcessorService.process(gameData, world);
        }
        
        // Post Update
        for (IPostEntityProcessingService postEntityProcessorService : postEntityProcessors) {
            postEntityProcessorService.process(gameData, world);
        }
    }
    
    private void draw() {
        for (Entity entity : world.getEntities()) {
            sr.setColor(1, 1, 1, 1);
            
            sr.begin(ShapeRenderer.ShapeType.Line);
            
            float[] shapex = entity.getShapeX();
            float[] shapey = entity.getShapeY();
            
            for (int i = 0, j = shapex.length - 1;
                 i < shapex.length;
                 j = i++) {
                
                sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
            }
            
            sr.end();
        }
    }
    
    @Override
    public void pause() {
    
    }
    
    @Override
    public void resume() {
    
    }
    
    @Override
    public void dispose() {
    
    }
}
