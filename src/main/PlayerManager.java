package StudyingBot.StudyingBot;

import java.util.HashMap;
import java.util.Map;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;

import net.dv8tion.jda.api.entities.Guild;

public class PlayerManager {
 private static PlayerManager Instance;
 private final AudioPlayerManager audioPlayerManager;
 
 private final Map<Long,GuildMusicManager> musicManagers;
 
 public PlayerManager() {
	 this.musicManagers= new HashMap<>();
	 this.audioPlayerManager= new DefaultAudioPlayerManager();
	 
	 AudioSourceManagers.registerRemoteSources(this.audioPlayerManager);
	 AudioSourceManagers.registerLocalSource(this.audioPlayerManager);
 }
 
 public GuildMusicManager getMusicManager(Guild guild) {
	 return this.musicManagers.computeIfAbsent(guild.getIdLong(), (guildId)->{
		 final GuildMusicManager gmm= new GuildMusicManager(this.audioPlayerManager);
		 guild.getAudioManager().setSendingHandler(gmm.getSendHandler());
		 return gmm;
	 });
 }
 private static PlayerManager getInstance() {
	 if(Instance==null) {
		 Instance=new PlayerManager();
	 }
	 return Instance;
 }
}
