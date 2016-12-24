<%@ include file="template/header.jsp"%>

<script>

var prod=${productData};
angular.module("productApp",[])

.controller("productController",function($scope){

	$scope.prodData=prod;
	$scope.sort=function(keyname){
		$scope.sortKey=keyname;
		$scope.reverse=!$scope.reverse;
	}
});
</script>

<div class ="section" style="padding-top:100px" ng-app="productApp">

<div class ="row">


    <div class="col-sm-4">
      <input type="text" class="form-control" ng-model="search" placeholder="Enter Search Criteria">
    </div>
	<div class ="col-sm-8">
	</div>
  </div>

<div style="padding-left:100px"  ng-controller = "productController" class="row" style="padding-top:100px">
	<table class ="table table-striped">
	<thead>
	   <tr>
		<th ng-click="sort('productName')">Product Name</th>
		<th ng-click="sort('brand')">Brand</th>
		<th ng-click="sort('price')">Price</th>
		<th ng-click="sort('category')">Category</th>
		<th></th>
	   </tr>
	</thead>

	<tbody>
     <tr ng-repeat="product in prodData|orderBy:sortKey:reverse|filter:search">
	<td>{{product.productName}}</td>
	<td>{{product.brand}}</td>
	<td>{{product.price}}</td>
	<td>{{product.category}}</td>
     </tr>
     
	</tbody>
</table>
</div>
<%@ include file="template/footer.jsp"%>