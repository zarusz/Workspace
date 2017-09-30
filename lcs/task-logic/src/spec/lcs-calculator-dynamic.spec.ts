import {expect} from 'chai';
import {DynamicLCSCalculator} from "../lib/lcs-calculator-dynamic";

describe('DynamicLCSCalculator', () => {
    let subject: DynamicLCSCalculator = new DynamicLCSCalculator();

    beforeEach(() => {
    });

    it('when any string empty yelds empty string', () => {
        expect(subject.calculate('', 'ababa')).to.equal('');
        expect(subject.calculate('abab', '')).to.equal('');
        expect(subject.calculate('', '')).to.equal('');
    });

    it('when any string undefined yelds empty string', () => {
        expect(subject.calculate(undefined, 'abab')).to.equal('');
        expect(subject.calculate('abab', undefined)).to.equal('');
        expect(subject.calculate(undefined, undefined)).to.equal('');
    });

    it('when there is no common substring yelds empty string', () => {
        expect(subject.calculate('cdcdcd', 'abab')).to.equal('');
    });

    it('calculates common substring properly', () => {
        expect(subject.calculate('ab_abab_abababab_', '_abab_')).to.equal('_abab_');
        expect(subject.calculate('_abab_', 'ab_ab_ab_ab_ab_ab_ab_')).to.equal('_abab_');
        expect(subject.calculate('a2b_', 'ab_abab_abababab_')).to.equal('ab_');

        expect(subject.calculate('ABCDGH', 'AEDFHR')).to.equal('ADH');
        expect(subject.calculate('AGGTAB', 'GXTXAYB')).to.equal('GTAB');
    });
});