/*
    Wildfire's Female Gender Mod is a female gender mod created for Minecraft.
    Copyright (C) 2023 WildfireRomeo

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package com.wildfire.main.entitydata;

import com.wildfire.main.config.ConfigKey;
import com.wildfire.main.config.Configuration;
import org.joml.Vector3f;

import java.util.function.Consumer;

/**
 * Data class representing an entity's breast appearance settings
 */
@SuppressWarnings("UnusedReturnValue")
public final class Breasts {

    private float xOffset = Configuration.BREASTS_OFFSET_X.getDefault(), yOffset = Configuration.BREASTS_OFFSET_Y.getDefault(), zOffset = Configuration.BREASTS_OFFSET_Z.getDefault();
    private float cleavage = Configuration.BREASTS_CLEAVAGE.getDefault();
    private boolean uniboob = Configuration.BREASTS_UNIBOOB.getDefault();

    private <VALUE> boolean updateValue(ConfigKey<VALUE> key, VALUE value, Consumer<VALUE> setter) {
        if (key.validate(value)) {
            setter.accept(value);
            return true;
        }
        return false;
    }

    public Vector3f getOffsets() {
        return new Vector3f(xOffset, yOffset, zOffset);
    }

    public void updateOffsets(Vector3f offsets) {
        updateXOffset(offsets.x);
        updateYOffset(offsets.y);
        updateZOffset(offsets.z);
    }

    /**
     * How far apart the player's breasts should be rendered from each other, also referred to as Separation in the UI
     *
     * @implNote Negative float values renders the breasts further apart, while positive values renders them closer together
     *
     * @return  A {@code float} between {@code -1f} and {@code 1f}
     */
    public float getXOffset() {
        return xOffset;
    }

    /**
     * @see #getXOffset()
     */
    public boolean updateXOffset(float value) {
        return updateValue(Configuration.BREASTS_OFFSET_X, value, v -> this.xOffset = v);
    }

    /**
     * How far up or down the player's breasts should be rendered, also referred to as Height in the UI
     *
     * @implNote Negative values renders the breasts lower down, while positive values renders them higher up
     *
     * @return  A {@code float} between {@code -1f} and {@code 1f}
     */
    public float getYOffset() {
        return yOffset;
    }

    /**
     * @see #getYOffset()
     */
    public boolean updateYOffset(float value) {
        return updateValue(Configuration.BREASTS_OFFSET_Y, value, v -> this.yOffset = v);
    }

    /**
     * How far back the player's breasts should be rendered, also referred to as Depth in the UI
     *
     * @return  A {@code float} between {@code 0f} and {@code 1f}
     */
    public float getZOffset() {
        return zOffset;
    }

    /**
     * @see #getZOffset()
     */
    public boolean updateZOffset(float value) {
        return updateValue(Configuration.BREASTS_OFFSET_Z, value, v -> this.zOffset = v);
    }

    /**
     * How much rotation outward there should be on each of the player's breasts
     *
     * @return  A {@code float} between {@code 0f} and {@code 0.1f}
     */
    public float getCleavage() {
        return cleavage;
    }

    /**
     * @see #getCleavage()
     */
    public boolean updateCleavage(float value) {
        return updateValue(Configuration.BREASTS_CLEAVAGE, value, v -> this.cleavage = v);
    }

    /**
     * Determines if breast physics should be independent of each other; also referred to as Dual-Physics in the UI
     *
     * @return {@code false} if physics should be independent on each breast, {@code true} if both should use the same physics
     */
    public boolean isUniboob() {
        return uniboob;
    }

    /**
     * @see #isUniboob()
     */
    public boolean updateUniboob(boolean value) {
        return updateValue(Configuration.BREASTS_UNIBOOB, value, v -> this.uniboob = v);
    }
}
