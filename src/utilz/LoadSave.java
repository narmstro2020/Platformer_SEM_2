package utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entities.Crabby;
import main.Game;

public class LoadSave {

    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
    //	public static final String LEVEL_ONE_DATA = "level_one_data.png";
    public static final String LEVEL_ONE_DATA = "level_one_data_long.png";
    public static final String MENU_BUTTONS = "button_atlas.png";
    public static final String MENU_BACKGROUND = "menu_background.png";
    public static final String PAUSE_BACKGROUND = "pause_menu.png";
    public static final String SOUND_BUTTONS = "sound_button.png";
    public static final String URM_BUTTONS = "urm_buttons.png";
    public static final String VOLUME_BUTTONS = "volume_buttons.png";
    // TODO: add a String MENU_BACKGROUND_IMG and assign "background_menu.png" to it.
    // TODO: you should make sure that this file is in the res folder if not download it.
    // TODO: (2025-02-04): add a String PLAYING_BG_IMG and assign "playing_bg_img.png" to it
    // TODO: (2025-02-04): add a String BIG_CLOUDS and assign "big_clouds.png" to it
    // TODO: (2025-02-04): add a String SMALL_CLOUDS and assign "small_clouds.png" to it
    // TODO: (2025-02-06): add a String CRABBY_SPRITE and assign "crabby_sprite.png" to it


    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static ArrayList<Crabby> GetCrabs() {
        // TODO: (2025-02-06):  create a BufferedImage named img and assign GetSpriteAtlas(LEVEL_ONE_DATA) to it
        // TODO: (2025-02-06): create a new ArrayList<Crabby> named list and assign new ArrayList<>() to it.
        // TODO: (2025-02-06): start of a double nested for loop
        // outer for loop starts at 0 ends when less than img.getHeight(), increments by one each time, use j for variable
        // inner for loop starts at 0 ends when less than img.getWidth(), increments by one each time, use i for variable
        // TODO: (2025-02-06): create a Color named color and get from new Color(img.getRGB(i, j)
        // TODO: (2025-02-06): create an int named value and assign color.getGreen() to it
        // TODO: (2025-02-06): start of if statement
        // check if the value is equal to CRABBY
        // when true add new Crabby(i * Game.TILES_SIZE, j * Game.TILES_SIZE) to the list
        // TODO: (2025-02-06): end of if statement
        // TODO: (2025-02-06): end of the double nested for loop
        // TODO: (2025-02-06: return list
    }

    public static int[][] GetLevelData() {
        // TODO: double check that you code matches this one.  Some of you may not have
        // gotten this far the other day.
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
        int[][] lvlData = new int[img.getHeight()][img.getWidth()];
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if (value >= 48)
                    value = 0;
                lvlData[j][i] = value;
            }
        return lvlData;

    }
}
