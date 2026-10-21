package org.CreadoresProgram.CCAProtocol.data;

import java.util.Arrays;

import lombok.Getter;

public class World {
    @Getter
    private final int maxX;
    private static final int maxY = 100;
    private final int[] worldData;

    public World(int maxX) {
        if (maxX < 50 || maxX > 500) {
            throw new IllegalArgumentException("maxX should be between 50 and 500. Current value: " + maxX);
        }
        
        this.maxX = maxX;
        this.worldData = new int[maxX * maxY];
        Arrays.fill(this.worldData, 0);
    }

    public World(int maxX, int[] worldData) {
        if (maxX < 50 || maxX > 500) {
            throw new IllegalArgumentException("maxX should be between 50 and 500. Current value: " + maxX);
        }
        
        int expectedLength = maxX * maxY;
        if (worldData == null || worldData.length != expectedLength) {
            throw new IllegalArgumentException(
                String.format("The size of the array does not match the protocol. Expected: %d, Received: %d", 
                expectedLength, (worldData != null ? worldData.length : 0))
            );
        }

        this.maxX = maxX;
        this.worldData = worldData.clone();
    }

    private int getIndex(Vector2 pos) {
        if (pos.getX() < 0 || pos.getX() >= maxX || pos.getY() < 0 || pos.getY() >= maxY) {
            throw new IndexOutOfBoundsException("Position outside the bounds of the world: " + pos);
        }
        return pos.getY() + (pos.getX() * maxY);
    }

    public void setBlock(Vector2 pos, int blockId) {
        int index = getIndex(pos);
        this.worldData[index] = blockId;
    }

    public int getBlock(Vector2 pos) {
        int index = getIndex(pos);
        return this.worldData[index];
    }

    public int[] getData() {
        return this.worldData;
    }
}