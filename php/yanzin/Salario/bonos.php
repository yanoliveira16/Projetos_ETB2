<!DOCTYPE html>
<html>
<head>
</head>
<body>
  <?php
	 echo"<h1>Reajuste</h1>";
	 $nome=$_POST["nome"];
	 $sal=$_POST["sal"];
	 $resl=$sal*.1+$sal;
	 echo"<p>seu novo salario é:R$$resl</p>";
	 ?>
</body>
</html>