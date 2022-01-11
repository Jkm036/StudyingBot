package StudyingBot.StudyingBot;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class GuildMusicManager {
	private final AudioPlayer audioplayer;
	public final TrackHandler handler;
	private final AudioPlayerSendHandler sender;
	public GuildMusicManager(AudioPlayerManager manager) {
		this.audioplayer=manager.createPlayer();
		this.handler = new TrackHandler(this.audioplayer);		
		this.audioplayer.addListener(this.handler);
		this.sender=new AudioPlayerSendHandler(this.audioplayer);
	}
	
	public AudioPlayerSendHandler getSendHandler() {
		return sender;
	}
}
