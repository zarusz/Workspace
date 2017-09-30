/**
 * Two dimensional Matrix implementation that stores the values as one continuous array.
 */
export class Matrix2<T> {

    private arr: Array<T>;

    constructor(private rows: number, private columns: number) {
        this.arr = new Array<T>(rows * columns);
    }

    get numRows(): number {
        return this.rows;
    }

    get numColumns(): number {
        return this.columns;
    }

    getValue(i: number, j: number): T {
        return this.arr[this.columns * i + j];
    }

    setValue(i: number, j: number, value: T) {
        this.arr[this.columns * i + j] = value;
    }
}
