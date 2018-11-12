package com.Julian.game.level.tiles;

import com.Julian.game.gfx.Colors;
import com.Julian.game.gfx.Screen;
import com.Julian.game.level.Level;

import com.Julian.game.level.tiles.Tile;
import com.Julian.game.level.tiles.TreeTile;

import com.Julian.game.level.tiles.BushTile;

public abstract class Tile {

	// 256 is the maximum amount of tiles that can be in the board
	public static final Tile[] tiles = new Tile[256];
	
	public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colors.get(000, -1, -1, -1), 0xFF000000);
	public static final Tile STONE = new BasicSolidTile(1, 1, 0, Colors.get(-1, 222, -1, -1), 0xFF555555);
	public static final Tile STONE_GROUND = new BasicTile(2, 1, 0, Colors.get(-1, 333, -1, -1), 0xFF777777);
	public static final Tile GRASS = new BasicTile(3, 2, 0, Colors.get(-1, 141, 151, -1), 0xFF00FF00);
	public static final Tile WATER = new AnimatedTile(4, new int[][] {{0, 5}, {1, 5}, {2,5}, {1,5}}, Colors.get(-1, 004, 115, -1), 0xFF0000FF, 1000);
	public static final Tile SAND = new BasicTile(5, 4, 0, Colors.get(-1, 538, 549, -1), 0xFFF9EE95);
	public static final Tile TREE = new TreeTile(6, 5, 0, Colors.get(141, 311, 322, 351), 0xFF8a5809);
	public static final Tile BUSH = new BushTile(8, 3, 0, Colors.get(141, -1, 121, 131), 0xFF42b042);
	
	protected byte id;
	// Collision detection
	protected boolean solid;
	// Light
	protected boolean emitter;
	// This is the color ID for image to tile.
	private int levelImageColor;

	public Tile(int id, boolean isSolid, boolean isEmitter, int levelImageColor) {
        this.id = (byte) id;
        if (tiles[id] != null) {
                throw new RuntimeException("Duplicate tile id on " + id);
        }
        this.solid = isSolid;
        this.emitter = isEmitter;
        this.levelImageColor = levelImageColor;
        tiles[id] = this;
}

	public byte getId() {
		return id;
	}

	public boolean isSolid() {
		return solid;
	}

	public boolean isEmitter() {
		return emitter;
	}

	public int getLevelImageColor() {
		return levelImageColor;
	}
	
	public abstract void tick();
	
	public abstract void render(Screen screen, Level level, int x, int y, boolean flipX, boolean flipY);

}
