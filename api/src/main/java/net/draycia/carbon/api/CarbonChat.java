/*
 * CarbonChat
 *
 * Copyright (c) 2021 Josua Parks (Vicarious)
 *                    Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package net.draycia.carbon.api;

import java.nio.file.Path;
import net.draycia.carbon.api.channels.ChannelRegistry;
import net.draycia.carbon.api.events.CarbonEventHandler;
import net.draycia.carbon.api.util.RenderedMessage;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.moonshine.message.IMessageRenderer;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;

/**
 * The main plugin interface.<br>
 * Instances may be obtained through {@link CarbonChatProvider#carbonChat()}.
 *
 * @since 1.0.0
 */
@DefaultQualifier(NonNull.class)
public interface CarbonChat {

    /**
     * The plugin's logger.<br>
     * All messages will be logged through this.
     *
     * @return the plugin's logger
     * @since 2.0.0
     */
    Logger logger();

    /**
     * The plugin's data storage directory.<br>
     * This is where configs and misc files will be stored.
     *
     * @return the plugin's data directory
     * @since 2.0.0
     */
    Path dataDirectory();

    /**
     * The event handler, used for listening to and emitting events.
     *
     * @return the event handler
     * @since 2.0.0
     */
    CarbonEventHandler eventHandler();

    /**
     * The server that carbon is running on.
     *
     * @return the server
     * @since 2.0.0
     */
    CarbonServer server();

    /**
     * The registry that channels are registered to.
     *
     * @return the channel registry
     * @since 2.0.0
     */
    ChannelRegistry channelRegistry();

    /**
     * The message renderer, tailored for the current platform.
     *
     * @return the message renderer
     * @since 2.0.0
     */
    <T extends Audience> IMessageRenderer<T, String, RenderedMessage, Component> messageRenderer();

    // TODO: Redis as MariaDB cache
    // TODO: Adopt egg82/Messenger for use with databases?

}
