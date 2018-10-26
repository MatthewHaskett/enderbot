package me.enderaura.enderbot.util;

import com.google.common.collect.Maps;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;

import java.awt.*;
import java.util.Map;

/**
 * @author Enderaura
 * @since 26/10/2018 19:26.
 */
public class CommandResponseBuilder {

    private String title, description = "";
    private Color colour = Color.BLUE;
    private Map<String, String> fields = Maps.newHashMap();

    public CommandResponseBuilder(String title){
        this.title = title;
    }

    public CommandResponseBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public CommandResponseBuilder withColour(Color colour){
        this.colour = colour;
        return this;
    }

    public CommandResponseBuilder withField(String header, String text){
        fields.put(header, text);
        return this;
    }

    public MessageEmbed build(){
        EmbedBuilder embedBuilder =  new EmbedBuilder()
                .setTitle(title)
                .setDescription(description)
                .setColor(colour)
                .setFooter("© Matthew Haskett 2018", "https://avatars1.githubusercontent.com/u/25549254?s=400&v=4");

        for(Map.Entry<String, String> field : fields.entrySet())
            embedBuilder.addField(field.getKey(), field.getValue(), true);

        return embedBuilder.build();
    }



}
