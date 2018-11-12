package com.Julian.game.level.tiles;

import com.Julian.game.gfx.Screen;
import com.Julian.game.level.Level;

public class TreeTile extends Tile {

	protected int tileId;
	protected int tileColor;
	
	public TreeTile(int id, int x, int y, int tileColor, int levelColor) {
		super(id, true, false, levelColor);
		this.tileColor = tileColor;
		this.tileId = x + y * 32;
		this.solid = true;
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Screen screen, Level level, int x, int y, boolean flipX, boolean flipY) {
		screen.render (x- 4, y - 8, tileId + 1, tileColor, false, false, 1);
		screen.render (x + 4, y - 8, tileId + 1, tileColor, true, false, 1);
		screen.render (x, y, tileId + 1 * 33, tileColor, false, false, 1);		
	}
}
