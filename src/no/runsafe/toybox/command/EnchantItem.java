package no.runsafe.toybox.command;

import no.runsafe.framework.command.player.PlayerCommand;
import no.runsafe.framework.server.enchantment.RunsafeEnchantment;
import no.runsafe.framework.server.enchantment.RunsafeEnchantmentType;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.toybox.handlers.Enchanter;

import java.util.HashMap;

public class EnchantItem extends PlayerCommand
{
	public EnchantItem(Enchanter enchanter)
	{
		super("enchant", "Enchants an item", "runsafe.toybox.enchant", "enchant");
		this.enchanter = enchanter;
	}

	@Override
	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters)
	{
		return null;
	}

	@Override
	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments)
	{
		RunsafeItemStack item = executor.getItemInHand();
		String enchantName = parameters.get("enchant");

		if (enchantName.equalsIgnoreCase("all"))
		{
			this.enchanter.applyAllEnchants(item);
			return "&2Applied all available enchants to your item.";
		}
		else
		{
			for (RunsafeEnchantmentType enchantType : RunsafeEnchantmentType.values())
			{
				if (enchantType.name().equalsIgnoreCase(enchantName))
				{
					RunsafeEnchantment enchant = new RunsafeEnchantment(enchantType);
					if (!enchant.canEnchantItem(item))
						return "&cThat enchant cannot be applied to that item.";

					int power = (arguments.length > 0 ? Integer.valueOf(arguments[0]) : enchant.getMaxLevel());
					if (power > enchant.getMaxLevel()) power = enchant.getMaxLevel();

					item.addEnchantment(enchant, power);

					return "&2Your item has been enchanted.";
				}
			}
			return "&cThe enchantment you are looking for does not exist.";
		}
	}

	private Enchanter enchanter;
}