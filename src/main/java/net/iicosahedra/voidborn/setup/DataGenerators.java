package net.iicosahedra.voidborn.setup;

import net.iicosahedra.voidborn.Voidborn;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Voidborn.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeClient(), new ModLanguageProvider(packOutput, "en_us"));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, helper));
        gen.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput, event.getLookupProvider()));

    }

}

class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Voidborn.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(Registration.VIAL.value());
        handheldItem(Registration.SHIMMER_VIAL.value());
        handheldItem(Registration.CRYSTALLINE_SHARD.value());
        handheldItem(Registration.SHIMMER_INJECTOR.value());
    }
}

class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Voidborn.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    }
}

class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, Voidborn.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Registration.VIAL.value(), "Vial");
        add(Registration.SHIMMER_VIAL.value(), "Vial of Shimmer");
        add(Registration.CRYSTALLINE_SHARD.value(), "Crystalline Shard");
        add(Registration.SHIMMER_INJECTOR.value(), "Shimmer Injector");
    }
}

class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Voidborn.MODID);
    }

    @Override
    protected void start() {
    }
}