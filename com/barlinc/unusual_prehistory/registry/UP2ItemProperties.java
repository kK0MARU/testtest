/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.item.ItemProperties
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  net.minecraftforge.registries.RegistryObject
 */
package com.barlinc.unusual_prehistory.registry;

import com.barlinc.unusual_prehistory.items.PterodactylusPotItem;
import com.barlinc.unusual_prehistory.items.UP2MobBucketItem;
import com.barlinc.unusual_prehistory.registry.UP2Items;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class UP2ItemProperties {
    public static void registerItemProperties() {
        for (RegistryObject item : UP2Items.ITEMS.getEntries()) {
            if (item.get() instanceof UP2MobBucketItem) {
                ItemProperties.register((Item)((Item)item.get()), (ResourceLocation)new ResourceLocation("variant"), (stack, level, living, i) -> stack.m_41782_() ? (float)stack.m_41783_().m_128451_("BucketVariantTag") : 0.0f);
            }
            if (item.get() instanceof PterodactylusPotItem) {
                ItemProperties.register((Item)((Item)item.get()), (ResourceLocation)new ResourceLocation("variant"), (stack, level, living, i) -> stack.m_41782_() ? (float)stack.m_41783_().m_128451_("BucketVariantTag") : 0.0f);
            }
            ItemProperties.register((Item)((Item)UP2Items.ORGANIC_OOZE.get()), (ResourceLocation)new ResourceLocation("ooze_shape"), (stack, level, living, j) -> (float)(stack.m_41613_() % 5) / 5.0f);
        }
    }
}

