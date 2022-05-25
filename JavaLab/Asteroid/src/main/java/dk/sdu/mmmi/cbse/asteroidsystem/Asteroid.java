package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author corfixen
 */
public class Asteroid extends Entity {
    private final AsteroidType type;
  
    public Asteroid(AsteroidType type)
    {
      this.type = type;
    }
    
    public String getSize() {
      return type.getSize();
    }
}
