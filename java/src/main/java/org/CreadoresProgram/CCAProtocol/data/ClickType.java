package org.CreadoresProgram.CCAProtocol.data;

public enum ClickType{
    LEFT(0x01),
    RIGHT(0x02);

    private final int type;

    ClickType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    public static ClickType fromType(int typeI){
        for (ClickType type : values()) {
            if (type.type == typeI) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown Click Type: 0x" + Integer.toHexString(code));
    }
}