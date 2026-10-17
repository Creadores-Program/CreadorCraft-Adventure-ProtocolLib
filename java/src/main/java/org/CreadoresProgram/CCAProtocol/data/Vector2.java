package org.CreadoresProgram.CCAProtocol.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vector2 implements Cloneable {
    public float x;
    public float y;

    public static final Vector2 ZERO = new Vector2(0, 0);
    public static final Vector2 UNIT_X = new Vector2(1, 0);
    public static final Vector2 UNIT_Y = new Vector2(0, 1);
    public static final Vector2 ONE = new Vector2(1, 1);

    public Vector2 set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2 set(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
        return this;
    }

    public int getFloorX() {
        return (int) Math.floor(this.x);
    }

    public int getFloorY() {
        return (int) Math.floor(this.y);
    }

    public Vector2 ceil() {
        this.x = (float) Math.ceil(this.x);
        this.y = (float) Math.ceil(this.y);
        return this;
    }

    public Vector2 floor() {
        this.x = (float) Math.floor(this.x);
        this.y = (float) Math.floor(this.y);
        return this;
    }

    public Vector2 round() {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        return this;
    }

    public Vector2 abs() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    public Vector2 negate() {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public Vector2 add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2 add(Vector2 v) {
        return add(v.x, v.y);
    }

    public Vector2 sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2 sub(Vector2 v) {
        return sub(v.x, v.y);
    }

    public Vector2 mul(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    public Vector2 mul(float x, float y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    public Vector2 div(float scalar) {
        this.x /= scalar;
        this.y /= scalar;
        return this;
    }

    public Vector2 div(float x, float y) {
        this.x /= x;
        this.y /= y;
        return this;
    }

    public float dot(Vector2 v) {
        return this.x * v.x + this.y * v.y;
    }

    public float lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }

    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public Vector2 normalize() {
        float len = length();
        if (len != 0) {
            this.x /= len;
            this.y /= len;
        }
        return this;
    }

    public float distanceSquared(Vector2 v) {
        float dx = this.x - v.x;
        float dy = this.y - v.y;
        return dx * dx + dy * dy;
    }

    public float distance(Vector2 v) {
        return (float) Math.sqrt(distanceSquared(v));
    }

    public static Vector2 createDirectionRad(float angle) {
        return new Vector2((float) Math.cos(angle), (float) Math.sin(angle));
    }

    public static Vector2 createDirectionDeg(float angle) {
        return createDirectionRad((float) Math.toRadians(angle));
    }

    @Override
    public Vector2 clone() {
        try {
            return (Vector2) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Vector2(this.x, this.y);
        }
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}