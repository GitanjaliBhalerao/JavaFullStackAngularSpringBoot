import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-employee',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css'
})
export class CreateEmployeeComponent {

  employee:Employee=new Employee();

  constructor(private empService:EmployeeService,private router:Router){

  }

  saveEmployee()
  {
    this.empService.createEmployee(this.employee).subscribe(
      data=>{
        console.log(data);
        this.goToEmployeeList();
      }
    );
  }

  goToEmployeeList()
  {
    this.router.navigate(['/employees']);
  }

  onSubmit()
  {
    this.saveEmployee();
    console.log(this.employee);
  }
}
