package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import levels.LevelManager;
import main.Game;
import ui.PauseOverlay;
import utilz.LoadSave;

import static utilz.Constants.UI.Environment.*;

public class Playing extends State implements Statemethods {
	private Player player;
	private LevelManager levelManager;
	// TODO: (2025-02-06): add an EnemyManager named enemyManager
	private PauseOverlay pauseOverlay;
	private boolean paused = false;

	// TODO: add an int field named xLvlOffset
	// TODO: add an int field named leftBorder and assign (int) (0.2 * Game.GAME_WIDTH) to it
	// TODO: add an int field named rightBorder and assign (int) (0.8 * Game.GAME_WIDTH) to it
	// TODO: add an int field named lvlTilesWide and assign to LoadSave.GetLevelData()[0].length
	// TODO: add an int field named maxTilesOffset and assign lvlTilesWide - Game.TILES_IN_WIDTH to it
	// TODO: add an int field named maxLvlOffsetX and assign maxTilesOffset * Game.TILE_SIZE to it

	// TODO: (2025-02-04): add a BufferedImage named backgroundImg, bigCloud, smallCloud
	// TODO: (2025-02-04): add an int[] named smallCloudPos
	// TODO: (2025-02-04): Add a Random named rnd and intiailize to new Random();

	public Playing(Game game) {
		super(game);
		initClasses();

		// TODO: (2025-02-04): Make sure to copy this.
		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.PLAYING_BG_IMG);
		bigCloud = LoadSave.GetSpriteAtlas(LoadSave.BIG_CLOUDS);
		smallCloud = LoadSave.GetSpriteAtlas(LoadSave.SMALL_CLOUDS);
		smallCloudsPos = new int[8];
		for (int i = 0; i < smallCloudsPos.length; i++)
			smallCloudsPos[i] = (int) (90 * Game.SCALE) + rnd.nextInt((int) (100 * Game.SCALE));
		// TODO: (2025-02-04): Make sure to copy this end.
	}

	private void initClasses() {
		levelManager = new LevelManager(game);
		// TODO: (2025-02-06): assign new EnemyManager(this) to enemyManager
		player = new Player(200, 200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		pauseOverlay = new PauseOverlay(this);
	}

	@Override
	public void update() {
		if (!paused) {
			levelManager.update();
			player.update();
			// TODO: (2025-02-06): called enemyManager.update()
			checkCloseToBorder();  // TODO: (2025-02-06):  Add this
		} else {
			pauseOverlay.update();
		}
	}

	// TODO:  add the commented out code here
	// private void checkCloseToBorder() {
	// 	int playerX = (int) player.getHitbox().x;
	// 	int diff = playerX - xLvlOffset;
	// 	if (diff > rightBorder)
	// 		xLvlOffset += diff - rightBorder;
	// 	else if (diff < leftBorder)
	// 		xLvlOffset += diff - leftBorder;
	// 	if (xLvlOffset > maxLvlOffsetX)
	// 		xLvlOffset = maxLvlOffsetX;
	// 	else if (xLvlOffset < 0)
	// 		xLvlOffset = 0;
	// }

	@Override
	public void draw(Graphics g) {
		// TODO: (2025-02-04): call g.drawImage() passing in backgroundIMg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null

		// TODO: (2025-02-04): call drawClouds() passing in g

		levelManager.draw(g); // TODO: also pass in xLvlOffset
		player.render(g); // TODO: also pass in xLvlOffset
		// TODO: (2025-02-06):  call enemyManger's draw method pasing in g and xLvlOffset

		if (paused) {
			// TODO: call g.setColor and pass in a new Color(0, 0, 0, 150)
			// TODO: call g.fillRect and pass in 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT
			pauseOverlay.draw(g);
		}
	}

	public void drawClouds(Graphics g) {

		// TODO: (2025-02-04): for loop from int i = 0; i < 3; i++
		// TODO: (2025-02-04): call g.drawImage() passing in bigCloud, i * BIG_CLOUD_WIDTH - (int) (xLvlOffset * 0.3), (int) (204 * Game.SCALE), BIG_CLOUD_WIDTH, BIG_CLOUD_HEIGHT, null

		// TODO: (2025-02-04): for loop from int i = 0; i < smallCloudsPos.length; i++
		// TODO: (2025-02-04): call g.drawImage() passing in smallCloud, SMALL_CLOUD_WIDTH * 4 * i - (int) (xLvlOffset * 0.7), smallCloudsPos[i], SMALL_CLOUD_WIDTH, SMALL_CLOUD_HEIGHT, null

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			player.setAttacking(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_SPACE:
			player.setJump(true);
			break;
		case KeyEvent.VK_ESCAPE:
			paused = !paused;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			player.setJump(false);
			break;
		}

	}

	public void mouseDragged(MouseEvent e) {
		if (paused)
			pauseOverlay.mouseDragged(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (paused)
			pauseOverlay.mousePressed(e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (paused)
			pauseOverlay.mouseReleased(e);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (paused)
			pauseOverlay.mouseMoved(e);

	}

	public void unpauseGame() {
		paused = false;
	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}

}
