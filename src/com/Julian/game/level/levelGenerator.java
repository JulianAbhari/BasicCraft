package com.Julian.game.level;

import com.Julian.game.level.OpenSimplexNoise;
import com.Julian.game.level.tiles.Tile;

public class levelGenerator {

	static int HEIGHT = Level.height;
	static int WIDTH = Level.width;
	static int y;
	static int x;

	public static void generateLevel(float FEATURE_SIZE) {
		
		OpenSimplexNoise noise = new OpenSimplexNoise();
		double value;
		
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				value = noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 0.0);
				
				if (value >= 0.535) {
					Level.tiles[x + y * WIDTH] = Tile.STONE_GROUND.getId();
				}
				
				else if (value >= 0.49) {
					Level.tiles[x + y * WIDTH] = Tile.STONE.getId();
				}
				
				else if ((value >= 0.43) && (value <= 0.435)) {
					Level.tiles[x + y * WIDTH] = Tile.TREE.getId();
				}
				
				else if ((value >= 0.23) && (value <= 0.235)) {
					Level.tiles[x + y * WIDTH] = Tile.BUSH.getId();
				}
				
				else if (value >= 0.2) {
					Level.tiles[x + y * WIDTH] = Tile.GRASS.getId();
				}

				else if (value >= 0) {
					Level.tiles[x + y * WIDTH] = Tile.SAND.getId();
				}
				else {
					Level.tiles[x + y * WIDTH] = Tile.WATER.getId();
				}
				
			}
		}
	}
}
