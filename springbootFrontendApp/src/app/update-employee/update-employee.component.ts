import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-employee',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent {

  employee:Employee=new Employee()
  id:number=0;

  constructor(private empService:EmployeeService,private route:ActivatedRoute ,private router:Router){ }

  ngOnInit()
  {
    this.id=this.route.snapshot.params['id'];

    this.empService.getEmployeeById(this.id).subscribe(
      data=>{
        this.employee=data;
      },error=>console.error(error)      
    );
  }
 

  goToEmployeeList()
  {
    this.router.navigate(['/employees']);
  }

  onSubmit()
  {
    this.empService.updateEmployee(this.id,this.employee).subscribe(
      data=>{
        console.log(data);
        this.goToEmployeeList();
      },error=>console.log(error)
    );
  
  }
}
