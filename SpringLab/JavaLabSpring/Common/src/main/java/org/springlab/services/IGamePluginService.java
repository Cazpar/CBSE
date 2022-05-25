package org.springlab.services;

import org.springlab.data.GameData;
import org.springlab.data.World;

public interface IGamePluginService
{
    void start(GameData gameData, World world);
    
    void stop(GameData gameData, World world);
}
