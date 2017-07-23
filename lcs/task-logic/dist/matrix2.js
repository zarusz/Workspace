/**
 * Created by tmaruszak on 22/07/2017.
 */
/**
 * Two dimensional Matrix implementation that stores the values as one continuous array.
 */
var Matrix2 = (function () {
    function Matrix2(w, h) {
        this.w = w;
        this.arr = new Array(w * h);
    }
    Matrix2.prototype.getValue = function (i, j) {
        return this.arr[this.w * i + j];
    };
    Matrix2.prototype.setValue = function (i, j, value) {
        this.arr[this.w * i + j] = value;
    };
    return Matrix2;
}());
export { Matrix2 };
//# sourceMappingURL=matrix2.js.map