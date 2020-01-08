import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http:HttpClient) { }


  public doRegistration(bank){
    return this.http.post("http://localhost:8085/bank/save",bank,{responseType:'text' as 'json'}); 
  }

  public getBank(){ 
    return this.http.get("http://localhost:8086/bank/getallbank");
  }

  public getBankById(id){
    console.log("service called");
    let bankdetails=null;
     bankdetails= this.http.get("http://localhost:8086/bank/findbankbyid/"+id); 
     if(bankdetails==null){
       return "bank not present";
     }else{
       return bankdetails;
     } 
  }

  public deleteBank(id){
    return this.http.get("http://localhost:8085/bank/delete/"+id); 
  }

}
