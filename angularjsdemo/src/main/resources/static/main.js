var app = angular.module("EmployeeManagement", []);

// Controller Part
app.controller("EmployeeController", function($scope, $http) {


    $scope.employees = [];
    $scope.employee = {
        empId: -1,
        empno: "",
        empname: ""
    };

    // Now load the data from server
    _refreshEmployeeData();

    // HTTP POST/PUT methods for add/edit employee
    // Call: http://localhost:8080/employee
    $scope.submitEmployee = function() {

        var method = "";
        var url = "";

        if ($scope.employee.id == -1) {
            method = "POST";
            url = '/employee';
        } else {
            method = "PUT";
            url = '/employee';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.employee),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createEmployee = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employee/' + employee.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editEmployee = function(employee) {
        $scope.employee.id = employee.id;
        $scope.employee.empno = employee.empno;
        $scope.employee.empname = employee.empname;
    };

    // Private Method
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/employees'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.employee.id = -1;
        $scope.employee.empno = "";
        $scope.employee.empname = ""
    };
});