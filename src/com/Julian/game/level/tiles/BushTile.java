package com.Julian.game.level.tiles;

public class BushTile extends Tile {

	protected int tileId;
	protected int tileColor;
	
	public BushTile(int id, int x, int y, int tileColor, int levelColor) {
		super(id, true, false, levelColor);
		this.tileColor = tileColor;
		this.tileId = x + y * 32;
		this.solid = false;
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(com.Julian.game.gfx.Screen screen, com.Julian.game.level.Level level, int x, int y,
			boolean flipX, boolean flipY) {
		screen.render(x, y, tileId, tileColor, true, false, 1);
		screen.render(x - 8, y, tileId, tileColor, false, false, 1);		
	}

}
