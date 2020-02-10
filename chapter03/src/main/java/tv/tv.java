package tv;

public class tv {
	private int channel;
	private int volume; 
	private boolean power;
	
	public tv(int channel,int volume,boolean power) {
		this.channel=channel;
		this.volume=volume;
		this.power=power;
	}
	
	public void power(boolean on) {
		this.power=on;
		
		if(on)
			System.out.println("tv가 켜졌습니다");
		else
			System.out.println("tv가 꺼졌습니다");
	}
	
	public void channel(int channel) {
		if(!power) {
			return ;
		}
		
		if(channel>255) {
			this.channel=1;
			
		}
		else if(channel<1){
			this.channel=255;
		}
		else
			this.channel= channel;
	}
	public void channel(boolean up) {

			channel(this.channel+= up ? +1 : -1);
	}
	
	public void volume(int volume) {
		if(!power) {
			return ;
		}
		if(volume<1) {
			System.out.println("너무 낮은 볼륨입니다.");
		}
		else if(255<volume)
			System.out.println("너무 높은 볼륨입니다.");
		
		else 
			this.volume= volume;
	}
	public void volume(boolean up) {
		if(up) {
			this.volume+=1;
			
			if(this.volume==256)
				this.volume=1;
		}
		else {
			this.volume-=1;
			if(this.volume==0)
				this.volume=255;
		}
	}
	
	public void status() {
		
		System.out.println("TV[channel= "+channel+" volume= "+volume+" power="+power+"]");
	}
	
}
