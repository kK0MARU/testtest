/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.PathNavigationRegion
 *  net.minecraft.world.level.pathfinder.BlockPathTypes
 *  net.minecraft.world.level.pathfinder.Node
 *  net.minecraft.world.level.pathfinder.NodeEvaluator
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.level.pathfinder.PathFinder
 *  net.minecraft.world.level.pathfinder.WalkNodeEvaluator
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package com.barlinc.unusual_prehistory.entity.ai.navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class NoSpinGroundPathNavigation
extends GroundPathNavigation {
    public static final float EPSILON = 1.0E-8f;
    public float distanceModifier = 0.5f;

    public NoSpinGroundPathNavigation(Mob entity, Level world) {
        super(entity, world);
    }

    public NoSpinGroundPathNavigation(Mob entity, Level world, float distanceModifier) {
        super(entity, world);
        this.distanceModifier = distanceModifier;
    }

    @NotNull
    protected PathFinder m_5532_(int maxVisitedNodes) {
        this.f_26508_ = new WalkNodeEvaluator();
        this.f_26508_.m_77351_(true);
        return new PatchedPathFinder(this.f_26508_, maxVisitedNodes);
    }

    protected void m_7636_() {
        Path path = Objects.requireNonNull(this.f_26496_);
        Vec3 entityPos = this.m_7475_();
        int pathLength = path.m_77398_();
        for (int i = path.m_77399_(); i < path.m_77398_(); ++i) {
            if ((double)path.m_77375_((int)i).f_77272_ == Math.floor(entityPos.f_82480_)) continue;
            pathLength = i;
            break;
        }
        Vec3 base = entityPos.m_82520_((double)(-this.f_26494_.m_20205_() * this.distanceModifier), 0.0, (double)(-this.f_26494_.m_20205_() * this.distanceModifier));
        Vec3 max = base.m_82520_((double)this.f_26494_.m_20205_(), (double)this.f_26494_.m_20206_(), (double)this.f_26494_.m_20205_());
        if (this.tryShortcut(path, new Vec3(this.f_26494_.m_20185_(), this.f_26494_.m_20186_(), this.f_26494_.m_20189_()), pathLength, base, max) && (this.isAt(path, this.distanceModifier) || this.atElevationChange(path) && this.isAt(path, this.f_26494_.m_20205_() * this.distanceModifier))) {
            path.m_77393_(path.m_77399_() + 1);
        }
        this.m_6481_(entityPos);
    }

    private boolean isAt(Path path, float threshold) {
        Vec3 pathPos = path.m_77380_((Entity)this.f_26494_);
        return Mth.m_14154_((float)((float)(this.f_26494_.m_20185_() - pathPos.f_82479_))) < threshold && Mth.m_14154_((float)((float)(this.f_26494_.m_20189_() - pathPos.f_82481_))) < threshold && Math.abs(this.f_26494_.m_20186_() - pathPos.f_82480_) < 1.0;
    }

    private boolean atElevationChange(Path path) {
        int curr = path.m_77399_();
        int end = Math.min(path.m_77398_(), curr + Mth.m_14167_((float)(this.f_26494_.m_20205_() * this.distanceModifier)) + 1);
        int currY = path.m_77375_((int)curr).f_77272_;
        for (int i = curr + 1; i < end; ++i) {
            if (path.m_77375_((int)i).f_77272_ == currY) continue;
            return true;
        }
        return false;
    }

    private boolean tryShortcut(Path path, Vec3 entityPos, int pathLength, Vec3 base, Vec3 max) {
        int i = pathLength;
        while (--i > path.m_77399_()) {
            Vec3 vec = path.m_77382_((Entity)this.f_26494_, i).m_82546_(entityPos);
            if (!this.sweep(vec, base, max)) continue;
            path.m_77393_(i);
            return false;
        }
        return true;
    }

    private boolean sweep(Vec3 vec, Vec3 base, Vec3 max) {
        float t = 0.0f;
        float max_t = (float)vec.m_82553_();
        if (max_t < 1.0E-8f) {
            return true;
        }
        float[] tr = new float[3];
        int[] ldi = new int[3];
        int[] tri = new int[3];
        int[] step = new int[3];
        float[] tDelta = new float[3];
        float[] tNext = new float[3];
        float[] normed = new float[3];
        for (int i = 0; i < 3; ++i) {
            float value = NoSpinGroundPathNavigation.element(vec, i);
            boolean dir = value >= 0.0f;
            step[i] = dir ? 1 : -1;
            float lead = NoSpinGroundPathNavigation.element(dir ? max : base, i);
            tr[i] = NoSpinGroundPathNavigation.element(dir ? base : max, i);
            ldi[i] = NoSpinGroundPathNavigation.leadEdgeToInt(lead, step[i]);
            tri[i] = NoSpinGroundPathNavigation.trailEdgeToInt(tr[i], step[i]);
            normed[i] = value / max_t;
            tDelta[i] = Mth.m_14154_((float)(max_t / value));
            float dist = dir ? (float)(ldi[i] + 1) - lead : lead - (float)ldi[i];
            tNext[i] = tDelta[i] < Float.POSITIVE_INFINITY ? tDelta[i] * dist : Float.POSITIVE_INFINITY;
        }
        do {
            int axis = tNext[0] < tNext[1] ? (tNext[0] < tNext[2] ? 0 : 2) : (tNext[1] < tNext[2] ? 1 : 2);
            float dt = tNext[axis] - t;
            t = tNext[axis];
            int n = axis;
            ldi[n] = ldi[n] + step[axis];
            int n2 = axis;
            tNext[n2] = tNext[n2] + tDelta[axis];
            for (int i = 0; i < 3; ++i) {
                int n3 = i;
                tr[n3] = tr[n3] + dt * normed[i];
                tri[i] = NoSpinGroundPathNavigation.trailEdgeToInt(tr[i], step[i]);
            }
            int stepx = step[0];
            int x0 = axis == 0 ? ldi[0] : tri[0];
            int x1 = ldi[0] + stepx;
            int y0 = axis == 1 ? ldi[1] : tri[1];
            int stepz = step[2];
            int z0 = axis == 2 ? ldi[2] : tri[2];
            int z1 = ldi[2] + stepz;
            for (int x = x0; x != x1; x += stepx) {
                for (int z = z0; z != z1; z += stepz) {
                    BlockPathTypes below = this.f_26508_.m_8086_((BlockGetter)this.f_26495_, x, y0 - 1, z);
                    BlockPathTypes in = this.f_26508_.m_7209_((BlockGetter)this.f_26495_, x, y0, z, this.f_26494_);
                    float priority = this.f_26494_.m_21439_(in);
                    if (priority < 0.0f || priority >= 8.0f) {
                        return false;
                    }
                    if (this.f_26494_.m_6095_().m_20672_() || in != BlockPathTypes.DAMAGE_FIRE && in != BlockPathTypes.DANGER_FIRE && in != BlockPathTypes.DAMAGE_OTHER && below != BlockPathTypes.LAVA) continue;
                    return false;
                }
            }
        } while (t <= max_t);
        return true;
    }

    protected static int leadEdgeToInt(float coord, int step) {
        return Mth.m_14143_((float)(coord - (float)step * 1.0E-8f));
    }

    protected static int trailEdgeToInt(float coord, int step) {
        return Mth.m_14143_((float)(coord + (float)step * 1.0E-8f));
    }

    protected static float element(Vec3 v, int i) {
        switch (i) {
            case 0: {
                return (float)v.f_82479_;
            }
            case 1: {
                return (float)v.f_82480_;
            }
            case 2: {
                return (float)v.f_82481_;
            }
        }
        return 0.0f;
    }

    public static class PatchedPathFinder
    extends PathFinder {
        public PatchedPathFinder(NodeEvaluator processor, int maxVisitedNodes) {
            super(processor, maxVisitedNodes);
        }

        @Nullable
        public Path m_77427_(PathNavigationRegion region, Mob mob, Set<BlockPos> targetPositions, float maxRange, int accuracy, float searchDepthMultiplier) {
            Path path = super.m_77427_(region, mob, targetPositions, maxRange, accuracy, searchDepthMultiplier);
            return path == null ? null : new PatchedPath(path);
        }

        static class PatchedPath
        extends Path {
            public PatchedPath(Path original) {
                super(PatchedPath.copyPathPoints(original), original.m_77406_(), original.m_77403_());
            }

            public Vec3 m_77382_(Entity entity, int index) {
                Node point = this.m_77375_(index);
                double d0 = (double)point.f_77271_ + (double)Mth.m_14143_((float)(entity.m_20205_() + 1.0f)) * 0.5;
                double d1 = point.f_77272_;
                double d2 = (double)point.f_77273_ + (double)Mth.m_14143_((float)(entity.m_20205_() + 1.0f)) * 0.5;
                return new Vec3(d0, d1, d2);
            }

            private static List<Node> copyPathPoints(Path original) {
                ArrayList<Node> points = new ArrayList<Node>();
                for (int i = 0; i < original.m_77398_(); ++i) {
                    points.add(original.m_77375_(i));
                }
                return points;
            }
        }
    }
}

