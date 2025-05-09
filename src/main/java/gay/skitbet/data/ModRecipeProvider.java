package gay.skitbet.data;

import gay.skitbet.SkitDubstepMod;
import gay.skitbet.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.REDSTONE_DEBSTEP_GUN)
                .pattern("RRR")
                .pattern("IRI")
                .pattern("IRI")
                .input('R', Items.REDSTONE)
                .input('I', Items.IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(consumer, Identifier.of(SkitDubstepMod.MOD_ID, "redstone_dubstep_gun"));
    }
}
