package com.gildedgames.aether.data.generators.tags;

import com.gildedgames.aether.Aether;
import com.gildedgames.aether.AetherTags;
import com.gildedgames.aether.data.resources.AetherBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class AetherBiomeTagData extends BiomeTagsProvider {
    public AetherBiomeTagData(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Aether.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(AetherTags.Biomes.IS_AETHER).add(
                AetherBiomes.GOLDEN_FOREST,
                AetherBiomes.SKYROOT_FOREST,
                AetherBiomes.SKYROOT_GROVE,
                AetherBiomes.SKYROOT_THICKET
        );
        this.tag(AetherTags.Biomes.HAS_LARGE_AERCLOUD).addTag(AetherTags.Biomes.IS_AETHER);
    }
}
