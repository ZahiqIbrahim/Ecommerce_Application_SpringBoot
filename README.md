SpringEcom - E-Commerce REST API
A RESTful API backend for an e-commerce platform built with Spring Boot and Java.
This application provides comprehensive product management capabilities including CRUD operations, 
image handling, and advanced search functionality, also keeps logs using AOP concepts. 

Features
Product Management: Full CRUD operations for products
Image Upload: Support for product images with multipart file upload
Advanced Search: Search products by name, description, brand, or category
RESTful API: Clean REST endpoints with proper HTTP status codes
Database Integration: PostgreSQL with JPA/Hibernate
Cross-Origin Support: CORS enabled for frontend integration
Logs and Monitoring: AOP concepts implimented to kepp record and observe performance of the application in the application.logs file


Tech Stack
Java 
Spring Boot 
Spring Data JPA - Database operations
PostgreSQL - Primary database
Lombok - Reduce boilerplate code
Maven - Dependency management

Database Setup
Install PostgreSQL
Create a database (default name: zahiq)
Update src/main/resources/application.properties with your credentials:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password



API Endpoints
Base URL: http://localhost:8080/api

Products
GET    /products              Get all products
GET    /product/{id}          Get product by ID
GET    /product/{id}/image    Get product image
POST   /product               Create new product
PUT    /product/{id}          Update existing product
DELETE /product/{id}          Delete product
GET    /products/search       Search products by keyword
Examples
Get All Products

GET /api/products
Get Single Product

GET /api/product/1
Get Product Image

GET /api/product/1/image
Create Product

POST /api/product
Content-Type: multipart/form-data

Form Data:
- product: JSON object
- imageFile: image file

Example JSON:
{
  "name": "Laptop",
  "description": "High performance laptop",
  "brand": "Dell",
  "price": 999.99,
  "category": "Electronics",
  "releaseDate": "2026-03-05",
  "productAvailable": true,
  "stockQuantity": 50
}
Update Product

PUT /api/product/1
Content-Type: multipart/form-data

Form Data:
- product: JSON object (same as create)
- imageFile: image file
Delete Product

DELETE /api/product/1
Search Products


GET /api/products/search?keyword=laptop

Searches in: name, description, brand, category
