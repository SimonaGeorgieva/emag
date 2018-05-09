var app = angular.module('emag');

app.controller("innerCategoryProducts", function ($scope, $location, $routeParams, $http, sessionService, $rootScope) {

    var innerCategoryId = $routeParams.id;

    var getProducts = function () {
        $http({
            url: "http://localhost:7377/product" + "/getInnerCategoryProducts",
            method: "GET",
            params: {"id": innerCategoryId}
        }).then(function (response) {
            $scope.products = response.data;
        }, function (error) {

        });
    };
    getProducts()
    $scope.editProduct = function (updateProduct) {
        $scope.updateProduct = jQuery.extend({}, updateProduct);
    };

    $scope.updProduct = function () {
        $scope.error = false;

        $http({
            url: "http://localhost:7377/admin" + "/updateProduct",
            method: "PUT",
            params: {
                "id": $scope.updateProduct.id,
                "name": $scope.updateProduct.name,
                "categoryId": $scope.updateProduct.innerCategoryId,
                "price": $scope.updateProduct.price,
                "quantity": $scope.updateProduct.quantity,
                "description": $scope.updateProduct.description
            }
        }).then(function (response) {

            $location.url("/");
        }, function (error) {
            $scope.error = true;
            $scope.value = error.data;
        });
    }

    $scope.removeProduct = function (productId) {
        $http({
            url: "http://localhost:7377/admin" + "/removeProductById",
            method: "DELETE",
            params: {"id": productId}
        }).then(function (response) {
            getProducts();
        }, function (error) {

        });
    };
});