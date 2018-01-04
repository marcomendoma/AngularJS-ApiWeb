// Criação de controllers
appCliente.controller("usuarioController", function($scope, $http) {
	$scope.usuarios = [];
	$scope.usuario = {};

	carregarUsuarios = function(){
		$http({	
			method: 'GET', 
			url: 'http://localhost:8081/usuarios' })
			.then(
					function(response) {
						$scope.usuarios = response.data;
					}, 
					function(response) {
						console.log(response.data);
						console.log(response.status);
					}
			 	 );
	};
	
	$scope.salvarUsuario = function(){
		
		if ($scope.frmUsuario.$valid){
			$http({
				method: 'POST',
				url: 'http://localhost:8081/usuarios',
				data: $scope.usuario })
				.then(
						function(response) {
							//$scope.usuarios.push(response.data);
							carregarUsuarios();
							$scope.cancelarUsuario();
							$scope.frmUsuario.$setPristine(true);
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
	
	$scope.excluirUsuario = function(usuario){
		$http({
			method: 'DELETE',
			url: 'http://localhost:8081/usuarios/' + usuario.id })
			.then(
					function(response) {
						pos = $scope.usuarios.indexOf(usuario);
						
						if (pos >= 0)
							$scope.usuarios.splice(pos, 1);
					}, 
					function(response) {
						console.log(response.data);
						console.log(response.status);
					} 
			 	 );
	};
	
	$scope.alterarUsuario = function(usu){
		$scope.usuario = angular.copy(usu);
	};
	
	$scope.cancelarUsuario = function(usu){
		$scope.usuario = {};
	};
	
	carregarUsuarios();
	
});
