package net.moddedminecraft.simplegamemode;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.HashMap;
import java.util.Map;

@Plugin(id = "simplegamemode", name = "SimpleGamemode", version = "1.2")
public class Main {

    @Inject
    public Logger logger;

    @Inject
    private Metrics metrics;

    private CommandManager cmdManager = Sponge.getCommandManager();


    Map<String, String> choices = new HashMap<String, String>() {
        {
            put("c", "c");
            put("s", "s");
            put("a", "a");
            put("sp", "sp");
        }
    };

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        // /gm
        CommandSpec gm = CommandSpec.builder()
                .description(Text.of("Change Gamemode easily"))
                .permission("simplegamemode.gamemode")
                .arguments(GenericArguments.optional(GenericArguments.choices(Text.of("Gamemode"), choices)),
                        GenericArguments.optional(GenericArguments.player(Text.of("Player"))))
                .executor(new GamemodeCMD(this))
                .build();
        cmdManager.register(this, gm, "gm");

        logger.info("SimpleGamemode Enabled");
    }

    public Text fromLegacy(String legacy) {
        return TextSerializers.FORMATTING_CODE.deserializeUnchecked(legacy);
    }

}
