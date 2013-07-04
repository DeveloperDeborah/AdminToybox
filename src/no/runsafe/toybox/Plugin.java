package no.runsafe.toybox;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.toybox.command.*;
import no.runsafe.toybox.events.*;
import no.runsafe.toybox.handlers.CarePackageHandler;
import no.runsafe.toybox.handlers.LockedObjectHandler;
import no.runsafe.toybox.handlers.MobDropHandler;
import no.runsafe.toybox.horses.HorseSpawner;
import no.runsafe.toybox.repositories.LockedObjectRepository;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		// Repositories
		addComponent(LockedObjectRepository.class);

		// Handlers
		addComponent(LockedObjectHandler.class);
		addComponent(CarePackageHandler.class);
		addComponent(MobDropHandler.class);

		addComponent(HorseSpawner.class);

		// Commands
		addComponent(Bazooka.class);
		addComponent(Bomb.class);
		addComponent(Dismount.class);
		addComponent(Dynamite.class);
		addComponent(Fireball.class);
		addComponent(Firework.class);
		addComponent(Lightning.class);
		addComponent(Mount.class);
		addComponent(SpawnMob.class);
		addComponent(Ride.class);
		addComponent(CreateHead.class);
		addComponent(Mode.class); // TODO: Move this to another more suiting plug-in.
		addComponent(CarePackage.class);
		addComponent(MobDrop.class);
		addComponent(Nuke.class);
		addComponent(SpawnGodMob.class);
		addComponent(EnchantItem.class);
		addComponent(RenameItem.class);
		addComponent(GiveItem.class);
		addComponent(Kill.class);
		addComponent(BuffCommand.class);
		addComponent(Colour.class);
		addComponent(Author.class);
		addComponent(PlaySound.class);
		addComponent(Lock.class);
		addComponent(SpawnHorse.class);

		// Events
		addComponent(InventoryClose.class);
		addComponent(ChangeBlockEvent.class);
		addComponent(Dispense.class);
		addComponent(InventoryMoveItem.class);
		addComponent(BlockPlace.class);
		addComponent(InventoryClick.class);
		addComponent(PlayerMove.class);
	}
}
