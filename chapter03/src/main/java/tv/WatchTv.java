package tv;

public class WatchTv {
	public static void main (String[] args) {
		tv tv= new tv(7,20,false);
		
		tv.status();	
        
        tv.power( true );
        tv.volume(120);
        tv.status();		          
        
        tv.volume( false );
        tv.status();
        
        tv.channel( 255);
        tv.status();		          
        
        tv.channel( true );
        tv.channel( false );
        tv.channel( true );
        tv.status();

        tv.power( false );
        tv.status();      	
	
		
		
	}
}
