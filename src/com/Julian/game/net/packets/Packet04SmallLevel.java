package com.Julian.game.net.packets;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.Julian.game.Game;
import com.Julian.game.net.GameClient;
import com.Julian.game.net.GameServer;

public class Packet04SmallLevel extends Packet {

	private String levelPath;
	private BufferedImage image;

	public Packet04SmallLevel(byte[] data) {
		super(04);
		String[] dataArray = readData(data).split(",");
		this.levelPath = dataArray[0];

		if (Game.socketServer == null) {
			String imageStringData = "";

			System.out.println("From byte constructor: " + dataArray.length);

			for (int i = 7; i < dataArray.length; i += 1) {
				if (i != dataArray.length - 1) {
					imageStringData += dataArray[i] + ",";
				} else {
					imageStringData += dataArray[i];
				}
			}

			System.out.println(imageStringData);

			String[] imageStringByteValues = imageStringData.substring(1, imageStringData.length() - 1).split(", ");
			byte[] imageBytes = new byte[imageStringByteValues.length];

			for (int i = 0, len = imageBytes.length; i < len; i++) {
				imageBytes[i] = Byte.parseByte(imageStringByteValues[i].trim());
			}

			this.image = createImageFromBytes(imageBytes);

		} else {
			this.image = Game.game.level.getImage();
		}

	}

	public Packet04SmallLevel(String username, int x, int y, int numSteps, boolean isMoving, int movingDir,
			String levelPath, BufferedImage image) {
		super(04);
		this.levelPath = levelPath;
		this.image = image;
	}

	private BufferedImage createImageFromBytes(byte[] imageData) {
		BufferedImage img;
		try {
			img = ImageIO.read(new ByteArrayInputStream(imageData));
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public byte[] extractBytes(BufferedImage image) throws IOException {
		BufferedImage originalImage = image;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "png", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();

		return imageInByte;
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
		try {
			return ("04" + this.levelPath + "," + Arrays.toString(extractBytes(this.image))).getBytes();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getLevelPath() {
		return this.levelPath;
	}

	public BufferedImage getImage() {
		return this.image;
	}

}
