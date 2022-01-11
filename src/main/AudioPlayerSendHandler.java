package StudyingBot.StudyingBot;

import java.nio.ByteBuffer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.MutableAudioFrame;

import net.dv8tion.jda.api.audio.AudioSendHandler;

public class AudioPlayerSendHandler implements AudioSendHandler {
	private final AudioPlayer audioplayer;
	private final ByteBuffer buffer;
	private final MutableAudioFrame frame;

		public AudioPlayerSendHandler(AudioPlayer audioplayer) {
			this.audioplayer=audioplayer;
			this.buffer=ByteBuffer.allocate(1024);
			this.frame=new MutableAudioFrame();
			frame.setBuffer(buffer);
		}
	@Override
	public boolean canProvide() {
		// TODO Auto-generated method stub
		return this.audioplayer.provide(this.frame);
	}

	@Override
	public ByteBuffer provide20MsAudio() {
		// TODO Auto-generated method stub
		return this.buffer.flip();
	}
	
	public boolean isOpus() {
		return false;
		
	}

}
