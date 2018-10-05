import { Component, OnInit } from '@angular/core';
import { AlertModel } from './AlertModel';


@Component({
  selector: 'app-create-alert',
  templateUrl: './create-alert.component.html',
  styleUrls: ['./create-alert.component.css'],
})
export class CreateAlertComponent implements OnInit {

  alert: AlertModel;
  constructor() { }

  ngOnInit() {
    this.alert = new AlertModel();
  }

}
