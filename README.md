## **What Is Multi-tenancy?**

Multi-tenancy is an architecture in which a single instance of a software application serves multiple customers.

Each customer is called a `tenant`.

Tenants may be given the ability to customize some parts of the application, such as the color of the user interface (UI) or business rules, but they cannot customize the application’s code.

There are multiple well-known strategies to implement this architecture, ranging from highly isolated (like single-tenant) to everything shared. We can implement multi-tenancy using any of the following approaches:


1-Database per Tenant: Each Tenant has its own database and is isolated from other tenants.

2-Shared Database, Shared Schema: All Tenants share a database and tables. Every table has a Column with the Tenant Identifier, that shows the owner of the row.

3-Shared Database, Separate Schema: All Tenants share a database, but have their own database schemas and tables.


## The process to establish a multi-tenant communication usually consists of the following three steps:

* Accept the incoming connection, and authenticate the user if necessary.
* Intercept the request and identify the tenant for which the user is issuing the request.
* Establish a connection with the database or schema of the tenant.

``` 
Tenant identification is performed against a default schema, which contains the user's information. 
A user can authenticate himself on an external service and then pass the tenant information using an HTTP header.

