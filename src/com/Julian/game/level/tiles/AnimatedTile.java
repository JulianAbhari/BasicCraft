package com.Julian.game.level.tiles;

public class AnimatedTile extends BasicTile {

	private int[][] animationTileCoords;
	private int currentAnimationIndex;
	private long lastIterationTime;
	private int animationSwitchDelay;
	
	public AnimatedTile(int id, int[][] animationTileCoords, int tileColor, int levelImageColor, int animationSwitchDelay) {
		super(id, animationTileCoords[0][0], animationTileCoords[0][1], tileColor, levelImageColor);
		this.animationTileCoords = animationTileCoords;
		this.currentAnimationIndex = 0;
		this.lastIterationTime = System.currentTimeMillis();
		this.animationSwitchDelay = animationSwitchDelay;
		
	}

	public void tick() {
		if ((System.currentTimeMillis() - lastIterationTime) >= animationSwitchDelay) {
			lastIterationTime = System.currentTimeMillis();
			currentAnimationIndex = (currentAnimationIndex += 1) % animationTileCoords.length;
			this.tileId = (animationTileCoords[currentAnimationIndex][0] + (animationTileCoords[currentAnimationIndex][1] * 32));
		}
	}
}
