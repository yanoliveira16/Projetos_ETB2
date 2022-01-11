<!DOCTYPE html>
<html>
<head>
	 
</head>
<body>
 <?php
	 echo"<h1>Peso Ideal</h1>";

	 $sx=$_GET["sx"];
	 $altura=$_GET["altura"];
	
	if($sx=="M"){
		$peso_ideal = 72.7*$altura-58;
		}
		else{

		
	    $peso_ideal = 72.1*$altura-44.7;
	}
	 echo"<p> Seu peso ideal é: $peso_ideal </p>";
	 ?>
</body>
</html>

