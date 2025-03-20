package net.iicosahedra.voidborn.setup;

import net.iicosahedra.voidborn.Voidborn;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.iicosahedra.voidborn.item.*;


public class Registration {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Voidborn.MODID);

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    /*
    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(
            String name, UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator){
        return DATA_TYPES.register(name, ()-> builderUnaryOperator.apply(DataComponentType.builder()).build());
    }
    */

    public static final Holder<Item> VIAL = ITEMS.register("vial", VialItem::new);
    public static final Holder<Item> SHIMMER_VIAL = ITEMS.register("shimmer_vial", ShimmerVialItem::new);
    public static final Holder<Item> CRYSTALLINE_SHARD = ITEMS.register("crystalline_shard", CrystallineShardItem::new);
    public static final DeferredHolder<Item, ArmorItem> SHIMMER_INJECTOR = ITEMS.register("shimmer_injector", ShimmerInjectorItem::new);
}