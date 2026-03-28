/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.Nullable
 */
package com.barlinc.unusual_prehistory.entity.mob.base;

import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricAquaticMob;
import com.barlinc.unusual_prehistory.entity.mob.base.PrehistoricMob;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public abstract class SchoolingAquaticMob
extends PrehistoricAquaticMob {
    @Nullable
    private SchoolingAquaticMob leader;
    protected int schoolSize = 1;

    protected SchoolingAquaticMob(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void m_8119_() {
        List list;
        super.m_8119_();
        if (this.hasFollowers() && this.m_9236_().f_46441_.m_188503_(200) == 1 && (list = this.m_9236_().m_45976_(((Object)((Object)this)).getClass(), this.m_20191_().m_82377_(8.0, 8.0, 8.0))).size() <= 1) {
            this.schoolSize = 1;
        }
    }

    protected void m_5625_(float volume) {
        float multiplier = 1.0f;
        if (this.leader != null) {
            multiplier = Math.max(1.0f - (float)(this.leader.schoolSize - 1) * 0.1f, 0.4f);
        }
        this.m_5496_(this.m_5501_(), volume * multiplier, 1.0f + (this.f_19796_.m_188501_() - this.f_19796_.m_188501_()) * 0.4f);
    }

    public int m_5792_() {
        return this.getMaxSchoolSize();
    }

    public int getMaxSchoolSize() {
        return super.m_5792_();
    }

    public boolean isFollower() {
        return this.leader != null && this.leader.m_6084_();
    }

    public void startFollowing(SchoolingAquaticMob entity) {
        this.leader = entity;
        entity.addFollower();
    }

    public void stopFollowing() {
        this.leader.removeFollower();
        this.leader = null;
    }

    protected void addFollower() {
        ++this.schoolSize;
    }

    protected void removeFollower() {
        --this.schoolSize;
    }

    public boolean canBeFollowed() {
        return this.hasFollowers() && this.schoolSize < this.getMaxSchoolSize();
    }

    public boolean hasFollowers() {
        return this.schoolSize > 1;
    }

    public boolean inRangeOfLeader() {
        return this.m_20280_((Entity)this.leader) <= 121.0;
    }

    public void addFollowers(Stream<? extends SchoolingAquaticMob> entity) {
        entity.limit(this.getMaxSchoolSize() - this.schoolSize).filter(entity1 -> entity1 != this).forEach(entity2 -> {
            if (this.getVariant() == entity2.getVariant()) {
                entity2.startFollowing(this);
            }
        });
    }

    public void pathToLeader() {
        if (this.isFollower()) {
            this.m_21573_().m_5624_((Entity)this.leader, 1.0);
        }
    }
}

