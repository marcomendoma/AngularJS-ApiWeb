// Criação de controllers
appCliente.controller("clienteController", function($scope, $http) {
	$scope.clientes = [];
	$scope.cliente = {};

	carregarClientes = function(){
		token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer ' + token;
		
		$http({	
			method: 'GET', 
			url: 'http://localhost:8081/admin/clientes' })
			.then(
					function(response) {
						$scope.clientes = response.data;
					}, 
					function(response) {
						console.log(response.data);
						console.log(response.status);
					}
			 	 );
	};
	
	$scope.salvarClientes = function(){
		
		if ($scope.frmCliente.$valid){
			$http({
				method: 'POST',
				url: 'http://localhost:8081/admin/clientes',
				data: $scope.cliente })
				.then(
						function(response) {
							//$scope.clientes.push(response.data);
							carregarClientes();
							$scope.cancelarCliente();
							$scope.frmCliente.$setPristine(true);
						}, 
						function(response) {
							console.log(response.data);
							console.log(response.status);
						}
				 	 );
		}else {
			window.alert('dados inválidos !!!');
		}
	};
	
	$scope.excluirClientes = function(cliente){
		$http({
			method: 'DELETE',
			url: 'http://localhost:8081/admin/clientes/' + cliente.id })
			.then(
					function(response) {
						pos = $scope.clientes.indexOf(cliente);
						
						if (pos >= 0)
							$scope.clientes.splice(pos, 1);
					}, 
					function(response) {
						console.log(response.data);
						console.log(response.status);
					} 
			 	 );
	};
	
	$scope.alterarCliente = function(cli){
		$scope.cliente = angular.copy(cli);
	};
	
	$scope.cancelarCliente = function(cli){
		$scope.cliente = {};
	};
	
	carregarClientes();
	
});
