import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateAlertComponent } from './create-alert/create-alert.component';
import { AccountComponent } from './account/account.component';
import { SignoutComponent } from './signout/signout.component';
import { DealDashboardComponent } from './deal-dashboard/deal-dashboard.component';


const appRoutes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: DealDashboardComponent },
    { path: 'create', component: CreateAlertComponent },
    { path: 'account', component: AccountComponent },
    { path: 'signout', component: SignoutComponent }
  ];

@NgModule({
  imports: [ RouterModule.forRoot(appRoutes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {

}