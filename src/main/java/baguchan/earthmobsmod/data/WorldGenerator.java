package baguchan.earthmobsmod.data;

import baguchan.earthmobsmod.world.features.ModEarthFeatures;
import baguchan.earthmobsmod.world.features.ModEarthPlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public class WorldGenerator extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, ModEarthFeatures::bootstrap)
			.add(Registries.PLACED_FEATURE, ModEarthPlacements::bootstrap);


	public WorldGenerator(PackOutput output) {
		super(output, WorldGenerator::createLookup);
	}

	public static HolderLookup.Provider createLookup() {
		return BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), VanillaRegistries.createLookup());
	}
}