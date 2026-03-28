/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.block.Block
 */
package com.barlinc.unusual_prehistory.entity.utils;

import com.barlinc.unusual_prehistory.registry.UP2Blocks;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import java.util.function.Supplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface UP2BoatType {
    public Type getUP2BoatType();

    public static enum Type {
        DRYOPHYLLUM("dryophyllum", (Supplier<Block>)UP2Blocks.DRYOPHYLLUM_PLANKS, (Supplier<Item>)UP2Items.DRYOPHYLLUM_BOAT, (Supplier<Item>)UP2Items.DRYOPHYLLUM_CHEST_BOAT),
        GINKGO("ginkgo", (Supplier<Block>)UP2Blocks.GINKGO_PLANKS, (Supplier<Item>)UP2Items.GINKGO_BOAT, (Supplier<Item>)UP2Items.GINKGO_CHEST_BOAT),
        LEPIDODENDRON("lepidodendron", (Supplier<Block>)UP2Blocks.LEPIDODENDRON_PLANKS, (Supplier<Item>)UP2Items.LEPIDODENDRON_BOAT, (Supplier<Item>)UP2Items.LEPIDODENDRON_CHEST_BOAT),
        METASEQUOIA("metasequoia", (Supplier<Block>)UP2Blocks.METASEQUOIA_PLANKS, (Supplier<Item>)UP2Items.METASEQUOIA_BOAT, (Supplier<Item>)UP2Items.METASEQUOIA_CHEST_BOAT);

        private final String name;
        private final Supplier<Block> plankSupplier;
        private final Supplier<Item> dropSupplier;
        private final Supplier<Item> chestDropSupplier;

        private Type(String name, Supplier<Block> plankSupplier, Supplier<Item> dropSupplier, Supplier<Item> chestDropSupplier) {
            this.name = name;
            this.plankSupplier = plankSupplier;
            this.dropSupplier = dropSupplier;
            this.chestDropSupplier = chestDropSupplier;
        }

        public String getName() {
            return this.name;
        }

        public Supplier<Block> getPlankSupplier() {
            return this.plankSupplier;
        }

        public Supplier<Item> getDropSupplier() {
            return this.dropSupplier;
        }

        public Supplier<Item> getChestDropSupplier() {
            return this.chestDropSupplier;
        }

        public String toString() {
            return this.name;
        }

        public static Type byId(int id) {
            Type[] boatEntityType = Type.values();
            if (id < 0 || id >= boatEntityType.length) {
                id = 0;
            }
            return boatEntityType[id];
        }

        public static Type byName(String name) {
            Type[] boatEntityType;
            for (Type pfBoatTypes : boatEntityType = Type.values()) {
                if (!pfBoatTypes.getName().equals(name)) continue;
                return pfBoatTypes;
            }
            return boatEntityType[0];
        }
    }
}

