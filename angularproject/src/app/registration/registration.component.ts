import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';
import { Bank } from '../bank';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

bank: Bank=new Bank(0,"","","","","");
message:any;

  constructor(private service:UserRegistrationService) { }

  ngOnInit() {
  }

public registerNow(){
    console.log(this.bank)
    let response=this.service.doRegistration(this.bank);
    response.subscribe((data)=>this.message=data);
}

public getBank(){
  let response=this.service.getBank();
  response.subscribe((data)=>this.message=data);
}

public deleteBank(id){
  let response=this.service.deleteBank(id);
  response.subscribe((data)=>this.message=data);
}
}

