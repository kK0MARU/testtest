/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Pose
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.gen.Invoker
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.barlinc.unusual_prehistory.mixins;

import com.barlinc.unusual_prehistory.entity.utils.UP2Poses;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Pose.class})
public class PoseMixin {
    @Shadow
    @Mutable
    @Final
    private static Pose[] $VALUES;

    @Invoker(value="<init>")
    public static Pose unusualPrehistory2$newPose(String name, int id) {
        throw new AssertionError();
    }

    @Inject(method={"<clinit>"}, at={@At(value="FIELD", target="Lnet/minecraft/world/entity/Pose;$VALUES:[Lnet/minecraft/world/entity/Pose;", shift=At.Shift.AFTER)})
    private static void unusualPrehistory2$addCustomPose(CallbackInfo ci) {
        ArrayList<Pose> poses = new ArrayList<Pose>(Arrays.asList($VALUES));
        Pose last = (Pose)poses.get(poses.size() - 1);
        int i = 1;
        for (UP2Poses pose : UP2Poses.values()) {
            poses.add(PoseMixin.unusualPrehistory2$newPose(pose.name(), last.ordinal() + i));
            ++i;
        }
        $VALUES = poses.toArray(new Pose[0]);
    }
}

