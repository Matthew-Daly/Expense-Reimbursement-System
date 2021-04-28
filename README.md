# Expense-Reimbursement-System (ERS) - Java CDE Full Stack
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. 

# Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

# Technologies Used
* Java
* JavaScript
* HTML/CSS
* AWS RDS
* PostgreSQL
* Javalin

# Features
* As employees, user can login into account and be able to submit the reimbursement ticket ( types are LODGING, FOOD, TRAVEL, OTHERS ) with specific amount and   description of that ticket. The default status for ticket will be pending, finance manager will able to review that ticket and are authorized to approve and deny requests for expense reimbursement.
* As finance manager, user can login into account and be able to review all tickets from employees. User can either approve or deny the tickets by inserting the ticket id.
* User can register new account to be either employee or manager.

To-do list:

* Encrypted password on database.
* Forget-password will able to send email confirmation and reset password from user.
* As employee, user can upload the reimbursement reciept when create ticket.
* As manager, user can download and view the reciept.


# Environment / Technologies
Servlets, Java, JavaScript, HTML, CSS, JDBC, SQL, AJAX, Bootstrap, RDS, Tomcat, Git, Maven

# Usage

* Open the project, go to Driver folder inside main folder. Open the MainDriver class and run that class.
![Selection_006](https://user-images.githubusercontent.com/16307728/116434036-e7f42100-a7fe-11eb-9240-97273d8d00ba.png)

* After running, the project will run on (http://localhost:9002/)
* Login (if you like login as Jim Halpert - username: Tuna, password: Pam)
![Selection_002](https://user-images.githubusercontent.com/16307728/116434673-79639300-a7ff-11eb-983d-8d880110e8d1.png)

* Employees are directed to this page to see and submit reimbursement requests.
![Selection_003](https://user-images.githubusercontent.com/16307728/116435038-ce9fa480-a7ff-11eb-8807-ca8d6b55e51c.png)

* Mangers are directed to a page where they can see all reimbursement requests and approve or deny them. (if you would like to log in as 
  a manager, use Michael's credentials - username: DateMike, password: ThatsWhatSheSaid)
  ![Selection_005](https://user-images.githubusercontent.com/16307728/116435594-61404380-a800-11eb-9e5f-d63a1f18f1b7.png)


