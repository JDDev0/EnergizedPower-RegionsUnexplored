package me.jddev0.epru.registry.tags;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class CompatibilityItemTags {
    private CompatibilityItemTags() {}

    public static final TagKey<Item> BRANCHES = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "branches"));

    public static final TagKey<Item> BAOBAB_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "baobab_logs"));
    public static final TagKey<Item> BLACKWOOD_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "blackwood_logs"));
    public static final TagKey<Item> CHERRY_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "cherry_logs"));
    public static final TagKey<Item> CYPRESS_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "cypress_logs"));
    public static final TagKey<Item> DEAD_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "dead_logs"));
    public static final TagKey<Item> EUCALYPTUS_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "eucalyptus_logs"));
    public static final TagKey<Item> JOSHUA_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "joshua_logs"));
    public static final TagKey<Item> LARCH_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "larch_logs"));
    public static final TagKey<Item> MAPLE_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "maple_logs"));
    public static final TagKey<Item> MAUVE_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "mauve_logs"));
    public static final TagKey<Item> PALM_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "palm_logs"));
    public static final TagKey<Item> PINE_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "pine_logs"));
    public static final TagKey<Item> REDWOOD_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "redwood_logs"));
    public static final TagKey<Item> WILLOW_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "willow_logs"));
    public static final TagKey<Item> SCULKWOOD_LOGS = TagKey.of(Registry.ITEM_KEY,
            new Identifier("regions_unexplored", "sculkwood_logs"));
}