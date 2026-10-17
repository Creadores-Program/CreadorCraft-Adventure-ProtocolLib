export class Vector2 {
    public x: number;
    public y: number;

    public static readonly ZERO = new Vector2(0, 0);
    public static readonly UNIT_X = new Vector2(1, 0);
    public static readonly UNIT_Y = new Vector2(0, 1);
    public static readonly ONE = new Vector2(1, 1);

    constructor(x: number = 0, y: number = 0) {
        this.x = x;
        this.y = y;
    }

    public set(x: number, y: number): this;
    public set(v: Vector2): this;
    public set(xOrVector: number | Vector2, y?: number): this {
        if (typeof xOrVector === 'number') {
            this.x = xOrVector;
            this.y = y ?? 0;
        } else {
            this.x = xOrVector.x;
            this.y = xOrVector.y;
        }
        return this;
    }

    public getFloorX(): number {
        return Math.floor(this.x);
    }

    public getFloorY(): number {
        return Math.floor(this.y);
    }

    public ceil(): this {
        this.x = Math.ceil(this.x);
        this.y = Math.ceil(this.y);
        return this;
    }

    public floor(): this {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        return this;
    }

    public round(): this {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        return this;
    }

    public abs(): this {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        return this;
    }

    public negate(): this {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }

    public add(x: number, y: number): this;
    public add(v: Vector2): this;
    public add(xOrVector: number | Vector2, y?: number): this {
        if (typeof xOrVector === 'number') {
            this.x += xOrVector;
            this.y += (y ?? 0);
        } else {
            this.x += xOrVector.x;
            this.y += xOrVector.y;
        }
        return this;
    }

    public sub(x: number, y: number): this;
    public sub(v: Vector2): this;
    public sub(xOrVector: number | Vector2, y?: number): this {
        if (typeof xOrVector === 'number') {
            this.x -= xOrVector;
            this.y -= (y ?? 0);
        } else {
            this.x -= xOrVector.x;
            this.y -= xOrVector.y;
        }
        return this;
    }

    public mul(scalar: number): this;
    public mul(x: number, y: number): this;
    public mul(scalarOrX: number, y?: number): this {
        if (y !== undefined) {
            this.x *= scalarOrX;
            this.y *= y;
        } else {
            this.x *= scalarOrX;
            this.y *= scalarOrX;
        }
        return this;
    }

    public div(scalar: number): this;
    public div(x: number, y: number): this;
    public div(scalarOrX: number, y?: number): this {
        if (y !== undefined) {
            this.x /= scalarOrX;
            this.y /= y;
        } else {
            this.x /= scalarOrX;
            this.y /= scalarOrX;
        }
        return this;
    }

    public dot(v: Vector2): number {
        return this.x * v.x + this.y * v.y;
    }

    public lengthSquared(): number {
        return this.x * this.x + this.y * this.y;
    }

    public length(): number {
        return Math.sqrt(this.lengthSquared());
    }

    public normalize(): this {
        const len = this.length();
        if (len !== 0) {
            this.x /= len;
            this.y /= len;
        }
        return this;
    }

    public distanceSquared(v: Vector2): number {
        const dx = this.x - v.x;
        const dy = this.y - v.y;
        return dx * dx + dy * dy;
    }

    public distance(v: Vector2): number {
        return Math.sqrt(this.distanceSquared(v));
    }

    public static createDirectionRad(angle: number): Vector2 {
        return new Vector2(Math.cos(angle), Math.sin(angle));
    }

    public static createDirectionDeg(angle: number): Vector2 {
        return Vector2.createDirectionRad(angle * (Math.PI / 180));
    }

    public clone(): Vector2 {
        return new Vector2(this.x, this.y);
    }

    public toString(): string {
        return `(${this.x}, ${this.y})`;
    }
}