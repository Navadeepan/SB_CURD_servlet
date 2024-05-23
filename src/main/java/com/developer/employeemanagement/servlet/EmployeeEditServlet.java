package com.developer.employeemanagement.servlet;

import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/editEmployee")
public class EmployeeEditServlet extends HttpServlet {
    private EmployeeService employeeService; // No need to instantiate here

    @Override
    public void init() throws ServletException {
        super.init();
        this.employeeService = (EmployeeService) getServletContext().getAttribute("employeeService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Optional<EmployeeEntity> optionalEmployee = employeeService.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity employee = optionalEmployee.get();
            request.setAttribute("employee", employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle error: employee not found
            response.sendRedirect(request.getContextPath() + "/employeeList");
        }
    }
}
