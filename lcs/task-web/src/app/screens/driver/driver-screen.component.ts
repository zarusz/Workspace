import {Component, OnInit} from '@angular/core';
import {DynamicLCSCalculator} from "../../../../../task-logic/src/lib/lcs-calculator-dynamic";
import {ILCSCalculator} from "../../../../../task-logic/src/lib/lcs-calculator";

class ResultCase {

  constructor(public a: string, public b: string, public r: string) {
  }
}

@Component({
  selector: 'app-driver-screen',
  templateUrl: './driver-screen.component.html',
  styleUrls: ['./driver-screen.component.css']
})
export class DriverScreenComponent implements OnInit {

  a: string;
  b: string;
  cases: Array<ResultCase> = [];

  calculator: ILCSCalculator = new DynamicLCSCalculator();

  constructor() {
  }

  ngOnInit() {
  }

  doCalculate(a: string, b: string) {
    if (a && b) {
      let r = this.calculator.calculate(a, b);
      this.cases.unshift(new ResultCase(a, b, r))
    }
  }
}
