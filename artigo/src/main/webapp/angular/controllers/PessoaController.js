function PessoaController($scope, $http) {
    $scope.pessoa = {};
    $scope.cidade = {};
    $scope.pessoas = [];
    $scope.cidades = [];

    $scope.save = function() {
        $http.post('mvc/pessoa/save', $scope.pessoa).success(function(data) {
            $scope.list();
            $scope.pessoa = {};
        });
    };
    
    $scope.saveCidade = function() {
        $http.post('mvc/cidade/save', $scope.cidade).success(function(data) {
            $scope.listCidades();
            $scope.cidade = {};
        });
    };

    $scope.remove = function(pessoa) {
        $http.post('mvc/pessoa/remove', pessoa).success(function(){
            var index = $scope.pessoas.indexOf(pessoa);
            console.log(index);
            if(index > -1){
                $scope.pessoas.splice(index, 1);
            }
        });
    };

    $scope.list = function() {  
        $http.get('mvc/pessoa/list').success(function(data) {
            $scope.pessoas = data;
        });
    };

    $scope.update = function(pessoa) {
        var pessoa = angular.copy(pessoa);
        console.log(pessoa);
        $scope.pessoa = pessoa;
    };

    $scope.listCidades = function() {
        $http.get('mvc/cidade/list').success(function(data) {
            $scope.cidades = data;
        });
    }
} 