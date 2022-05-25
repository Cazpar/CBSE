package org.springlab.services;

import org.springlab.data.GameData;
import org.springlab.data.World;

public interface IEntityProcessingService
{
    void process(GameData gameData, World world);
}
