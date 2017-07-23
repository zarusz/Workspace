/**
 * Created by tmaruszak on 22/07/2017.
 */
/**
 * Two dimensional Matrix implementation that stores the values as one continuous array.
 */
export declare class Matrix2<T> {
    private w;
    private arr;
    constructor(w: number, h: number);
    getValue(i: number, j: number): T;
    setValue(i: number, j: number, value: T): void;
}
