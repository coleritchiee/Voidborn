package net.iicosahedra.voidborn.util;

import net.iicosahedra.voidborn.Voidborn;
import net.minecraft.resources.ResourceLocation;

public class ResourceLoc {
    public static ResourceLocation create(String path){
        return ResourceLocation.fromNamespaceAndPath(Voidborn.MODID, path);
    }
}
