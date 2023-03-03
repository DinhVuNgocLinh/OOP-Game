package main;

import entity.NPC;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void setObject() {

    }

    public void setNPC() {
        gp.npc[0] = new NPC(gp);
        gp.npc[0].x = gp.tileSize * 21;
        gp.npc[0].y = gp.tileSize * 21;

    }

    public void setNPC_white() {
        gp.npc[0] = new NPC(gp);
        gp.npc[0].x = gp.tileSize * 27;
        gp.npc[0].y = gp.tileSize * 27;

    }

}
