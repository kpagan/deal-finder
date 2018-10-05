import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort } from '@angular/material';
import { DealTableDataSource } from './deal-table-datasource';

@Component({
  selector: 'app-deal-table',
  templateUrl: './deal-table.component.html',
  styleUrls: ['./deal-table.component.css']
})
export class DealTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource: DealTableDataSource;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'name'];

  ngOnInit() {
    this.dataSource = new DealTableDataSource(this.paginator, this.sort);
  }
}
