var app=angular.module("myBanqueApp", []);
app.controller("myBanqueController", function($scope, $http) {
	
	$scope.compte = null;
	$scope.codeCompte = null;
	$scope.operation={type:"versement", montant:0}
	$scope.pageOperations=[];
	$scope.chargerCompte=function(){
			$http.get("/comptes/"+$scope.codeCompte)
			.success(function(date){
				$scope.compte = date;
				$scope.chargerOperations;
			});
	};
	
	$scope.chargerOperations=function(){
		$http.get("/operations?codeCompte="+$scope.codeCompte+"&page=0&size3")
		.success(function(date){
			$scope.pageOperations = date;
		});
	}
	
	$scope.saveOperation=function(){
		$http({
			method   : 'PUT',
			url      : $scope.operation.type,
			data     : "code="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmp=4",
			headers  : {'Content-Type': 'application/x-www-form-urlencoded'}
		})
		.success(function(data) {
			console.log(data);
			$scope.chargerCompte();
			$scope.loadOperations();
		});
		
	};
});