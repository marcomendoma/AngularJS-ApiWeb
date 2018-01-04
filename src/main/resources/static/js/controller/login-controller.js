appCliente.controller ("loginController", function($scope, $http){
	$scope.usuario = {};
	$scope.token="";
	
	$scope.autenticar = function (){
		//console.log("Chamou usuário: " + $scope.usuario.nome + " " + $scoper.usuario.senha);
		$http.post("/autenticar", $scope.usuario)
			.then(
					function(response){
						console.log("Sucesso " + response);
						$scope.token = response.data.token;
						localStorage.setItem("userToken", response.data.token);
					}, 
					function(response){
						console.log("Falha " + response);
					}
			);
	}
});