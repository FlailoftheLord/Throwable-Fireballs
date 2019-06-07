/*
 * Copyright (C) 2018-2019 FlailoftheLord
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package me.flail.ThrowableFireballs.Handlers.elytra;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class PlayerHitListener implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void playerHitByFireball(ProjectileHitEvent event) {
		Entity target = event.getHitEntity();
		if ((target != null) && (target instanceof Player)) {
			Player player = (Player) target;
			Entity projectile = event.getEntity();
			if (player.isGliding() && projectile.isValid() && projectile.hasMetadata("HolyBalls")) {
				player.setGliding(false);
			}
		}

	}

}
