<!DOCTYPE html>
<html>
<head>
	
</head>
<body>
	<?php
	
	 

	 $operador=$_GET["operador"];
	 $num=$_GET["num"];
	 $num2=$_GET["num2"];

	 
	 echo"<p> Operação escolhida: $operador </p>";
     echo"<h1>Resultado</h1>";

	 switch ($operador) {
	
	case '+': $Resultado =$num + $num2;
	 	      echo "<p> O resultado da soma é: $Resultado</p>";
	 	      break;
	case '-': $Resultado =$num - $num2;
	 	      echo "<p> O resultado da subtração é: $Resultado</p>";
	 		  break;
	case '*': $Resultado =$num * $num2;
	 	      echo "<p> O resultado da multiplicação é: $Resultado</p>";
	 	      break;
    case '/': $Resultado =$num / $num2;
	 	      echo "<p> O resultado da divisão é: $Resultado</p>";
              break;	 	
	 	default:
	 		# code...
	 		break;
	 }
	?>
</body>
</html>