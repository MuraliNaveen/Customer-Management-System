<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.pojo.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Details</title>
    <style>
        /* Background Gradient */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #FF9A9E, #A5D5F9, #D4A5F9); /* Pink to pale blue to violet */
            color: #333;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            padding: 20px;
        }

        /* Card Grid */
        .card-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            max-width: 1200px;
            width: 100%;
        }

        /* Add Customer Button */
        .add-btn {
            display: inline-block;
            margin: 20px auto;
            padding: 12px 24px;
            background: linear-gradient(135deg, #6A0572, #AB47BC); /* Dark purple to lavender */
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 25px; /* Fully rounded corners */
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
            text-decoration: none;
            text-align: center;
        }

        .add-btn:hover {
            background: linear-gradient(135deg, #530456, #8E24AA); /* Darker purple gradient */
            transform: scale(1.05);
        }

        /* Individual Card Styling */
        .card {
            background:#d1e5f4; /* Soft lavender blue */
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            padding: 20px;
            text-align: center;
            transition: transform 0.2s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card h3 {
            font-size: 20px;
            margin: 10px 0;
            color: #333;
        }

        .card p {
            font-size: 16px;
            margin: 5px 0;
            color: #555;
        }

        /* Buttons in Cards */
        .card .btn {
            display: inline-block;
            margin: 10px 5px 0;
            padding: 10px 20px;
            font-size: 14px;
            font-weight: bold;
            border: none;
            border-radius: 20px; /* Rounded buttons */
            cursor: pointer;
            text-decoration: none;
            transition: transform 0.2s, background 0.3s;
        }

        .btn-edit {
            background: linear-gradient(135deg, #6A0572, #AB47BC); /* Purple gradient */
            color: #fff;
        }

        .btn-edit:hover {
            background: linear-gradient(135deg, #530456, #8E24AA); /* Darker purple gradient */
            transform: scale(1.05);
        }

        .btn-delete {
            background: linear-gradient(135deg, #FF6F61, #FF3E3E); /* Red gradient */
            color: #fff;
        }

        .btn-delete:hover {
            background: linear-gradient(135deg, #E53935, #D32F2F); /* Darker red gradient */
            transform: scale(1.05);
        }

        /* Footer */
        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #666;
        }
    </style>
</head>
<body>
    <!-- Add Customer Button -->
    <a href="AddCustomer.jsp" class="add-btn">Add Customer</a>
    <div class="card-grid">
        <!-- Dynamically generated cards -->
        <%
            List<Customer> customerList = (List<Customer>) session.getAttribute("customerlist");
            if (customerList != null && !customerList.isEmpty()) {
                for (Customer customer : customerList) {
        %>
                    <div class="card">
                        <h3><%= customer.getName() %></h3>
                        <p><strong>Email:</strong> <%= customer.getEmail() %></p>
                        <p><strong>Mobile:</strong> <%= customer.getMobile() %></p>
                        <p><strong>City:</strong> <%= customer.getCity() %></p>
                        <!-- Action Buttons -->
                        <a href="EditCustomer?cid=<%= customer.getId() %>" class="btn btn-edit">Edit</a>
                        <a href="DeleteCustomer?id=<%= customer.getId()%>" class="btn btn-delete">Delete</a>
                    </div>
        <%
                }
            } else {
        %>
            <p style="color: white;">No customers found!</p>
        <%
            }
        %>
    </div>
    <div class="footer">
        &copy; 2024 Customer Management System
    </div>
</body>
</html>
