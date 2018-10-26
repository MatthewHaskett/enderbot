package me.enderaura.enderbot.command;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.enderaura.enderbot.util.CommandResponseBuilder;

/**
 * @author Enderaura
 * @since 26/10/2018 19:24.
 */
public class InfoCommand extends Command {

    public InfoCommand(){
        this.name = "info";
        this.help = "Displays some information about the bot.";
    }

    protected void execute(CommandEvent event) {
        event.reply(new CommandResponseBuilder("Bot Information")
                .withDescription("Here is some information about the bot.")
                .withField("Guilds", event.getJDA().getGuilds().size() + "")
                .withField("Members", event.getJDA().getUsers().size() + "")
                .withField("Ping", event.getJDA().getPing() + "")
                .build());
    }
}
