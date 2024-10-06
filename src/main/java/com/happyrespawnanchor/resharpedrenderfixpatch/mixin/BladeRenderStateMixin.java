package com.happyrespawnanchor.resharpedrenderfixpatch.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import mods.flammpfeil.slashblade.client.renderer.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState.renderOverrided;

@Mixin(BladeRenderState.class)
public abstract class BladeRenderStateMixin {
    @Shadow public abstract void renderOverrided(ItemStack stack, WavefrontObject model, String target, ResourceLocation texture, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn);

    @Inject(at = @At("TAIL"), method = "renderOverrided*", remap = false)
    public void renderOverridedMixin(CallbackInfo ci) {
        renderOverrided(stack, model, target, texture, matrixStackIn, bufferIn,
        packedLightIn, Util.memoize(BladeRenderState::getSlashBladeBlend), true;

    }
}
