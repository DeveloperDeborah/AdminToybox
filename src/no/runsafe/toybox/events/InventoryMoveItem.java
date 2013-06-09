package no.runsafe.toybox.events;

import no.runsafe.framework.event.inventory.IInventoryMoveItem;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryMoveItemEvent;

public class InventoryMoveItem implements IInventoryMoveItem
{
	@Override
	public void OnInventoryMoveItemEvent(RunsafeInventoryMoveItemEvent event)
	{
		String sourceTitle = event.getSource().getTitle();

		if (sourceTitle.equalsIgnoreCase("Infinite"))
		{
			event.getDestination().addItems(event.getItem().clone());
			event.setCancelled(true);
		}
	}
}
