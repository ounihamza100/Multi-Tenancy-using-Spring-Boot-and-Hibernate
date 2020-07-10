**What Is Multi-tenancy?**

Multi-tenancy is an architecture in which a single instance of a software application serves multiple customers.

Each customer is called a `tenant`.

Tenants may be given the ability to customize some parts of the application, such as the color of the user interface (UI) or business rules, but they cannot customize the application’s code.

There are multiple well-known strategies to implement this architecture, ranging from highly isolated (like single-tenant) to everything shared. We can implement multi-tenancy using any of the following approaches:


1-Database per Tenant: Each Tenant has its own database and is isolated from other tenants.

2-Shared Database, Shared Schema: All Tenants share a database and tables. Every table has a Column with the Tenant Identifier, that shows the owner of the row.

3-Shared Database, Separate Schema: All Tenants share a database, but have their own database schemas and tables.