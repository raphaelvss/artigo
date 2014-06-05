<!DOCTYPE html>
<html ng-app>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script src="angular/lib/jquery-1.9.1.js" type="text/javascript"></script>
        <script src="angular/lib/angular.js" type="text/javascript"></script>
        <script src="angular/controllers/PessoaController.js" type="text/javascript"></script>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <title>Pessoa</title>
    </head>
    <body ng-controller="PessoaController" ng-init="list();
                    listCidades();">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">Universidade Católica de Brasília - Projeto Integrado</a>
                        </div>
                    </nav>
                    <div class="row clearfix">
                        <div class="col-md-4 column">
                            <h1>Pessoa</h1>
                            <form role="form">
                                <div class="form-group">
                                    <label for="nome">Nome</label>
                                    <input type="text" class="form-control" ng-model="pessoa.nome" id="nome" placeholder="Nome"/>
                                </div>
                                <div class="form-group">
                                    <label for="idade">Idade</label>
                                    <input type="text" class="form-control" ng-model="pessoa.idade" id="idade" placeholder="Idade"/>
                                </div>
                                <div class="form-group">
                                    <label for="idade">Cidade</label>
                                    <select class="form-control" ng-model="pessoa.cidadeNatal" ng-options="cidade.nome for cidade in cidades">
                                        <option value="">Selecione</option>
                                    </select>
                                </div>
                                
                                <div class="form-group">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Adicionar nova cidade</button>
                                    <button class="btn btn-primary" ng-click="save()">Salvar</button>d
                                </div>

                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">Adicionar cidade</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label for="nome">Nome</label>
                                                    <input type="text" class="form-control" ng-model="cidade.nome" id="nome" placeholder="Nome"/>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="saveCidade()">Salvar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div ng-show="pessoas.length == 0">
                        <h3><i>Nenhuma pessoa cadastrada!</i></h3>
                    </div>

                    <div id="listContas" ng-show="pessoas.length != 0">
                        <h1>Lista de Pessoas</h1>
                        <table ng-show="pessoas.length != 0">
                            <tr>
                                <th width="175">Nome</th>
                                <th width="175">Idade</th>
                                <th width="175">Cidade</th>
                                <th width="200">Ações</th>
                            </tr>
                            <tbody>
                                <tr ng-repeat="pessoa in pessoas| orderBy:'nome':false">
                                    <td>{{pessoa.nome}}</td>
                                    <td>{{pessoa.idade}}</td>
                                    <td>{{pessoa.cidadeNatal.nome}}</td>
                                    <td style="text-align: center;" data-title="'Ações'" width="200">
                                        <a href ng-click="update(pessoa);">Editar</a> - 
                                        <a href ng-click="remove(pessoa);">Remover</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>