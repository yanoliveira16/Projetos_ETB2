<!Doctype html>
<html>
<head>
</head>
  <body>
  <?php
	 echo"<h1>SAIDA DE DADOS</h1>";
	 $nome=$_POST["nome"];
     $num1=$_POST["nota1"];
	 $num2=$_POST["nota2"];
	 $num3=$_POST["nota3"];
	 $num4=$_POST["nota4"];
	 $resultado=($num1+$num2*2+$num3*3+$num4*4)/4;
	 echo"<p>$nome sua media é: $resultado </p>";
  ?>
  </body>
</html>