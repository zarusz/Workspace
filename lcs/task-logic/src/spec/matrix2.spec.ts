import {Matrix2} from '../lib/matrix2';
import {expect} from 'chai';

describe('Matrix2', () => {
    let subject: Matrix2<number> = new Matrix2<number>(3, 2);

    beforeEach(() => {
        //subject = new Matrix2<number>(3, 2);
    });

    it('after creation has proper dimensions', () => {
        expect(subject.numRows).to.equal(3);
        expect(subject.numColumns).to.equal(2);
    });

    describe('#getValue', () => {
        // arrange
        let v = 1;
        for (let i = 0; i < subject.numRows; i++)
            for (let j = 0; j < subject.numColumns; j++)
                subject.setValue(i, j, v++);

        it('retrieves from proper cell', () => {
            expect(subject.getValue(0, 0)).to.equal(1);
            expect(subject.getValue(1, 0)).to.equal(subject.numColumns + 1);
            expect(subject.getValue(0, 1)).to.equal(2);
            expect(subject.getValue(1, 1)).to.equal(subject.numColumns + 2);
            expect(subject.getValue(subject.numRows-1, subject.numColumns-1)).to.equal(subject.numRows * subject.numColumns);
        });
    });
});