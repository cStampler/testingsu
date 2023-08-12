package drealm.entity;


import lotr.common.LOTRMod;
import lotr.common.LOTRReflection;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.animal.LOTREntityHorse;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

public class DREntityEagle extends LOTREntityHorse {
    public DREntityEagle(World world) {
        super(world);
        setSize(6.5f, 6.5f);
    }



    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0);
    }

    public EntityAgeable createChild(final EntityAgeable entity) {
        return (EntityAgeable)new DREntityEagle(this.worldObj);
    }

    @Override
    public double clampChildHealth(double health) {
        return MathHelper.clamp_double(health, 20.0, 50.0);
    }

    @Override
    public double clampChildJump(double jump) {
        return MathHelper.clamp_double(jump, 0.2, 0.8);
    }

    @Override
    public double clampChildSpeed(double speed) {
        return MathHelper.clamp_double(speed, 0.12, 0.42);
    }

    @Override
    public EntityAIBase createMountAttackAI() {
        return new LOTREntityAIAttackOnCollide(this, 1.0, true);
    }

    @Override
    public void dropFewItems(boolean flag, int i) {
        int j = rand.nextInt(2) + rand.nextInt(1 + i);
        for (int k = 0; k < j; ++k) {
            dropItem(Items.bone, 1);
        }
        int meat = rand.nextInt(3) + rand.nextInt(1 + i);
        for (int l = 0; l < meat; ++l) {
            if (isBurning()) {
                dropItem(Items.cooked_beef, 1);
                continue;
            }
            dropItem(Items.beef, 1);
        }
    }

    public final double getMountedYOffset() {
        double d = this.getBaseMountedYOffset();
        if (this.riddenByEntity != null) {
            d += this.riddenByEntity.yOffset - this.riddenByEntity.getYOffset();
        }
        return d;
    }

    protected double getBaseMountedYOffset() {
        return this.height * 0.5 - 0.2000000011920929;
    }

    @Override
    public String getAngrySoundName() {
        super.getAngrySoundName();
        return "lotr:misc.say";
    }

    @Override
    public String getDeathSound() {
        super.getDeathSound();
        return "lotr:misc.death";
    }

    @Override
    public int getHorseType() {
        return 1;
    }

    @Override
    public String getHurtSound() {
        super.getHurtSound();
        return "lotr:misc.hurt";
    }

    @Override
    public String getLivingSound() {
        super.getLivingSound();
        return "lotr:misc.say";
    }

    @Override
    public boolean isBreedingItem(ItemStack itemstack) {
        return itemstack != null && itemstack.getItem() == Items.wheat;
    }

    @Override
    public boolean isMountHostile() {
        return true;
    }


    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote) {
            if (this.riddenByEntity instanceof EntityLivingBase) {
                final EntityLivingBase rhinoRider = (EntityLivingBase)this.riddenByEntity;
                final float momentum = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                if (momentum > 0.2f) {
                    this.setSprinting(true);
                }
                else {
                    this.setSprinting(false);
                }
                if (momentum >= 0.2) {
                    final float strength = momentum * 15.0f;
                    final Vec3 position = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
                    final Vec3 look = this.getLookVec();
                    final float sightWidth = 1.0f;
                    final double range = 0.5;
                    final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, this.boundingBox.contract(1.0, 1.0, 1.0).addCoord(look.xCoord * range, look.yCoord * range, look.zCoord * range).expand((double)sightWidth, (double)sightWidth, (double)sightWidth));
                    boolean hitAnyEntities = false;
                    for (final Object element : list) {
                        final Entity obj = (Entity)element;
                        final EntityLivingBase entity;
                        if (obj instanceof EntityLivingBase && (entity = (EntityLivingBase)obj) != rhinoRider && (!(rhinoRider instanceof EntityPlayer) || LOTRMod.canPlayerAttackEntity((EntityPlayer)rhinoRider, entity, false)) && (!(rhinoRider instanceof EntityCreature) || LOTRMod.canNPCAttackEntity((EntityCreature)rhinoRider, entity, false))) {
                            final boolean flag;
                            if (!(flag = entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), strength))) {
                                continue;
                            }
                            final float knockback = strength * 0.06f;
                            entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f) * knockback), (double)knockback, (double)(MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f) * knockback));
                            hitAnyEntities = true;
                            if (!(entity instanceof EntityLiving)) {
                                continue;
                            }
                            final EntityLiving entityliving;
                            if ((entityliving = (EntityLiving)entity).getAttackTarget() != this) {
                                continue;
                            }
                            entityliving.getNavigator().clearPathEntity();
                            entityliving.setAttackTarget(rhinoRider);
                        }
                    }
                    if (hitAnyEntities) {
                        this.worldObj.playSoundAtEntity((Entity)this, "lotr:troll.ologHai_hammer", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
                    }
                }
            }
            else if (this.getAttackTarget() != null) {
                final float momentum2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                if (momentum2 > 0.2f) {
                    this.setSprinting(true);
                }
                else {
                    this.setSprinting(false);
                }
            }
            else {
                this.setSprinting(false);
            }
        }
    }

    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlock(i, j - 1, k) == Blocks.sand && this.worldObj.getFullBlockLightValue(i, j, k) > 8;
    }


    @Override
    public void onLOTRHorseSpawn() {
        double maxHealth = getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
        maxHealth *= 1.5;
        maxHealth = Math.max(maxHealth, 40.0);
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(maxHealth);
        double speed = getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(speed *= 1.2);
        double jumpStrength = getEntityAttribute(LOTRReflection.getHorseJumpStrength()).getAttributeValue();
        getEntityAttribute(LOTRReflection.getHorseJumpStrength()).setBaseValue(jumpStrength *= 0.5);
    }
}