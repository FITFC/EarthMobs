package baguchan.earthmobsmod;

import baguchan.earthmobsmod.capability.ShadowCapability;
import baguchan.earthmobsmod.registry.ModBlocks;
import baguchan.earthmobsmod.registry.ModEntities;
import baguchan.earthmobsmod.registry.ModFluids;
import baguchan.earthmobsmod.registry.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EarthMobsMod.MODID)
public class EarthMobsMod {
	public static final String MODID = "earthmobsmod";
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger(MODID);

	public static Capability<ShadowCapability> SHADOW_CAP = CapabilityManager.get(new CapabilityToken<>() {
	});

	public EarthMobsMod() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		ModBlocks.BLOCKS.register(modBus);
		ModEntities.ENTITIES.register(modBus);
		ModFluids.FLUIDS.register(modBus);
		ModItems.ITEMS.register(modBus);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EarthMobsConfig.COMMON_SPEC);
	}

	private void setup(final FMLCommonSetupEvent event) {
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {

	}

	private void processIMC(final InterModProcessEvent event) {
	}
}
