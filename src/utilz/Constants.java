package utilz;

import main.Game;

public class Constants {

	public static class UI {

		public static class EnemyConstants{
			// TODO: (2025-02-06): create the following
			// all are public static final
			// int named IDLE set to 0
			// int named RUNNING set to 1
			// int named ATTACK set to 2
			// int named HIT set to 3
			// int named DEAD set to 4

			// int named CRABBY_WIDTH_DEFAULT set to 72
			// int named CRABBY_HEIGHT_DEFAULT set to 32

			// int named CRABBY_WIDTH assign (int) (CRABBY_WIDTH_DEFAULT * Game.Scale)
			// int named CRABBY_HEIGHT assign (int) (CRABBY_HEIGHT_DEFAULT * Game.Scale)

			public static int GetSpriteAmount(int enemy_type, int enemy_state){
				switch (enemy_type){
					case CRABBY:
						switch(enemy_state){
							case IDLE -> return 9;
							// TODO: (2025-02-06): add cases for the following
							// RUNNING return 6, ATTACK return 7, HIT return 4, DEAD return 5
						}
				}

				return 0;
			}

		}

		public static class Environment {
			// TODO: (2025-02-04): all fields are public static final ints
			// TODO: (2025-02-04): BIG_CLOUD_WIDTH_DEFAULT assign 448 to it
			// TODO: (2025-02-04): BIG_CLOUD_HEIGHT_DEFAULT assign 101 to it
			// TODO: (2025-02-04): SMALL_CLOUD_WIDTH_DEFAULT assign 74 to it
			// TODO: (2025-02-04): SMALL_CLOUD_HEIGHT_DEFAULT assign 24 to it

			// TODO: (2025-02-04): BIG_CLOUD_WIDTH assign (int) (BIG_CLOUD_WIDTH_DEFAULT * Game.SCALE) to it
			// TODO: (2025-02-04): BIG_CLOUD_HEIGHT assign (int) (BIG_CLOUD_HEIGHT_DEFAULT * Game.SCALE) to it
			// TODO: (2025-02-04): SMALL_CLOUD_WIDTH assign (int) (SMALL_CLOUD_WIDTH_DEFAULT * Game.SCALE) to it
			// TODO: (2025-02-04): SMALL_CLOUD_HEIGHT assign (int) (SMALL_CLOUD_HEIGHT_DEFAULT * Game.SCALE) to it


		}

		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 140;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}

		public static class PauseButtons {
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
		}

		public static class URMButtons {
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);

		}

		public static class VolumeButtons {
			public static final int VOLUME_DEFAULT_WIDTH = 28;
			public static final int VOLUME_DEFAULT_HEIGHT = 44;
			public static final int SLIDER_DEFAULT_WIDTH = 215;

			public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
			public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
			public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);
		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int ATTACK_1 = 6;
		public static final int ATTACK_JUMP_1 = 7;
		public static final int ATTACK_JUMP_2 = 8;

		public static int GetSpriteAmount(int player_action) {
			switch (player_action) {
			case RUNNING:
				return 6;
			case IDLE:
				return 5;
			case HIT:
				return 4;
			case JUMP:
			case ATTACK_1:
			case ATTACK_JUMP_1:
			case ATTACK_JUMP_2:
				return 3;
			case GROUND:
				return 2;
			case FALLING:
			default:
				return 1;
			}
		}
	}

}
