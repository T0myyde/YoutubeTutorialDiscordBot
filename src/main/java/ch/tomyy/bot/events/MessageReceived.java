package ch.tomyy.bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.ArrayList;

public class MessageReceived extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentDisplay().split(" ");
        TextChannel textChannel = event.getGuild().getTextChannelById("993107674977796207");

        if (args[0].equalsIgnoreCase("+setup")) {
            String roles = String.valueOf(event.getMember().getRoles());
            if (roles.contains("Admin")) {
                if (textChannel != null) {
                    if (event.getMessage().getChannel() == textChannel) {
                        ArrayList<Button> buttons = new ArrayList<>();

                        buttons.add(Button.success("support", "Support Ticket").withEmoji(Emoji.fromMarkdown("U+1F600")));
                        buttons.add(Button.danger("bug", "Bug gefunden!").withEmoji(Emoji.fromMarkdown("U+1F600")));

                        textChannel.sendMessageEmbeds(embedBuilder(event.getMember()).build()).setActionRow(buttons).queue();
                    }
                }
            }
        } else if (args[0].equalsIgnoreCase("+test")) {
            event.getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessageEmbeds(embedBuilder(event.getMember()).build()).setActionRow(Button.success("test","test")).queue();
            });
        }
    }

    private EmbedBuilder embedBuilder(Member member) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor("T-Codes");
        embedBuilder.setTitle("Ticket-System");
        embedBuilder.setDescription("Dürck auf ein Button!");
        embedBuilder.setThumbnail(member.getEffectiveAvatarUrl());

        return embedBuilder;

    }

    private EmbedBuilder privateEmbedBuilder(Member member) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor("T-Codes");
        embedBuilder.setTitle("Ticket-System");
        embedBuilder.setDescription("Dürck auf ein Button!");
        embedBuilder.setThumbnail(member.getEffectiveAvatarUrl());

        return embedBuilder;

    }

}
