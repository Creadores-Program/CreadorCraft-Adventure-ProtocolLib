package org.CreadoresProgram.CCAProtocol.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset implements Cloneable {
    
    private int id;
    private int version;
    private AssetType type;

    public enum AssetType {
        BLOCK(0x01),
        ENTITY(0x02),
        AUDIO(0x03),
        ITEM(0x04),
        SUN(0x05),
        MOON(0x06),
        CLICK_SOUND(0x07),
        DAY_CLOUD(0x08),
        NIGHT_CLOUD(0x09),
        RAIN_CLOUD(0x10),
        BACKGROUND(0x11),
        RUBY(0x12);

        private final int code;

        AssetType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static AssetType fromCode(int code) {
            for (AssetType type : values()) {
                if (type.code == code) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown AssetType: 0x" + Integer.toHexString(code));
        }
    }

    public Asset set(int id, int version, AssetType type) {
        this.id = id;
        this.version = version;
        this.type = type;
        return this;
    }

    @Override
    public Asset clone() {
        try {
            return (Asset) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Asset(this.id, this.version, this.type);
        }
    }

    @Override
    public String toString() {
        return "Asset{id='" + id + "', version=" + version + ", type=" + type + " (0x" + Integer.toHexString(type.getCode()) + ")}";
    }
}