package net.iicosahedra.voidborn.setup;

import net.iicosahedra.voidborn.Voidborn;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber(modid = Voidborn.MODID, bus = EventBusSubscriber.Bus.MOD)
public class SetupEvents {
    @SubscribeEvent
    static void registerAttributes(EntityAttributeModificationEvent event) {

    }

    @SubscribeEvent
    static void registerRegistries(NewRegistryEvent event){

    }
}
