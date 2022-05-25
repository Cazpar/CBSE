package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


public interface IPostEntityProcessingService  {
        /**
         * Pre-condition: Entities must exist in the game.
         * Post-condition: Entities in the game should already have processed their logic.
         * @param gameData Runs when game data related entities has been processed.
         * @param world Runs when world data related entities has been processed.
         *              
         * 
         *              Collision colliding should be implemented using this since
         *              the data relating to the entities has been processed.
         */
        void process(GameData gameData, World world);
}
