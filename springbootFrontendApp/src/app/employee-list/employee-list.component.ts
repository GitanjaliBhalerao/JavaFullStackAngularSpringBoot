import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent {

  employees:Employee[]=[];

  constructor(private empService:EmployeeService,private router:Router){}

  ngOnInit():void{
    this.getEmployees();
  }

  private getEmployees()
  {
      this.empService.getEmployeeList().subscribe(
        data=>{
          this.employees=data;
        });
  }

  employeeDetails(id:number)
  {
    this.router.navigate(['employee-details',id]);
  }

  updateEmployee(id:number)
  {
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id:number)
  {
    this.empService.deleteEmployee(id).subscribe(
      data =>{
        console.log(data);
        this.getEmployees();
      }
    );
  }

}
