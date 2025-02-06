package entities;

import gamestates.Playing;

import java.awt.*;

public class EnemyManager {

    // TODO: (2025-02-06):  private fields to make
    // Playing named playing
    // BufferedImage[][] named crabbyArr
    // ArrayList<Crabby> named crabbies and initialized to new ArrayList<>()

    public EnemyManager(Playing playing){
        // TODO: (2025-02-06):
        // assign playing to this.playing
        // call loadEnemyImgs()
        // call addEnemies()
    }

    public void addEnemies(){
        // TODO: (2025-02-06):
        // assign LoadSave.GetCrabs() to crabbies
        // print "size of crabs: " + crabbies.size()
    }

    public void update(){
        // TODO: (2025-02-06):
        // start of for loop.
        // for var c : crabbies
        // call c.update()
        // end of for loop
    }

    public void draw(Graphics g, int xLvlOffset){
        // TODO: (2025-02-06):
        // call drawCrabs(g, xLvlOffset)
    }

    public void drawCrabs(Graphics g, int xLvlOffset){
        // TODO: (2025-02-06):
        // start of for loop
        // for var c : crabbies
        // call g.drawImage(crabbyArr[c.getEnemyState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset, (int) c.getHitbox().y, CRABBY_WIDTH, CRABBY_HEIGHT, null)
    }

    // TODO: (2025-02-06):
    private void loadEnemyImgs() {
        crabbyArr = new BufferedImage[5][9];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.CRABBY_SPRITE);
        for (int j = 0; j < crabbyArr.length; j++)
            for (int i = 0; i < crabbyArr[j].length; i++)
                crabbyArr[j][i] = temp.getSubimage(i * CRABBY_WIDTH_DEFAULT, j * CRABBY_HEIGHT_DEFAULT, CRABBY_WIDTH_DEFAULT, CRABBY_HEIGHT_DEFAULT);
    }
}
