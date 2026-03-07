# SpringEcom - E-Commerce REST API

SpringEcom is a RESTful API backend for an e-commerce platform built with Spring Boot and Java. It provides comprehensive product management capabilities including CRUD operations, image handling, advanced search functionality, and performance monitoring via AOP.

---

## 🚀 Features

* **Product Management:** Full CRUD operations for products
* **Image Upload:** Support for product images with multipart file upload
* **Advanced Search:** Search products by name, description, brand, or category
* **RESTful API:** Clean REST endpoints with proper HTTP status codes
* **Database Integration:** PostgreSQL with JPA/Hibernate
* **Cross-Origin Support:** CORS enabled for frontend integration
* **Logs & Monitoring:** AOP concepts implemented to keep record and observe application performance in `application.logs`

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA — Database operations
* PostgreSQL — Primary database
* Lombok — Reduce boilerplate code
* Maven — Dependency management

---

## 🗄️ Database Setup

1. Install PostgreSQL
2. Create a database (default name: `zahiq`)
3. Update `src/main/resources/application.properties` with your credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## 📖 API Endpoints

**Base URL:** `http://localhost:8080/api`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/products` | Get all products |
| `GET` | `/product/{id}` | Get product by ID |
| `GET` | `/product/{id}/image` | Get product image |
| `POST` | `/product` | Create new product |
| `PUT` | `/product/{id}` | Update existing product |
| `DELETE` | `/product/{id}` | Delete product |
| `GET` | `/products/search` | Search products by keyword |

---

## 📬 Examples

### Get All Products
```bash
GET /api/products
```

### Get Single Product
```bash
GET /api/product/1
```

### Get Product Image
```bash
GET /api/product/1/image
```

### Create Product
```bash
POST /api/product
Content-Type: multipart/form-data
```

Form Data:
* `product` — JSON object
* `imageFile` — image file

Example JSON:
```json
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
```

### Update Product
```bash
PUT /api/product/1
Content-Type: multipart/form-data
```

Form Data:
* `product` — JSON object (same structure as create)
* `imageFile` — image file

### Delete Product
```bash
DELETE /api/product/1
```

### Search Products
```bash
GET /api/products/search?keyword=laptop
```

> Searches across: `name`, `description`, `brand`, `category`

---

## 📌 TODO

* Add pagination support for product listings
* Add authentication and authorization (Spring Security / JWT)
* Add order and cart management endpoints
