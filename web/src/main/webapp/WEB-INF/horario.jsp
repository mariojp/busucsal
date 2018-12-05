<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<link rel="stylesheet" href="/css/busucsal.css" />
<link rel="stylesheet"
	href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css" />

<title>BusUCSal</title>
</head>
<body>
	<header>
		<div class="collapse bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-md-7 py-4">
						<h4 class="text-white">Sobre</h4>
						<p class="text-muted">Horarios do BusUCSal UCSal.</p>
					</div>
					<div class="col-sm-4 offset-md-1 py-4">
						<h4 class="text-white">Contato</h4>
						<ul class="list-unstyled">
							<li><a href="#" class="text-white">Siga no Twitter</a></li>
							<li><a href="#" class="text-white">Curta no Facebook</a></li>
							<li><a href="#" class="text-white">Email</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="#" class="navbar-brand d-flex align-items-center"> <strong>BusUCSal</strong>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarHeader" aria-controls="navbarHeader"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</div>
	</header>

	<main role="main">

	<div class="album py-5 bg-light">
		<div class="container">

			<div class="row">
				<h1>FORMULARIO ADICIONAR HORARIO</h1>	
			</div>
			
			<div class="row">
			
				<form action="horario" method="post">
					<input type="hidden" name="id" value="${horario.id}">
					Hora de Saida :<br> <input type="text" name="horaInicio" value="${horario.horaInicio}"><br>
					Dia da Semana :<br> 
					<select id="input_diadasemana" name="diaDaSemana"> 
						<option value=""  >Selecione</option>
					
						<option value="Segunda-feira"  >Segunda-feira</option>
						<option value="Terça-feira" >Terça-feira</option>
						<option value="Quarta-feira" >Quarta-feira</option>
						<option value="Quinta-feira" >Quinta-feira</option> 
						<option value="Sexta-feira" >Sexta-feira</option>
						<option value="Sabado" >Sabado</option> 
					</select><br>
					Roteiro:<br>
					<select id="input_roteiro" name="roteiroId"> 
					    <option value=""  >Selecione</option>
						<c:forEach var="roteiro" items="${roteiros}"> 
					     <option  value="${roteiro.id}" >${roteiro.titulo}</option>
						</c:forEach>					     
					 </select><br>
					<input type="submit" value="Submit"><br>
				</form>


			</div>
		</div>
	</div>
	</main>

	<footer class="text-muted">
		<div class="container">
			<p class="float-right">
				<a href="#">Voltar para o Topo</a>
			</p>
			<p>BusUCSal é &copy; UCSal!</p>
		</div>
	</footer>

	<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="/webjars/popper.js/1.14.4/umd/popper.min.js"></script>
	<script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/holderjs/2.5.2/holder.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
    $("#input_diadasemana").val("${horario.diaDaSemana}").attr('selected', 'selected');
    $("#input_roteiro").val("${horario.roteiro.id}").attr('selected', 'selected');
});


</script>

</body>
</html>