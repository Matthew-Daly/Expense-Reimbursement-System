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
