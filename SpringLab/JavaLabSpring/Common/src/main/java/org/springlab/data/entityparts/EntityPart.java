package org.springlab.data.entityparts;

import org.springlab.data.Entity;
import org.springlab.data.GameData;

public interface EntityPart {
    void process(GameData gameData, Entity entity);
}
