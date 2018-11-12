package com.Julian.game.net.packets;

import java.util.Arrays;

//import com.Julian.game.level.tiles.Tile;
import com.Julian.game.net.GameClient;
import com.Julian.game.net.GameServer;

public class Packet05ChunkData extends Packet {

	int[] xPositions;
	int[] yPositions;
	int[] tileIds;
	
	
	public Packet05ChunkData(byte[] data) {
		super(05);
		String[] dataArray = readData(data).split("|");
		//String xPositionStringData = dataArray[0];
		
		for (int i = 0; i < dataArray[0].length(); i += 1) {
			
		}
	}
	
	public Packet05ChunkData(int[] xPositions, int[] yPositions, int[] tileIds) {
		super(05);
		this.xPositions = xPositions;
		this.yPositions = yPositions;
		this.tileIds = tileIds;
	}

	@Override
	public void writeData(GameClient client) {
		client.sendData(getData());
	}

	@Override
	public void writeData(GameServer server) {
		server.sendDataToAllClients(getData());
	}

	@Override
	public byte[] getData() {
		return ("05" + Arrays.toString(xPositions) + "|" + Arrays.toString(yPositions) + "|" + Arrays.toString(tileIds)).getBytes();
	}
	
	public int[] getXPositions() {
		return this.xPositions;
	}
	
	public int[] getYPositions() {
		return this.yPositions;
	}
	
	public int[] getTileIds() {
		return this.tileIds;
	}

}
