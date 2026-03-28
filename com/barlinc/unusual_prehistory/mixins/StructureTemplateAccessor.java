/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$Palette
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureEntityInfo
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package com.barlinc.unusual_prehistory.mixins;

import java.util.List;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={StructureTemplate.class})
public interface StructureTemplateAccessor {
    @Accessor(value="palettes")
    public List<StructureTemplate.Palette> getBlocks();

    @Accessor(value="entityInfoList")
    public List<StructureTemplate.StructureEntityInfo> getEntityInfoList();
}

