import { Component, OnInit } from '@angular/core';
import { LoginService } from "../../services/login.service";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})

export class NavBarComponent implements OnInit {

  isLoggedIn = false;

  constructor(private loginService: LoginService) {}

  toggle(){
    this.isLoggedIn = !this.isLoggedIn;
  }

  ngOnInit(): void {
    this.loginService.checkSession().subscribe(
      res => {
        this.isLoggedIn = true;
      },
      error => {
        this.isLoggedIn = false;
      }
    );
  }
}
