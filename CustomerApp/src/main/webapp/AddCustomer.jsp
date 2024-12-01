<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Customer</title>
    <style>
        /* Background Gradient */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #FF9A9E, #A5D5F9, #D4A5F9); /* Pink to pale blue to violet */
            color: #333;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        /* Form Container */
        .form-container {
            background: #ABCCF9; /* Soft lavender blue */
            padding: 20px 40px;
            border-radius: 12px; /* Rounded corners */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        /* Form Styling */
        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
        }

        .form-group input:focus {
            border-color: #6A0572; /* Purple highlight */
            outline: none;
        }

        /* Submit Button */
        .btn-submit {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
            color: #fff;
            background: linear-gradient(135deg, #6A0572, #AB47BC); /* Purple gradient */
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }

        .btn-submit:hover {
            background: linear-gradient(135deg, #530456, #8E24AA); /* Darker purple gradient */
            transform: scale(1.03);
        }

        /* Back Button */
        .btn-back {
            display: inline-block;
            margin-top: 10px;
            text-align: center;
            width: 100%;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
            color: #fff;
            background: linear-gradient(135deg, #FF6F61, #FF3E3E); /* Red gradient */
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            transition: background 0.3s, transform 0.2s;
        }

        .btn-back:hover {
            background: linear-gradient(135deg, #E53935, #D32F2F); /* Darker red gradient */
            transform: scale(1.03);
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add Customer</h2>
        <form action="AddCustomerServlet" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile:</label>
                <input type="tel" id="mobile" name="mobile" required pattern="[0-9]{10}" title="Enter a valid 10-digit mobile number">
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" id="city" name="city" required>
            </div>
            <button type="submit" class="btn-submit">Add Customer</button>
        </form>
        <a href="Home.jsp" class="btn-back">Back to Home</a>
    </div>
</body>
</html>
