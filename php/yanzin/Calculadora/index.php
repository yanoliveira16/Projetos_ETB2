<!DOCTYPE html>
<html>
<head>
	<title>Calculadora</title>
</head>
<body>

<h1>CALCULADORA </h1><BR>
<form method="get" action="Resultado.php">
	<p>Número 1 <input type="text" name="num" value="1"  > 
    <p>Número 2 <input type="text" name="num2"  value="2" >  </P>
    <p><input type="submit" value="Calcular"></p>
    <p>Selecione um operador</p>
    <input type="radio" name="operador" value="+" checked> Soma </P>
    <input type="radio" name="operador" value="-" > Subtração </P>
    <input type="radio" name="operador" value="*"> Multiplição </P>
    <input type="radio" name="operador" value="/" > Divisão </P>
	</form> 
</body>
</html>
