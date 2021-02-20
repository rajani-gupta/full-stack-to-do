import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegistrationformComponent} from './registrationform/registrationform.component';
import {StuctureComponent} from './stucture/stucture.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import { ViewRegisterFormComponent } from './registrationform/view-register-form/view-register-form.component';
import { EditRegisterFormComponent } from './registrationform/edit-register-form/edit-register-form.component';
import { CreateRegisterFormComponent } from './registrationform/create-register-form/create-register-form.component';

const routes: Routes = [
 
  {path:'main-page',component:StuctureComponent},
  {path:'register',component:CreateRegisterFormComponent},
  {path:'view/:id',component:ViewRegisterFormComponent},
  {path:'edit/:id',component:EditRegisterFormComponent},
  { path: '',   redirectTo: 'main-page', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
