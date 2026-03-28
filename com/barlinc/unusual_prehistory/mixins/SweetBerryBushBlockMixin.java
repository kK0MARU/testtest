/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.block.SweetBerryBushBlock
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package com.barlinc.unusual_prehistory.mixins;

import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={SweetBerryBushBlock.class})
public class SweetBerryBushBlockMixin {
    @Redirect(method={"entityInside"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getType()Lnet/minecraft/world/entity/EntityType;"))
    private EntityType<?> unusualPrehistory2$redirectBerryBushImmunityCheck(Entity entity) {
        if (entity.m_6095_().m_204039_(UP2EntityTags.SWEET_BERRY_BUSH_IMMUNE)) {
            return EntityType.f_20452_;
        }
        return entity.m_6095_();
    }
}

