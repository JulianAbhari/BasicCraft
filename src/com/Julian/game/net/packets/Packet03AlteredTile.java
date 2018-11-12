package com.Julian.game.net.packets;

import com.Julian.game.level.tiles.Tile;
import com.Julian.game.net.GameClient;
import com.Julian.game.net.GameServer;

public class Packet03AlteredTile extends Packet {
	int x, y;
	int tileId;
	
	public Packet03AlteredTile(byte[] data) {
		super(03);
		String[] dataArray = readData(data).split(",");
		this.x = Integer.parseInt(dataArray[0]);
		this.y = Integer.parseInt(dataArray[1]);
		this.tileId = Integer.parseInt(dataArray[2]);
	}
	
	public Packet03AlteredTile(int x, int y, Tile tile) {
		super(03);
		this.x = x;
		this.y = y;
		this.tileId = tile.getId();
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
		return ("03" + getX() + "," + getY() + "," + getTileId()).getBytes();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getTileId() {
		return this.tileId;
	}

}
