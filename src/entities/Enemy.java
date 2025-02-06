package entities;

public class Enemy extends Entity {

    // TODO: (2025-02-06):
    // create private fields
    // an int named aniIndex, enemyState, enemyType
    // an int named aniTick, aniSpeed = 25

    public Enemy(float x, float y, int width, int height, int enemyType) {
        super(x, y, width, height);
        // TODO: (2025-02-06):
        // assign enemyType to this.enemyType
        // call initHitbox() passing in x, y, width, height
    }

    private void updateAnimationTick(){
        // TODO: (2025-02-06):
        // add 1 to aniTick
        // start of if statement
        // check if aniTick is greater than or equal to aniSpeed
        // when true do the following
        // set aniTick to 0
        // add 1 to aniIndex
        // start of if statement
        // check if aniIndex is greater than or equal to GetSpriteAmount(enemyType, enemyState)
        // when true set aniIndex to 0
        // end of if statement
        // end of if statement
    }

    // TODO: (2025-02-06):
    public void update() {
        updateAnimationTick();
    }

    // TODO: (2025-02-06):
    public int getAniIndex() {
        return aniIndex;
    }

    // TODO: (2025-02-06):
    public int getEnemyState() {
        return enemyState;
    }
}
