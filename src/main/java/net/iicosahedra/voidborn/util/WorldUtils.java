package net.iicosahedra.voidborn.util;
import net.iicosahedra.voidborn.Voidborn;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class WorldUtils {
    @Nullable
    public static Entity getLevelEntity(Entity entity){
        Level level;
        if((level = Voidborn.instance.proxy.getClientWorld()) != null){
            return level.getEntity(entity.getId());
        }
        return null;
    }
}
