package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject{
	public OBJ_Key() {
		name = "icon1";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/icon/icon1.jpg"));	
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
