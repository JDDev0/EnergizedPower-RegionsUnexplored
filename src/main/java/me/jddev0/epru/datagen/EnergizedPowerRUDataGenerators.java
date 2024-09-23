package me.jddev0.epru.datagen;

import me.jddev0.epru.EnergizedPowerRUMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnergizedPowerRUMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnergizedPowerRUDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));
    }
}
