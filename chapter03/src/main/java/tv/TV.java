package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV() {
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		if(!power) {
			return;
		}
		
		if (channel < 1) {
			channel = 255;
		} else if (channel > 255) {
			channel = 1;
		}
		
		this.channel = channel;
		
		/*
		 * if (channel < 1 || channel > 255) { System.out.println("채널이 존재하지 않습니다.");
		 * return; } this.channel = channel;
		 */
	}
	
	public void channel(boolean up) {
		/*
		 * if (up) { channel = channel + 1; } else { channel = channel - 1; }
		 * channel(channel);
		 */
		
		channel(channel + (up ? 1 : -1));
		
		/*
		 * if (up) { if (this.channel == 255) { this.channel = -1; } this.channel++; }
		 * else { if (this.channel == 0) { System.out.println("볼륨을 더 이상 낮출 수 없습니다.");
		 * return; } this.channel--; }
		 */
	}
	
	public void volume(int volume) {
		if (volume < 0 || volume > 255) {
			System.out.println("값을 벗어났습니다.");
			return;
		}
		this.volume = volume;
	}
	
	public void volume(boolean up) {
		if (up) {
			if (this.volume == 255) {
				this.volume = -1;
			}
			this.volume++;
		} else {
			if (this.volume == 0) {
				System.out.println("볼륨을 더 이상 낮출 수 없습니다.");
				return;
			}
			this.volume--;
		}
	}
	
	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + power + "]");
	}
}
