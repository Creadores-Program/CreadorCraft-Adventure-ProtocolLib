package org.CreadoresProgram.CCAProtocol.data;

public enum Weather{
    CLEAR(0x01),
    RAIN(0x02),
    SNOWY(0x03);

    private final int weatherId;

    Weather(int weatherId){
        this.weatherId = weatherId;
    }

    public int getId(){
        return this.weatherId;
    }

    public static Weather fromId(int weatherId) {
        for (Weather type : values()) {
            if (type.weatherId == weatherId) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown Weather Id: 0x" + Integer.toHexString(code));
    }
}