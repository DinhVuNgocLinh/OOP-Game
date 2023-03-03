package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

    GamePanel gp;
    public int x, y;
    public int speed;
    public BufferedImage up1, up2, up3, stand, down1, down2, left1, left2, right1, right2;// Mô tả hình ảnh dưới dạng
                                                                                          // một thông tin (để lưu trữ
                                                                                         // file ảnh))
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); // default solid area for all entity
    public int solidAreaDefaultX, solidAreaDefaultY;
    // public boolean collisionOn = false; // phần collision 
    public int actionLockCounter = 0;

    public Entity(GamePanel gp) {
        this.gp = gp;

    }

    // NPC movement
    public void setAction() {

    }

    public void update() {
        setAction();

        // collisionOn = false;
        // gp.cChecker.checkTile(this);// collision checker created in GamePanel thuộc phần Collision

        // if (collisionOn == false) {
        switch (direction) {
            case "up":
                y -= speed;
                break;
            case "down":
                y += speed;
                break;
            case "left":
                x -= speed;
                break;
            case "right":
                x += speed;
                break;
        }
        // }

        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = x - gp.player.x + gp.player.screenX;
        int screenY = y - gp.player.y + gp.player.screenY;

        if (x + gp.tileSize > gp.player.x - gp.player.screenX &&
                x - gp.tileSize < gp.player.x + gp.player.screenX &&
                y - gp.tileSize > gp.player.y + gp.player.screenY &&
                y - gp.tileSize < gp.player.y + gp.player.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
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

            }

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }

    }

    public BufferedImage setup(String imagePath) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResource(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize); //
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
