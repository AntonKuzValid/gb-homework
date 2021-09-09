angular.module('app', []).controller('indexController', function ($scope, $http) {

    const contextPath = 'http://localhost:8181';
    const pageNumber = document.querySelector(".page-number");
    let page = Number(pageNumber.textContent);
    console.log(pageNumber);


    $scope.saveProduct = function () {
        $http.post(contextPath + '/product', $scope.NewProduct)
            .then(function (resp) {
                $scope.fillTable()
            });
    };

    $scope.fillTable = function () {
        $http.get(contextPath + '/product/' + page)
            .then(function (resp) {
                $scope.products = resp.data
            })
    };

    $scope.increment = function () {
        page++;
        pageNumber.textContent = page.toString();
        $scope.fillTable()
    }

    $scope.decrement = function () {
        if (page > 1) {
            page--;
            pageNumber.textContent = page.toString();
            $scope.fillTable()
        }
    }

    $scope.removeProduct = function (id) {
        $http.delete(contextPath + '/product/' + id)
            .then(function (resp) {
                $scope.fillTable()
            })
    }

    $scope.getFiltered = function () {
        console.log($scope.NewFilter);
        $http.post(contextPath + '/product/filter', $scope.NewFilter)
            .then(function (resp) {
                $scope.products = resp.data
            });
    }

    $scope.fillTable()


});