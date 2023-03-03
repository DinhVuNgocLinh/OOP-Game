package main;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int orignialTileSize = 16;
    final int scale = 3;
    public final int tileSize = orignialTileSize * scale; // 48 X48 tile
    public final int maxScreenCol = 16;// horizontal
    public final int maxScreenRow = 16; // vertical
    public final int screenWidth = tileSize * maxScreenRow; // 768 pixel
    public final int screenHeight = tileSize * maxScreenCol;//
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;// to start and stop the game whenever you want to
// set player default position
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;
    int FPS=60;

    //	ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public Entity npc[] = new Entity[10];// this is npc array
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setVisible(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame() {
//    	aSetter.setNPC();
    	
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

     double drawinterval=1000000000/FPS;
     double delta=0;
     long lasttime=System.nanoTime();
     long currenTime;
     long time=0;
     int DrawCount=0;
     while(gameThread!=null){
         currenTime=System.nanoTime();
         delta+=(currenTime-lasttime)/drawinterval;
         lasttime=currenTime;
         if(delta>=1){
             update();
             repaint();
             delta--;
             DrawCount++;
             time+=(currenTime-lasttime);
         } if (time>=1000000000){
             System.out.println("Fps"+DrawCount);
             DrawCount=0;
             time=0;
         }

     }
    }
    public void update(){
        if(keyH.upPressed){
            playerY=playerY-playerSpeed;
        }
        if(keyH.downPressed){
            playerY=playerY+playerSpeed;
        }
        if(keyH.rightPressed){
            playerX=playerX-playerSpeed;
        }
        if(keyH.leftPressed){
            playerX=playerX+playerSpeed;
        }
        
        for (int i = 0; i < npc.length; i++) {
        	if (npc[i] != null) {
        		npc[i].update();
        	}
        }


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g; // change graphics g-> graphics 2D
        g2.setColor(Color.RED);
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();

        
        // NPC
        for (int i = 0; i < npc.length; i++) { 
        	if (npc[i] != null) {
        		npc[i].draw(g2);
        	}
        }

    }
}


