package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
	public int screenY;
	public int screenX;

    public Player(GamePanel gp, KeyHandler keyH) {
    	super(gp);// calling the constructor of the superclass of this class and passing this gp
    	
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "up";
    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_up-1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_up-2.png")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_up-3.png")));
            stand = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_stand.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_down-1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_down-2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_left-1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_left-2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_right-1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/player_right-2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }
        else {
            direction = "stand";
        }

        spriteCounter++;
        if (spriteCounter > 20) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }
            else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);//vẽ màu cho object
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction) {
            case "stand":
                image = stand;
                break;
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}