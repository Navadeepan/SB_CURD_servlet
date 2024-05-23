package com.developer.employeemanagement.servlet;

import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    @Autowired
    private EmployeeService employeeService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Your servlet logic here
            List<EmployeeEntity> employees = employeeService.findAllEmployee();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/WEB-INF/views/employees.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle the exception
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
        }
    }


    // Add doPost, doPut, and doDelete methods for handling form submissions and CRUD operations
}

