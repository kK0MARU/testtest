/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.tags.EntityTypeTagsProvider
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.EntityTypeTags
 *  net.minecraft.world.entity.EntityType
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.datagen;

import com.barlinc.unusual_prehistory.registry.UP2Entities;
import com.barlinc.unusual_prehistory.registry.tags.UP2EntityTags;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UP2EntityTagProvider
extends EntityTypeTagsProvider {
    public UP2EntityTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, "unusual_prehistory", existingFileHelper);
    }

    protected void m_6577_(@NotNull HolderLookup.Provider provider) {
        this.m_206424_(UP2EntityTags.CARNOTAURUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20557_, EntityType.f_147035_, EntityType.f_20457_, EntityType.f_20510_, EntityType.f_20520_, EntityType.f_243976_, EntityType.f_20492_, (EntityType)UP2Entities.PACHYCEPHALOSAURUS.get(), (EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.KENTROSAURUS.get()});
        this.m_206424_(UP2EntityTags.DROMAEOSAURUS_TARGETS).m_255245_((Object)EntityType.f_20555_);
        this.m_206424_(UP2EntityTags.SMALL_DUNKLEOSTEUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20489_, EntityType.f_217013_, (EntityType)UP2Entities.JAWLESS_FISH.get(), EntityType.f_20501_, EntityType.f_20511_, EntityType.f_20524_, EntityType.f_20497_});
        this.m_206424_(UP2EntityTags.MEDIUM_DUNKLEOSTEUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20556_, EntityType.f_20519_, (EntityType)UP2Entities.JAWLESS_FISH.get(), (EntityType)UP2Entities.LOBE_FINNED_FISH.get(), EntityType.f_20501_, EntityType.f_20511_, EntityType.f_20524_, EntityType.f_20497_});
        this.m_206424_(UP2EntityTags.BIG_DUNKLEOSTEUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20490_, EntityType.f_20562_, EntityType.f_20455_, EntityType.f_20501_, EntityType.f_20511_, EntityType.f_20524_, EntityType.f_20497_});
        this.m_206424_(UP2EntityTags.KAPROSUCHUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20510_, EntityType.f_20511_});
        this.m_206424_(UP2EntityTags.MAJUNGASAURUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20557_, EntityType.f_147035_, EntityType.f_20510_, EntityType.f_20520_});
        this.m_206424_(UP2EntityTags.MEGALANIA_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20557_, EntityType.f_147035_, EntityType.f_20457_, EntityType.f_20510_, EntityType.f_20520_, EntityType.f_243976_, EntityType.f_20492_});
        this.m_206424_(UP2EntityTags.METRIORHYNCHUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20489_, EntityType.f_20556_, EntityType.f_20519_, (EntityType)UP2Entities.JAWLESS_FISH.get(), (EntityType)UP2Entities.LOBE_FINNED_FISH.get()});
        this.m_206424_(UP2EntityTags.PACHYCEPHALOSAURUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20557_, EntityType.f_20520_, EntityType.f_20555_, EntityType.f_20510_, EntityType.f_20492_, EntityType.f_20504_});
        this.m_206424_(UP2EntityTags.PACHYCEPHALOSAURUS_TARGETS_TO_KILL).m_255245_((Object)EntityType.f_147035_);
        this.m_206424_(UP2EntityTags.PRAEPUSA_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20556_, EntityType.f_20519_});
        this.m_206424_(UP2EntityTags.STETHACANTHUS_TARGETS).m_255245_((Object)((EntityType)UP2Entities.JAWLESS_FISH.get()));
        this.m_206424_(UP2EntityTags.ULUGHBEGSAURUS_TARGETS).m_255179_((Object[])new EntityType[]{EntityType.f_20557_, EntityType.f_147035_, EntityType.f_20457_, EntityType.f_20510_, EntityType.f_20520_, EntityType.f_243976_});
        this.m_206424_(UP2EntityTags.COELACANTHUS_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DUNKLEOSTEUS.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get(), (EntityType)UP2Entities.MEGALANIA.get(), EntityType.f_20455_, EntityType.f_20562_});
        this.m_206424_(UP2EntityTags.DROMAEOSAURUS_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.CARNOTAURUS.get(), (EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.MEGALANIA.get()});
        this.m_206424_(UP2EntityTags.DIPLOCAULUS_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DUNKLEOSTEUS.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get(), (EntityType)UP2Entities.MEGALANIA.get(), (EntityType)UP2Entities.CARNOTAURUS.get(), (EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.DROMAEOSAURUS.get(), EntityType.f_20455_, EntityType.f_20562_});
        this.m_206424_(UP2EntityTags.JAWLESS_FISH_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DUNKLEOSTEUS.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get(), (EntityType)UP2Entities.STETHACANTHUS.get(), EntityType.f_20455_, EntityType.f_20562_});
        this.m_206424_(UP2EntityTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.KENTROSAURUS.get(), (EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.MEGALANIA.get(), (EntityType)UP2Entities.DROMAEOSAURUS.get(), EntityType.f_20505_, EntityType.f_20514_, EntityType.f_20499_, EntityType.f_20479_, EntityType.f_20501_, EntityType.f_20524_, EntityType.f_20558_, EntityType.f_20509_, EntityType.f_20481_, EntityType.f_20456_, EntityType.f_20500_, EntityType.f_20518_, EntityType.f_20457_, EntityType.f_20525_, EntityType.f_20502_, EntityType.f_20503_, EntityType.f_20560_, EntityType.f_20562_, EntityType.f_20458_, EntityType.f_147035_, EntityType.f_217015_, EntityType.f_20495_, EntityType.f_20492_, EntityType.f_20491_, EntityType.f_20493_, EntityType.f_20568_, EntityType.f_20569_, EntityType.f_243976_, EntityType.f_20553_, EntityType.f_20497_, EntityType.f_20496_, EntityType.f_20565_, EntityType.f_20566_, EntityType.f_20554_, EntityType.f_20452_, EntityType.f_20460_, EntityType.f_20515_, EntityType.f_20526_, EntityType.f_20468_, EntityType.f_20551_, EntityType.f_20494_, EntityType.f_20531_, EntityType.f_20511_, EntityType.f_20513_, EntityType.f_20512_, EntityType.f_20530_, EntityType.f_20521_, EntityType.f_20453_, EntityType.f_20459_, EntityType.f_20466_});
        this.m_206424_(UP2EntityTags.KIMMERIDGEBRACHYPTERAESCHNIDIUM_NYMPH_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DUNKLEOSTEUS.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get(), (EntityType)UP2Entities.STETHACANTHUS.get(), EntityType.f_147039_, EntityType.f_20562_, EntityType.f_20455_});
        this.m_206424_(UP2EntityTags.LEPTICTIDIUM_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DROMAEOSAURUS.get(), (EntityType)UP2Entities.PSILOPTERUS.get(), EntityType.f_20505_, EntityType.f_20510_, EntityType.f_20553_, EntityType.f_20452_, EntityType.f_20499_});
        this.m_206424_(UP2EntityTags.MAJUNGASAURUS_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.CARNOTAURUS.get(), (EntityType)UP2Entities.ULUGHBEGSAURUS.get(), EntityType.f_20518_, EntityType.f_20460_, EntityType.f_20496_, EntityType.f_217015_});
        this.m_206424_(UP2EntityTags.PRAEPUSA_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DUNKLEOSTEUS.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get(), (EntityType)UP2Entities.MEGALANIA.get(), (EntityType)UP2Entities.CARNOTAURUS.get(), (EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.DROMAEOSAURUS.get(), EntityType.f_20455_, EntityType.f_20562_});
        this.m_206424_(UP2EntityTags.STETHACANTHUS_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DUNKLEOSTEUS.get(), EntityType.f_20562_, EntityType.f_20455_});
        this.m_206424_(UP2EntityTags.TALPANAS_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.MEGALANIA.get(), (EntityType)UP2Entities.DROMAEOSAURUS.get(), EntityType.f_20505_, EntityType.f_20514_, EntityType.f_20499_, EntityType.f_20479_, EntityType.f_20501_, EntityType.f_20524_, EntityType.f_20558_, EntityType.f_20509_, EntityType.f_20481_, EntityType.f_20456_, EntityType.f_20500_, EntityType.f_20518_, EntityType.f_20457_, EntityType.f_20525_, EntityType.f_20502_, EntityType.f_20560_, EntityType.f_20562_, EntityType.f_20458_, EntityType.f_147035_, EntityType.f_217015_, EntityType.f_20495_, EntityType.f_20492_, EntityType.f_20491_, EntityType.f_20493_, EntityType.f_20568_, EntityType.f_20569_, EntityType.f_243976_, EntityType.f_20553_, EntityType.f_20497_, EntityType.f_20496_, EntityType.f_20565_, EntityType.f_20566_, EntityType.f_20554_, EntityType.f_20452_, EntityType.f_20460_, EntityType.f_20515_, EntityType.f_20526_, EntityType.f_20468_, EntityType.f_20551_, EntityType.f_20494_, EntityType.f_20531_, EntityType.f_20511_, EntityType.f_20513_, EntityType.f_20512_, EntityType.f_20530_, EntityType.f_20521_, EntityType.f_20453_, EntityType.f_20459_});
        this.m_206424_(UP2EntityTags.TARTUOSTEUS_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DUNKLEOSTEUS.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), (EntityType)UP2Entities.ONCHOPRISTIS.get(), (EntityType)UP2Entities.STETHACANTHUS.get(), EntityType.f_20455_, EntityType.f_20562_});
        this.m_206424_(UP2EntityTags.TELECREX_AVOIDS).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.MAJUNGASAURUS.get(), (EntityType)UP2Entities.MEGALANIA.get(), (EntityType)UP2Entities.DROMAEOSAURUS.get(), (EntityType)UP2Entities.CARNOTAURUS.get(), (EntityType)UP2Entities.METRIORHYNCHUS.get(), EntityType.f_20505_, EntityType.f_20514_, EntityType.f_20499_, EntityType.f_20479_, EntityType.f_20501_, EntityType.f_20524_, EntityType.f_20558_, EntityType.f_20509_, EntityType.f_20481_, EntityType.f_20456_, EntityType.f_20500_, EntityType.f_20518_, EntityType.f_20525_, EntityType.f_20502_, EntityType.f_20562_, EntityType.f_20458_, EntityType.f_147035_, EntityType.f_217015_, EntityType.f_20495_, EntityType.f_20492_, EntityType.f_20491_, EntityType.f_20493_, EntityType.f_20568_, EntityType.f_20569_, EntityType.f_20553_, EntityType.f_20497_, EntityType.f_20496_, EntityType.f_20565_, EntityType.f_20566_, EntityType.f_20554_, EntityType.f_20452_, EntityType.f_20460_, EntityType.f_20515_, EntityType.f_20526_, EntityType.f_20468_, EntityType.f_20551_, EntityType.f_20494_, EntityType.f_20531_, EntityType.f_20511_, EntityType.f_20513_, EntityType.f_20512_, EntityType.f_20530_, EntityType.f_20521_, EntityType.f_20453_, EntityType.f_20459_});
        this.m_206424_(UP2EntityTags.SWEET_BERRY_BUSH_IMMUNE).m_255245_((Object)((EntityType)UP2Entities.KENTROSAURUS.get()));
        this.m_206424_(UP2EntityTags.CARNOTAURUS_IGNORES).m_255245_((Object)EntityType.f_20558_).m_176839_(new ResourceLocation("species", "quake"));
        this.m_206424_(UP2EntityTags.COELACANTHUS_NEVER_EATS).m_255245_((Object)EntityType.f_20565_);
        this.m_206424_(UP2EntityTags.METRIORHYNCHUS_CANT_GRAB).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.METRIORHYNCHUS.get(), EntityType.f_20565_, EntityType.f_20496_});
        this.m_206424_(UP2EntityTags.METRIORHYNCHUS_CAN_GRAB).m_255245_((Object)((EntityType)UP2Entities.TARTUOSTEUS.get()));
        this.m_206424_(EntityTypeTags.f_215847_).m_255179_((Object[])new EntityType[]{(EntityType)UP2Entities.DELITZSCHALA.get(), (EntityType)UP2Entities.ZHANGSOLVA.get()});
    }
}

