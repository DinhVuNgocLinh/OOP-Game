package entity;

import java.util.Random;

import main.GamePanel;


public class NPC extends Entity {

	public NPC(GamePanel gp) {
		super(gp);

		direction = "down";
		speed = 1;

		getNPCImage();
	}
//image
	public void getNPCImage() {

		up1 = setup("/npc/npc_nau_up1");
		up2 = setup("/npc/npc_nau_up2");
		down1 = setup("/npc/npc_nau_down1");
		down2 = setup("/npc/npc_nau_down2");
		left1 = setup("/npc/npc_nau_left1");
		left2 = setup("/npc/npc_nau_left2");
		right1 = setup("/npc/npc_nau_right1");
		right2 = setup("/npc/npc_nau_right2");
	}
// movement
	public void setAction() {
		
		actionLockCounter ++;
		if (actionLockCounter == 120) { //once pick up a direction it won't change for the next 120 frames with means 2 seconds // note that we set FPS is 60
			
			Random random = new Random();
			
			int i = random.nextInt(100)+1; // pick up a number randomly 1-100 plus 1 bc it random from 0-99 and plus 1 is 1-100
					
			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <=75) {
				direction = "left";
			}
			if (i > 75 && i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}
	
	
	}
	
	
}
