package net.iicosahedra.voidborn.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.iicosahedra.voidborn.Voidborn;
import net.iicosahedra.voidborn.item.ShimmerInjectorItem;
import net.iicosahedra.voidborn.util.ResourceLoc;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.DefaultedGeoModel;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class ShimmerInjectorRenderer extends GeoArmorRenderer<ShimmerInjectorItem> implements ICurioRenderer {
    public ShimmerInjectorRenderer() {
        super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath(Voidborn.MODID,"curio/shimmer_injector")));
    }

    @Override
    public void setupAnim(Entity entity, float v, float v1, float v2, float v3, float v4) {

    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        defaultRender(poseStack,(ShimmerInjectorItem) stack.getItem(), renderTypeBuffer,RenderType.armorCutoutNoCull(this.getTextureLocation((ShimmerInjectorItem) stack.getItem())),renderTypeBuffer.getBuffer(RenderType.armorCutoutNoCull(this.getTextureLocation((ShimmerInjectorItem) stack.getItem()))), netHeadYaw, partialTicks, light);
    }
}