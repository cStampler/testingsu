package drealm.render;


import drealm.entity.DREntityEagle;
import drealm.model.DRModelEagle;
import lotr.client.render.entity.LOTRRenderHorse;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DRRenderEagle extends RenderLiving {
    public static ResourceLocation rhinoTexture = new ResourceLocation("drealm:mob/eagle/eagle.png");


    public DRRenderEagle() {
        super(new DRModelEagle(), 0.5f);
        setRenderPassModel(new DRModelEagle());
    }


    protected void preRenderCallback(final EntityLivingBase entity, final float f) {
        final DREntityEagle orc = (DREntityEagle) entity;
        GL11.glScalef(3.5f, 3.5f, 3.5f);
    }

    public void createChild(final DREntityEagle entity, final float f) {
        if (entity.isChild()) {
            GL11.glScalef(-0.5f, -0.5f, -0.5f);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        DREntityEagle rhino = (DREntityEagle) entity;
        return LOTRRenderHorse.getLayeredMountTexture(rhino, rhinoTexture);
    }

    @Override
    public int shouldRenderPass(EntityLivingBase entity, int pass, float f) {
        if (pass == 0 && ((DREntityEagle) entity).isMountSaddled()) {
            return 1;
        }
        return super.shouldRenderPass(entity, pass, f);
    }
}