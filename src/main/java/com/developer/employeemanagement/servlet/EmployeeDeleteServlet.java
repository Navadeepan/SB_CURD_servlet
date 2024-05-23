package com.developer.employeemanagement.servlet;

import com.developer.employeemanagement.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEmployee")
public class EmployeeDeleteServlet extends HttpServlet {
    private EmployeeService employeeService; // No need to instantiate here

    @Override
    public void init() throws ServletException {
        super.init();
        this.employeeService = (EmployeeService) getServletContext().getAttribute("employeeService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        response.sendRedirect(request.getContextPath() + "/employeeList");
    }
}
