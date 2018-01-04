// Criação de controllers
appCliente.controller("estadoController", function($scope, $http) {
	$scope.estados = [];
	$scope.estado = {};

	carregarEstados = function(){
		$http({	
			method: 'GET', 
			url: 'http://localhost:8081/estados' })
			.then(
					function(response) {
						$scope.estados = response.data;
					}, 
					function(response) {
						console.log(response.data);
						console.log(response.status);
					}
			 	 );
	};
	
	$scope.salvarEstados = function(){
		$http({
			method: 'POST',
			url: 'http://localhost:8081/estados',
			data: $scope.estado })
			.then(
					function(response) {
						carregarEstados();
						$scope.cancelarEstado();
					}, 
					function(response) {
						console.log(response.data);
						console.log(response.status);
					}
			 	 );
	};
	
	$scope.excluirEstados = function(estado){
		$http({
			method: 'DELETE',
			url: 'http://localhost:8081/estados/' + estado.id })
			.then(
					function(response) {
						pos = $scope.estados.indexOf(estado);
						
						if (pos >= 0)
							$scope.estados.splice(pos, 1);
					}, 
					function(response) {
						console.log(response.data);
						console.log(response.status);
					} 
			 	 );
	};
	
	$scope.alterarEstados = function(uf){
		$scope.estado = angular.copy(uf);
	};
	
	$scope.cancelarEstados = function(uf){
		$scope.estado = {};
	};
	
	carregarEstados();
	
});
