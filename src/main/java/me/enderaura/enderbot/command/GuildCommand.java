package me.enderaura.enderbot.command;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.enderaura.enderbot.util.CommandResponseBuilder;
import net.dv8tion.jda.core.entities.Guild;

/**
 * @author Enderaura
 * @since 26/10/2018 19:44.
 */
public class GuildCommand extends Command {

    public GuildCommand(){
        this.name = "guild";
        this.help = "Displays some information about the guild.";
    }

    protected void execute(CommandEvent event) {
        Guild guild = event.getGuild();

        event.reply(new CommandResponseBuilder("Guild Information")
                .withDescription("Here is some information about guild: " + guild.getName())
                .withField("Members", guild.getMembers().size() + "")
                .withField("Region", guild.getRegionRaw())
                .withField("Text Channels", guild.getTextChannels().size() + "")
                .withField("Voice Channels", guild.getVoiceChannels().size() + "")
                .withField("Categories", guild.getCategories().size() + "")
                .withField("Emotes", guild.getEmotes().size() + "")
                .withField("Explicit Content Level", guild.getExplicitContentLevel().getDescription())
                .withField("Owner", guild.getOwner().getUser().getName())
                .withField("Roles", guild.getRoles().size() + "")
                .build());
    }
}
