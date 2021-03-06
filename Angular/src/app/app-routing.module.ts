import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AuthGuard } from './security/auth.guards';

const routes: Routes = [{
  path: '', component: HomeComponent, canActivate: [AuthGuard]
},
{ path: 'about', component: AboutComponent }, {
  path: 'contact', component: ContactComponent
}, {
path: 'login', component: LoginComponent
}, {
path: 'register', component: RegistrationComponent
}, {
path: '**', redirectTo: ''
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
