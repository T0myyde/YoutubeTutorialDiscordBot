package ch.tomyy.bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class JoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Member member = event.getMember();
        TextChannel channel = event.getGuild().getTextChannelById("991238215958798356");

        if (channel != null) {
            channel.sendMessageEmbeds(joinEmbed(member).build()).queue();
        } else {
            System.out.println("Der Channel Exsistiert nicht");
        }
    }


    private EmbedBuilder joinEmbed(Member member) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle(member.getEffectiveName());
        embedBuilder.setDescription("Wilkommen auf dem Discord!");
        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setAuthor("TestBot");
        embedBuilder.setThumbnail(member.getEffectiveAvatarUrl());

        return embedBuilder;
    }
}
