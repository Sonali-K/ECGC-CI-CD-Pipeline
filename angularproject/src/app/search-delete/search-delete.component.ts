import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit {

  banks:any;
  message:any
  bank1:any
  isLoggedIn = true;
  constructor(private service:UserRegistrationService) { }

  ngOnInit() {
   let resp=this.service.getBank();
   resp.subscribe((data)=>this.banks=data);
  }

  public getBankById(id){
    console.log("function called")
    let response=this.service.getBankById(id);
    response.subscribe((data)=>this.bank1=data);
   
  }

  public deleteBank(id){
    let response=this.service.deleteBank(id);
    response.subscribe((data)=>this.message=data);
    let resp=this.service.getBank();
   resp.subscribe((data)=>this.banks=data);
  }
}
